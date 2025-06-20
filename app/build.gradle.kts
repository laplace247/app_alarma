plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.empresa.appalarma"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.empresa.appalarma"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.database.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // --- DEPENDENCIAS DE FIREBASE ---
    // BoM (Bill of Materials) para gestionar las versiones de Firebase de forma centralizada
    val firebaseBom = platform("com.google.firebase:firebase-bom:32.7.2")
    implementation(firebaseBom)

    // 1. Firebase Realtime Database: Para leer la lista de anomalías
    implementation("com.google.firebase:firebase-database-ktx")

    // 2. Firebase Cloud Messaging: Para recibir las notificaciones push
    implementation("com.google.firebase:firebase-messaging-ktx")

    // --- DEPENDENCIAS DE ANDROID JETPACK (ARQUITECTURA) ---
    // 3. ViewModel: Para mantener la lógica de la UI y sobrevivir a cambios de configuración
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    // 4. LiveData: Para crear flujos de datos observables y conscientes del ciclo de vida
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // 5. RecyclerView: Para mostrar eficientemente la lista de alertas
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // --- DEPENDENCIAS PARA PRUEBAS (OPCIONAL PERO RECOMENDADO) ---
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}