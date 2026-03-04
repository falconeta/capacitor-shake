// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "Shake",
    platforms: [.iOS(.v15)],
    products: [
        .library(
            name: "Shake",
            targets: ["ShakePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "8.0.0")
    ],
    targets: [
        .target(
            name: "ShakePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/ShakePlugin"),
        .testTarget(
            name: "ShakePluginTests",
            dependencies: ["ShakePlugin"],
            path: "ios/Tests/ShakePluginTests")
    ]
)