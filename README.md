# Broadcast Sender

## Send Broadcast Explicitly (branch: `master`)
### 1st Approach
```
val intent = Intent("com.hanseltritama.MY_ACTION")
val cn = ComponentName("com.hanseltritama.broadcastreceiver", "com.hanseltritama.broadcastreceiver.MyBroadcastReceiver")
intent.component = cn
sendBroadcast(intent)
```
### 2nd Approach
```
val intent = Intent("com.hanseltritama.MY_ACTION")
intent.setClassName("com.hanseltritama.broadcastreceiver", "com.hanseltritama.broadcastreceiver.MyBroadcastReceiver")
sendBroadcast(intent)
```
### 3rd Approach
```
val intent = Intent("com.hanseltritama.MY_ACTION")
intent.setPackage("com.hanseltritama.broadcastreceiver")
sendBroadcast(intent)
```
### 4th Approach
```
val intent = Intent("com.hanseltritama.MY_ACTION")
val packageManager: PackageManager = packageManager

// check which app that has a BroadcastReceiver that is registered
// with an intent-filter com.hansel.MY_ACTION
// Let the system found its receiver
val infos: List<ResolveInfo> = packageManager.queryBroadcastReceivers(intent, 0)
for (info in infos) {
    val cn = ComponentName(info.activityInfo.packageName,
        info.activityInfo.name)
    intent.component = cn
    sendBroadcast(intent)
}
```
## Send Ordered Broadcast (branch: `ordered-broadcast`)
It mostly handled by the receiver.
```
val intent = Intent("com.hanseltritama.MY_ACTION")
intent.setPackage("com.hanseltritama.broadcastreceiver")

val extras = Bundle()
extras.putString("stringExtra", "Start")

sendOrderedBroadcast(intent,
    null, <-- receiver permission
    SenderReceiver(), <-- broadcast receiver
    null, <-- scheduler
    0, <-- initial code
    "Start", <-- initial data
    extras) <-- intent extra
```
## Broadcast Permissions (branch: `broadcast-permission`)
Add `<uses-permission>` inside of the sender's `AndroidManifest.xml` file.
```
<uses-permission android:name="android.permission.VIBRATE" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="com.hanseltritama.CUSTOM_PERMISSION" />
```
