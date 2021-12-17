package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class autostart_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (autostart) ","autostart",2,autostart.processBA,autostart.mostCurrent,11);
if (RapidSub.canDelegate("service_create")) { return b4a.example.autostart.remoteMe.runUserSub(false, "autostart","service_create");}
 BA.debugLineNum = 11;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(1024);
 BA.debugLineNum = 13;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (autostart) ","autostart",2,autostart.processBA,autostart.mostCurrent,20);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.autostart.remoteMe.runUserSub(false, "autostart","service_destroy");}
 BA.debugLineNum = 20;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (autostart) ","autostart",2,autostart.processBA,autostart.mostCurrent,15);
if (RapidSub.canDelegate("service_start")) { return b4a.example.autostart.remoteMe.runUserSub(false, "autostart","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 15;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="Service.StopAutomaticForeground 'Call this when t";
Debug.ShouldStop(32768);
autostart.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 17;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(65536);
autostart.mostCurrent.__c.runVoidMethod ("StartActivity",autostart.processBA,(Object)((autostart.mostCurrent._main.getObject())));
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}