import platform.UIKit.*

actual fun renderIcon(iconName: String, size: Float): Any {
    return materialIcon(named = iconName, size = size.toDouble())
}
