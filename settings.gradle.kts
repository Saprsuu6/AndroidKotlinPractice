pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidKotlinPractice"
include(":Activity")
include(":ResultFromActivity")
include(":StatusCatsBook")
include(":Navigation")
include(":RoomDataBase")
include(":NavigationLibrary")
include(":SQLite")
