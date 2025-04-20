import UIKit

func materialIcon(named iconName: String, size: CGFloat) -> UILabel {
    let label = UILabel()
    label.font = UIFont(name: "MaterialIcons-Regular", size: size)
    label.text = iconName
    return label
}
