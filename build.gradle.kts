buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath (ClassPaths.gradlePath)
        classpath (ClassPaths.kotlinPath)
        classpath (ClassPaths.googleServices)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}