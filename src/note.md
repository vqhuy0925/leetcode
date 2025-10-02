### gradle-wrapper.properties
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.7-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists

### build.gradle
plugins {
  id 'org.jetbrains.intellij' version '1.17.3'
  id 'org.jetbrains.kotlin.jvm' version '2.2.0'
  id 'java'
}

group 'org.jetbrains'
version '1.0-SNAPSHOT'

repositories {
  mavenCentral()
}

dependencies {

}

def properties = new Properties()
def file = rootProject.file('local.properties')

if (file.exists()) {
  properties.load(file.newDataInputStream())
}

def ideaPath = properties.getProperty('idea.path')

intellij {
  type = 'IU'

  if (ideaPath == null) {
    version = 'LATEST-EAP-SNAPSHOT'
  } else {
    localPath = ideaPath
  }

  plugins = ['java']
}

patchPluginXml {
}

test {
  useJUnitPlatform()
}

sourceSets {
  main {
    java.srcDirs = ['src', 'gen']
    resources.srcDirs = ['resources']
  }
  test {
    java.srcDirs = ['tests/src']
    resources.srcDirs = []
  }
}

// Configure Java compatibility
java {
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
  jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of('21'))
  }
}

// Skip buildSearchableOptions task to avoid IndexOutOfBoundsException
tasks.named('buildSearchableOptions') {
  enabled = false
}
