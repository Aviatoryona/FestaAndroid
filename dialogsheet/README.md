# DialogSheet
An Android library to create fully material designed bottom dialogs similar to the Android Pay app.

---

## Releases:

#### Current release: 1.0.2.

You can see all the library releases [here](https://github.com/marcoscgdev/DialogSheet/releases).

---

## Screenshots
<kbd><img src="https://raw.githubusercontent.com/marcoscgdev/DialogSheet/master/screenshots/1.png" width="350"></kbd>&nbsp;&nbsp;&nbsp;&nbsp;<kbd><img src="https://raw.githubusercontent.com/marcoscgdev/DialogSheet/master/screenshots/2.png" width="350"></kbd>

<kbd><img src="https://raw.githubusercontent.com/marcoscgdev/DialogSheet/master/screenshots/3.png" width="620"></kbd>

Download the sample apk [here](https://github.com/marcoscgdev/DialogSheet/releases/download/1.0.2/app-debug.apk).

---

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```
compile 'com.github.marcoscgdev:DialogSheet:1.0.2'
```

### Creating the dialog

Here is a complete snippet of it usage:

```java
new DialogSheet(this)
    .setTitle(R.string.app_name)
    .setMessage(R.string.lorem)
    .setPositiveButton(android.R.string.ok, new DialogSheet.OnPositiveClickListener() {
        @Override
        public void onClick(View v) {
            // Your action
        }
    })
    .setNegativeButton(android.R.string.cancel, new DialogSheet.OnNegativeClickListener() {
        @Override
        public void onClick(View v) {
            // Your action
        }
    })
    .setButtonsColorRes(R.color.colorPrimary)  // Default color is accent
    .show();
```

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
The MIT License (MIT)

Copyright (c) 2017 Marcos Calvo García

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

