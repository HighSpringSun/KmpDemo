# 一个KMP DEMO项目

## 介绍

项目包含了在 [www.kmpstudy.com](https://www.kmpstudy.com)网站中的所有代码片段,主要是一些非常基础的代码块

## 使用

### 克隆项目

```bash
git clone https://github.com/HighSpringSun/KmpDemo.git
cd KmpDemo
```

### 构建与运行

* **Android**

使用 Android Studio 打开项目,使用`composeApp`命令，并运行到设备或模拟器上。

* **iOS**

使用 Xcode 打开 iosApp/iosApp.xcodeproj 并运行到模拟器或真机上。

* **桌面端**

打开编辑配置，添加gradle选项，添加以下命令到Run输入框中`desktopRun -DmainClass=com.kmpstudy.MainKt --quiet`,点击运行

* **WASM**

打开编辑配置，添加gradle选项，添加以下命令到Run输入框中`composeApp:wasmJsBrowserDevelopmentRun`,点击运行