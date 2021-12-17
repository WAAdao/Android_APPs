package VinculaBomba.Unielver;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("activity_create")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="PanelLeitura.Initialize(\"\") : PanelLeitura.Visibl";
Debug.ShouldStop(64);
main.mostCurrent._panelleitura.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 71;BA.debugLine="PanelLeitura.Initialize(\"\") : PanelLeitura.Visibl";
Debug.ShouldStop(64);
main.mostCurrent._panelleitura.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 72;BA.debugLine="PanelLeitura.LoadLayout(\"Layout\")";
Debug.ShouldStop(128);
main.mostCurrent._panelleitura.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 73;BA.debugLine="Activity.AddView(PanelLeitura, 0, 0, 100%x, 100%y";
Debug.ShouldStop(256);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panelleitura.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 74;BA.debugLine="PanelLogin2.Initialize(\"\") : PanelLogin2.Visible";
Debug.ShouldStop(512);
main.mostCurrent._panellogin2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 74;BA.debugLine="PanelLogin2.Initialize(\"\") : PanelLogin2.Visible";
Debug.ShouldStop(512);
main.mostCurrent._panellogin2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 75;BA.debugLine="PanelLogin2.LoadLayout(\"Login\")";
Debug.ShouldStop(1024);
main.mostCurrent._panellogin2.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Login")),main.mostCurrent.activityBA);
 BA.debugLineNum = 76;BA.debugLine="Activity.AddView(PanelLogin2, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panellogin2.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 77;BA.debugLine="PanelConfig.Initialize(\"\") : PanelConfig.Visible";
Debug.ShouldStop(4096);
main.mostCurrent._panelconfig.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 77;BA.debugLine="PanelConfig.Initialize(\"\") : PanelConfig.Visible";
Debug.ShouldStop(4096);
main.mostCurrent._panelconfig.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 78;BA.debugLine="PanelConfig.LoadLayout(\"Config\")";
Debug.ShouldStop(8192);
main.mostCurrent._panelconfig.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Config")),main.mostCurrent.activityBA);
 BA.debugLineNum = 79;BA.debugLine="Activity.AddView(PanelConfig, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panelconfig.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 80;BA.debugLine="filename  = \"dataterminalpesagem.db\"";
Debug.ShouldStop(32768);
main.mostCurrent._filename = BA.ObjectToString("dataterminalpesagem.db");
 BA.debugLineNum = 82;BA.debugLine="If File.Exists(File.DirInternal,filename) = False";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._filename)),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 83;BA.debugLine="File.Copy(File.DirAssets,filename,File.DirIntern";
Debug.ShouldStop(262144);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._filename),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._filename));
 };
 BA.debugLineNum = 86;BA.debugLine="If sql1.IsInitialized = False Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main._sql1.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 87;BA.debugLine="sql1.Initialize(File.DirInternal, filename, Fals";
Debug.ShouldStop(4194304);
main._sql1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._filename),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 90;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, End";
Debug.ShouldStop(33554432);
main._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT NomeTerminal, EnderecoWebservice, NomeImpressora FROM Data WHERE id=1;"))));
 BA.debugLineNum = 91;BA.debugLine="cursor.Position =  0";
Debug.ShouldStop(67108864);
main._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 92;BA.debugLine="Nometerminal = cursor.GetString2(0)";
Debug.ShouldStop(134217728);
main.mostCurrent._nometerminal = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 94;BA.debugLine="NamePrinter = cursor.GetString2(2)";
Debug.ShouldStop(536870912);
main.mostCurrent._nameprinter = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 95;BA.debugLine="ButtonVincularBomba.Color = Colors.Green";
Debug.ShouldStop(1073741824);
main.mostCurrent._buttonvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 96;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
Debug.ShouldStop(-2147483648);
main.mostCurrent._buttonvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 97;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Red";
Debug.ShouldStop(1);
main.mostCurrent._buttondesvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 98;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
Debug.ShouldStop(2);
main.mostCurrent._buttondesvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 99;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Red";
Debug.ShouldStop(4);
main.mostCurrent._buttonregistrasscc.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 100;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
Debug.ShouldStop(8);
main.mostCurrent._buttonregistrasscc.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 101;BA.debugLine="Mode = 1";
Debug.ShouldStop(16);
main._mode = BA.numberCast(int.class, 1);
 BA.debugLineNum = 102;BA.debugLine="StatusLogin = 0";
Debug.ShouldStop(32);
main._statuslogin = BA.numberCast(int.class, 0);
 BA.debugLineNum = 103;BA.debugLine="ButtonScan.Enabled = False";
Debug.ShouldStop(64);
main.mostCurrent._buttonscan.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="ButtonConcluir.Enabled = False";
Debug.ShouldStop(128);
main.mostCurrent._buttonconcluir.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("activity_pause")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 111;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("activity_resume")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 107;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonconcluir_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonConcluir_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,160);
if (RapidSub.canDelegate("buttonconcluir_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonconcluir_click");}
RemoteObject _b1 = RemoteObject.createImmutable(0);
RemoteObject _b2 = RemoteObject.createImmutable(0);
RemoteObject _bs = RemoteObject.createImmutable(0);
 BA.debugLineNum = 160;BA.debugLine="Private Sub ButtonConcluir_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="If StatusLogin =1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main._statuslogin,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 162;BA.debugLine="If idSSCC.Length > 0 And CodigoBomba.Length > 0";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",main.mostCurrent._idsscc.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._codigobomba.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 163;BA.debugLine="If Mode=1 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main._mode,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 164;BA.debugLine="If idSSCC.Length > 0 And CodigoBomba.Length >";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",main.mostCurrent._idsscc.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._codigobomba.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 165;BA.debugLine="VinculaBomba";
Debug.ShouldStop(16);
_vinculabomba();
 };
 }else 
{ BA.debugLineNum = 167;BA.debugLine="Else If Mode=2 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main._mode,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 168;BA.debugLine="idSSCC = 00";
Debug.ShouldStop(128);
main.mostCurrent._idsscc = BA.NumberToString(00);
 BA.debugLineNum = 169;BA.debugLine="If idSSCC.Length > 0 And CodigoBomba.Length >";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",main.mostCurrent._idsscc.runMethod(true,"length"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",main.mostCurrent._codigobomba.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 170;BA.debugLine="VinculaBomba";
Debug.ShouldStop(512);
_vinculabomba();
 };
 }else 
{ BA.debugLineNum = 172;BA.debugLine="Else If Mode=3 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main._mode,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 173;BA.debugLine="Dim B1 As Int = 0";
Debug.ShouldStop(4096);
_b1 = BA.numberCast(int.class, 0);Debug.locals.put("B1", _b1);Debug.locals.put("B1", _b1);
 BA.debugLineNum = 174;BA.debugLine="Dim B2 As Int = 0";
Debug.ShouldStop(8192);
_b2 = BA.numberCast(int.class, 0);Debug.locals.put("B2", _b2);Debug.locals.put("B2", _b2);
 BA.debugLineNum = 175;BA.debugLine="Dim BS As Int = 0";
Debug.ShouldStop(16384);
_bs = BA.numberCast(int.class, 0);Debug.locals.put("BS", _bs);Debug.locals.put("BS", _bs);
 BA.debugLineNum = 177;BA.debugLine="If Barcode1 = \"\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main.mostCurrent._barcode1,BA.ObjectToString(""))) { 
 BA.debugLineNum = 178;BA.debugLine="ToastMessageShow(\"Faça a leitura do código de";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Faça a leitura do código de Lote.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 179;BA.debugLine="B1 = 1";
Debug.ShouldStop(262144);
_b1 = BA.numberCast(int.class, 1);Debug.locals.put("B1", _b1);
 };
 BA.debugLineNum = 182;BA.debugLine="If Barcode2 = \"\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._barcode2,BA.ObjectToString(""))) { 
 BA.debugLineNum = 183;BA.debugLine="ToastMessageShow(\"Faça a leitura do código Va";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Faça a leitura do código Validade.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 184;BA.debugLine="B2 = 1";
Debug.ShouldStop(8388608);
_b2 = BA.numberCast(int.class, 1);Debug.locals.put("B2", _b2);
 };
 BA.debugLineNum = 187;BA.debugLine="If BarcodeSSCC = \"\" Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main.mostCurrent._barcodesscc,BA.ObjectToString(""))) { 
 BA.debugLineNum = 188;BA.debugLine="ToastMessageShow(\"Faça a leitura do código SS";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Faça a leitura do código SSCC.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 189;BA.debugLine="BS = 1";
Debug.ShouldStop(268435456);
_bs = BA.numberCast(int.class, 1);Debug.locals.put("BS", _bs);
 };
 BA.debugLineNum = 192;BA.debugLine="If  B1 =1 And B2 =1 And BS =1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_b1,BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",_b2,BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",_bs,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 193;BA.debugLine="SendSSCC";
Debug.ShouldStop(1);
_sendsscc();
 };
 }}}
;
 };
 };
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttondesvincularbomba_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonDesvincularBomba_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,138);
if (RapidSub.canDelegate("buttondesvincularbomba_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttondesvincularbomba_click");}
 BA.debugLineNum = 138;BA.debugLine="Private Sub ButtonDesvincularBomba_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="ButtonVincularBomba.Color = Colors.Red";
Debug.ShouldStop(1024);
main.mostCurrent._buttonvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 140;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
Debug.ShouldStop(2048);
main.mostCurrent._buttonvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 141;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Green";
Debug.ShouldStop(4096);
main.mostCurrent._buttondesvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 142;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
Debug.ShouldStop(8192);
main.mostCurrent._buttondesvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 143;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Red";
Debug.ShouldStop(16384);
main.mostCurrent._buttonregistrasscc.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 144;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
Debug.ShouldStop(32768);
main.mostCurrent._buttonregistrasscc.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 145;BA.debugLine="Mode = 2";
Debug.ShouldStop(65536);
main._mode = BA.numberCast(int.class, 2);
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonimprimir_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonImprimir_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,202);
if (RapidSub.canDelegate("buttonimprimir_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonimprimir_click");}
 BA.debugLineNum = 202;BA.debugLine="Private Sub ButtonImprimir_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 203;BA.debugLine="PrintBT";
Debug.ShouldStop(1024);
_printbt();
 BA.debugLineNum = 204;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("ButtonLimparLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,524);
if (RapidSub.canDelegate("buttonlimparlogin_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonlimparlogin_click");}
 BA.debugLineNum = 524;BA.debugLine="Private Sub ButtonLimparLogin_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 525;BA.debugLine="EditTextSenha.Text = \"\"";
Debug.ShouldStop(4096);
main.mostCurrent._edittextsenha.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 526;BA.debugLine="EditTextUsuario.Text = \"\"";
Debug.ShouldStop(8192);
main.mostCurrent._edittextusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 527;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonlogin_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,529);
if (RapidSub.canDelegate("buttonlogin_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonlogin_click");}
 BA.debugLineNum = 529;BA.debugLine="Private Sub ButtonLogin_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 530;BA.debugLine="PanelLogin2.Visible = True";
Debug.ShouldStop(131072);
main.mostCurrent._panellogin2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 531;BA.debugLine="PanelLeitura.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._panelleitura.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
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
public static void  _buttonlogintela_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLoginTela_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,462);
if (RapidSub.canDelegate("buttonlogintela_click")) { VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonlogintela_click"); return;}
ResumableSub_ButtonLoginTela_Click rsub = new ResumableSub_ButtonLoginTela_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonLoginTela_Click extends BA.ResumableSub {
public ResumableSub_ButtonLoginTela_Click(VinculaBomba.Unielver.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
VinculaBomba.Unielver.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop3 = RemoteObject.declareNull("VinculaBomba.Unielver.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonLoginTela_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,462);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 463;BA.debugLine="Try";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 464;BA.debugLine="If EditTextUsuario.Text = \"admin\" And EditTextSe";
Debug.ShouldStop(32768);
if (true) break;

case 4:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._edittextusuario.runMethod(true,"getText"),BA.ObjectToString("admin")) && RemoteObject.solveBoolean("=",parent.mostCurrent._edittextsenha.runMethod(true,"getText"),BA.ObjectToString("password"))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 23;
 BA.debugLineNum = 465;BA.debugLine="PanelLeitura.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._panelleitura.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 466;BA.debugLine="PanelConfig.Visible = True";
Debug.ShouldStop(131072);
parent.mostCurrent._panelconfig.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 468;BA.debugLine="Dim URL As String";
Debug.ShouldStop(524288);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 469;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(1048576);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 471;BA.debugLine="Dim XML As String";
Debug.ShouldStop(4194304);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 472;BA.debugLine="Dim JobOP3 As HttpJob";
Debug.ShouldStop(8388608);
_jobop3 = RemoteObject.createNew ("VinculaBomba.Unielver.httpjob");Debug.locals.put("JobOP3", _jobop3);
 BA.debugLineNum = 473;BA.debugLine="Dim Result As String";
Debug.ShouldStop(16777216);
_result = RemoteObject.createImmutable("");Debug.locals.put("Result", _result);
 BA.debugLineNum = 475;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
Debug.ShouldStop(67108864);
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 476;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
Debug.ShouldStop(134217728);
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 477;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
Debug.ShouldStop(268435456);
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 478;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(536870912);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 479;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(1073741824);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 480;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
Debug.ShouldStop(-2147483648);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 481;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
Debug.ShouldStop(1);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 482;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap";
Debug.ShouldStop(2);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body>  "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 483;BA.debugLine="XML = XML & \"<LoginSoftware xmlns='http://www.a";
Debug.ShouldStop(4);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<LoginSoftware xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 484;BA.debugLine="XML = XML & \"<Usuario>\" & EditTextUsuario.Text";
Debug.ShouldStop(8);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Usuario>"),parent.mostCurrent._edittextusuario.runMethod(true,"getText"),RemoteObject.createImmutable("</Usuario>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 485;BA.debugLine="XML = XML & \"<Password>\" & EditTextSenha.Text &";
Debug.ShouldStop(16);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Password>"),parent.mostCurrent._edittextsenha.runMethod(true,"getText"),RemoteObject.createImmutable("</Password></LoginSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 486;BA.debugLine="XML = XML & \"</soap:Body></soap:Envelope>\"";
Debug.ShouldStop(32);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</soap:Body></soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 488;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(128);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 489;BA.debugLine="JobOP3.PostString(URL,XML)";
Debug.ShouldStop(256);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 490;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(512);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 491;BA.debugLine="Wait For (JobOP3) JobDone";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonlogintela_click"), (_jobop3));
this.state = 27;
return;
case 27:
//C
this.state = 9;
;
 BA.debugLineNum = 492;BA.debugLine="Sleep(100)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonlogintela_click"),BA.numberCast(int.class, 100));
this.state = 28;
return;
case 28:
//C
this.state = 9;
;
 BA.debugLineNum = 494;BA.debugLine="If JobOP3.Success = True Then";
Debug.ShouldStop(8192);
if (true) break;

case 9:
//if
this.state = 22;
if (RemoteObject.solveBoolean("=",_jobop3.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 495;BA.debugLine="XMLWork2 = JobOP3.GetString";
Debug.ShouldStop(16384);
_xmlwork2 = _jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 496;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(32768);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 497;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(65536);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 498;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(131072);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 499;BA.debugLine="If XMLWork2.Contains(\"<LoginSoftwareResult>\")";
Debug.ShouldStop(262144);
if (true) break;

case 12:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<LoginSoftwareResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 500;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf";
Debug.ShouldStop(524288);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);
 BA.debugLineNum = 501;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(1048576);
if (true) break;

case 15:
//if
this.state = 20;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 17;
}else {
this.state = 19;
}if (true) break;

case 17:
//C
this.state = 20;
 BA.debugLineNum = 502;BA.debugLine="StatusLogin = 1";
Debug.ShouldStop(2097152);
parent._statuslogin = BA.numberCast(int.class, 1);
 BA.debugLineNum = 503;BA.debugLine="PanelLeitura.Visible = True";
Debug.ShouldStop(4194304);
parent.mostCurrent._panelleitura.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 504;BA.debugLine="PanelLogin2.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._panellogin2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 505;BA.debugLine="ButtonScan.Enabled = True";
Debug.ShouldStop(16777216);
parent.mostCurrent._buttonscan.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 506;BA.debugLine="ButtonConcluir.Enabled = True";
Debug.ShouldStop(33554432);
parent.mostCurrent._buttonconcluir.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 507;BA.debugLine="ToastMessageShow(Result,True)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 509;BA.debugLine="StatusLogin = 0";
Debug.ShouldStop(268435456);
parent._statuslogin = BA.numberCast(int.class, 0);
 BA.debugLineNum = 510;BA.debugLine="ButtonScan.Enabled = False";
Debug.ShouldStop(536870912);
parent.mostCurrent._buttonscan.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 511;BA.debugLine="ButtonConcluir.Enabled = False";
Debug.ShouldStop(1073741824);
parent.mostCurrent._buttonconcluir.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 512;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 20:
//C
this.state = 21;
;
 if (true) break;

case 21:
//C
this.state = 22;
;
 if (true) break;

case 22:
//C
this.state = 23;
;
 BA.debugLineNum = 516;BA.debugLine="JobOP3.Release";
Debug.ShouldStop(8);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_release" /*RemoteObject*/ );
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
 BA.debugLineNum = 519;BA.debugLine="ToastMessageShow(\"Erro no processo de login.\", F";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro no processo de login.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 522;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
public static RemoteObject  _buttonregistrasscc_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonRegistraSSCC_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,148);
if (RapidSub.canDelegate("buttonregistrasscc_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonregistrasscc_click");}
 BA.debugLineNum = 148;BA.debugLine="Private Sub ButtonRegistraSSCC_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="ButtonVincularBomba.Color = Colors.Red";
Debug.ShouldStop(1048576);
main.mostCurrent._buttonvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 150;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
Debug.ShouldStop(2097152);
main.mostCurrent._buttonvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 151;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Red";
Debug.ShouldStop(4194304);
main.mostCurrent._buttondesvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 152;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
Debug.ShouldStop(8388608);
main.mostCurrent._buttondesvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 153;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Green";
Debug.ShouldStop(16777216);
main.mostCurrent._buttonregistrasscc.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 154;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
Debug.ShouldStop(33554432);
main.mostCurrent._buttonregistrasscc.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 155;BA.debugLine="Mode = 3";
Debug.ShouldStop(67108864);
main._mode = BA.numberCast(int.class, 3);
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("ButtonScan_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,208);
if (RapidSub.canDelegate("buttonscan_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonscan_click");}
 BA.debugLineNum = 208;BA.debugLine="Private Sub ButtonScan_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="myABBarcode.ABGetBarcode(\"myABBarcode\",\"\")";
Debug.ShouldStop(65536);
main.mostCurrent._myabbarcode.runVoidMethod ("ABGetBarcode",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("myABBarcode")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonupdatedados_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonUpdateDados_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,539);
if (RapidSub.canDelegate("buttonupdatedados_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonupdatedados_click");}
 BA.debugLineNum = 539;BA.debugLine="Private Sub ButtonUpdateDados_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 540;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 541;BA.debugLine="sql1.ExecNonQuery(\"UPDATE Data SET  NomeTerminal";
Debug.ShouldStop(268435456);
main._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE Data SET  NomeTerminal ='"),main.mostCurrent._edittextnometerminal.runMethod(true,"getText"),RemoteObject.createImmutable("', EnderecoWebservice='"),main.mostCurrent._edittextenderecowebservice.runMethod(true,"getText"),RemoteObject.createImmutable("', NomeImpressora='"),main.mostCurrent._edittextnomeimpressora.runMethod(false,"getTag"),RemoteObject.createImmutable("' WHERE id=1;"))));
 BA.debugLineNum = 544;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
Debug.ShouldStop(-2147483648);
main._cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT NomeTerminal, EnderecoWebservice, NomeImpressora FROM Data WHERE id=1;"))));
 BA.debugLineNum = 545;BA.debugLine="cursor.Position =  0";
Debug.ShouldStop(1);
main._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 546;BA.debugLine="Nometerminal = cursor.GetString2(0)";
Debug.ShouldStop(2);
main.mostCurrent._nometerminal = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 548;BA.debugLine="NamePrinter = cursor.GetString2(2)";
Debug.ShouldStop(8);
main.mostCurrent._nameprinter = main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 2)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 550;BA.debugLine="MsgboxAsync(\"Erro ao gravar.\",\"Erro\")";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao gravar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 };
 BA.debugLineNum = 552;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonvincularbomba_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonVincularBomba_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,128);
if (RapidSub.canDelegate("buttonvincularbomba_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonvincularbomba_click");}
 BA.debugLineNum = 128;BA.debugLine="Private Sub ButtonVincularBomba_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 129;BA.debugLine="ButtonVincularBomba.Color = Colors.Green";
Debug.ShouldStop(1);
main.mostCurrent._buttonvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 130;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
Debug.ShouldStop(2);
main.mostCurrent._buttonvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 131;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Red";
Debug.ShouldStop(4);
main.mostCurrent._buttondesvincularbomba.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 132;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
Debug.ShouldStop(8);
main.mostCurrent._buttondesvincularbomba.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 133;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Red";
Debug.ShouldStop(16);
main.mostCurrent._buttonregistrasscc.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 134;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
Debug.ShouldStop(32);
main.mostCurrent._buttonregistrasscc.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 135;BA.debugLine="Mode = 1";
Debug.ShouldStop(64);
main._mode = BA.numberCast(int.class, 1);
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonvoltarconfig_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonVoltarConfig_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,534);
if (RapidSub.canDelegate("buttonvoltarconfig_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonvoltarconfig_click");}
 BA.debugLineNum = 534;BA.debugLine="Private Sub ButtonVoltarConfig_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 535;BA.debugLine="PanelLeitura.Visible = True";
Debug.ShouldStop(4194304);
main.mostCurrent._panelleitura.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 536;BA.debugLine="PanelConfig.Visible = False";
Debug.ShouldStop(8388608);
main.mostCurrent._panelconfig.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 537;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("ButtonVoltarLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,457);
if (RapidSub.canDelegate("buttonvoltarlogin_click")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","buttonvoltarlogin_click");}
 BA.debugLineNum = 457;BA.debugLine="Private Sub ButtonVoltarLogin_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 458;BA.debugLine="PanelLogin2.Visible = False";
Debug.ShouldStop(512);
main.mostCurrent._panellogin2.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 459;BA.debugLine="PanelLeitura.Visible = True";
Debug.ShouldStop(1024);
main.mostCurrent._panelleitura.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 460;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edittextbalanca_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("EditTextBalanca_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("edittextbalanca_textchanged")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","edittextbalanca_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 115;BA.debugLine="Private Sub EditTextBalanca_TextChanged (Old As St";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 117;BA.debugLine="If New.SubString2(0,1) = \"@\" And New.Length >= 3";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1))),BA.ObjectToString("@")) && RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 118;BA.debugLine="CodigoBomba = New.SubString(2)";
Debug.ShouldStop(2097152);
main.mostCurrent._codigobomba = _new.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e6.toString()); BA.debugLineNum = 121;BA.debugLine="ToastMessageShow(LastException,False)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).getObject())),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 122;BA.debugLine="ToastMessageShow(\"Erro ao processsar código.\",Fa";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao processsar código.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _getzplsscc(RemoteObject _sscc) throws Exception{
try {
		Debug.PushSubsStack("GetZPLSSCC (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,362);
if (RapidSub.canDelegate("getzplsscc")) { VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","getzplsscc", _sscc); return;}
ResumableSub_GetZPLSSCC rsub = new ResumableSub_GetZPLSSCC(null,_sscc);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_GetZPLSSCC extends BA.ResumableSub {
public ResumableSub_GetZPLSSCC(VinculaBomba.Unielver.main parent,RemoteObject _sscc) {
this.parent = parent;
this._sscc = _sscc;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
VinculaBomba.Unielver.main parent;
RemoteObject _sscc;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop3 = RemoteObject.declareNull("VinculaBomba.Unielver.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("GetZPLSSCC (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,362);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("SSCC", _sscc);
 BA.debugLineNum = 363;BA.debugLine="Try";
Debug.ShouldStop(1024);
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
 BA.debugLineNum = 364;BA.debugLine="Dim URL As String";
Debug.ShouldStop(2048);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 365;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(4096);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 367;BA.debugLine="Dim XML As String";
Debug.ShouldStop(16384);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 368;BA.debugLine="Dim JobOP3 As HttpJob";
Debug.ShouldStop(32768);
_jobop3 = RemoteObject.createNew ("VinculaBomba.Unielver.httpjob");Debug.locals.put("JobOP3", _jobop3);
 BA.debugLineNum = 370;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
Debug.ShouldStop(131072);
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 371;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
Debug.ShouldStop(262144);
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 372;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
Debug.ShouldStop(524288);
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 373;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(1048576);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 374;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(2097152);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 375;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(4194304);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 376;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(8388608);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 377;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
Debug.ShouldStop(16777216);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 378;BA.debugLine="XML = XML & \"<soap:Body><GeraZPL_SSCC xmlns='htt";
Debug.ShouldStop(33554432);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body><GeraZPL_SSCC xmlns='http://www.aplipack.com.br/'"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 379;BA.debugLine="XML = XML & \"><UserSoftware>user</UserSoftware><";
Debug.ShouldStop(67108864);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("><UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 380;BA.debugLine="XML = XML & \"<idSSCC>\" & SSCC & \"</idSSCC><Impri";
Debug.ShouldStop(134217728);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<idSSCC>"),_sscc,RemoteObject.createImmutable("</idSSCC><Imprimir>0</Imprimir>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 381;BA.debugLine="XML = XML & \"<UsuarioSoft>\" & EditTextUsuario.Te";
Debug.ShouldStop(268435456);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UsuarioSoft>"),parent.mostCurrent._edittextusuario.runMethod(true,"getText"),RemoteObject.createImmutable("</UsuarioSoft>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 382;BA.debugLine="XML = XML & \"<Terminal>\" & Nometerminal & \"</Ter";
Debug.ShouldStop(536870912);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Terminal>"),parent.mostCurrent._nometerminal,RemoteObject.createImmutable("</Terminal></GeraZPL_SSCC></soap:Body></soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 384;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(-2147483648);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 385;BA.debugLine="JobOP3.PostString(URL,XML)";
Debug.ShouldStop(1);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 386;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(2);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 387;BA.debugLine="Wait For (JobOP3) JobDone";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getzplsscc"), (_jobop3));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
 BA.debugLineNum = 388;BA.debugLine="Sleep(100)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "getzplsscc"),BA.numberCast(int.class, 100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
 BA.debugLineNum = 390;BA.debugLine="If JobOP3.Success = True Then";
Debug.ShouldStop(32);
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
 BA.debugLineNum = 391;BA.debugLine="XMLWork2 = JobOP3.GetString";
Debug.ShouldStop(64);
_xmlwork2 = _jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 392;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(128);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 393;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(256);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 394;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(512);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 395;BA.debugLine="If XMLWork2.Contains(\"<GeraZPL_SSCCResult>\") =";
Debug.ShouldStop(1024);
if (true) break;

case 7:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<GeraZPL_SSCCResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 396;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
Debug.ShouldStop(2048);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);Debug.locals.put("Result", _result);
 BA.debugLineNum = 397;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 398;BA.debugLine="CodZPL = XMLWork2.SubString2(XMLWork2.IndexOf";
Debug.ShouldStop(8192);
parent.mostCurrent._codzpl = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodZPL>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodZPL>")))));
 BA.debugLineNum = 399;BA.debugLine="PrintBT";
Debug.ShouldStop(16384);
_printbt();
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 401;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(65536);
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
 BA.debugLineNum = 405;BA.debugLine="JobOP3.Release";
Debug.ShouldStop(1048576);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
 BA.debugLineNum = 407;BA.debugLine="ToastMessageShow(\"Erro ao obter etiqueta.\", Fals";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao obter etiqueta.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 410;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Dim myABBarcode As ABZxing";
main.mostCurrent._myabbarcode = RemoteObject.createNew ("com.AB.ABZxing.ABZxing");
 //BA.debugLineNum = 23;BA.debugLine="Private CodigoBomba As String = \"\"";
main.mostCurrent._codigobomba = BA.ObjectToString("");
 //BA.debugLineNum = 24;BA.debugLine="Private idSSCC As String = \"\"";
main.mostCurrent._idsscc = BA.ObjectToString("");
 //BA.debugLineNum = 25;BA.debugLine="Dim Mode As Int = 0";
main._mode = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 29;BA.debugLine="Dim AddressWebservice As String = \"http://192.168";
main.mostCurrent._addresswebservice = BA.ObjectToString("http://192.168.137.1:4000/WSWrongAdditionSU.asmx");
 //BA.debugLineNum = 31;BA.debugLine="Private PanelLogin2 As Panel";
main.mostCurrent._panellogin2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private PanelLeitura As Panel";
main.mostCurrent._panelleitura = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private PanelConfig As Panel";
main.mostCurrent._panelconfig = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private ButtonConcluir As Button";
main.mostCurrent._buttonconcluir = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private ButtonDesvincularBomba As Button";
main.mostCurrent._buttondesvincularbomba = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private ButtonRegistraSSCC As Button";
main.mostCurrent._buttonregistrasscc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private ButtonScan As Button";
main.mostCurrent._buttonscan = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private ButtonVincularBomba As Button";
main.mostCurrent._buttonvincularbomba = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private EditTextBalanca As EditText";
main.mostCurrent._edittextbalanca = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private ButtonImprimir As Button";
main.mostCurrent._buttonimprimir = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Dim Printer As TextWriter";
main.mostCurrent._printer = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.TextWriterWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Dim PrintBuffer As String";
main.mostCurrent._printbuffer = RemoteObject.createImmutable("");
 //BA.debugLineNum = 43;BA.debugLine="Private NamePrinter As String";
main.mostCurrent._nameprinter = RemoteObject.createImmutable("");
 //BA.debugLineNum = 44;BA.debugLine="Private Barcode1 As String";
main.mostCurrent._barcode1 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 45;BA.debugLine="Private Barcode2 As String";
main.mostCurrent._barcode2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 46;BA.debugLine="Private BarcodeSSCC As String";
main.mostCurrent._barcodesscc = RemoteObject.createImmutable("");
 //BA.debugLineNum = 47;BA.debugLine="Dim Quantidade As String";
main.mostCurrent._quantidade = RemoteObject.createImmutable("");
 //BA.debugLineNum = 48;BA.debugLine="Dim Validade As String";
main.mostCurrent._validade = RemoteObject.createImmutable("");
 //BA.debugLineNum = 49;BA.debugLine="Dim Material As String";
main.mostCurrent._material = RemoteObject.createImmutable("");
 //BA.debugLineNum = 50;BA.debugLine="Dim Lote As String";
main.mostCurrent._lote = RemoteObject.createImmutable("");
 //BA.debugLineNum = 51;BA.debugLine="Dim CodZPL As String = \"\"";
main.mostCurrent._codzpl = BA.ObjectToString("");
 //BA.debugLineNum = 52;BA.debugLine="Dim Nometerminal As String = \"\"";
main.mostCurrent._nometerminal = BA.ObjectToString("");
 //BA.debugLineNum = 53;BA.debugLine="Dim DataProducao As String";
main.mostCurrent._dataproducao = RemoteObject.createImmutable("");
 //BA.debugLineNum = 54;BA.debugLine="Dim filename As String";
main.mostCurrent._filename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 55;BA.debugLine="Dim StatusLogin As Int = 0";
main._statuslogin = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 56;BA.debugLine="Private ButtonLimparLogin As Button";
main.mostCurrent._buttonlimparlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private ButtonLoginTela As Button";
main.mostCurrent._buttonlogintela = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private ButtonVoltarLogin As Button";
main.mostCurrent._buttonvoltarlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private EditTextSenha As EditText";
main.mostCurrent._edittextsenha = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private EditTextUsuario As EditText";
main.mostCurrent._edittextusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private ButtonLogin As Button";
main.mostCurrent._buttonlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private ButtonUpdateDados As Button";
main.mostCurrent._buttonupdatedados = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private ButtonVoltarConfig As Button";
main.mostCurrent._buttonvoltarconfig = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private EditTextEnderecoWebservice As EditText";
main.mostCurrent._edittextenderecowebservice = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private EditTextNomeImpressora As EditText";
main.mostCurrent._edittextnomeimpressora = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private EditTextNomeTerminal As EditText";
main.mostCurrent._edittextnometerminal = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private ImageViewUnilever As ImageView";
main.mostCurrent._imageviewunilever = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _myabbarcode_barcodefound(RemoteObject _barcode,RemoteObject _formatname) throws Exception{
try {
		Debug.PushSubsStack("myABBarcode_BarcodeFound (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,212);
if (RapidSub.canDelegate("myabbarcode_barcodefound")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","myabbarcode_barcodefound", _barcode, _formatname);}
Debug.locals.put("Barcode", _barcode);
Debug.locals.put("formatName", _formatname);
 BA.debugLineNum = 212;BA.debugLine="Sub myABBarcode_BarcodeFound (Barcode As String, f";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 215;BA.debugLine="If formatName=\"QR_CODE\" And Barcode.Contains(\"|\"";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_formatname,BA.ObjectToString("QR_CODE")) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("|"))),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 216;BA.debugLine="idSSCC = Barcode.SubString2(0,9)";
Debug.ShouldStop(8388608);
main.mostCurrent._idsscc = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 9)));
 }else 
{ BA.debugLineNum = 217;BA.debugLine="Else If formatName = \"CODE_128\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_formatname,BA.ObjectToString("CODE_128"))) { 
 BA.debugLineNum = 218;BA.debugLine="If Barcode.Length = 40 And Barcode.SubString2(0";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"length"),BA.numberCast(double.class, 40)) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),BA.ObjectToString("90")) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 12))),BA.ObjectToString("37")) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 20))),BA.ObjectToString("10"))) { 
 BA.debugLineNum = 219;BA.debugLine="Barcode1 = Barcode";
Debug.ShouldStop(67108864);
main.mostCurrent._barcode1 = _barcode;
 BA.debugLineNum = 220;BA.debugLine="Barcode1 = Barcode1.Replace(Chr(29),\"\")";
Debug.ShouldStop(134217728);
main.mostCurrent._barcode1 = main.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 29))))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 221;BA.debugLine="Quantidade = Barcode1.SubString2(12,18)";
Debug.ShouldStop(268435456);
main.mostCurrent._quantidade = main.mostCurrent._barcode1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 18)));
 BA.debugLineNum = 222;BA.debugLine="ToastMessageShow(\"Bracode Lote capturado com s";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bracode Lote capturado com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 223;BA.debugLine="Material = Barcode1.SubString2(2,10)";
Debug.ShouldStop(1073741824);
main.mostCurrent._material = main.mostCurrent._barcode1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 224;BA.debugLine="Lote = Barcode1.SubString(20)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lote = main.mostCurrent._barcode1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 20)));
 }else 
{ BA.debugLineNum = 225;BA.debugLine="Else if Barcode.Length = 32 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"length"),BA.numberCast(double.class, 32))) { 
 BA.debugLineNum = 226;BA.debugLine="If Barcode.SubString2(0,2) = \"02\" And Barcode.";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),BA.ObjectToString("02")) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 18))),BA.ObjectToString("17")) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 24)),(Object)(BA.numberCast(int.class, 26))),BA.ObjectToString("11"))) { 
 BA.debugLineNum = 227;BA.debugLine="Barcode2 = Barcode";
Debug.ShouldStop(4);
main.mostCurrent._barcode2 = _barcode;
 BA.debugLineNum = 228;BA.debugLine="Barcode2 = Barcode2.Replace(Chr(29),\"\")";
Debug.ShouldStop(8);
main.mostCurrent._barcode2 = main.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 29))))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 229;BA.debugLine="ToastMessageShow(\"Bracode Validade capturado";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bracode Validade capturado com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 230;BA.debugLine="Validade = Barcode2.SubString2(18,24)";
Debug.ShouldStop(32);
main.mostCurrent._validade = main.mostCurrent._barcode2.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 24)));
 BA.debugLineNum = 231;BA.debugLine="Validade = Validade.SubString(4) & \"/\" & Vali";
Debug.ShouldStop(64);
main.mostCurrent._validade = RemoteObject.concat(main.mostCurrent._validade.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/"),main.mostCurrent._validade.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/20"),main.mostCurrent._validade.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 232;BA.debugLine="DataProducao = DataProducao.SubString(4) & \"/";
Debug.ShouldStop(128);
main.mostCurrent._dataproducao = RemoteObject.concat(main.mostCurrent._dataproducao.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/"),main.mostCurrent._dataproducao.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/20"),main.mostCurrent._dataproducao.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))));
 };
 }else 
{ BA.debugLineNum = 234;BA.debugLine="Else if Barcode.Length = 20 And Barcode.SubStri";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"length"),BA.numberCast(double.class, 20)) && RemoteObject.solveBoolean("=",_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),BA.ObjectToString("00"))) { 
 BA.debugLineNum = 235;BA.debugLine="BarcodeSSCC = Barcode";
Debug.ShouldStop(1024);
main.mostCurrent._barcodesscc = _barcode;
 BA.debugLineNum = 236;BA.debugLine="BarcodeSSCC = BarcodeSSCC.SubString(2).Replace";
Debug.ShouldStop(2048);
main.mostCurrent._barcodesscc = main.mostCurrent._barcodesscc.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2))).runMethod(true,"replace",(Object)(BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 29))))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 237;BA.debugLine="ToastMessageShow(\"Bracode SSCC capturado com s";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bracode SSCC capturado com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 239;BA.debugLine="ToastMessageShow(\"Código Invalido.\",False)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Código Invalido.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }}}
;
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e30) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e30.toString()); BA.debugLineNum = 243;BA.debugLine="ToastMessageShow(\"Erro ao processar código.\",Fal";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao processar código.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _printbt() throws Exception{
try {
		Debug.PushSubsStack("PrintBT (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,414);
if (RapidSub.canDelegate("printbt")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","printbt");}
RemoteObject _paireddevices = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _devicename = RemoteObject.createImmutable("");
RemoteObject _macaddress = RemoteObject.createImmutable("");
int _i = 0;
 BA.debugLineNum = 414;BA.debugLine="Private Sub PrintBT()";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 415;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 416;BA.debugLine="Dim PairedDevices As Map";
Debug.ShouldStop(-2147483648);
_paireddevices = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("PairedDevices", _paireddevices);
 BA.debugLineNum = 417;BA.debugLine="BTConnection.Initialize(\"ConnectBT\")";
Debug.ShouldStop(1);
main._btconnection.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("ConnectBT")));
 BA.debugLineNum = 418;BA.debugLine="Dim l As List";
Debug.ShouldStop(2);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 419;BA.debugLine="Dim DeviceName, MacAddress As String";
Debug.ShouldStop(4);
_devicename = RemoteObject.createImmutable("");Debug.locals.put("DeviceName", _devicename);
_macaddress = RemoteObject.createImmutable("");Debug.locals.put("MacAddress", _macaddress);
 BA.debugLineNum = 421;BA.debugLine="PairedDevices = BTConnection.GetPairedDevices";
Debug.ShouldStop(16);
_paireddevices = main._btconnection.runMethod(false,"GetPairedDevices");Debug.locals.put("PairedDevices", _paireddevices);
 BA.debugLineNum = 423;BA.debugLine="l.Initialize";
Debug.ShouldStop(64);
_l.runVoidMethod ("Initialize");
 BA.debugLineNum = 424;BA.debugLine="For i = 0 To PairedDevices.Size - 1 'Check all d";
Debug.ShouldStop(128);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {_paireddevices.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 425;BA.debugLine="l.Add(PairedDevices.GetKeyAt(i))";
Debug.ShouldStop(256);
_l.runVoidMethod ("Add",(Object)(_paireddevices.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))));
 BA.debugLineNum = 426;BA.debugLine="DeviceName=PairedDevices.Getkeyat(i)";
Debug.ShouldStop(512);
_devicename = BA.ObjectToString(_paireddevices.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("DeviceName", _devicename);
 BA.debugLineNum = 427;BA.debugLine="MacAddress=PairedDevices.GetValueAt(i)";
Debug.ShouldStop(1024);
_macaddress = BA.ObjectToString(_paireddevices.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("MacAddress", _macaddress);
 BA.debugLineNum = 428;BA.debugLine="If DeviceName.Contains(NamePrinter) Then 'Inser";
Debug.ShouldStop(2048);
if (_devicename.runMethod(true,"contains",(Object)(main.mostCurrent._nameprinter)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 429;BA.debugLine="Exit";
Debug.ShouldStop(4096);
if (true) break;
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 432;BA.debugLine="BTConnection.Connect(MacAddress)";
Debug.ShouldStop(32768);
main._btconnection.runVoidMethod ("Connect",main.processBA,(Object)(_macaddress));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e18) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e18.toString()); BA.debugLineNum = 434;BA.debugLine="ToastMessageShow(\"Erro ao conectar o Bluetootth.";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao conectar o Bluetootth.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 436;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _printer_connected(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Printer_Connected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,438);
if (RapidSub.canDelegate("printer_connected")) { return VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","printer_connected", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 438;BA.debugLine="Sub Printer_Connected (Success As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 439;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 440;BA.debugLine="If Success Then";
Debug.ShouldStop(8388608);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 441;BA.debugLine="Printer.Initialize2(BTConnection.OutputStream,\"";
Debug.ShouldStop(16777216);
main.mostCurrent._printer.runVoidMethod ("Initialize2",(Object)(main._btconnection.runMethod(false,"getOutputStream")),(Object)(RemoteObject.createImmutable("windows-1252")));
 BA.debugLineNum = 442;BA.debugLine="PrintBuffer=Chr(27)&\"t\"&Chr(16)&\"Teste de impre";
Debug.ShouldStop(33554432);
main.mostCurrent._printbuffer = RemoteObject.concat(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 27))),RemoteObject.createImmutable("t"),main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 16))),RemoteObject.createImmutable("Teste de impressão."));
 BA.debugLineNum = 443;BA.debugLine="PrintBuffer = CodZPL";
Debug.ShouldStop(67108864);
main.mostCurrent._printbuffer = main.mostCurrent._codzpl;
 BA.debugLineNum = 444;BA.debugLine="Printer.WriteLine(PrintBuffer)";
Debug.ShouldStop(134217728);
main.mostCurrent._printer.runVoidMethod ("WriteLine",(Object)(main.mostCurrent._printbuffer));
 BA.debugLineNum = 445;BA.debugLine="Printer.Flush";
Debug.ShouldStop(268435456);
main.mostCurrent._printer.runVoidMethod ("Flush");
 BA.debugLineNum = 446;BA.debugLine="ToastMessageShow(\"Impresso com sucesso.\",False)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Impresso com sucesso.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 447;BA.debugLine="Printer.Close";
Debug.ShouldStop(1073741824);
main.mostCurrent._printer.runVoidMethod ("Close");
 BA.debugLineNum = 448;BA.debugLine="BTConnection.Disconnect 'disable this if you li";
Debug.ShouldStop(-2147483648);
main._btconnection.runVoidMethod ("Disconnect");
 }else {
 BA.debugLineNum = 450;BA.debugLine="MsgboxAsync(\"No printer found...\",\"Print error\"";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("No printer found...")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Print error"))),main.processBA);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e15) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e15.toString()); BA.debugLineNum = 453;BA.debugLine="ToastMessageShow(\"Erro ao realizar a impressão.\"";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao realizar a impressão.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 455;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("VinculaBomba.Unielver.main");
starter.myClass = BA.getDeviceClass ("VinculaBomba.Unielver.starter");
httputils2service.myClass = BA.getDeviceClass ("VinculaBomba.Unielver.httputils2service");
httpjob.myClass = BA.getDeviceClass ("VinculaBomba.Unielver.httpjob");
		
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
 //BA.debugLineNum = 18;BA.debugLine="Dim BTConnection As Serial";
main._btconnection = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _sendsscc() throws Exception{
try {
		Debug.PushSubsStack("SendSSCC (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,300);
if (RapidSub.canDelegate("sendsscc")) { VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","sendsscc"); return;}
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
public ResumableSub_SendSSCC(VinculaBomba.Unielver.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
VinculaBomba.Unielver.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop3 = RemoteObject.declareNull("VinculaBomba.Unielver.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");
RemoteObject _nova = RemoteObject.createImmutable("");
RemoteObject _userregistro = RemoteObject.createImmutable("");
RemoteObject _datahoraregistro = RemoteObject.createImmutable("");
RemoteObject _idssccget = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("SendSSCC (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,300);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 301;BA.debugLine="Try";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 302;BA.debugLine="Dim URL As String";
Debug.ShouldStop(8192);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 303;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(16384);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 305;BA.debugLine="Dim XML As String";
Debug.ShouldStop(65536);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 306;BA.debugLine="Dim JobOP3 As HttpJob";
Debug.ShouldStop(131072);
_jobop3 = RemoteObject.createNew ("VinculaBomba.Unielver.httpjob");Debug.locals.put("JobOP3", _jobop3);
 BA.debugLineNum = 308;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
Debug.ShouldStop(524288);
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 309;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
Debug.ShouldStop(1048576);
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 310;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
Debug.ShouldStop(2097152);
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 311;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(4194304);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 312;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(8388608);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 313;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(16777216);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 314;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(33554432);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 315;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
Debug.ShouldStop(67108864);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 316;BA.debugLine="XML = XML & \"<soap:Body><RegistraSSCC xmlns='htt";
Debug.ShouldStop(134217728);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body><RegistraSSCC xmlns='http://www.aplipack.com.br/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 317;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
Debug.ShouldStop(268435456);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 318;BA.debugLine="XML = XML & \"<Barcode1>\" & Barcode1 & \"</Barcode";
Debug.ShouldStop(536870912);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Barcode1>"),parent.mostCurrent._barcode1,RemoteObject.createImmutable("</Barcode1><Barcode2>"),parent.mostCurrent._barcode2,RemoteObject.createImmutable("</Barcode2>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 319;BA.debugLine="XML = XML & \"<BarcodeSSCC>\" & BarcodeSSCC & \"</B";
Debug.ShouldStop(1073741824);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<BarcodeSSCC>"),parent.mostCurrent._barcodesscc,RemoteObject.createImmutable("</BarcodeSSCC><UsuarioLeitura>user</UsuarioLeitura>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 320;BA.debugLine="XML = XML & \"<Quantidade>\" & Quantidade & \"</Qua";
Debug.ShouldStop(-2147483648);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<Quantidade>"),parent.mostCurrent._quantidade,RemoteObject.createImmutable("</Quantidade></RegistraSSCC></soap:Body></soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 322;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(2);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 323;BA.debugLine="JobOP3.PostString(URL,XML)";
Debug.ShouldStop(4);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 324;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(8);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 325;BA.debugLine="Wait For (JobOP3) JobDone";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "sendsscc"), (_jobop3));
this.state = 27;
return;
case 27:
//C
this.state = 4;
;
 BA.debugLineNum = 326;BA.debugLine="Sleep(100)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "sendsscc"),BA.numberCast(int.class, 100));
this.state = 28;
return;
case 28:
//C
this.state = 4;
;
 BA.debugLineNum = 328;BA.debugLine="If JobOP3.Success = True Then";
Debug.ShouldStop(128);
if (true) break;

case 4:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",_jobop3.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 329;BA.debugLine="XMLWork2 = JobOP3.GetString";
Debug.ShouldStop(256);
_xmlwork2 = _jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 330;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(512);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 331;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(1024);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 332;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(2048);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 333;BA.debugLine="If XMLWork2.Contains(\"<RegistraSSCCResult>\") =";
Debug.ShouldStop(4096);
if (true) break;

case 7:
//if
this.state = 22;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<RegistraSSCCResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 334;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
Debug.ShouldStop(8192);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);Debug.locals.put("Result", _result);
 BA.debugLineNum = 335;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(16384);
if (true) break;

case 10:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 12;
}else {
this.state = 20;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 336;BA.debugLine="Dim Nova As String = XMLWork2.SubString2(XMLW";
Debug.ShouldStop(32768);
_nova = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Nova>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Nova>")))));Debug.locals.put("Nova", _nova);Debug.locals.put("Nova", _nova);
 BA.debugLineNum = 337;BA.debugLine="If Nova = \"True\" Then";
Debug.ShouldStop(65536);
if (true) break;

case 13:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",_nova,BA.ObjectToString("True"))) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
 BA.debugLineNum = 338;BA.debugLine="ToastMessageShow(\"SSCC registrado com sucess";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("SSCC registrado com sucesso.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 340;BA.debugLine="Dim UserRegistro As String = XMLWork2.SubStr";
Debug.ShouldStop(524288);
_userregistro = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<UsuarioRegistro>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</UsuarioRegistro>")))));Debug.locals.put("UserRegistro", _userregistro);Debug.locals.put("UserRegistro", _userregistro);
 BA.debugLineNum = 341;BA.debugLine="Dim DataHoraRegistro As String = XMLWork2.Su";
Debug.ShouldStop(1048576);
_datahoraregistro = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DataHoraRegistro>"))),RemoteObject.createImmutable(18)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DataHoraRegistro>")))));Debug.locals.put("DataHoraRegistro", _datahoraregistro);Debug.locals.put("DataHoraRegistro", _datahoraregistro);
 BA.debugLineNum = 342;BA.debugLine="Dim IDSSCCGet As String = XMLWork2.SubString";
Debug.ShouldStop(2097152);
_idssccget = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<IdSSCC>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</IdSSCC>")))));Debug.locals.put("IDSSCCGet", _idssccget);Debug.locals.put("IDSSCCGet", _idssccget);
 BA.debugLineNum = 343;BA.debugLine="ToastMessageShow(\"SSCC já registrada por \" &";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("SSCC já registrada por "),_userregistro,RemoteObject.createImmutable(" em "),_datahoraregistro,RemoteObject.createImmutable("  com o ID "),_idssccget))),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 344;BA.debugLine="ButtonImprimir.Enabled = True";
Debug.ShouldStop(8388608);
parent.mostCurrent._buttonimprimir.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 345;BA.debugLine="GetZPLSSCC(IDSSCCGet)";
Debug.ShouldStop(16777216);
_getzplsscc(_idssccget);
 if (true) break;

case 18:
//C
this.state = 21;
;
 BA.debugLineNum = 347;BA.debugLine="Barcode1 = \"\"";
Debug.ShouldStop(67108864);
parent.mostCurrent._barcode1 = BA.ObjectToString("");
 BA.debugLineNum = 348;BA.debugLine="Barcode2 = \"\"";
Debug.ShouldStop(134217728);
parent.mostCurrent._barcode2 = BA.ObjectToString("");
 BA.debugLineNum = 349;BA.debugLine="BarcodeSSCC = \"\"";
Debug.ShouldStop(268435456);
parent.mostCurrent._barcodesscc = BA.ObjectToString("");
 if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 351;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 21:
//C
this.state = 22;
;
 if (true) break;

case 22:
//C
this.state = 23;
;
 if (true) break;

case 23:
//C
this.state = 26;
;
 BA.debugLineNum = 355;BA.debugLine="JobOP3.Release";
Debug.ShouldStop(4);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
 BA.debugLineNum = 357;BA.debugLine="ToastMessageShow(\"Erro ao registtar SCCC.\", Fals";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao registtar SCCC.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 360;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("VinculaBomba (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,248);
if (RapidSub.canDelegate("vinculabomba")) { VinculaBomba.Unielver.main.remoteMe.runUserSub(false, "main","vinculabomba"); return;}
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
public ResumableSub_VinculaBomba(VinculaBomba.Unielver.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
VinculaBomba.Unielver.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork2 = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
RemoteObject _jobop3 = RemoteObject.declareNull("VinculaBomba.Unielver.httpjob");
RemoteObject _result = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("VinculaBomba (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,248);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 249;BA.debugLine="Try";
Debug.ShouldStop(16777216);
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
 BA.debugLineNum = 250;BA.debugLine="Dim URL As String";
Debug.ShouldStop(33554432);
_url = RemoteObject.createImmutable("");Debug.locals.put("URL", _url);
 BA.debugLineNum = 251;BA.debugLine="Dim XMLWork2 As String";
Debug.ShouldStop(67108864);
_xmlwork2 = RemoteObject.createImmutable("");Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 253;BA.debugLine="Dim XML As String";
Debug.ShouldStop(268435456);
_xml = RemoteObject.createImmutable("");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 254;BA.debugLine="Dim JobOP3 As HttpJob";
Debug.ShouldStop(536870912);
_jobop3 = RemoteObject.createNew ("VinculaBomba.Unielver.httpjob");Debug.locals.put("JobOP3", _jobop3);
 BA.debugLineNum = 256;BA.debugLine="CodigoBomba = CodigoBomba.Replace(\" \",\"\")";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._codigobomba = parent.mostCurrent._codigobomba.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 257;BA.debugLine="idSSCC = idSSCC.Replace(\" \",\"\")";
Debug.ShouldStop(1);
parent.mostCurrent._idsscc = parent.mostCurrent._idsscc.runMethod(true,"replace",(Object)(BA.ObjectToString(" ")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 258;BA.debugLine="URL = AddressWebservice";
Debug.ShouldStop(2);
_url = parent.mostCurrent._addresswebservice;Debug.locals.put("URL", _url);
 BA.debugLineNum = 259;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
Debug.ShouldStop(4);
_xml = BA.ObjectToString("<?xml version='1.0' encoding='utf-8'?>");Debug.locals.put("XML", _xml);
 BA.debugLineNum = 260;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
Debug.ShouldStop(8);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 261;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
Debug.ShouldStop(16);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:xsd='http://www.w3.org/2001/XMLSchema' "));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 262;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
Debug.ShouldStop(32);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 263;BA.debugLine="XML = XML & \"<soap:Body><VinculaBomba xmlns=`htt";
Debug.ShouldStop(64);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<soap:Body><VinculaBomba xmlns=`http://www.aplipack.com.br/`>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 264;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
Debug.ShouldStop(128);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 265;BA.debugLine="XML = XML & \"<idSSCC>\" & idSSCC & \"</idSSCC><Cod";
Debug.ShouldStop(256);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("<idSSCC>"),parent.mostCurrent._idsscc,RemoteObject.createImmutable("</idSSCC><CodigoBomba>"),parent.mostCurrent._codigobomba,RemoteObject.createImmutable("</CodigoBomba>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 266;BA.debugLine="XML = XML & \"</VinculaBomba></soap:Body></soap:E";
Debug.ShouldStop(512);
_xml = RemoteObject.concat(_xml,RemoteObject.createImmutable("</VinculaBomba></soap:Body></soap:Envelope>"));Debug.locals.put("XML", _xml);
 BA.debugLineNum = 268;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(2048);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 269;BA.debugLine="JobOP3.PostString(URL,XML)";
Debug.ShouldStop(4096);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(_xml));
 BA.debugLineNum = 270;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
Debug.ShouldStop(8192);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("text/xml")));
 BA.debugLineNum = 271;BA.debugLine="Wait For (JobOP3) JobDone";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "vinculabomba"), (_jobop3));
this.state = 27;
return;
case 27:
//C
this.state = 4;
;
 BA.debugLineNum = 272;BA.debugLine="Sleep(100)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "vinculabomba"),BA.numberCast(int.class, 100));
this.state = 28;
return;
case 28:
//C
this.state = 4;
;
 BA.debugLineNum = 274;BA.debugLine="If JobOP3.Success = True Then";
Debug.ShouldStop(131072);
if (true) break;

case 4:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",_jobop3.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 275;BA.debugLine="XMLWork2 = JobOP3.GetString";
Debug.ShouldStop(262144);
_xmlwork2 = _jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 276;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
Debug.ShouldStop(524288);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&lt;")),(Object)(RemoteObject.createImmutable("<")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 277;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
Debug.ShouldStop(1048576);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&gt;")),(Object)(RemoteObject.createImmutable(">")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 278;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
Debug.ShouldStop(2097152);
_xmlwork2 = _xmlwork2.runMethod(true,"replace",(Object)(BA.ObjectToString("&amp;")),(Object)(RemoteObject.createImmutable("-")));Debug.locals.put("XMLWork2", _xmlwork2);
 BA.debugLineNum = 279;BA.debugLine="If XMLWork2.Contains(\"<VinculaBombaResult>\") =";
Debug.ShouldStop(4194304);
if (true) break;

case 7:
//if
this.state = 22;
if (RemoteObject.solveBoolean("=",_xmlwork2.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<VinculaBombaResult>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 280;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
Debug.ShouldStop(8388608);
_result = _xmlwork2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Erro>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlwork2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Erro>")))));Debug.locals.put("Result", _result);Debug.locals.put("Result", _result);
 BA.debugLineNum = 281;BA.debugLine="If Result = \"sucesso\" Then";
Debug.ShouldStop(16777216);
if (true) break;

case 10:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_result,BA.ObjectToString("sucesso"))) { 
this.state = 12;
}else {
this.state = 20;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 282;BA.debugLine="If Mode = 1 Then";
Debug.ShouldStop(33554432);
if (true) break;

case 13:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",parent._mode,BA.numberCast(double.class, 1))) { 
this.state = 15;
}else 
{ BA.debugLineNum = 284;BA.debugLine="Else If Mode=2 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",parent._mode,BA.numberCast(double.class, 2))) { 
this.state = 17;
}}
if (true) break;

case 15:
//C
this.state = 18;
 BA.debugLineNum = 283;BA.debugLine="ToastMessageShow(\"Bomba Vinculada com sucess";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bomba Vinculada com sucesso..")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 285;BA.debugLine="ToastMessageShow(\"Bomba Desvinculada com suc";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Bomba Desvinculada com sucesso..")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 18:
//C
this.state = 21;
;
 if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 288;BA.debugLine="ToastMessageShow(Result,False)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_result)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 21:
//C
this.state = 22;
;
 if (true) break;

case 22:
//C
this.state = 23;
;
 if (true) break;

case 23:
//C
this.state = 26;
;
 BA.debugLineNum = 292;BA.debugLine="JobOP3.Release";
Debug.ShouldStop(8);
_jobop3.runClassMethod (VinculaBomba.Unielver.httpjob.class, "_release" /*RemoteObject*/ );
 Debug.CheckDeviceExceptions();
if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
 BA.debugLineNum = 294;BA.debugLine="ToastMessageShow(\"Erro ao registtar SCCC.\", Fals";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Erro ao registtar SCCC.")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 296;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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