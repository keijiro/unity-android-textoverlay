#pragma strict

#if UNITY_ANDROID && !UNITY_EDITOR

private static function GetPluginClass() : AndroidJavaClass {
    return new AndroidJavaClass("com.unity3d.plugin.TextOverlay");
}

static function Install(ox : int, oy : int, width : int, height : int) {
    GetPluginClass().CallStatic("install", ox, oy, width, height);
}

static function SetText(text : String) {
    GetPluginClass().CallStatic("setText", text);
}

#else

static function Install(ox : int, oy : int, width : int, height : int) {
}

static function SetText(text : String) {
}

#endif
