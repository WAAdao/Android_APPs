package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 96;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 98;BA.debugLine="PanelMain.Initialize(\"\") : PanelMain.Visible = T";
Debug.ShouldStop(2);
main.mostCurrent._panelmain.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 98;BA.debugLine="PanelMain.Initialize(\"\") : PanelMain.Visible = T";
Debug.ShouldStop(2);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 99;BA.debugLine="PanelMain.LoadLayout(\"Layout\")";
Debug.ShouldStop(4);
main.mostCurrent._panelmain.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 100;BA.debugLine="Activity.AddView(PanelMain, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panelmain.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 102;BA.debugLine="PanelSettings.Initialize(\"\") : PanelSettings.Vis";
Debug.ShouldStop(32);
main.mostCurrent._panelsettings.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 102;BA.debugLine="PanelSettings.Initialize(\"\") : PanelSettings.Vis";
Debug.ShouldStop(32);
main.mostCurrent._panelsettings.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 103;BA.debugLine="PanelSettings.LoadLayout(\"Settings\")";
Debug.ShouldStop(64);
main.mostCurrent._panelsettings.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Settings")),main.mostCurrent.activityBA);
 BA.debugLineNum = 104;BA.debugLine="Activity.AddView(PanelSettings, 0, 0, 100%x, 100";
Debug.ShouldStop(128);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panelsettings.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 106;BA.debugLine="PanelLogin.Initialize(\"\") : PanelLogin.Visible =";
Debug.ShouldStop(512);
main.mostCurrent._panellogin.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 106;BA.debugLine="PanelLogin.Initialize(\"\") : PanelLogin.Visible =";
Debug.ShouldStop(512);
main.mostCurrent._panellogin.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 107;BA.debugLine="PanelLogin.LoadLayout(\"Login\")";
Debug.ShouldStop(1024);
main.mostCurrent._panellogin.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Login")),main.mostCurrent.activityBA);
 BA.debugLineNum = 108;BA.debugLine="Activity.AddView(PanelLogin, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panellogin.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 110;BA.debugLine="PanelPesagem.Initialize(\"\") : PanelPesagem.Visib";
Debug.ShouldStop(8192);
main.mostCurrent._panelpesagem.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 110;BA.debugLine="PanelPesagem.Initialize(\"\") : PanelPesagem.Visib";
Debug.ShouldStop(8192);
main.mostCurrent._panelpesagem.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 111;BA.debugLine="PanelPesagem.LoadLayout(\"Pesagem\")";
Debug.ShouldStop(16384);
main.mostCurrent._panelpesagem.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pesagem")),main.mostCurrent.activityBA);
 BA.debugLineNum = 112;BA.debugLine="Activity.AddView(PanelPesagem, 0, 0, 100%x, 100%";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panelpesagem.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 114;BA.debugLine="PanelQRCode2.Initialize(\"\") : PanelQRCode2.Visib";
Debug.ShouldStop(131072);
main.mostCurrent._panelqrcode2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 114;BA.debugLine="PanelQRCode2.Initialize(\"\") : PanelQRCode2.Visib";
Debug.ShouldStop(131072);
main.mostCurrent._panelqrcode2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 115;BA.debugLine="PanelQRCode2.LoadLayout(\"QRCode2\")";
Debug.ShouldStop(262144);
main.mostCurrent._panelqrcode2.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("QRCode2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 116;BA.debugLine="Activity.AddView(PanelQRCode2,0,0,100%x,100%y)";
Debug.ShouldStop(524288);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panelqrcode2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 118;BA.debugLine="filename  = \"dataterminalpesagem6.db\"";
Debug.ShouldStop(2097152);
main.mostCurrent._filename = BA.ObjectToString("dataterminalpesagem6.db");
 BA.debugLineNum = 120;BA.debugLine="If File.Exists(File.DirInternal,filename) = Fals";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._filename)),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 121;BA.debugLine="File.Copy(File.DirAssets,filename,File.DirInter";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._filename),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._filename));
 };
 BA.debugLineNum = 124;BA.debugLine="If sql1.IsInitialized = False Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main._sql1.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 125;BA.debugLine="sql1.Initialize(File.DirInternal, filename, Fal";
Debug.ShouldStop(268435456);
main._sql1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._filename),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 128;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
Debug.ShouldStop(-2147483648);
main._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT NomeTerminal, EnderecoWebservice FROM Data WHERE id=1;"))));
 BA.debugLineNum = 129;BA.debugLine="cursor.Position =  0";
Debug.ShouldStop(1);
main._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 130;BA.debugLine="NomeTerminal = cursor.GetString2(0)";
Debug.ShouldStop(2);
main.mostCurrent._nometerminal = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 131;BA.debugLine="AddressWebservice = cursor.GetString2(1)";
Debug.ShouldStop(4);
main.mostCurrent._addresswebservice = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 133;BA.debugLine="ButtonOP1.Color = Colors.Green";
Debug.ShouldStop(16);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 134;BA.debugLine="ButtonOP2.Color = Colors.Red";
Debug.ShouldStop(32);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 135;BA.debugLine="ButtonOP3.Color = Colors.Red";
Debug.ShouldStop(64);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 136;BA.debugLine="ButtonOP4.Color = Colors.Red";
Debug.ShouldStop(128);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 137;BA.debugLine="ButtonOP5.Color = Colors.Red";
Debug.ShouldStop(256);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 138;BA.debugLine="ButtonOP6.Color = Colors.Red";
Debug.ShouldStop(512);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 139;BA.debugLine="OPSelecionadaButton = 1";
Debug.ShouldStop(1024);
main._opselecionadabutton = BA.numberCast(int.class, 1);
 BA.debugLineNum = 141;BA.debugLine="GetOPAtiva(True)";
Debug.ShouldStop(4096);
_getopativa(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 142;BA.debugLine="Clock(True)";
Debug.ShouldStop(8192);
_clock(main.mostCurrent.__c.getField(true,"True"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e43) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e43.toString()); BA.debugLineNum = 144;BA.debugLine="ToastMessageShow(\"Erro ao inicar aplicativo.\",Fa";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao inicar aplicativo.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,154);
if (RapidSub.canDelegate("activity_pause")) { b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed); return;}
ResumableSub_Activity_Pause rsub = new ResumableSub_Activity_Pause(null,_userclosed);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Pause extends BA.ResumableSub {
public ResumableSub_Activity_Pause(b4a.example.main parent,RemoteObject _userclosed) {
this.parent = parent;
this._userclosed = _userclosed;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _userclosed;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,154);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 155;BA.debugLine="Do While UserClosed = True";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//do while
this.state = 4;
while (RemoteObject.solveBoolean("=",_userclosed,parent.mostCurrent.__c.getField(true,"True"))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 BA.debugLineNum = 156;BA.debugLine="Sleep(1000)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_pause"),BA.numberCast(int.class, 1000));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 BA.debugLineNum = 157;BA.debugLine="Clock(False)";
Debug.ShouldStop(268435456);
_clock(parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 158;BA.debugLine="GetOPAtiva(False)";
Debug.ShouldStop(536870912);
_getopativa(parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,149);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 149;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="GetOPAtiva(True)";
Debug.ShouldStop(2097152);
_getopativa(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 151;BA.debugLine="Clock(True)";
Debug.ShouldStop(4194304);
_clock(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 152;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btscan2_click() throws Exception{
try {
		Debug.PushSubsStack("BtScan2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,657);
if (RapidSub.canDelegate("btscan2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btscan2_click");}
 BA.debugLineNum = 657;BA.debugLine="Private Sub BtScan2_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 658;BA.debugLine="myABBarcode2.ABGetBarcode(\"myabbarcode2\", \"\")";
Debug.ShouldStop(131072);
main.mostCurrent._myabbarcode2.runVoidMethod ("ABGetBarcode",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("myabbarcode2")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 659;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonconfig_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonConfig_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,480);
if (RapidSub.canDelegate("buttonconfig_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonconfig_click");}
 BA.debugLineNum = 480;BA.debugLine="Sub ButtonConfig_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 481;BA.debugLine="PanelLogin.Visible = True";
Debug.ShouldStop(1);
main.mostCurrent._panellogin.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 482;BA.debugLine="PanelMain.Visible = False";
Debug.ShouldStop(2);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 483;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttongravar_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonGravar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,358);
if (RapidSub.canDelegate("buttongravar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttongravar_click");}
 BA.debugLineNum = 358;BA.debugLine="Sub ButtonGravar_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 359;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 360;BA.debugLine="sql1.ExecNonQuery(\"UPDATE Data SET  NomeTerminal";
Debug.ShouldStop(128);
main._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE Data SET  NomeTerminal ='"),main.mostCurrent._edittextlinha.runMethod(true,"getText"),RemoteObject.createImmutable("', EnderecoWebservice='"),main.mostCurrent._edittextwebservice.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE id=1;"))));
 BA.debugLineNum = 363;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
Debug.ShouldStop(1024);
main._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT NomeTerminal, EnderecoWebservice FROM Data WHERE id=1;"))));
 BA.debugLineNum = 364;BA.debugLine="cursor.Position =  0";
Debug.ShouldStop(2048);
main._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 365;BA.debugLine="NomeTerminal = cursor.GetString2(0)";
Debug.ShouldStop(4096);
main.mostCurrent._nometerminal = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 366;BA.debugLine="AddressWebservice = cursor.GetString2(1)";
Debug.ShouldStop(8192);
main.mostCurrent._addresswebservice = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 1)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 368;BA.debugLine="MsgboxAsync(\"Erro ao gravar.\",\"Erro\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao gravar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 };
 BA.debugLineNum = 370;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonlimparbarcode_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLimparBarcode_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,485);
if (RapidSub.canDelegate("buttonlimparbarcode_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonlimparbarcode_click");}
 BA.debugLineNum = 485;BA.debugLine="Private Sub ButtonLimparBarcode_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 486;BA.debugLine="EditTextBarcode.Text = \"\"";
Debug.ShouldStop(32);
main.mostCurrent._edittextbarcode.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 487;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonlimparlogin_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLimparLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,353);
if (RapidSub.canDelegate("buttonlimparlogin_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonlimparlogin_click");}
 BA.debugLineNum = 353;BA.debugLine="Sub ButtonLimparLogin_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 354;BA.debugLine="EditTextLinha.Text = \"\"";
Debug.ShouldStop(2);
main.mostCurrent._edittextlinha.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 355;BA.debugLine="EditTextWebservice.Text = \"\"";
Debug.ShouldStop(4);
main.mostCurrent._edittextwebservice.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 356;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _buttonlogin_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,377);
if (RapidSub.canDelegate("buttonlogin_click")) { b4a.example.main.remoteMe.runUserSub(false, "main","buttonlogin_click"); return;}
ResumableSub_ButtonLogin_Click rsub = new ResumableSub_ButtonLogin_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonLogin_Click extends BA.ResumableSub {
public ResumableSub_ButtonLogin_Click(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop2 = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,377);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 378;BA.debugLine="Try";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//try
this.state = 22;
this.catchState = 21;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 21;
 BA.debugLineNum = 391;BA.debugLine="Dim URL As String";
Debug.ShouldStop(64);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 392;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(128);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 393;BA.debugLine="Dim XML As String";
Debug.ShouldStop(256);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 394;BA.debugLine="Dim JobOP2 As HttpJob";
Debug.ShouldStop(512);
_jobop2 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("JobOP2", _jobop2);
 BA.debugLineNum = 395;BA.debugLine="Dim Result As String";
Debug.ShouldStop(1024);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 397;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(4096);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 398;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(8192);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 399;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(16384);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 400;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(32768);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 401;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
Debug.ShouldStop(65536);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 402;BA.debugLine="XML = XML & \"<soap:Body>\"";
Debug.ShouldStop(131072);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 403;BA.debugLine="XML = XML & \"<LoginSoftware xmlns='http://www.ap";
Debug.ShouldStop(262144);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<LoginSoftware xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 404;BA.debugLine="XML = XML & \"<Usuario>\" & EditTextUsuarioLogin.T";
Debug.ShouldStop(524288);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Usuario>"),parent.mostCurrent._edittextusuariologin.runMethod(true,"getText"),RemoteObject.createImmutable("</Usuario>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 405;BA.debugLine="XML = XML & \"<Password>\" & EditTextSenhaLogin.Te";
Debug.ShouldStop(1048576);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Password>"),parent.mostCurrent._edittextsenhalogin.runMethod(true,"getText"),RemoteObject.createImmutable("</Password></LoginSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 406;BA.debugLine="XML = XML & \"</soap:Body>\"";
Debug.ShouldStop(2097152);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 407;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
Debug.ShouldStop(4194304);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 409;BA.debugLine="JobOP2.Initialize(\"JOBSOAP2\", Me)";
Debug.ShouldStop(16777216);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP2")),(Object)(main.getObject()));
 BA.debugLineNum = 410;BA.debugLine="JobOP2.PostString(URL,XML)";
Debug.ShouldStop(33554432);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 411;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml; char";
Debug.ShouldStop(67108864);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml; charset=utf-8")));
 BA.debugLineNum = 412;BA.debugLine="Wait For (JobOP2) JobDone";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonlogin_click"), (_jobop2));
this.state = 23;
return;
case 23:
//C
this.state = 4;
;
 BA.debugLineNum = 413;BA.debugLine="Sleep(100)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonlogin_click"),BA.numberCast(int.class, 100));
this.state = 24;
return;
case 24:
//C
this.state = 4;
;
 BA.debugLineNum = 415;BA.debugLine="If JobOP2.Success = True Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 4:
//if
this.state = 19;
if (RemoteObject.solveBoolean("=",_jobop2.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}else {
this.state = 18;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 416;BA.debugLine="XMLWork2 = JobOP2.GetString";
Debug.ShouldStop(-2147483648);
_xmlwork2 = _jobop2.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 417;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(1);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 418;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(2);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 419;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(4);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 421;BA.debugLine="If XMLWork2.Contains(\"<LoginSoftwareResult>\") =";
Debug.ShouldStop(16);
if (true) break;

case 7:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<LoginSoftwareResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 422;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
Debug.ShouldStop(32);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 423;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(64);
if (true) break;

case 10:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 424;BA.debugLine="ToastMessageShow(\"Logado com sucesso.\",False)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Logado com sucesso.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 425;BA.debugLine="Logado = True";
Debug.ShouldStop(256);
parent._logado = parent.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 426;BA.debugLine="PanelMain.Visible = True";
Debug.ShouldStop(512);
parent.mostCurrent._panelmain.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 427;BA.debugLine="PanelLogin.Visible = False";
Debug.ShouldStop(1024);
parent.mostCurrent._panellogin.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 429;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = 19;
;
 if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 433;BA.debugLine="ToastMessageShow(\"Problema no processo de Login";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Problema no processo de Login. Tente Novamente.")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 19:
//C
this.state = 22;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 21:
//C
this.state = 22;
this.catchState = 0;
 BA.debugLineNum = 436;BA.debugLine="ToastMessageShow(\"Erro ao fazer Login.\",False)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao fazer Login.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 22:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 438;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _jobdone() throws Exception{
}
public static RemoteObject  _buttonloginop2_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLoginOP2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,806);
if (RapidSub.canDelegate("buttonloginop2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonloginop2_click");}
 BA.debugLineNum = 806;BA.debugLine="Private Sub ButtonLoginOP2_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 807;BA.debugLine="PanelLogin.Visible = True";
Debug.ShouldStop(64);
main.mostCurrent._panellogin.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 808;BA.debugLine="PanelMain.Visible = False";
Debug.ShouldStop(128);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 809;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonop1_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonOP1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,861);
if (RapidSub.canDelegate("buttonop1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonop1_click");}
 BA.debugLineNum = 861;BA.debugLine="Private Sub ButtonOP1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 862;BA.debugLine="ButtonOP1.Color = Colors.Green";
Debug.ShouldStop(536870912);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 863;BA.debugLine="ButtonOP2.Color = Colors.Red";
Debug.ShouldStop(1073741824);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 864;BA.debugLine="ButtonOP3.Color = Colors.Red";
Debug.ShouldStop(-2147483648);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 865;BA.debugLine="ButtonOP4.Color = Colors.Red";
Debug.ShouldStop(1);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 866;BA.debugLine="ButtonOP5.Color = Colors.Red";
Debug.ShouldStop(2);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 867;BA.debugLine="ButtonOP6.Color = Colors.Red";
Debug.ShouldStop(4);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 868;BA.debugLine="OPSelecionadaButton = 1";
Debug.ShouldStop(8);
main._opselecionadabutton = BA.numberCast(int.class, 1);
 BA.debugLineNum = 869;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonop2_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonOP2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,851);
if (RapidSub.canDelegate("buttonop2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonop2_click");}
 BA.debugLineNum = 851;BA.debugLine="Private Sub ButtonOP2_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 852;BA.debugLine="ButtonOP1.Color = Colors.Red";
Debug.ShouldStop(524288);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 853;BA.debugLine="ButtonOP2.Color = Colors.Green";
Debug.ShouldStop(1048576);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 854;BA.debugLine="ButtonOP3.Color = Colors.Red";
Debug.ShouldStop(2097152);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 855;BA.debugLine="ButtonOP4.Color = Colors.Red";
Debug.ShouldStop(4194304);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 856;BA.debugLine="ButtonOP5.Color = Colors.Red";
Debug.ShouldStop(8388608);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 857;BA.debugLine="ButtonOP6.Color = Colors.Red";
Debug.ShouldStop(16777216);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 858;BA.debugLine="OPSelecionadaButton = 2";
Debug.ShouldStop(33554432);
main._opselecionadabutton = BA.numberCast(int.class, 2);
 BA.debugLineNum = 859;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonop3_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonOP3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,841);
if (RapidSub.canDelegate("buttonop3_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonop3_click");}
 BA.debugLineNum = 841;BA.debugLine="Private Sub ButtonOP3_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 842;BA.debugLine="ButtonOP1.Color = Colors.Red";
Debug.ShouldStop(512);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 843;BA.debugLine="ButtonOP2.Color = Colors.Red";
Debug.ShouldStop(1024);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 844;BA.debugLine="ButtonOP3.Color = Colors.Green";
Debug.ShouldStop(2048);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 845;BA.debugLine="ButtonOP4.Color = Colors.Red";
Debug.ShouldStop(4096);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 846;BA.debugLine="ButtonOP5.Color = Colors.Red";
Debug.ShouldStop(8192);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 847;BA.debugLine="ButtonOP6.Color = Colors.Red";
Debug.ShouldStop(16384);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 848;BA.debugLine="OPSelecionadaButton = 3";
Debug.ShouldStop(32768);
main._opselecionadabutton = BA.numberCast(int.class, 3);
 BA.debugLineNum = 849;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonop4_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonOP4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,831);
if (RapidSub.canDelegate("buttonop4_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonop4_click");}
 BA.debugLineNum = 831;BA.debugLine="Private Sub ButtonOP4_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 832;BA.debugLine="ButtonOP1.Color = Colors.Red";
Debug.ShouldStop(-2147483648);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 833;BA.debugLine="ButtonOP2.Color = Colors.Red";
Debug.ShouldStop(1);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 834;BA.debugLine="ButtonOP3.Color = Colors.Red";
Debug.ShouldStop(2);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 835;BA.debugLine="ButtonOP4.Color = Colors.Green";
Debug.ShouldStop(4);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 836;BA.debugLine="ButtonOP5.Color = Colors.Red";
Debug.ShouldStop(8);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 837;BA.debugLine="ButtonOP6.Color = Colors.Red";
Debug.ShouldStop(16);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 838;BA.debugLine="OPSelecionadaButton = 4";
Debug.ShouldStop(32);
main._opselecionadabutton = BA.numberCast(int.class, 4);
 BA.debugLineNum = 839;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonop5_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonOP5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,821);
if (RapidSub.canDelegate("buttonop5_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonop5_click");}
 BA.debugLineNum = 821;BA.debugLine="Private Sub ButtonOP5_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 822;BA.debugLine="ButtonOP1.Color = Colors.Red";
Debug.ShouldStop(2097152);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 823;BA.debugLine="ButtonOP2.Color = Colors.Red";
Debug.ShouldStop(4194304);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 824;BA.debugLine="ButtonOP3.Color = Colors.Red";
Debug.ShouldStop(8388608);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 825;BA.debugLine="ButtonOP4.Color = Colors.Red";
Debug.ShouldStop(16777216);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 826;BA.debugLine="ButtonOP5.Color = Colors.Green";
Debug.ShouldStop(33554432);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 827;BA.debugLine="ButtonOP6.Color = Colors.Red";
Debug.ShouldStop(67108864);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 828;BA.debugLine="OPSelecionadaButton = 5";
Debug.ShouldStop(134217728);
main._opselecionadabutton = BA.numberCast(int.class, 5);
 BA.debugLineNum = 829;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonop6_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonOP6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,811);
if (RapidSub.canDelegate("buttonop6_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonop6_click");}
 BA.debugLineNum = 811;BA.debugLine="Private Sub ButtonOP6_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 812;BA.debugLine="ButtonOP1.Color = Colors.Red";
Debug.ShouldStop(2048);
main.mostCurrent._buttonop1.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 813;BA.debugLine="ButtonOP2.Color = Colors.Red";
Debug.ShouldStop(4096);
main.mostCurrent._buttonop2.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 814;BA.debugLine="ButtonOP3.Color = Colors.Red";
Debug.ShouldStop(8192);
main.mostCurrent._buttonop3.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 815;BA.debugLine="ButtonOP4.Color = Colors.Red";
Debug.ShouldStop(16384);
main.mostCurrent._buttonop4.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 816;BA.debugLine="ButtonOP5.Color = Colors.Red";
Debug.ShouldStop(32768);
main.mostCurrent._buttonop5.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 817;BA.debugLine="ButtonOP6.Color = Colors.Green";
Debug.ShouldStop(65536);
main.mostCurrent._buttonop6.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 818;BA.debugLine="OPSelecionadaButton = 6";
Debug.ShouldStop(131072);
main._opselecionadabutton = BA.numberCast(int.class, 6);
 BA.debugLineNum = 819;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonscan_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonScan_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,534);
if (RapidSub.canDelegate("buttonscan_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonscan_click");}
 BA.debugLineNum = 534;BA.debugLine="Private Sub ButtonScan_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 535;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
Debug.ShouldStop(4194304);
main.mostCurrent._myabbarcode.runVoidMethod ("ABGetBarcode",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("myabbarcode")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 536;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonvalidate_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonValidate_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,463);
if (RapidSub.canDelegate("buttonvalidate_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonvalidate_click");}
 BA.debugLineNum = 463;BA.debugLine="Sub ButtonValidate_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 464;BA.debugLine="If Barcode1.Length > 0 And Barcode2.Length > 0 An";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean(">",main.mostCurrent._barcode1.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._barcode2.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._barcodesscc.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 465;BA.debugLine="SendSSCC";
Debug.ShouldStop(65536);
_sendsscc();
 }else 
{ BA.debugLineNum = 466;BA.debugLine="Else if Barcode1.Length = 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main.mostCurrent._barcode1.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 467;BA.debugLine="ToastMessageShow(\"Barcode 1 Vazio.\",False)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Barcode 1 Vazio.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 468;BA.debugLine="Else if Barcode2.Length = 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent._barcode2.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 469;BA.debugLine="ToastMessageShow(\"Barcode 2 Vazio.\",False)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Barcode 2 Vazio.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 470;BA.debugLine="Else if BarcodeSSCC.Length = 0 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._barcodesscc.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 471;BA.debugLine="ToastMessageShow(\"Barcode SSCC Vazio.\",False)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Barcode SSCC Vazio.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }}}}
;
 BA.debugLineNum = 473;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonvoltarlogin_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonVoltarLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,372);
if (RapidSub.canDelegate("buttonvoltarlogin_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonvoltarlogin_click");}
 BA.debugLineNum = 372;BA.debugLine="Sub ButtonVoltarLogin_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 373;BA.debugLine="PanelMain.Visible = True";
Debug.ShouldStop(1048576);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 374;BA.debugLine="PanelLogin.Visible = False";
Debug.ShouldStop(2097152);
main.mostCurrent._panellogin.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 375;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonvoltarop_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonVoltarOP_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,689);
if (RapidSub.canDelegate("buttonvoltarop_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonvoltarop_click");}
 BA.debugLineNum = 689;BA.debugLine="Private Sub ButtonVoltarOP_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 690;BA.debugLine="PanelQRCode2.Visible=False";
Debug.ShouldStop(131072);
main.mostCurrent._panelqrcode2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 691;BA.debugLine="PanelMain.Visible=True";
Debug.ShouldStop(262144);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 692;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonvoltarpesagem_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonVoltarPesagem_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,475);
if (RapidSub.canDelegate("buttonvoltarpesagem_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonvoltarpesagem_click");}
 BA.debugLineNum = 475;BA.debugLine="Sub ButtonVoltarPesagem_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 476;BA.debugLine="PanelMain.Visible = True";
Debug.ShouldStop(134217728);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 477;BA.debugLine="PanelPesagem.Visible = False";
Debug.ShouldStop(268435456);
main.mostCurrent._panelpesagem.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 478;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _clock(RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("Clock (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,164);
if (RapidSub.canDelegate("clock")) { b4a.example.main.remoteMe.runUserSub(false, "main","clock", _state); return;}
ResumableSub_Clock rsub = new ResumableSub_Clock(null,_state);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Clock extends BA.ResumableSub {
public ResumableSub_Clock(b4a.example.main parent,RemoteObject _state) {
this.parent = parent;
this._state = _state;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _state;
RemoteObject _time = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Clock (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,164);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("state", _state);
 BA.debugLineNum = 165;BA.debugLine="Do While state = True";
Debug.ShouldStop(16);
if (true) break;

case 1:
//do while
this.state = 4;
while (RemoteObject.solveBoolean("=",_state,parent.mostCurrent.__c.getField(true,"True"))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 BA.debugLineNum = 166;BA.debugLine="Dim time As String = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(32);
_time = parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("time", _time);Debug.locals.put("time", _time);
 BA.debugLineNum = 167;BA.debugLine="LabelClockLogin.Text = time";
Debug.ShouldStop(64);
parent.mostCurrent._labelclocklogin.runMethod(true,"setText",BA.ObjectToCharSequence(_time));
 BA.debugLineNum = 168;BA.debugLine="LabelClockMain.Text = time";
Debug.ShouldStop(128);
parent.mostCurrent._labelclockmain.runMethod(true,"setText",BA.ObjectToCharSequence(_time));
 BA.debugLineNum = 169;BA.debugLine="Sleep(500)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "clock"),BA.numberCast(int.class, 500));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _edittextbarcode_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("EditTextBarcode_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,489);
if (RapidSub.canDelegate("edittextbarcode_textchanged")) { return b4a.example.main.remoteMe.runUserSub(false, "main","edittextbarcode_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 489;BA.debugLine="Private Sub EditTextBarcode_TextChanged (Old As St";
Debug.ShouldStop(256);
 BA.debugLineNum = 490;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 491;BA.debugLine="If EditTextBarcode.Text.Length = 42 And EditText";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edittextbarcode.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 42)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittextbarcode.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),BA.ObjectToString("90"))) { 
 BA.debugLineNum = 492;BA.debugLine="Barcode1 = EditTextBarcode.Text";
Debug.ShouldStop(2048);
main.mostCurrent._barcode1 = main.mostCurrent._edittextbarcode.runMethod(true,"getText");
 BA.debugLineNum = 493;BA.debugLine="Barcode1 = Barcode1.Replace(Chr(29),\"\")";
Debug.ShouldStop(4096);
main.mostCurrent._barcode1 = main.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 29))))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 494;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
Debug.ShouldStop(8192);
main.mostCurrent._barcode1 = main.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 495;BA.debugLine="Quantidade = Barcode1.SubString2(12,18)";
Debug.ShouldStop(16384);
main._quantidade = BA.numberCast(int.class, main.mostCurrent._barcode1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 18))));
 BA.debugLineNum = 496;BA.debugLine="ToastMessageShow(\"Bracode 1 capturado com suces";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bracode 1 capturado com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 497;BA.debugLine="EditTextQuantidade.Text = Quantidade";
Debug.ShouldStop(65536);
main.mostCurrent._edittextquantidade.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._quantidade));
 BA.debugLineNum = 498;BA.debugLine="Material = Barcode1.SubString2(2,10)";
Debug.ShouldStop(131072);
main.mostCurrent._material = main.mostCurrent._barcode1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 499;BA.debugLine="EditTextProduto.Text = Material";
Debug.ShouldStop(262144);
main.mostCurrent._edittextproduto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._material));
 BA.debugLineNum = 500;BA.debugLine="Lote = Barcode1.SubString(20)";
Debug.ShouldStop(524288);
main._lote = BA.numberCast(int.class, main.mostCurrent._barcode1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 20))));
 BA.debugLineNum = 501;BA.debugLine="EditTextLote.Text = Lote";
Debug.ShouldStop(1048576);
main.mostCurrent._edittextlote.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._lote));
 BA.debugLineNum = 502;BA.debugLine="EditTextBarcode1.Text = Barcode1";
Debug.ShouldStop(2097152);
main.mostCurrent._edittextbarcode1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._barcode1));
 BA.debugLineNum = 503;BA.debugLine="EditTextBarcode.Text = \"\"";
Debug.ShouldStop(4194304);
main.mostCurrent._edittextbarcode.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 }else 
{ BA.debugLineNum = 504;BA.debugLine="Else if EditTextBarcode.Text.Length = 33 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edittextbarcode.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 33))) { 
 BA.debugLineNum = 505;BA.debugLine="If EditTextBarcode.Text.SubString2(0,2) = \"02\"";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edittextbarcode.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),BA.ObjectToString("02"))) { 
 BA.debugLineNum = 506;BA.debugLine="Barcode2 = EditTextBarcode.Text";
Debug.ShouldStop(33554432);
main.mostCurrent._barcode2 = main.mostCurrent._edittextbarcode.runMethod(true,"getText");
 BA.debugLineNum = 507;BA.debugLine="Barcode2 = Barcode2.Replace(Chr(29),\"\")";
Debug.ShouldStop(67108864);
main.mostCurrent._barcode2 = main.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 29))))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 508;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
Debug.ShouldStop(134217728);
main.mostCurrent._barcode2 = main.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 509;BA.debugLine="ToastMessageShow(\"Bracode 2 capturado com suce";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bracode 2 capturado com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 510;BA.debugLine="Validade = Barcode2.SubString2(18,24)";
Debug.ShouldStop(536870912);
main.mostCurrent._validade = main.mostCurrent._barcode2.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 24)));
 BA.debugLineNum = 511;BA.debugLine="Validade = Validade.SubString(4) & \"/\" & Valid";
Debug.ShouldStop(1073741824);
main.mostCurrent._validade = RemoteObject.concat(main.mostCurrent._validade.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/"),main.mostCurrent._validade.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/20"),main.mostCurrent._validade.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 512;BA.debugLine="EditTextValidade.Text = Validade";
Debug.ShouldStop(-2147483648);
main.mostCurrent._edittextvalidade.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._validade));
 BA.debugLineNum = 513;BA.debugLine="DataProducao = Barcode2.SubString(26)";
Debug.ShouldStop(1);
main.mostCurrent._dataproducao = main.mostCurrent._barcode2.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 26)));
 BA.debugLineNum = 514;BA.debugLine="DataProducao = DataProducao.SubString(4) & \"/\"";
Debug.ShouldStop(2);
main.mostCurrent._dataproducao = RemoteObject.concat(main.mostCurrent._dataproducao.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/"),main.mostCurrent._dataproducao.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/20"),main.mostCurrent._dataproducao.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 515;BA.debugLine="EditTextFabricacao.Text = DataProducao";
Debug.ShouldStop(4);
main.mostCurrent._edittextfabricacao.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._dataproducao));
 BA.debugLineNum = 516;BA.debugLine="EditTextBarcode2.Text = Barcode2";
Debug.ShouldStop(8);
main.mostCurrent._edittextbarcode2.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._barcode2));
 BA.debugLineNum = 517;BA.debugLine="EditTextBarcode.Text = \"\"";
Debug.ShouldStop(16);
main.mostCurrent._edittextbarcode.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else 
{ BA.debugLineNum = 519;BA.debugLine="Else if EditTextBarcode.Text.Length = 17 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edittextbarcode.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 17))) { 
 BA.debugLineNum = 520;BA.debugLine="If EditTextBarcode.Text.SubString2(0,2) = \"00\"";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent._edittextbarcode.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),BA.ObjectToString("00"))) { 
 BA.debugLineNum = 521;BA.debugLine="BarcodeSSCC = EditTextBarcode.Text";
Debug.ShouldStop(256);
main.mostCurrent._barcodesscc = main.mostCurrent._edittextbarcode.runMethod(true,"getText");
 BA.debugLineNum = 522;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(Chr(29),\"\")";
Debug.ShouldStop(512);
main.mostCurrent._barcodesscc = main.mostCurrent._barcodesscc.runMethod(true,"replace",(Object)(BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 29))))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 523;BA.debugLine="ToastMessageShow(\"Bracode SSCC capturado com s";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bracode SSCC capturado com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 524;BA.debugLine="EditTextBarcodeSSCC.Text = BarcodeSSCC";
Debug.ShouldStop(2048);
main.mostCurrent._edittextbarcodesscc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._barcodesscc));
 BA.debugLineNum = 525;BA.debugLine="EditTextBarcode.Text = \"\"";
Debug.ShouldStop(4096);
main.mostCurrent._edittextbarcode.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }}}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e40) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e40.toString()); BA.debugLineNum = 529;BA.debugLine="ToastMessageShow(\"Erro ao processar código.\",Fal";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao processar código.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 532;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _getidpesagem() throws Exception{
try {
		Debug.PushSubsStack("GetIdPesagem (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,696);
if (RapidSub.canDelegate("getidpesagem")) { b4a.example.main.remoteMe.runUserSub(false, "main","getidpesagem"); return;}
ResumableSub_GetIdPesagem rsub = new ResumableSub_GetIdPesagem(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_GetIdPesagem extends BA.ResumableSub {
public ResumableSub_GetIdPesagem(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop2 = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("GetIdPesagem (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,696);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 697;BA.debugLine="Try";
Debug.ShouldStop(16777216);
if (true) break;

case 1:
//try
this.state = 20;
this.catchState = 19;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 19;
 BA.debugLineNum = 698;BA.debugLine="Dim URL As String";
Debug.ShouldStop(33554432);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 699;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(67108864);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 700;BA.debugLine="Dim XML As String";
Debug.ShouldStop(134217728);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 701;BA.debugLine="Dim JobOP2 As HttpJob";
Debug.ShouldStop(268435456);
_jobop2 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("JobOP2", _jobop2);
 BA.debugLineNum = 702;BA.debugLine="Dim Result As String";
Debug.ShouldStop(536870912);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 704;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(-2147483648);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 705;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(1);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 706;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(2);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 707;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(4);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 708;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
Debug.ShouldStop(8);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 709;BA.debugLine="XML = XML & \"<soap:Body>\"";
Debug.ShouldStop(16);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 710;BA.debugLine="XML = XML & \"<GetidPesagem xmlns='http://www.apl";
Debug.ShouldStop(32);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<GetidPesagem xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 711;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
Debug.ShouldStop(64);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 712;BA.debugLine="XML = XML & \"<idOrdemProdSAP>\" & OPSap.Trim & \"<";
Debug.ShouldStop(128);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<idOrdemProdSAP>"),parent.mostCurrent._opsap.runMethod(true,"trim"),RemoteObject.createImmutable("</idOrdemProdSAP>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 713;BA.debugLine="XML = XML & \"<CodigoMaterial>\" & CodMaterial.Tri";
Debug.ShouldStop(256);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<CodigoMaterial>"),parent.mostCurrent._codmaterial.runMethod(true,"trim"),RemoteObject.createImmutable("</CodigoMaterial>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 714;BA.debugLine="XML = XML & \"<eptRota>\" & \"1\" & \"</eptRota><IDSS";
Debug.ShouldStop(512);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<eptRota>"),RemoteObject.createImmutable("1"),RemoteObject.createImmutable("</eptRota><IDSSCC>"),parent.mostCurrent._sscc.runMethod(true,"trim"),RemoteObject.createImmutable("</IDSSCC>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 715;BA.debugLine="XML = XML & \"<Settore>\" & OPSelecionadaButton &";
Debug.ShouldStop(1024);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Settore>"),parent._opselecionadabutton,RemoteObject.createImmutable("</Settore><Usuario>"),RemoteObject.createImmutable("Teste"),RemoteObject.createImmutable("</Usuario>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 716;BA.debugLine="XML = XML & \"<idTerminal>\" & \"1\" & \"</idTerminal";
Debug.ShouldStop(2048);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<idTerminal>"),RemoteObject.createImmutable("1"),RemoteObject.createImmutable("</idTerminal></GetidPesagem>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 717;BA.debugLine="XML = XML & \"</soap:Body>\"";
Debug.ShouldStop(4096);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 718;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
Debug.ShouldStop(8192);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 720;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(32768);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 721;BA.debugLine="JobOP2.PostString(URL,XML)";
Debug.ShouldStop(65536);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 722;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(131072);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 723;BA.debugLine="Wait For (JobOP2) JobDone";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getidpesagem"), (_jobop2));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
 BA.debugLineNum = 724;BA.debugLine="Sleep(100)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getidpesagem"),BA.numberCast(int.class, 100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
 BA.debugLineNum = 726;BA.debugLine="If JobOP2.Success = True Then";
Debug.ShouldStop(2097152);
if (true) break;

case 4:
//if
this.state = 17;
if (RemoteObject.solveBoolean("=",_jobop2.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 727;BA.debugLine="XMLWork2 = JobOP2.GetString";
Debug.ShouldStop(4194304);
_xmlwork2 = _jobop2.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 728;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(8388608);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 729;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(16777216);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 730;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(33554432);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 732;BA.debugLine="If XMLWork2.Contains(\"<GetidPesagemResult>\") =";
Debug.ShouldStop(134217728);
if (true) break;

case 7:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<GetidPesagemResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 733;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
Debug.ShouldStop(268435456);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 735;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 10:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 736;BA.debugLine="IdPesagem = XMLWork2.SubString2(XMLWork2.Inde";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._idpesagem = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<IdPesagem>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</IdPesagem>")))));
 BA.debugLineNum = 737;BA.debugLine="Peso = XMLWork2.SubString2(XMLWork2.IndexOf(\"";
Debug.ShouldStop(1);
parent.mostCurrent._peso = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Peso>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Peso>")))));
 BA.debugLineNum = 738;BA.debugLine="ToastMessageShow(\"ID da Pesagem valido.\",Fals";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("ID da Pesagem valido.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 740;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = 17;
;
 if (true) break;

case 17:
//C
this.state = 20;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
 BA.debugLineNum = 745;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","61507377",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 747;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _getopativa(RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("GetOPAtiva (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,175);
if (RapidSub.canDelegate("getopativa")) { b4a.example.main.remoteMe.runUserSub(false, "main","getopativa", _state); return;}
ResumableSub_GetOPAtiva rsub = new ResumableSub_GetOPAtiva(null,_state);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_GetOPAtiva extends BA.ResumableSub {
public ResumableSub_GetOPAtiva(b4a.example.main parent,RemoteObject _state) {
this.parent = parent;
this._state = _state;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _state;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");
RemoteObject _quant = RemoteObject.createImmutable(0);
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _ordens = RemoteObject.createImmutable("");
RemoteObject _ordemprod = RemoteObject.createImmutable("");
RemoteObject _statusop = RemoteObject.createImmutable("");
RemoteObject _idordemprod = RemoteObject.createImmutable("");
RemoteObject _ordemproduc = RemoteObject.createImmutable("");
RemoteObject _descricaocuc = RemoteObject.createImmutable("");
RemoteObject _datahorasap = RemoteObject.createImmutable("");
RemoteObject _setorselec = RemoteObject.createImmutable(0);
int _j = 0;
int step52;
int limit52;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("GetOPAtiva (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,175);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("state", _state);
 BA.debugLineNum = 176;BA.debugLine="Do While state = True";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//do while
this.state = 51;
while (RemoteObject.solveBoolean("=",_state,parent.mostCurrent.__c.getField(true,"True"))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 177;BA.debugLine="Try";
Debug.ShouldStop(65536);
if (true) break;

case 4:
//try
this.state = 50;
this.catchState = 49;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 49;
 BA.debugLineNum = 178;BA.debugLine="Dim URL As String";
Debug.ShouldStop(131072);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 179;BA.debugLine="Sleep(1000)";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getopativa"),BA.numberCast(int.class, 1000));
this.state = 52;
return;
case 52:
//C
this.state = 7;
;
 BA.debugLineNum = 180;BA.debugLine="Dim XMLWork As String";
Debug.ShouldStop(524288);
_xmlwork = RemoteObject.createImmutable("");Debug.locals.put("XMLWork", _xmlwork);
 BA.debugLineNum = 181;BA.debugLine="Dim XML As String";
Debug.ShouldStop(1048576);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 182;BA.debugLine="Dim JobOP As HttpJob";
Debug.ShouldStop(2097152);
_jobop = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("JobOP", _jobop);
 BA.debugLineNum = 183;BA.debugLine="Dim Result As String";
Debug.ShouldStop(4194304);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 184;BA.debugLine="Dim Quant As Int";
Debug.ShouldStop(8388608);
_quant = RemoteObject.createImmutable(0);Debug.locals.put("Quant", _quant);
 BA.debugLineNum = 185;BA.debugLine="Dim b As Bitmap";
Debug.ShouldStop(16777216);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 186;BA.debugLine="Dim c As Bitmap";
Debug.ShouldStop(33554432);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 187;BA.debugLine="Dim Ordens As String";
Debug.ShouldStop(67108864);
_ordens = RemoteObject.createImmutable("");Debug.locals.put("Ordens", _ordens);
 BA.debugLineNum = 188;BA.debugLine="Dim OrdemProd As String";
Debug.ShouldStop(134217728);
_ordemprod = RemoteObject.createImmutable("");Debug.locals.put("OrdemProd", _ordemprod);
 BA.debugLineNum = 189;BA.debugLine="Dim StatusOP As String";
Debug.ShouldStop(268435456);
_statusop = RemoteObject.createImmutable("");Debug.locals.put("StatusOP", _statusop);
 BA.debugLineNum = 190;BA.debugLine="Dim IdOrdemProd As String";
Debug.ShouldStop(536870912);
_idordemprod = RemoteObject.createImmutable("");Debug.locals.put("IdOrdemProd", _idordemprod);
 BA.debugLineNum = 191;BA.debugLine="Dim OrdemProduc As String";
Debug.ShouldStop(1073741824);
_ordemproduc = RemoteObject.createImmutable("");Debug.locals.put("OrdemProduc", _ordemproduc);
 BA.debugLineNum = 192;BA.debugLine="Dim DescricaoCUC As String";
Debug.ShouldStop(-2147483648);
_descricaocuc = RemoteObject.createImmutable("");Debug.locals.put("DescricaoCUC", _descricaocuc);
 BA.debugLineNum = 193;BA.debugLine="Dim DataHoraSAP As String";
Debug.ShouldStop(1);
_datahorasap = RemoteObject.createImmutable("");Debug.locals.put("DataHoraSAP", _datahorasap);
 BA.debugLineNum = 194;BA.debugLine="Dim SetorSelec As Int";
Debug.ShouldStop(2);
_setorselec = RemoteObject.createImmutable(0);Debug.locals.put("SetorSelec", _setorselec);
 BA.debugLineNum = 196;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(8);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 197;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(16);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 198;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
Debug.ShouldStop(32);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 199;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
Debug.ShouldStop(64);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 200;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003";
Debug.ShouldStop(128);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 201;BA.debugLine="XML = XML & \"<soap:Body>\"";
Debug.ShouldStop(256);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 202;BA.debugLine="XML = XML & \"<GetOrdensAbertasP xmlns='http://w";
Debug.ShouldStop(512);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<GetOrdensAbertasP xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 203;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><";
Debug.ShouldStop(1024);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 204;BA.debugLine="XML = XML & \"<StatusOP>2</StatusOP></GetOrdensA";
Debug.ShouldStop(2048);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<StatusOP>2</StatusOP></GetOrdensAbertasP>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 205;BA.debugLine="XML = XML & \"</soap:Body>\"";
Debug.ShouldStop(4096);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 206;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
Debug.ShouldStop(8192);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 208;BA.debugLine="JobOP.Initialize(\"JOBSOAP0\", Me)";
Debug.ShouldStop(32768);
_jobop.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP0")),(Object)(main.getObject()));
 BA.debugLineNum = 209;BA.debugLine="JobOP.PostString(URL,XML)";
Debug.ShouldStop(65536);
_jobop.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 210;BA.debugLine="JobOP.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(131072);
_jobop.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 211;BA.debugLine="Wait For (JobOP) JobDone";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getopativa"), (_jobop));
this.state = 53;
return;
case 53:
//C
this.state = 7;
;
 BA.debugLineNum = 212;BA.debugLine="Sleep(200)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getopativa"),BA.numberCast(int.class, 200));
this.state = 54;
return;
case 54:
//C
this.state = 7;
;
 BA.debugLineNum = 214;BA.debugLine="If JobOP.Success = True Then";
Debug.ShouldStop(2097152);
if (true) break;

case 7:
//if
this.state = 47;
if (RemoteObject.solveBoolean("=",_jobop.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 215;BA.debugLine="XMLWork = JobOP.GetString";
Debug.ShouldStop(4194304);
_xmlwork = _jobop.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork", _xmlwork);
 BA.debugLineNum = 216;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(8388608);
_xmlwork = _xmlwork.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork", _xmlwork);
 BA.debugLineNum = 217;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(16777216);
_xmlwork = _xmlwork.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork", _xmlwork);
 BA.debugLineNum = 218;BA.debugLine="XMLWork = XMLWork.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(33554432);
_xmlwork = _xmlwork.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork", _xmlwork);
 BA.debugLineNum = 219;BA.debugLine="Sleep(500)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getopativa"),BA.numberCast(int.class, 500));
this.state = 55;
return;
case 55:
//C
this.state = 10;
;
 BA.debugLineNum = 220;BA.debugLine="JobOP.Release";
Debug.ShouldStop(134217728);
_jobop.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 222;BA.debugLine="If XMLWork.Contains(\"<GetOrdensAbertasPResult>";
Debug.ShouldStop(536870912);
if (true) break;

case 10:
//if
this.state = 46;
if (RemoteObject.solveBoolean("=",_xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<GetOrdensAbertasPResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 223;BA.debugLine="Result = XMLWork.SubString2(XMLWork.IndexOf(\"";
Debug.ShouldStop(1073741824);
_result = _xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 224;BA.debugLine="Quant = XMLWork.SubString2(XMLWork.IndexOf(\"<";
Debug.ShouldStop(-2147483648);
_quant = BA.numberCast(int.class, _xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Quantidade>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Quantidade>"))))));Debug.locals.put("Quant", _quant);
 BA.debugLineNum = 225;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(1);
if (true) break;

case 13:
//if
this.state = 45;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 BA.debugLineNum = 226;BA.debugLine="b.InitializeResize(File.DirAssets,\"data_ok.p";
Debug.ShouldStop(2);
_b.runVoidMethod ("InitializeResize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("data_ok.png")),(Object)(BA.numberCast(int.class, "24")),(Object)(BA.numberCast(int.class, "24")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 228;BA.debugLine="c.InitializeResize(File.DirAssets,\"data.png\"";
Debug.ShouldStop(8);
_c.runVoidMethod ("InitializeResize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("data.png")),(Object)(BA.numberCast(int.class, "24")),(Object)(BA.numberCast(int.class, "24")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 230;BA.debugLine="ListViewOP.Clear";
Debug.ShouldStop(32);
parent.mostCurrent._listviewop.runVoidMethod ("Clear");
 BA.debugLineNum = 232;BA.debugLine="If Quant > 0 Then";
Debug.ShouldStop(128);
if (true) break;

case 16:
//if
this.state = 44;
if (RemoteObject.solveBoolean(">",_quant,BA.numberCast(double.class, 0))) { 
this.state = 18;
}else {
this.state = 43;
}if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 233;BA.debugLine="Ordens = XMLWork.SubString2(XMLWork.IndexOf";
Debug.ShouldStop(256);
_ordens = _xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Ordens>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Ordens>")))));Debug.locals.put("Ordens", _ordens);
 BA.debugLineNum = 235;BA.debugLine="For j=0 To Quant-1";
Debug.ShouldStop(1024);
if (true) break;

case 19:
//for
this.state = 41;
step52 = 1;
limit52 = RemoteObject.solve(new RemoteObject[] {_quant,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
Debug.locals.put("j", _j);
this.state = 56;
if (true) break;

case 56:
//C
this.state = 41;
if ((step52 > 0 && _j <= limit52) || (step52 < 0 && _j >= limit52)) this.state = 21;
if (true) break;

case 57:
//C
this.state = 56;
_j = ((int)(0 + _j + step52)) ;
Debug.locals.put("j", _j);
if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 236;BA.debugLine="OrdemProd =  Ordens.SubString2(Ordens.Inde";
Debug.ShouldStop(2048);
_ordemprod = _ordens.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordens.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<OrdemProducao>"))),RemoteObject.createImmutable(15)}, "+",1, 1)),(Object)(_ordens.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</OrdemProducao>")))));Debug.locals.put("OrdemProd", _ordemprod);
 BA.debugLineNum = 237;BA.debugLine="StatusOP = OrdemProd.SubString2(OrdemProd.";
Debug.ShouldStop(4096);
_statusop = _ordemprod.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<StatusOP>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</StatusOP>")))));Debug.locals.put("StatusOP", _statusop);
 BA.debugLineNum = 238;BA.debugLine="IdOrdemProd = OrdemProd.SubString2(OrdemPr";
Debug.ShouldStop(8192);
_idordemprod = _ordemprod.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<IdOrdemProd>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</IdOrdemProd>")))));Debug.locals.put("IdOrdemProd", _idordemprod);
 BA.debugLineNum = 239;BA.debugLine="OrdemProduc = OrdemProd.SubString2(OrdemPr";
Debug.ShouldStop(16384);
_ordemproduc = _ordemprod.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<OrdemProd>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</OrdemProd>")))));Debug.locals.put("OrdemProduc", _ordemproduc);
 BA.debugLineNum = 240;BA.debugLine="DescricaoCUC = OrdemProd.SubString2(OrdemP";
Debug.ShouldStop(32768);
_descricaocuc = _ordemprod.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoCUC>")))));Debug.locals.put("DescricaoCUC", _descricaocuc);
 BA.debugLineNum = 241;BA.debugLine="DataHoraSAP = OrdemProd.SubString2(OrdemPr";
Debug.ShouldStop(65536);
_datahorasap = _ordemprod.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<dataHoraSAP>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</dataHoraSAP>")))));Debug.locals.put("DataHoraSAP", _datahorasap);
 BA.debugLineNum = 242;BA.debugLine="SetorSelec = OrdemProd.SubString2(OrdemPro";
Debug.ShouldStop(131072);
_setorselec = BA.numberCast(int.class, _ordemprod.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SetorSelec>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_ordemprod.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SetorSelec>"))))));Debug.locals.put("SetorSelec", _setorselec);
 BA.debugLineNum = 244;BA.debugLine="OrdemProdSAP(j) = OrdemProduc";
Debug.ShouldStop(524288);
parent.mostCurrent._ordemprodsap.setArrayElement (_ordemproduc,BA.numberCast(int.class, _j));
 BA.debugLineNum = 245;BA.debugLine="DataHoraSAP = DataHoraSAP.SubString2(0,9)";
Debug.ShouldStop(1048576);
_datahorasap = _datahorasap.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 9)));Debug.locals.put("DataHoraSAP", _datahorasap);
 BA.debugLineNum = 246;BA.debugLine="DataHoraSAP = DataHoraSAP.SubString(8) & \"";
Debug.ShouldStop(2097152);
_datahorasap = RemoteObject.concat(_datahorasap.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 8))),RemoteObject.createImmutable("/"),_datahorasap.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(BA.numberCast(int.class, 7))),RemoteObject.createImmutable("/"),_datahorasap.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("DataHoraSAP", _datahorasap);
 BA.debugLineNum = 248;BA.debugLine="If StatusOP = \"2\" Then";
Debug.ShouldStop(8388608);
if (true) break;

case 22:
//if
this.state = 37;
if (RemoteObject.solveBoolean("=",_statusop,BA.ObjectToString("2"))) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 249;BA.debugLine="If SetorSelec > 0 Then";
Debug.ShouldStop(16777216);
if (true) break;

case 25:
//if
this.state = 36;
if (RemoteObject.solveBoolean(">",_setorselec,BA.numberCast(double.class, 0))) { 
this.state = 27;
}else {
this.state = 35;
}if (true) break;

case 27:
//C
this.state = 28;
 BA.debugLineNum = 251;BA.debugLine="If SetorSelec = OPSelecionadaButton Then";
Debug.ShouldStop(67108864);
if (true) break;

case 28:
//if
this.state = 33;
if (RemoteObject.solveBoolean("=",_setorselec,BA.numberCast(double.class, parent._opselecionadabutton))) { 
this.state = 30;
}else {
this.state = 32;
}if (true) break;

case 30:
//C
this.state = 33;
 BA.debugLineNum = 252;BA.debugLine="ListViewOP.AddTwoLinesAndBitmap2(\"OP \"";
Debug.ShouldStop(134217728);
parent.mostCurrent._listviewop.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("OP "),_ordemproduc,RemoteObject.createImmutable(" | Data:"),_datahorasap))),(Object)(BA.ObjectToCharSequence(_descricaocuc)),(Object)((_b.getObject())),(Object)((_idordemprod)));
 if (true) break;

case 32:
//C
this.state = 33;
 BA.debugLineNum = 254;BA.debugLine="ListViewOP.AddTwoLinesAndBitmap2(\"OP \"";
Debug.ShouldStop(536870912);
parent.mostCurrent._listviewop.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("OP "),_ordemproduc,RemoteObject.createImmutable(" | Data:"),_datahorasap))),(Object)(BA.ObjectToCharSequence(_descricaocuc)),(Object)((_c.getObject())),(Object)((_idordemprod)));
 if (true) break;

case 33:
//C
this.state = 36;
;
 if (true) break;

case 35:
//C
this.state = 36;
 BA.debugLineNum = 258;BA.debugLine="ListViewOP.AddTwoLinesAndBitmap2(\"OP \" &";
Debug.ShouldStop(2);
parent.mostCurrent._listviewop.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("OP "),_ordemproduc,RemoteObject.createImmutable(" | Data:"),_datahorasap))),(Object)(BA.ObjectToCharSequence(_descricaocuc)),(Object)((_c.getObject())),(Object)((_idordemprod)));
 if (true) break;

case 36:
//C
this.state = 37;
;
 if (true) break;
;
 BA.debugLineNum = 264;BA.debugLine="If  j < Quant-1 Then";
Debug.ShouldStop(128);

case 37:
//if
this.state = 40;
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_quant,RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
this.state = 39;
}if (true) break;

case 39:
//C
this.state = 40;
 BA.debugLineNum = 265;BA.debugLine="Ordens = Ordens.SubString(Ordens.IndexOf(";
Debug.ShouldStop(256);
_ordens = _ordens.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ordens.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</OrdemProducao>"))),RemoteObject.createImmutable(16)}, "+",1, 1)));Debug.locals.put("Ordens", _ordens);
 if (true) break;

case 40:
//C
this.state = 57;
;
 if (true) break;
if (true) break;

case 41:
//C
this.state = 44;
Debug.locals.put("j", _j);
;
 BA.debugLineNum = 269;BA.debugLine="ListViewOP.TwoLinesAndBitmap.ItemHeight = 6";
Debug.ShouldStop(4096);
parent.mostCurrent._listviewop.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60))));
 BA.debugLineNum = 270;BA.debugLine="ListViewOP.TwoLinesAndBitmap.SecondLabel.Te";
Debug.ShouldStop(8192);
parent.mostCurrent._listviewop.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel").runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 271;BA.debugLine="ListViewOP.TwoLinesAndBitmap.SecondLabel.Te";
Debug.ShouldStop(16384);
parent.mostCurrent._listviewop.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel").runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 272;BA.debugLine="ListViewOP.TwoLinesAndBitmap.Label.TextSize";
Debug.ShouldStop(32768);
parent.mostCurrent._listviewop.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 273;BA.debugLine="ListViewOP.TwoLinesAndBitmap.Label.TextColo";
Debug.ShouldStop(65536);
parent.mostCurrent._listviewop.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 if (true) break;

case 43:
//C
this.state = 44;
 BA.debugLineNum = 275;BA.debugLine="ToastMessageShow(\"Sem Ordens abertas.\",Fals";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Sem Ordens abertas.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 44:
//C
this.state = 45;
;
 if (true) break;

case 45:
//C
this.state = 46;
;
 if (true) break;

case 46:
//C
this.state = 47;
;
 if (true) break;

case 47:
//C
this.state = 50;
;
 BA.debugLineNum = 280;BA.debugLine="JobOP.Release";
Debug.ShouldStop(8388608);
_jobop.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 49:
//C
this.state = 50;
this.catchState = 0;
 BA.debugLineNum = 282;BA.debugLine="ToastMessageShow(\"Erro ao carregar OPs.\", False";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao carregar OPs.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 50:
//C
this.state = 1;
this.catchState = 0;
;
 if (true) break;

case 51:
//C
this.state = -1;
;
 BA.debugLineNum = 286;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private ListViewOP As ListView";
main.mostCurrent._listviewop = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private LabelClockMain As Label";
main.mostCurrent._labelclockmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private PanelMain As Panel";
main.mostCurrent._panelmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private PanelSettings As Panel";
main.mostCurrent._panelsettings = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private PanelLogin As Panel";
main.mostCurrent._panellogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private PanelPesagem As Panel";
main.mostCurrent._panelpesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private ButtonConfig As Button";
main.mostCurrent._buttonconfig = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private PanelQRCode2 As Panel";
main.mostCurrent._panelqrcode2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private ButtonValidate As Button";
main.mostCurrent._buttonvalidate = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private EditTextBarcode As EditText";
main.mostCurrent._edittextbarcode = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private ButtonVoltarPesagem As Button";
main.mostCurrent._buttonvoltarpesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private ButtonLimparBarcode As Button";
main.mostCurrent._buttonlimparbarcode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private Barcode1 As String";
main.mostCurrent._barcode1 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 39;BA.debugLine="Private Barcode2 As String";
main.mostCurrent._barcode2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 40;BA.debugLine="Private BarcodeSSCC As String";
main.mostCurrent._barcodesscc = RemoteObject.createImmutable("");
 //BA.debugLineNum = 41;BA.debugLine="Dim myABBarcode As ABZxing";
main.mostCurrent._myabbarcode = RemoteObject.createNew ("com.AB.ABZxing.ABZxing");
 //BA.debugLineNum = 42;BA.debugLine="Dim myABBarcode2 As ABZxing";
main.mostCurrent._myabbarcode2 = RemoteObject.createNew ("com.AB.ABZxing.ABZxing");
 //BA.debugLineNum = 43;BA.debugLine="Private Quantidade As Int = 0";
main._quantidade = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 44;BA.debugLine="Private ButtonScan As Button";
main.mostCurrent._buttonscan = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private EditTextBarcode1 As EditText";
main.mostCurrent._edittextbarcode1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private EditTextBarcode2 As EditText";
main.mostCurrent._edittextbarcode2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private EditTextBarcodeSSCC As EditText";
main.mostCurrent._edittextbarcodesscc = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private EditTextLote As EditText";
main.mostCurrent._edittextlote = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private EditTextProduto As EditText";
main.mostCurrent._edittextproduto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private EditTextQuantidade As EditText";
main.mostCurrent._edittextquantidade = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private EditTextValidade As EditText";
main.mostCurrent._edittextvalidade = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private Validade As String";
main.mostCurrent._validade = RemoteObject.createImmutable("");
 //BA.debugLineNum = 53;BA.debugLine="Private Lote As Int";
main._lote = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 54;BA.debugLine="Private Material As String";
main.mostCurrent._material = RemoteObject.createImmutable("");
 //BA.debugLineNum = 55;BA.debugLine="Private DataProducao As String";
main.mostCurrent._dataproducao = RemoteObject.createImmutable("");
 //BA.debugLineNum = 56;BA.debugLine="Private EditTextFabricacao As EditText";
main.mostCurrent._edittextfabricacao = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private EditTextLinha As EditText";
main.mostCurrent._edittextlinha = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private EditTextWebservice As EditText";
main.mostCurrent._edittextwebservice = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private filename As String";
main.mostCurrent._filename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 62;BA.debugLine="Dim NomeTerminal As String";
main.mostCurrent._nometerminal = RemoteObject.createImmutable("");
 //BA.debugLineNum = 63;BA.debugLine="Dim AddressWebservice As String";
main.mostCurrent._addresswebservice = RemoteObject.createImmutable("");
 //BA.debugLineNum = 66;BA.debugLine="Private ButtonLimparLogin As Button";
main.mostCurrent._buttonlimparlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private ButtonLogin As Button";
main.mostCurrent._buttonlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private ButtonVoltarLogin As Button";
main.mostCurrent._buttonvoltarlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private EditTextSenhaLogin As EditText";
main.mostCurrent._edittextsenhalogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private EditTextUsuarioLogin As EditText";
main.mostCurrent._edittextusuariologin = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private LabelClockLogin As Label";
main.mostCurrent._labelclocklogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private ButtonVoltar As Button";
main.mostCurrent._buttonvoltar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private BtScan2 As Button";
main.mostCurrent._btscan2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private ButtonVoltarOP As Button";
main.mostCurrent._buttonvoltarop = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 77;BA.debugLine="Private Bomba As String = \"\"";
main.mostCurrent._bomba = BA.ObjectToString("");
 //BA.debugLineNum = 78;BA.debugLine="Private SSCC As String = \"\"";
main.mostCurrent._sscc = BA.ObjectToString("");
 //BA.debugLineNum = 79;BA.debugLine="Private CodMaterial As String = \"\"";
main.mostCurrent._codmaterial = BA.ObjectToString("");
 //BA.debugLineNum = 80;BA.debugLine="Private OPSap As String = \"\"";
main.mostCurrent._opsap = BA.ObjectToString("");
 //BA.debugLineNum = 81;BA.debugLine="Private OrdemProdSAP(150) As String";
main.mostCurrent._ordemprodsap = RemoteObject.createNewArray ("String", new int[] {150}, new Object[]{});
 //BA.debugLineNum = 82;BA.debugLine="Private LabelScan As Label";
main.mostCurrent._labelscan = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private IdPesagem As String = \"\"";
main.mostCurrent._idpesagem = BA.ObjectToString("");
 //BA.debugLineNum = 84;BA.debugLine="Private Peso As String = \"\"";
main.mostCurrent._peso = BA.ObjectToString("");
 //BA.debugLineNum = 85;BA.debugLine="Private ButtonLoginOP2 As Button";
main.mostCurrent._buttonloginop2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 86;BA.debugLine="Private Logado As Boolean = False";
main._logado = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 87;BA.debugLine="Private ButtonOP1 As Button";
main.mostCurrent._buttonop1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private ButtonOP2 As Button";
main.mostCurrent._buttonop2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Private ButtonOP3 As Button";
main.mostCurrent._buttonop3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private ButtonOP4 As Button";
main.mostCurrent._buttonop4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private ButtonOP5 As Button";
main.mostCurrent._buttonop5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 92;BA.debugLine="Private ButtonOP6 As Button";
main.mostCurrent._buttonop6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 93;BA.debugLine="Private OPSelecionadaButton As Int = 0";
main._opselecionadabutton = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _labelscan_click() throws Exception{
try {
		Debug.PushSubsStack("LabelScan_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,800);
if (RapidSub.canDelegate("labelscan_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","labelscan_click");}
 BA.debugLineNum = 800;BA.debugLine="Private Sub LabelScan_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 801;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
Debug.ShouldStop(1);
main.mostCurrent._myabbarcode.runVoidMethod ("ABGetBarcode",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("myabbarcode")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 802;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _listviewop_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewOP_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,290);
if (RapidSub.canDelegate("listviewop_itemclick")) { b4a.example.main.remoteMe.runUserSub(false, "main","listviewop_itemclick", _position, _value); return;}
ResumableSub_ListViewOP_ItemClick rsub = new ResumableSub_ListViewOP_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewOP_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewOP_ItemClick(b4a.example.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _opselecionada = RemoteObject.createImmutable(0);
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop2 = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewOP_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,290);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 291;BA.debugLine="Try";
Debug.ShouldStop(4);
if (true) break;

case 1:
//try
this.state = 26;
this.catchState = 25;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 25;
 BA.debugLineNum = 292;BA.debugLine="If Logado = True Then";
Debug.ShouldStop(8);
if (true) break;

case 4:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",parent._logado,parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}else {
this.state = 22;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 293;BA.debugLine="Dim URL As String";
Debug.ShouldStop(16);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 294;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(32);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 295;BA.debugLine="Dim OPSelecionada As Int = Value";
Debug.ShouldStop(64);
_opselecionada = BA.numberCast(int.class, _value);Debug.locals.put("OPSelecionada", _opselecionada);Debug.locals.put("OPSelecionada", _opselecionada);
 BA.debugLineNum = 296;BA.debugLine="Dim XML As String";
Debug.ShouldStop(128);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 297;BA.debugLine="Dim JobOP2 As HttpJob";
Debug.ShouldStop(256);
_jobop2 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("JobOP2", _jobop2);
 BA.debugLineNum = 298;BA.debugLine="Dim Result As String";
Debug.ShouldStop(512);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 300;BA.debugLine="OPSap = OrdemProdSAP(Position)";
Debug.ShouldStop(2048);
parent.mostCurrent._opsap = parent.mostCurrent._ordemprodsap.getArrayElement(true,_position);
 BA.debugLineNum = 301;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(4096);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 302;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(8192);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 303;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
Debug.ShouldStop(16384);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 304;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
Debug.ShouldStop(32768);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 305;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003";
Debug.ShouldStop(65536);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 306;BA.debugLine="XML = XML & \"<soap:Body>\"";
Debug.ShouldStop(131072);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 307;BA.debugLine="XML = XML & \"<SelecionaOP xmlns='http://www.apl";
Debug.ShouldStop(262144);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<SelecionaOP xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 308;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><";
Debug.ShouldStop(524288);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 309;BA.debugLine="XML = XML & \"<Settore>\" & OPSelecionadaButton &";
Debug.ShouldStop(1048576);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Settore>"),parent._opselecionadabutton,RemoteObject.createImmutable("</Settore>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 310;BA.debugLine="XML = XML & \"<IdOrdemProd>\" & OPSelecionada & \"";
Debug.ShouldStop(2097152);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<IdOrdemProd>"),_opselecionada,RemoteObject.createImmutable("</IdOrdemProd></SelecionaOP>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 311;BA.debugLine="XML = XML & \"</soap:Body>\"";
Debug.ShouldStop(4194304);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 312;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
Debug.ShouldStop(8388608);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 314;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(33554432);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 315;BA.debugLine="JobOP2.PostString(URL,XML)";
Debug.ShouldStop(67108864);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 316;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(134217728);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 317;BA.debugLine="Wait For (JobOP2) JobDone";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewop_itemclick"), (_jobop2));
this.state = 27;
return;
case 27:
//C
this.state = 7;
;
 BA.debugLineNum = 318;BA.debugLine="Sleep(100)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewop_itemclick"),BA.numberCast(int.class, 100));
this.state = 28;
return;
case 28:
//C
this.state = 7;
;
 BA.debugLineNum = 320;BA.debugLine="If JobOP2.Success = True Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 7:
//if
this.state = 20;
if (RemoteObject.solveBoolean("=",_jobop2.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 321;BA.debugLine="XMLWork2 = JobOP2.GetString";
Debug.ShouldStop(1);
_xmlwork2 = _jobop2.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 322;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(2);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 323;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(4);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 324;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(8);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 326;BA.debugLine="If XMLWork2.Contains(\"<SelecionaOPResult>\") =";
Debug.ShouldStop(32);
if (true) break;

case 10:
//if
this.state = 19;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SelecionaOPResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 327;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf";
Debug.ShouldStop(64);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 329;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(256);
if (true) break;

case 13:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
 BA.debugLineNum = 330;BA.debugLine="ToastMessageShow(\"OP selecionada com sucesso";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("OP selecionada com sucesso.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 331;BA.debugLine="PanelMain.Visible = False";
Debug.ShouldStop(1024);
parent.mostCurrent._panelmain.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 332;BA.debugLine="PanelQRCode2.Visible = True";
Debug.ShouldStop(2048);
parent.mostCurrent._panelqrcode2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 333;BA.debugLine="Barcode1 = \"\"";
Debug.ShouldStop(4096);
parent.mostCurrent._barcode1 = BA.ObjectToString("");
 BA.debugLineNum = 334;BA.debugLine="Barcode2 = \"\"";
Debug.ShouldStop(8192);
parent.mostCurrent._barcode2 = BA.ObjectToString("");
 BA.debugLineNum = 335;BA.debugLine="BarcodeSSCC = \"\"";
Debug.ShouldStop(16384);
parent.mostCurrent._barcodesscc = BA.ObjectToString("");
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 337;BA.debugLine="ToastMessageShow(\"Falha so selecionar OP, te";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Falha so selecionar OP, tente novamente.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 18:
//C
this.state = 19;
;
 if (true) break;

case 19:
//C
this.state = 20;
;
 if (true) break;

case 20:
//C
this.state = 23;
;
 BA.debugLineNum = 341;BA.debugLine="JobOP2.Release";
Debug.ShouldStop(1048576);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 if (true) break;

case 22:
//C
this.state = 23;
 BA.debugLineNum = 343;BA.debugLine="ToastMessageShow(\"Por favor faça o Login para a";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Por favor faça o Login para acessar funções do sistema.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 23:
//C
this.state = 26;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
 BA.debugLineNum = 346;BA.debugLine="ToastMessageShow(\"Erro ao enviar OP selecionada.";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao enviar OP selecionada..")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 349;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _myabbarcode_barcodefound(RemoteObject _barcode,RemoteObject _formatname) throws Exception{
try {
		Debug.PushSubsStack("myABBarcode_BarcodeFound (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,538);
if (RapidSub.canDelegate("myabbarcode_barcodefound")) { return b4a.example.main.remoteMe.runUserSub(false, "main","myabbarcode_barcodefound", _barcode, _formatname);}
Debug.locals.put("barCode", _barcode);
Debug.locals.put("formatName", _formatname);
 BA.debugLineNum = 538;BA.debugLine="Sub myABBarcode_BarcodeFound (barCode As String, f";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 576;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 577;BA.debugLine="If barCode.SubString2(0,1) = \"@\" Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1))),BA.ObjectToString("@"))) { 
 BA.debugLineNum = 585;BA.debugLine="Bomba = barCode.SubString(3)";
Debug.ShouldStop(256);
main.mostCurrent._bomba = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)));
 BA.debugLineNum = 586;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fal";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código lido com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 588;BA.debugLine="SSCC = barCode.SubString2(0,9)";
Debug.ShouldStop(2048);
main.mostCurrent._sscc = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 9)));
 BA.debugLineNum = 589;BA.debugLine="CodMaterial = barCode.SubString2(10,18)";
Debug.ShouldStop(4096);
main.mostCurrent._codmaterial = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 18)));
 BA.debugLineNum = 590;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fal";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código lido com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e11.toString()); BA.debugLineNum = 593;BA.debugLine="ToastMessageShow(\"Código Invalido\", False)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código Invalido")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 596;BA.debugLine="If Bomba.Length > 0 And SSCC.Length > 0 And CodMa";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",main.mostCurrent._bomba.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._sscc.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._codmaterial.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 597;BA.debugLine="VinculaBomba";
Debug.ShouldStop(1048576);
_vinculabomba();
 };
 BA.debugLineNum = 599;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _myabbarcode2_barcodefound(RemoteObject _barcode,RemoteObject _formatname) throws Exception{
try {
		Debug.PushSubsStack("myABBarcode2_BarcodeFound (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,661);
if (RapidSub.canDelegate("myabbarcode2_barcodefound")) { return b4a.example.main.remoteMe.runUserSub(false, "main","myabbarcode2_barcodefound", _barcode, _formatname);}
Debug.locals.put("barCode", _barcode);
Debug.locals.put("formatName", _formatname);
 BA.debugLineNum = 661;BA.debugLine="Sub myABBarcode2_BarcodeFound (barCode As String,";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 662;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 663;BA.debugLine="If Logado = True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main._logado,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 664;BA.debugLine="If barCode.SubString2(0,1) = \"@\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1))),BA.ObjectToString("@"))) { 
 BA.debugLineNum = 672;BA.debugLine="Bomba = barCode.SubString(3)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._bomba = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)));
 BA.debugLineNum = 673;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fa";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código lido com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 675;BA.debugLine="SSCC = barCode.SubString2(0,9)";
Debug.ShouldStop(4);
main.mostCurrent._sscc = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 9)));
 BA.debugLineNum = 676;BA.debugLine="CodMaterial = barCode.SubString2(10,18)";
Debug.ShouldStop(8);
main.mostCurrent._codmaterial = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 18)));
 BA.debugLineNum = 677;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fa";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código lido com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e13.toString()); BA.debugLineNum = 681;BA.debugLine="ToastMessageShow(\"Código Invalido\", False)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código Invalido")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 684;BA.debugLine="If Bomba.Length > 0 And SSCC.Length > 0 And CodMa";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",main.mostCurrent._bomba.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._sscc.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._codmaterial.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 685;BA.debugLine="GetIdPesagem";
Debug.ShouldStop(4096);
_getidpesagem();
 };
 BA.debugLineNum = 687;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
autostart_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
autostart.myClass = BA.getDeviceClass ("b4a.example.autostart");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Dim sql1  As SQL";
main._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 17;BA.debugLine="Dim cursor As Cursor";
main._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _sendsscc() throws Exception{
try {
		Debug.PushSubsStack("SendSSCC (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,601);
if (RapidSub.canDelegate("sendsscc")) { b4a.example.main.remoteMe.runUserSub(false, "main","sendsscc"); return;}
ResumableSub_SendSSCC rsub = new ResumableSub_SendSSCC(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_SendSSCC extends BA.ResumableSub {
public ResumableSub_SendSSCC(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop3 = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("SendSSCC (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,601);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 602;BA.debugLine="Try";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//try
this.state = 20;
this.catchState = 19;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 19;
 BA.debugLineNum = 603;BA.debugLine="Dim URL As String";
Debug.ShouldStop(67108864);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 604;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(134217728);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 605;BA.debugLine="Dim XML As String";
Debug.ShouldStop(268435456);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 606;BA.debugLine="Dim JobOP3 As HttpJob";
Debug.ShouldStop(536870912);
_jobop3 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("JobOP3", _jobop3);
 BA.debugLineNum = 607;BA.debugLine="Dim Result As String";
Debug.ShouldStop(1073741824);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 609;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(1);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 610;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(2);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 611;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(4);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 612;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(8);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 613;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
Debug.ShouldStop(16);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 614;BA.debugLine="XML = XML & \"<soap:Body><RegistraSSCC xmlns='htt";
Debug.ShouldStop(32);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body><RegistraSSCC xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 615;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
Debug.ShouldStop(64);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 616;BA.debugLine="XML = XML & \"<Barcode1>\" & Barcode1 & \"</Barcode";
Debug.ShouldStop(128);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Barcode1>"),parent.mostCurrent._barcode1,RemoteObject.createImmutable("</Barcode1><Barcode2>"),parent.mostCurrent._barcode2,RemoteObject.createImmutable("</Barcode2>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 617;BA.debugLine="XML = XML & \"<BarcodeSSCC>\" & BarcodeSSCC & \"</B";
Debug.ShouldStop(256);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<BarcodeSSCC>"),parent.mostCurrent._barcodesscc,RemoteObject.createImmutable("</BarcodeSSCC>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 618;BA.debugLine="XML = XML & \"<UsuarioLeitura>user</UsuarioLeitur";
Debug.ShouldStop(512);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UsuarioLeitura>user</UsuarioLeitura><Quantidade>"),parent._quantidade,RemoteObject.createImmutable("</Quantidade>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 619;BA.debugLine="XML = XML & \"</RegistraSSCC></soap:Body></soap:E";
Debug.ShouldStop(1024);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</RegistraSSCC></soap:Body></soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 621;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
Debug.ShouldStop(4096);
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 622;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
Debug.ShouldStop(8192);
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 623;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
Debug.ShouldStop(16384);
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 625;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(65536);
_jobop3.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 626;BA.debugLine="JobOP3.PostString(URL,XML)";
Debug.ShouldStop(131072);
_jobop3.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 627;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(262144);
_jobop3.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 628;BA.debugLine="Wait For (JobOP3) JobDone";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "sendsscc"), (_jobop3));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
 BA.debugLineNum = 629;BA.debugLine="Sleep(100)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "sendsscc"),BA.numberCast(int.class, 100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
 BA.debugLineNum = 631;BA.debugLine="If JobOP3.Success = True Then";
Debug.ShouldStop(4194304);
if (true) break;

case 4:
//if
this.state = 17;
if (RemoteObject.solveBoolean("=",_jobop3.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 632;BA.debugLine="XMLWork2 = JobOP3.GetString";
Debug.ShouldStop(8388608);
_xmlwork2 = _jobop3.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 633;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(16777216);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 634;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(33554432);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 635;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(67108864);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 637;BA.debugLine="If XMLWork2.Contains(\"<RegistraSSCCResult>\") =";
Debug.ShouldStop(268435456);
if (true) break;

case 7:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<RegistraSSCCResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 638;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
Debug.ShouldStop(536870912);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 640;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 10:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 641;BA.debugLine="ToastMessageShow(\"SSCC registrado com sucesso";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("SSCC registrado com sucesso.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 642;BA.debugLine="Barcode1 = \"\"";
Debug.ShouldStop(2);
parent.mostCurrent._barcode1 = BA.ObjectToString("");
 BA.debugLineNum = 643;BA.debugLine="Barcode2 = \"\"";
Debug.ShouldStop(4);
parent.mostCurrent._barcode2 = BA.ObjectToString("");
 BA.debugLineNum = 644;BA.debugLine="BarcodeSSCC = \"\"";
Debug.ShouldStop(8);
parent.mostCurrent._barcodesscc = BA.ObjectToString("");
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 646;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = 17;
;
 if (true) break;

case 17:
//C
this.state = 20;
;
 BA.debugLineNum = 650;BA.debugLine="JobOP3.Release";
Debug.ShouldStop(512);
_jobop3.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
 BA.debugLineNum = 652;BA.debugLine="ToastMessageShow(\"Erro ao registtar SCCC.\", Fals";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao registtar SCCC.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 655;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _vinculabomba() throws Exception{
try {
		Debug.PushSubsStack("VinculaBomba (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,751);
if (RapidSub.canDelegate("vinculabomba")) { b4a.example.main.remoteMe.runUserSub(false, "main","vinculabomba"); return;}
ResumableSub_VinculaBomba rsub = new ResumableSub_VinculaBomba(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_VinculaBomba extends BA.ResumableSub {
public ResumableSub_VinculaBomba(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop2 = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("VinculaBomba (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,751);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 752;BA.debugLine="Try";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//try
this.state = 20;
this.catchState = 19;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 19;
 BA.debugLineNum = 753;BA.debugLine="Dim URL As String";
Debug.ShouldStop(65536);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 754;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(131072);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 755;BA.debugLine="Dim XML As String";
Debug.ShouldStop(262144);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 756;BA.debugLine="Dim JobOP2 As HttpJob";
Debug.ShouldStop(524288);
_jobop2 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("JobOP2", _jobop2);
 BA.debugLineNum = 757;BA.debugLine="Dim Result As String";
Debug.ShouldStop(1048576);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 759;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(4194304);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 760;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(8388608);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 761;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(16777216);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 762;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(33554432);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 763;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
Debug.ShouldStop(67108864);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 764;BA.debugLine="XML = XML & \"<soap:Body>\"";
Debug.ShouldStop(134217728);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 765;BA.debugLine="XML = XML & \"<VinculaBomba xmlns='http://www.apl";
Debug.ShouldStop(268435456);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<VinculaBomba xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 766;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
Debug.ShouldStop(536870912);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 767;BA.debugLine="XML = XML & \"<IdSSCC>\" & SSCC.Trim & \"</IdSSCC>\"";
Debug.ShouldStop(1073741824);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<IdSSCC>"),parent.mostCurrent._sscc.runMethod(true,"trim"),RemoteObject.createImmutable("</IdSSCC>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 768;BA.debugLine="XML = XML & \"<CodigoBomba>\" & Bomba.Trim & \"</Co";
Debug.ShouldStop(-2147483648);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<CodigoBomba>"),parent.mostCurrent._bomba.runMethod(true,"trim"),RemoteObject.createImmutable("</CodigoBomba></VinculaBomba>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 769;BA.debugLine="XML = XML & \"</soap:Body>\"";
Debug.ShouldStop(1);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Body>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 770;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
Debug.ShouldStop(2);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 772;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(8);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 773;BA.debugLine="JobOP2.PostString(URL,XML)";
Debug.ShouldStop(16);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 774;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(32);
_jobop2.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 775;BA.debugLine="Wait For (JobOP2) JobDone";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "vinculabomba"), (_jobop2));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
 BA.debugLineNum = 776;BA.debugLine="Sleep(100)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "vinculabomba"),BA.numberCast(int.class, 100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
 BA.debugLineNum = 778;BA.debugLine="If JobOP2.Success = True Then";
Debug.ShouldStop(512);
if (true) break;

case 4:
//if
this.state = 17;
if (RemoteObject.solveBoolean("=",_jobop2.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 779;BA.debugLine="XMLWork2 = JobOP2.GetString";
Debug.ShouldStop(1024);
_xmlwork2 = _jobop2.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 780;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(2048);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 781;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(4096);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 782;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(8192);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 784;BA.debugLine="If XMLWork2.Contains(\"<VinculaBombaResult>\") =";
Debug.ShouldStop(32768);
if (true) break;

case 7:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<VinculaBombaResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 785;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
Debug.ShouldStop(65536);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 786;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(131072);
if (true) break;

case 10:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 787;BA.debugLine="ToastMessageShow(\"Bomba vinculada com sucesso";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bomba vinculada com sucesso")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 789;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = 17;
;
 if (true) break;

case 17:
//C
this.state = 20;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
 BA.debugLineNum = 794;BA.debugLine="Log(LastException)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","61572907",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 796;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
}