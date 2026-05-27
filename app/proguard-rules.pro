-keep class com.ellepqe.alarmapp.** { *; }
-keep class androidx.** { *; }
-keep class android.** { *; }

# Keep Room database
-keep class androidx.room.** { *; }

# Keep Lifecycle
-keep class androidx.lifecycle.** { *; }

# Keep ViewModel
-keep class androidx.lifecycle.ViewModel { *; }

# Keep Coroutines
-keep class kotlinx.coroutines.** { *; }

# Keep GSON
-keep class com.google.gson.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Remove logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Keep R classes
-keepclassmembers class **.R$* {
    public static <fields>;
}
