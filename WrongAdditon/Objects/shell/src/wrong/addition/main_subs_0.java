package wrong.addition;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,143);
if (RapidSub.canDelegate("activity_create")) { wrong.addition.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(wrong.addition.main parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _firsttime;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _t = RemoteObject.createImmutable(0L);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _ordemprod = RemoteObject.createImmutable("");
int step64;
int limit64;
int step96;
int limit96;
int step115;
int limit115;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,143);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 144;BA.debugLine="panelMain.Initialize(\"\") : panelMain.Visible = Tr";
Debug.ShouldStop(32768);
parent.mostCurrent._panelmain.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 144;BA.debugLine="panelMain.Initialize(\"\") : panelMain.Visible = Tr";
Debug.ShouldStop(32768);
parent.mostCurrent._panelmain.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 145;BA.debugLine="panelMain.LoadLayout(\"Main\")";
Debug.ShouldStop(65536);
parent.mostCurrent._panelmain.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 146;BA.debugLine="Activity.AddView(panelMain, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(131072);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelmain.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 147;BA.debugLine="panelLogin.Initialize(\"\") : panelLogin.Visible =";
Debug.ShouldStop(262144);
parent.mostCurrent._panellogin.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 147;BA.debugLine="panelLogin.Initialize(\"\") : panelLogin.Visible =";
Debug.ShouldStop(262144);
parent.mostCurrent._panellogin.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 148;BA.debugLine="panelLogin.LoadLayout(\"Login\")";
Debug.ShouldStop(524288);
parent.mostCurrent._panellogin.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Login")),main.mostCurrent.activityBA);
 BA.debugLineNum = 149;BA.debugLine="Activity.AddView(panelLogin, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(1048576);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panellogin.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 150;BA.debugLine="panelMenu.Initialize(\"\") : panelMenu.Visible = Fa";
Debug.ShouldStop(2097152);
parent.mostCurrent._panelmenu.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 150;BA.debugLine="panelMenu.Initialize(\"\") : panelMenu.Visible = Fa";
Debug.ShouldStop(2097152);
parent.mostCurrent._panelmenu.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 151;BA.debugLine="panelMenu.LoadLayout(\"Menu\")";
Debug.ShouldStop(4194304);
parent.mostCurrent._panelmenu.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Menu")),main.mostCurrent.activityBA);
 BA.debugLineNum = 152;BA.debugLine="Activity.AddView(panelMenu, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(8388608);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelmenu.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 153;BA.debugLine="panelConexao.Initialize(\"\") : panelConexao.Visibl";
Debug.ShouldStop(16777216);
parent.mostCurrent._panelconexao.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 153;BA.debugLine="panelConexao.Initialize(\"\") : panelConexao.Visibl";
Debug.ShouldStop(16777216);
parent.mostCurrent._panelconexao.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 154;BA.debugLine="panelConexao.LoadLayout(\"Conexao\")";
Debug.ShouldStop(33554432);
parent.mostCurrent._panelconexao.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Conexao")),main.mostCurrent.activityBA);
 BA.debugLineNum = 155;BA.debugLine="Activity.AddView(panelConexao, 0, 0, 100%x, 100%y";
Debug.ShouldStop(67108864);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelconexao.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 156;BA.debugLine="panelPesagem.Initialize(\"\") : panelPesagem.Visibl";
Debug.ShouldStop(134217728);
parent.mostCurrent._panelpesagem.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 156;BA.debugLine="panelPesagem.Initialize(\"\") : panelPesagem.Visibl";
Debug.ShouldStop(134217728);
parent.mostCurrent._panelpesagem.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 157;BA.debugLine="panelPesagem.LoadLayout(\"pesgaem\")";
Debug.ShouldStop(268435456);
parent.mostCurrent._panelpesagem.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("pesgaem")),main.mostCurrent.activityBA);
 BA.debugLineNum = 158;BA.debugLine="Activity.AddView(panelPesagem, 0, 0, 100%x, 100%y";
Debug.ShouldStop(536870912);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelpesagem.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 159;BA.debugLine="panelUsuarios.Initialize(\"\") : panelUsuarios.Visi";
Debug.ShouldStop(1073741824);
parent.mostCurrent._panelusuarios.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 159;BA.debugLine="panelUsuarios.Initialize(\"\") : panelUsuarios.Visi";
Debug.ShouldStop(1073741824);
parent.mostCurrent._panelusuarios.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 160;BA.debugLine="panelUsuarios.LoadLayout(\"usuarios\")";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._panelusuarios.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("usuarios")),main.mostCurrent.activityBA);
 BA.debugLineNum = 161;BA.debugLine="Activity.AddView(panelUsuarios, 0, 0, 100%x, 100%";
Debug.ShouldStop(1);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelusuarios.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 162;BA.debugLine="panelWebservice.Initialize(\"\") : panelWebservice.";
Debug.ShouldStop(2);
parent.mostCurrent._panelwebservice.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 162;BA.debugLine="panelWebservice.Initialize(\"\") : panelWebservice.";
Debug.ShouldStop(2);
parent.mostCurrent._panelwebservice.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 163;BA.debugLine="panelWebservice.LoadLayout(\"webservice\")";
Debug.ShouldStop(4);
parent.mostCurrent._panelwebservice.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("webservice")),main.mostCurrent.activityBA);
 BA.debugLineNum = 164;BA.debugLine="Activity.AddView(panelWebservice, 0, 0, 100%x, 10";
Debug.ShouldStop(8);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelwebservice.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 165;BA.debugLine="panelProdutos.Initialize(\"\") : panelProdutos.Visi";
Debug.ShouldStop(16);
parent.mostCurrent._panelprodutos.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 165;BA.debugLine="panelProdutos.Initialize(\"\") : panelProdutos.Visi";
Debug.ShouldStop(16);
parent.mostCurrent._panelprodutos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 166;BA.debugLine="panelProdutos.LoadLayout(\"cadastroproduto\")";
Debug.ShouldStop(32);
parent.mostCurrent._panelprodutos.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("cadastroproduto")),main.mostCurrent.activityBA);
 BA.debugLineNum = 167;BA.debugLine="Activity.AddView(panelProdutos, 0, 0, 100%x, 100%";
Debug.ShouldStop(64);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._panelprodutos.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 168;BA.debugLine="SelecionaCUC.Initialize(\"\") : SelecionaCUC.Visibl";
Debug.ShouldStop(128);
parent.mostCurrent._selecionacuc.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 168;BA.debugLine="SelecionaCUC.Initialize(\"\") : SelecionaCUC.Visibl";
Debug.ShouldStop(128);
parent.mostCurrent._selecionacuc.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 169;BA.debugLine="SelecionaCUC.LoadLayout(\"selectCUC\")";
Debug.ShouldStop(256);
parent.mostCurrent._selecionacuc.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("selectCUC")),main.mostCurrent.activityBA);
 BA.debugLineNum = 170;BA.debugLine="Activity.AddView(SelecionaCUC, 0, 0, 100%x, 100%y";
Debug.ShouldStop(512);
parent.mostCurrent._activity.runVoidMethod ("AddView",(Object)((parent.mostCurrent._selecionacuc.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 171;BA.debugLine="Clock(True)";
Debug.ShouldStop(1024);
_clock(parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 172;BA.debugLine="filename  = \"data7.db\"";
Debug.ShouldStop(2048);
parent.mostCurrent._filename = BA.ObjectToString("data7.db");
 BA.debugLineNum = 173;BA.debugLine="If File.Exists(File.DirInternal,filename) = False";
Debug.ShouldStop(4096);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._filename)),parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 174;BA.debugLine="File.Copy(File.DirAssets,filename,File.DirIntern";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(parent.mostCurrent._filename),(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._filename));
 if (true) break;
;
 BA.debugLineNum = 176;BA.debugLine="If sql1.IsInitialized = False Then";
Debug.ShouldStop(32768);

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent._sql1.runMethod(true,"IsInitialized"),parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 177;BA.debugLine="sql1.Initialize(File.DirInternal, filename, Fals";
Debug.ShouldStop(65536);
parent._sql1.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._filename),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 179;BA.debugLine="Sleep(10)";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"),BA.numberCast(int.class, 10));
this.state = 79;
return;
case 79:
//C
this.state = 8;
;
 BA.debugLineNum = 180;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT * FROM webservice";
Debug.ShouldStop(524288);
parent._cursor.setObject(parent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM webservice"))));
 BA.debugLineNum = 181;BA.debugLine="cursor.Position =  0";
Debug.ShouldStop(1048576);
parent._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 182;BA.debugLine="URLglobal =  \"http://\"& cursor.GetString2(1) &\":\"";
Debug.ShouldStop(2097152);
parent.mostCurrent._urlglobal = RemoteObject.concat(RemoteObject.createImmutable("http://"),parent._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(":"),parent._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 183;BA.debugLine="Job1.Initialize(\"JOBSOAP\", Me)";
Debug.ShouldStop(4194304);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("JOBSOAP")),(Object)(main.getObject()));
 BA.debugLineNum = 184;BA.debugLine="Try";
Debug.ShouldStop(8388608);
if (true) break;

case 8:
//try
this.state = 27;
this.catchState = 26;
this.state = 10;
if (true) break;

case 10:
//C
this.state = 11;
this.catchState = 26;
 BA.debugLineNum = 185;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(16777216);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 186;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(33554432);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 187;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(67108864);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 188;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"), (parent._job1));
this.state = 80;
return;
case 80:
//C
this.state = 11;
;
 BA.debugLineNum = 189;BA.debugLine="If Job1.Success = True Then";
Debug.ShouldStop(268435456);
if (true) break;

case 11:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",parent._job1.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 190;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(536870912);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 191;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.L";
Debug.ShouldStop(1073741824);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 192;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 193;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Index";
Debug.ShouldStop(1);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 194;BA.debugLine="If count=1 Then";
Debug.ShouldStop(2);
if (true) break;

case 14:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",parent._count,BA.numberCast(double.class, 1))) { 
this.state = 16;
}else {
this.state = 18;
}if (true) break;

case 16:
//C
this.state = 23;
 BA.debugLineNum = 195;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLw";
Debug.ShouldStop(4);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 196;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&";
Debug.ShouldStop(8);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 198;BA.debugLine="For i=1 To count";
Debug.ShouldStop(32);
if (true) break;

case 19:
//for
this.state = 22;
step64 = 1;
limit64 = parent._count.<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 81;
if (true) break;

case 81:
//C
this.state = 22;
if ((step64 > 0 && parent._i.<Integer>get().intValue() <= limit64) || (step64 < 0 && parent._i.<Integer>get().intValue() >= limit64)) this.state = 21;
if (true) break;

case 82:
//C
this.state = 81;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step64)) ;
if (true) break;

case 21:
//C
this.state = 82;
 BA.debugLineNum = 199;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubStr";
Debug.ShouldStop(64);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 200;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.Su";
Debug.ShouldStop(128);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 201;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"";
Debug.ShouldStop(256);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 202;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Inde";
Debug.ShouldStop(512);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 22:
//C
this.state = 23;
;
 if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = 27;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 26:
//C
this.state = 27;
this.catchState = 0;
 BA.debugLineNum = 207;BA.debugLine="count = count";
Debug.ShouldStop(16384);
parent._count = parent._count;
 if (true) break;
if (true) break;

case 27:
//C
this.state = 28;
this.catchState = 0;
;
 BA.debugLineNum = 209;BA.debugLine="Sleep(2)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"),BA.numberCast(int.class, 2));
this.state = 83;
return;
case 83:
//C
this.state = 28;
;
 BA.debugLineNum = 210;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(131072);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 211;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(262144);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 212;BA.debugLine="Try";
Debug.ShouldStop(524288);
if (true) break;

case 28:
//try
this.state = 53;
this.catchState = 52;
this.state = 30;
if (true) break;

case 30:
//C
this.state = 31;
this.catchState = 52;
 BA.debugLineNum = 213;BA.debugLine="DateTime.DateFormat = \"dd-MM-yyyy\"";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd-MM-yyyy"));
 BA.debugLineNum = 214;BA.debugLine="Dim t As Long";
Debug.ShouldStop(2097152);
_t = RemoteObject.createImmutable(0L);Debug.locals.put("t", _t);
 BA.debugLineNum = 215;BA.debugLine="t = DateTime.DateParse(DateTime.Date(DateTime.no";
Debug.ShouldStop(4194304);
_t = parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),RemoteObject.createImmutable(31622400000L)}, "-",1, 0))))));Debug.locals.put("t", _t);
 BA.debugLineNum = 216;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd HH:mm:ss\"";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd HH:mm:ss"));
 BA.debugLineNum = 217;BA.debugLine="Dim s As String";
Debug.ShouldStop(16777216);
_s = RemoteObject.createImmutable("");Debug.locals.put("s", _s);
 BA.debugLineNum = 218;BA.debugLine="s = DateTime.Date(t)";
Debug.ShouldStop(33554432);
_s = parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_t));Debug.locals.put("s", _s);
 BA.debugLineNum = 219;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(67108864);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idOrdemProdSAP, DataHora, OrdemProd, StatusOP, Usuario , TipoOP, CodigoCUC, QuantMax, PesoMax, Prioridade, NumeroWeek, row_number() OVER (order by DataHora) as row_num FROM (SELECT idOrdemProdSAP, DataHora, OrdemProd, StatusOP, Usuario , TipoOP, CodigoCUC, QuantMax, PesoMax, Prioridade, NumeroWeek FROM (SELECT * FROM unilever_pi.ordemprodsap WHERE DataHora > '"),_s,RemoteObject.createImmutable("' ORDER BY DataHora) t) t;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 220;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(134217728);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 221;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(268435456);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 222;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"), (parent._job1));
this.state = 84;
return;
case 84:
//C
this.state = 31;
;
 BA.debugLineNum = 223;BA.debugLine="If Job1.Success = True Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 31:
//if
this.state = 50;
if (RemoteObject.solveBoolean("=",parent._job1.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 33;
}if (true) break;

case 33:
//C
this.state = 34;
 BA.debugLineNum = 224;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 225;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(1);
if (true) break;

case 34:
//if
this.state = 49;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 36;
}if (true) break;

case 36:
//C
this.state = 37;
 BA.debugLineNum = 226;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(2);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 227;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(";
Debug.ShouldStop(4);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 228;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Inde";
Debug.ShouldStop(8);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 229;BA.debugLine="ListOrdemProdSAP.Initialize";
Debug.ShouldStop(16);
parent.mostCurrent._listordemprodsap.runVoidMethod ("Initialize");
 BA.debugLineNum = 230;BA.debugLine="For i=1 To count";
Debug.ShouldStop(32);
if (true) break;

case 37:
//for
this.state = 48;
step96 = 1;
limit96 = parent._count.<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 85;
if (true) break;

case 85:
//C
this.state = 48;
if ((step96 > 0 && parent._i.<Integer>get().intValue() <= limit96) || (step96 < 0 && parent._i.<Integer>get().intValue() >= limit96)) this.state = 39;
if (true) break;

case 86:
//C
this.state = 85;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step96)) ;
if (true) break;

case 39:
//C
this.state = 40;
 BA.debugLineNum = 231;BA.debugLine="If i > count Then";
Debug.ShouldStop(64);
if (true) break;

case 40:
//if
this.state = 47;
if (RemoteObject.solveBoolean(">",parent._i,BA.numberCast(double.class, parent._count))) { 
this.state = 42;
}else 
{ BA.debugLineNum = 232;BA.debugLine="Else If i = count  Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, parent._count))) { 
this.state = 44;
}else {
this.state = 46;
}}
if (true) break;

case 42:
//C
this.state = 47;
 if (true) break;

case 44:
//C
this.state = 47;
 BA.debugLineNum = 233;BA.debugLine="ListOrdemProdSAP.Add(XMLCurrent.SubString2(X";
Debug.ShouldStop(256);
parent.mostCurrent._listordemprodsap.runVoidMethod ("Add",(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<OrdemProd>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</OrdemProd>"))))))));
 if (true) break;

case 46:
//C
this.state = 47;
 BA.debugLineNum = 235;BA.debugLine="ListOrdemProdSAP.Add(XMLCurrent.SubString2(X";
Debug.ShouldStop(1024);
parent.mostCurrent._listordemprodsap.runVoidMethod ("Add",(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<OrdemProd>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</OrdemProd>"))))))));
 BA.debugLineNum = 236;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(";
Debug.ShouldStop(2048);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 237;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Ind";
Debug.ShouldStop(4096);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;

case 47:
//C
this.state = 86;
;
 if (true) break;
if (true) break;

case 48:
//C
this.state = 49;
;
 if (true) break;

case 49:
//C
this.state = 50;
;
 if (true) break;

case 50:
//C
this.state = 53;
;
 BA.debugLineNum = 242;BA.debugLine="ListOrdemProdSAP.Add(\"Fim\")";
Debug.ShouldStop(131072);
parent.mostCurrent._listordemprodsap.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("Fim"))));
 Debug.CheckDeviceExceptions();
if (true) break;

case 52:
//C
this.state = 53;
this.catchState = 0;
 BA.debugLineNum = 244;BA.debugLine="MsgboxAsync(\"Erro ao carregar os CUCs\",\"Aviso\")";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao carregar os CUCs")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;
if (true) break;
;
 BA.debugLineNum = 246;BA.debugLine="Try";
Debug.ShouldStop(2097152);

case 53:
//try
this.state = 78;
this.catchState = 0;
this.catchState = 77;
this.state = 55;
if (true) break;

case 55:
//C
this.state = 56;
this.catchState = 77;
 BA.debugLineNum = 247;BA.debugLine="Dim count As Int = ListOrdemProdSAP.Size";
Debug.ShouldStop(4194304);
parent._count = parent.mostCurrent._listordemprodsap.runMethod(true,"getSize");
 BA.debugLineNum = 248;BA.debugLine="Dim OrdemProd As String";
Debug.ShouldStop(8388608);
_ordemprod = RemoteObject.createImmutable("");Debug.locals.put("OrdemProd", _ordemprod);
 BA.debugLineNum = 249;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(16777216);
if (true) break;

case 56:
//for
this.state = 75;
step115 = 1;
limit115 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 87;
if (true) break;

case 87:
//C
this.state = 75;
if ((step115 > 0 && parent._i.<Integer>get().intValue() <= limit115) || (step115 < 0 && parent._i.<Integer>get().intValue() >= limit115)) this.state = 58;
if (true) break;

case 88:
//C
this.state = 87;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step115)) ;
if (true) break;

case 58:
//C
this.state = 59;
 BA.debugLineNum = 250;BA.debugLine="If i >= count Then";
Debug.ShouldStop(33554432);
if (true) break;

case 59:
//if
this.state = 74;
if (RemoteObject.solveBoolean("g",parent._i,BA.numberCast(double.class, parent._count))) { 
this.state = 61;
}else {
this.state = 63;
}if (true) break;

case 61:
//C
this.state = 74;
 if (true) break;

case 63:
//C
this.state = 64;
 BA.debugLineNum = 252;BA.debugLine="OrdemProd = ListOrdemProdSAP.Get(i)";
Debug.ShouldStop(134217728);
_ordemprod = BA.ObjectToString(parent.mostCurrent._listordemprodsap.runMethod(false,"Get",(Object)(parent._i)));Debug.locals.put("OrdemProd", _ordemprod);
 BA.debugLineNum = 253;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryS";
Debug.ShouldStop(268435456);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemProg, DataHora, CodigoCUC, DescricaoCUC, Batch, Quant, OrdemProd, StatusPesagemProg, Rota, IdOrdemProdSap, Prioridade FROM unilever_pi.pesagemprog WHERE OrdemProd="),_ordemprod,RemoteObject.createImmutable(" LIMIT 1;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 254;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(536870912);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 255;BA.debugLine="Job1.GetRequest.SetContentType(\"application/X";
Debug.ShouldStop(1073741824);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 256;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_create"), (parent._job1));
this.state = 89;
return;
case 89:
//C
this.state = 64;
;
 BA.debugLineNum = 257;BA.debugLine="If Job1.Success = True Then";
Debug.ShouldStop(1);
if (true) break;

case 64:
//if
this.state = 73;
if (RemoteObject.solveBoolean("=",parent._job1.getField(true,"_success" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 66;
}if (true) break;

case 66:
//C
this.state = 67;
 BA.debugLineNum = 258;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(2);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 259;BA.debugLine="If XMLwork=\"<DocumentElement />\" Or XMLwork=";
Debug.ShouldStop(4);
if (true) break;

case 67:
//if
this.state = 72;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("<DocumentElement />")) || RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("0"))) { 
this.state = 69;
}else {
this.state = 71;
}if (true) break;

case 69:
//C
this.state = 72;
 if (true) break;

case 71:
//C
this.state = 72;
 BA.debugLineNum = 261;BA.debugLine="ListViewCUCMain.AddSingleLine2(XMLwork.SubS";
Debug.ShouldStop(16);
parent.mostCurrent._listviewcucmain.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoCUC>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<OrdemProd>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</OrdemProd>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoCUC>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Batch>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Batch>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Quant>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Quant>")))))))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idPesagemProg>"))),RemoteObject.createImmutable(15)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idPesagemProg>"))))))));
 if (true) break;

case 72:
//C
this.state = 73;
;
 if (true) break;

case 73:
//C
this.state = 74;
;
 if (true) break;

case 74:
//C
this.state = 88;
;
 if (true) break;
if (true) break;

case 75:
//C
this.state = 78;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 77:
//C
this.state = 78;
this.catchState = 0;
 BA.debugLineNum = 267;BA.debugLine="MsgboxAsync(\"Erro ao carregar os CUCs\",\"AvisoS\")";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao carregar os CUCs")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AvisoS"))),main.processBA);
 if (true) break;
if (true) break;

case 78:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 269;BA.debugLine="ListProdutosPesagem.Initialize";
Debug.ShouldStop(4096);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Initialize");
 BA.debugLineNum = 270;BA.debugLine="ButtonCadastraBalnca.Enabled = False";
Debug.ShouldStop(8192);
parent.mostCurrent._buttoncadastrabalnca.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 271;BA.debugLine="ButtonUsuarios.Enabled =  False";
Debug.ShouldStop(16384);
parent.mostCurrent._buttonusuarios.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 272;BA.debugLine="ButtonCadastroProduto.Enabled =  False";
Debug.ShouldStop(32768);
parent.mostCurrent._buttoncadastroproduto.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 273;BA.debugLine="ButtonWebservice.Enabled =  False";
Debug.ShouldStop(65536);
parent.mostCurrent._buttonwebservice.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 274;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
public static void  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,280);
if (RapidSub.canDelegate("activity_pause")) { wrong.addition.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed); return;}
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
public ResumableSub_Activity_Pause(wrong.addition.main parent,RemoteObject _userclosed) {
this.parent = parent;
this._userclosed = _userclosed;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _userclosed;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,280);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 281;BA.debugLine="Do While UserClosed = True";
Debug.ShouldStop(16777216);
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
 BA.debugLineNum = 282;BA.debugLine="Sleep(1000)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "activity_pause"),BA.numberCast(int.class, 1000));
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
 BA.debugLineNum = 284;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,276);
if (RapidSub.canDelegate("activity_resume")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 276;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _buttonalterarusuario_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonAlterarUsuario_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,642);
if (RapidSub.canDelegate("buttonalterarusuario_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonalterarusuario_click"); return;}
ResumableSub_ButtonAlterarUsuario_Click rsub = new ResumableSub_ButtonAlterarUsuario_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonAlterarUsuario_Click extends BA.ResumableSub {
public ResumableSub_ButtonAlterarUsuario_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _retu = RemoteObject.createImmutable("");
RemoteObject _usercurrent = RemoteObject.createImmutable("");
RemoteObject _usermain = RemoteObject.createImmutable("");
int step19;
int limit19;
int step28;
int limit28;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonAlterarUsuario_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,642);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 643;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDAT";
Debug.ShouldStop(4);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryUPDATE unilever_pi.usuarios SET usuario='"),parent.mostCurrent._edittextnomeusuario.runMethod(true,"getText"),RemoteObject.createImmutable("', nivel="),parent._positionnivel,RemoteObject.createImmutable(", pesagem=1, processo=1, relatorio=1 WHERE idusuario="),parent._idusuario);Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 644;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(8);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 645;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
Debug.ShouldStop(16);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 646;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonalterarusuario_click"), (parent._job1));
this.state = 27;
return;
case 27:
//C
this.state = 1;
;
 BA.debugLineNum = 647;BA.debugLine="Dim ret As String  = Job1.GetString";
Debug.ShouldStop(64);
_ret = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 648;BA.debugLine="If ret = \"0\"  Or ret=\"2\" Then";
Debug.ShouldStop(128);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("0")) || RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("2"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 649;BA.debugLine="MsgboxAsync(\"Falha ao Alterar\",\"Erro\")";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Falha ao Alterar")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 651;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
Debug.ShouldStop(1024);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ListaUsuarios"))));
 BA.debugLineNum = 652;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonalterarusuario_click"), (parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 5;
;
 BA.debugLineNum = 653;BA.debugLine="Dim retu As String = Job1.GetString";
Debug.ShouldStop(4096);
_retu = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("retu", _retu);Debug.locals.put("retu", _retu);
 BA.debugLineNum = 654;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
Debug.ShouldStop(8192);
_ret = _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<return>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</return>")))));Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 655;BA.debugLine="Dim usercurrent As String = \"\"";
Debug.ShouldStop(16384);
_usercurrent = BA.ObjectToString("");Debug.locals.put("usercurrent", _usercurrent);Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 656;BA.debugLine="Dim count As Int = ListViewUsuarios.Size";
Debug.ShouldStop(32768);
parent._count = parent.mostCurrent._listviewusuarios.runMethod(true,"getSize");
 BA.debugLineNum = 657;BA.debugLine="ListViewUsuarios.Clear";
Debug.ShouldStop(65536);
parent.mostCurrent._listviewusuarios.runVoidMethod ("Clear");
 BA.debugLineNum = 658;BA.debugLine="If ret = \"1\"  Then";
Debug.ShouldStop(131072);
if (true) break;

case 5:
//if
this.state = 26;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("1"))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 659;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
Debug.ShouldStop(262144);
_usermain = _retu.runMethod(true,"substring",(Object)(_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</usuario>")))));Debug.locals.put("usermain", _usermain);Debug.locals.put("usermain", _usermain);
 BA.debugLineNum = 660;BA.debugLine="Try";
Debug.ShouldStop(524288);
if (true) break;

case 8:
//try
this.state = 25;
this.catchState = 24;
this.state = 10;
if (true) break;

case 10:
//C
this.state = 11;
this.catchState = 24;
 BA.debugLineNum = 661;BA.debugLine="For i=0 To count-1";
Debug.ShouldStop(1048576);
if (true) break;

case 11:
//for
this.state = 22;
step19 = 1;
limit19 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 22;
if ((step19 > 0 && parent._i.<Integer>get().intValue() <= limit19) || (step19 < 0 && parent._i.<Integer>get().intValue() >= limit19)) this.state = 13;
if (true) break;

case 30:
//C
this.state = 29;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step19)) ;
if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 662;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
Debug.ShouldStop(2097152);
_usercurrent = _usermain.runMethod(true,"substring",(Object)(_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 663;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
Debug.ShouldStop(4194304);
_usercurrent = _usercurrent.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 664;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
Debug.ShouldStop(8388608);
parent.mostCurrent._listviewusuarios.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>"))))))),(Object)((_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))))));
 BA.debugLineNum = 665;BA.debugLine="If i = PositionUser Then";
Debug.ShouldStop(16777216);
if (true) break;

case 14:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, parent._positionuser))) { 
this.state = 16;
}if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 666;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
Debug.ShouldStop(33554432);
parent.mostCurrent._edittextnomeusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>")))))));
 BA.debugLineNum = 667;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
Debug.ShouldStop(67108864);
parent._positionnivel = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>"))))));
 BA.debugLineNum = 668;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
Debug.ShouldStop(134217728);
parent._idusuario = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))));
 BA.debugLineNum = 669;BA.debugLine="ListViewAcesso.Clear";
Debug.ShouldStop(268435456);
parent.mostCurrent._listviewacesso.runVoidMethod ("Clear");
 BA.debugLineNum = 670;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(536870912);
if (true) break;

case 17:
//for
this.state = 20;
step28 = 1;
limit28 = 4;
parent._i = BA.numberCast(int.class, 0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 20;
if ((step28 > 0 && parent._i.<Integer>get().intValue() <= limit28) || (step28 < 0 && parent._i.<Integer>get().intValue() >= limit28)) this.state = 19;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step28)) ;
if (true) break;

case 19:
//C
this.state = 32;
 BA.debugLineNum = 671;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
Debug.ShouldStop(1073741824);
parent.mostCurrent._listviewacesso.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent._i)),(Object)((parent._i)));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 BA.debugLineNum = 673;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(1);
parent.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(parent._positionnivel));
 if (true) break;

case 21:
//C
this.state = 30;
;
 BA.debugLineNum = 675;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
Debug.ShouldStop(4);
_usermain = _usermain.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usermain", _usermain);
 if (true) break;
if (true) break;

case 22:
//C
this.state = 25;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 24:
//C
this.state = 25;
this.catchState = 0;
 BA.debugLineNum = 678;BA.debugLine="MsgboxAsync(\"Erro ao Alterar\",\"Erro\")";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao Alterar")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
;
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 681;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
public static void  _buttonapagarusuario_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonApagarUsuario_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,683);
if (RapidSub.canDelegate("buttonapagarusuario_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonapagarusuario_click"); return;}
ResumableSub_ButtonApagarUsuario_Click rsub = new ResumableSub_ButtonApagarUsuario_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonApagarUsuario_Click extends BA.ResumableSub {
public ResumableSub_ButtonApagarUsuario_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _retu = RemoteObject.createImmutable("");
RemoteObject _usercurrent = RemoteObject.createImmutable("");
RemoteObject _cnt = RemoteObject.createImmutable(0);
RemoteObject _usermain = RemoteObject.createImmutable("");
int step20;
int limit20;
int step29;
int limit29;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonApagarUsuario_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,683);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 684;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryDELET";
Debug.ShouldStop(2048);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryDELETE * FROM unilever_pi.usuarios WHERE idusuario="),parent._idusuario,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 685;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(4096);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 686;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
Debug.ShouldStop(8192);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 687;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonapagarusuario_click"), (parent._job1));
this.state = 27;
return;
case 27:
//C
this.state = 1;
;
 BA.debugLineNum = 688;BA.debugLine="Dim ret As String  = Job1.GetString";
Debug.ShouldStop(32768);
_ret = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 689;BA.debugLine="If ret = \"0\" Then";
Debug.ShouldStop(65536);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("0"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 690;BA.debugLine="MsgboxAsync(\"Falha ao gravar\",\"Erro\")";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Falha ao gravar")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 692;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
Debug.ShouldStop(524288);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ListaUsuarios"))));
 BA.debugLineNum = 693;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonapagarusuario_click"), (parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 5;
;
 BA.debugLineNum = 694;BA.debugLine="Dim retu As String = Job1.GetString";
Debug.ShouldStop(2097152);
_retu = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("retu", _retu);Debug.locals.put("retu", _retu);
 BA.debugLineNum = 695;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
Debug.ShouldStop(4194304);
_ret = _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<return>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</return>")))));Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 696;BA.debugLine="Dim usercurrent As String = \"\"";
Debug.ShouldStop(8388608);
_usercurrent = BA.ObjectToString("");Debug.locals.put("usercurrent", _usercurrent);Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 697;BA.debugLine="Dim count As Int = ListViewUsuarios.Size";
Debug.ShouldStop(16777216);
parent._count = parent.mostCurrent._listviewusuarios.runMethod(true,"getSize");
 BA.debugLineNum = 698;BA.debugLine="ListViewUsuarios.Clear";
Debug.ShouldStop(33554432);
parent.mostCurrent._listviewusuarios.runVoidMethod ("Clear");
 BA.debugLineNum = 699;BA.debugLine="If ret = \"1\"  Then";
Debug.ShouldStop(67108864);
if (true) break;

case 5:
//if
this.state = 26;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("1"))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 700;BA.debugLine="Dim cnt As Int = retu.SubString2(retu.IndexOf(\"<";
Debug.ShouldStop(134217728);
_cnt = BA.numberCast(int.class, _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<count>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</count>"))))));Debug.locals.put("cnt", _cnt);Debug.locals.put("cnt", _cnt);
 BA.debugLineNum = 701;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
Debug.ShouldStop(268435456);
_usermain = _retu.runMethod(true,"substring",(Object)(_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</usuario>")))));Debug.locals.put("usermain", _usermain);Debug.locals.put("usermain", _usermain);
 BA.debugLineNum = 702;BA.debugLine="Try";
Debug.ShouldStop(536870912);
if (true) break;

case 8:
//try
this.state = 25;
this.catchState = 24;
this.state = 10;
if (true) break;

case 10:
//C
this.state = 11;
this.catchState = 24;
 BA.debugLineNum = 703;BA.debugLine="For i=0 To cnt-1";
Debug.ShouldStop(1073741824);
if (true) break;

case 11:
//for
this.state = 22;
step20 = 1;
limit20 = RemoteObject.solve(new RemoteObject[] {_cnt,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 22;
if ((step20 > 0 && parent._i.<Integer>get().intValue() <= limit20) || (step20 < 0 && parent._i.<Integer>get().intValue() >= limit20)) this.state = 13;
if (true) break;

case 30:
//C
this.state = 29;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step20)) ;
if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 704;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
Debug.ShouldStop(-2147483648);
_usercurrent = _usermain.runMethod(true,"substring",(Object)(_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 705;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
Debug.ShouldStop(1);
_usercurrent = _usercurrent.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 706;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
Debug.ShouldStop(2);
parent.mostCurrent._listviewusuarios.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>"))))))),(Object)((_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))))));
 BA.debugLineNum = 707;BA.debugLine="If i = PositionUser Then";
Debug.ShouldStop(4);
if (true) break;

case 14:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, parent._positionuser))) { 
this.state = 16;
}if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 708;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
Debug.ShouldStop(8);
parent.mostCurrent._edittextnomeusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>")))))));
 BA.debugLineNum = 709;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
Debug.ShouldStop(16);
parent._positionnivel = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>"))))));
 BA.debugLineNum = 710;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
Debug.ShouldStop(32);
parent._idusuario = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))));
 BA.debugLineNum = 711;BA.debugLine="ListViewAcesso.Clear";
Debug.ShouldStop(64);
parent.mostCurrent._listviewacesso.runVoidMethod ("Clear");
 BA.debugLineNum = 712;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(128);
if (true) break;

case 17:
//for
this.state = 20;
step29 = 1;
limit29 = 4;
parent._i = BA.numberCast(int.class, 0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 20;
if ((step29 > 0 && parent._i.<Integer>get().intValue() <= limit29) || (step29 < 0 && parent._i.<Integer>get().intValue() >= limit29)) this.state = 19;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step29)) ;
if (true) break;

case 19:
//C
this.state = 32;
 BA.debugLineNum = 713;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
Debug.ShouldStop(256);
parent.mostCurrent._listviewacesso.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent._i)),(Object)((parent._i)));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 BA.debugLineNum = 715;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(1024);
parent.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(parent._positionnivel));
 if (true) break;

case 21:
//C
this.state = 30;
;
 BA.debugLineNum = 717;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
Debug.ShouldStop(4096);
_usermain = _usermain.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usermain", _usermain);
 if (true) break;
if (true) break;

case 22:
//C
this.state = 25;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 24:
//C
this.state = 25;
this.catchState = 0;
 BA.debugLineNum = 720;BA.debugLine="MsgboxAsync(\"Erro ao Alterar\",\"Erro\")";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao Alterar")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
;
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 723;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
public static void  _buttonapgarprodutocuc_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonApgarProdutoCUC_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1029);
if (RapidSub.canDelegate("buttonapgarprodutocuc_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonapgarprodutocuc_click"); return;}
ResumableSub_ButtonApgarProdutoCUC_Click rsub = new ResumableSub_ButtonApgarProdutoCUC_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonApgarProdutoCUC_Click extends BA.ResumableSub {
public ResumableSub_ButtonApgarProdutoCUC_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonApgarProdutoCUC_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1029);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1030;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryDELET";
Debug.ShouldStop(32);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryDELETE FROM unilever_pi.produto_cuc WHERE codigomaterial="),parent.mostCurrent._edittextcodigoproduto.runMethod(true,"getText"),RemoteObject.createImmutable("AND codigoCUC="),parent.mostCurrent._edittextcodigocuctela.runMethod(true,"getText"),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1031;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(64);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1032;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
Debug.ShouldStop(128);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1033;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonapgarprodutocuc_click"), (parent._job1));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 BA.debugLineNum = 1034;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(512);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1035;BA.debugLine="If XMLwork = \"1\" Then";
Debug.ShouldStop(1024);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("1"))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 1036;BA.debugLine="MsgboxAsync(\"Apagado com sucesso.\",\"Sucesso\")";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Apagado com sucesso.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Sucesso"))),main.processBA);
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 1038;BA.debugLine="MsgboxAsync(\"Erro ao apagar.\",\"Erro\")";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao apagar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 1040;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static void  _buttonbalanaalterar_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonBalanaAlterar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1237);
if (RapidSub.canDelegate("buttonbalanaalterar_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonbalanaalterar_click"); return;}
ResumableSub_ButtonBalanaAlterar_Click rsub = new ResumableSub_ButtonBalanaAlterar_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonBalanaAlterar_Click extends BA.ResumableSub {
public ResumableSub_ButtonBalanaAlterar_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _idbalanca = RemoteObject.createImmutable(0);
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonBalanaAlterar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1237);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1238;BA.debugLine="Try";
Debug.ShouldStop(2097152);
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
 BA.debugLineNum = 1239;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(4194304);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="),parent._positiondb2,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1240;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(8388608);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1241;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(16777216);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1242;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonbalanaalterar_click"), (parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 4;
;
 BA.debugLineNum = 1243;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(67108864);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1244;BA.debugLine="Dim idBalanca As Int = XMLwork.SubString2(XMLwor";
Debug.ShouldStop(134217728);
_idbalanca = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))));Debug.locals.put("idBalanca", _idbalanca);Debug.locals.put("idBalanca", _idbalanca);
 BA.debugLineNum = 1245;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
Debug.ShouldStop(268435456);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryUPDATE unilever_pi.balancas SET balanca='"),parent.mostCurrent._edittextnomebalanca.runMethod(true,"getText"),RemoteObject.createImmutable("', ipbalanca='"),parent.mostCurrent._edittextip.runMethod(true,"getText"),RemoteObject.createImmutable("', portabalanca="),parent.mostCurrent._edittextporta.runMethod(true,"getText"),RemoteObject.createImmutable(", divisor="),parent.mostCurrent._edittextdivisor.runMethod(true,"getText"),RemoteObject.createImmutable(", decimais="),parent.mostCurrent._edittextdecimais.runMethod(true,"getText"),RemoteObject.createImmutable(" WHERE idbalancas="),_idbalanca,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1246;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(536870912);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1247;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(1073741824);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1248;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonbalanaalterar_click"), (parent._job1));
this.state = 18;
return;
case 18:
//C
this.state = 4;
;
 BA.debugLineNum = 1249;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(1);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1250;BA.debugLine="ListViewTelaBalanca.Clear";
Debug.ShouldStop(2);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("Clear");
 BA.debugLineNum = 1251;BA.debugLine="ListViewBalanca.Clear";
Debug.ShouldStop(4);
parent.mostCurrent._listviewbalanca.runVoidMethod ("Clear");
 BA.debugLineNum = 1252;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(8);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1253;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(16);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1254;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(32);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1255;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonbalanaalterar_click"), (parent._job1));
this.state = 19;
return;
case 19:
//C
this.state = 4;
;
 BA.debugLineNum = 1256;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(128);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1257;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(256);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1258;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(512);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1259;BA.debugLine="XMLCurrent = XMLwork.SubString2(XMLwork.IndexOf(";
Debug.ShouldStop(1024);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 1260;BA.debugLine="If count=1 Then";
Debug.ShouldStop(2048);
if (true) break;

case 4:
//if
this.state = 13;
if (RemoteObject.solveBoolean("=",parent._count,BA.numberCast(double.class, 1))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 1261;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLwo";
Debug.ShouldStop(4096);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1262;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&X";
Debug.ShouldStop(8192);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1264;BA.debugLine="For i=1 To count";
Debug.ShouldStop(32768);
if (true) break;

case 9:
//for
this.state = 12;
step27 = 1;
limit27 = parent._count.<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 12;
if ((step27 > 0 && parent._i.<Integer>get().intValue() <= limit27) || (step27 < 0 && parent._i.<Integer>get().intValue() >= limit27)) this.state = 11;
if (true) break;

case 21:
//C
this.state = 20;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step27)) ;
if (true) break;

case 11:
//C
this.state = 21;
 BA.debugLineNum = 1265;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubStri";
Debug.ShouldStop(65536);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1266;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.Sub";
Debug.ShouldStop(131072);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1267;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
Debug.ShouldStop(262144);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1268;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
Debug.ShouldStop(524288);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 12:
//C
this.state = 13;
;
 if (true) break;

case 13:
//C
this.state = 16;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 1272;BA.debugLine="count  =  count";
Debug.ShouldStop(8388608);
parent._count = parent._count;
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1274;BA.debugLine="End Sub";
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
public static void  _buttonbalancadown_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonBalancaDown_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,783);
if (RapidSub.canDelegate("buttonbalancadown_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonbalancadown_click"); return;}
ResumableSub_ButtonBalancaDown_Click rsub = new ResumableSub_ButtonBalancaDown_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonBalancaDown_Click extends BA.ResumableSub {
public ResumableSub_ButtonBalancaDown_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonBalancaDown_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,783);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 784;BA.debugLine="Try";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//try
this.state = 27;
this.catchState = 26;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 26;
 BA.debugLineNum = 785;BA.debugLine="If PosBalanca=0 Then";
Debug.ShouldStop(65536);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",parent._posbalanca,BA.numberCast(double.class, 0))) { 
this.state = 6;
}else 
{ BA.debugLineNum = 789;BA.debugLine="Else If PosBalanca <= ListViewTelaBalanca.Size-1";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("k",parent._posbalanca,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewtelabalanca.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
this.state = 8;
}}
if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 786;BA.debugLine="PosBalanca = 1";
Debug.ShouldStop(131072);
parent._posbalanca = BA.numberCast(int.class, 1);
 BA.debugLineNum = 787;BA.debugLine="positionDB2 =  2";
Debug.ShouldStop(262144);
parent._positiondb2 = BA.numberCast(int.class, 2);
 BA.debugLineNum = 788;BA.debugLine="ListViewTelaBalanca.SetSelection(1)";
Debug.ShouldStop(524288);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 1)));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 790;BA.debugLine="PosBalanca =  PosBalanca+1";
Debug.ShouldStop(2097152);
parent._posbalanca = RemoteObject.solve(new RemoteObject[] {parent._posbalanca,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 791;BA.debugLine="positionDB2=  PosBalanca+1";
Debug.ShouldStop(4194304);
parent._positiondb2 = RemoteObject.solve(new RemoteObject[] {parent._posbalanca,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 792;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
Debug.ShouldStop(8388608);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("SetSelection",(Object)(parent._posbalanca));
 if (true) break;
;
 BA.debugLineNum = 794;BA.debugLine="If PosBalanca > ListViewTelaBalanca.Size Then";
Debug.ShouldStop(33554432);

case 9:
//if
this.state = 12;
if (RemoteObject.solveBoolean(">",parent._posbalanca,BA.numberCast(double.class, parent.mostCurrent._listviewtelabalanca.runMethod(true,"getSize")))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 795;BA.debugLine="positionDB2 = ListViewTelaBalanca.Size";
Debug.ShouldStop(67108864);
parent._positiondb2 = parent.mostCurrent._listviewtelabalanca.runMethod(true,"getSize");
 BA.debugLineNum = 796;BA.debugLine="PosBalanca = ListViewTelaBalanca.Size-1";
Debug.ShouldStop(134217728);
parent._posbalanca = RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewtelabalanca.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);
 if (true) break;

case 12:
//C
this.state = 13;
;
 BA.debugLineNum = 798;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(536870912);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="),parent._positiondb2,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 799;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1073741824);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 800;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(-2147483648);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 801;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonbalancadown_click"), (parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 13;
;
 BA.debugLineNum = 802;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(2);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 803;BA.debugLine="If XMLwork=\"<DocumentElement />\" Or XMLwork=\"0\"";
Debug.ShouldStop(4);
if (true) break;

case 13:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("<DocumentElement />")) || RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("0"))) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 24;
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 805;BA.debugLine="EditTextNomeBalanca.Text = XMLwork.SubString2(X";
Debug.ShouldStop(16);
parent.mostCurrent._edittextnomebalanca.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>")))))));
 BA.debugLineNum = 806;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.In";
Debug.ShouldStop(32);
parent.mostCurrent._edittextip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<ipbalanca>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</ipbalanca>")))))));
 BA.debugLineNum = 807;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork";
Debug.ShouldStop(64);
parent.mostCurrent._edittextporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<portabalanca>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</portabalanca>")))))));
 BA.debugLineNum = 808;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwo";
Debug.ShouldStop(128);
parent.mostCurrent._edittextdivisor.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>")))))));
 BA.debugLineNum = 809;BA.debugLine="EditTextDecimais.Text = XMLwork.SubString2(XMLw";
Debug.ShouldStop(256);
parent.mostCurrent._edittextdecimais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<decimais>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</decimais>")))))));
 BA.debugLineNum = 810;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipope";
Debug.ShouldStop(512);
if (true) break;

case 18:
//if
this.state = 23;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),BA.ObjectToString("g"))) { 
this.state = 20;
}else {
this.state = 22;
}if (true) break;

case 20:
//C
this.state = 23;
 BA.debugLineNum = 811;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(1024);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 812;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(2048);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 813;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(4096);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 814;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(8192);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 22:
//C
this.state = 23;
 BA.debugLineNum = 816;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(32768);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 817;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(65536);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 818;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(131072);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 819;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(262144);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = 27;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 26:
//C
this.state = 27;
this.catchState = 0;
 BA.debugLineNum = 823;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao mudar a posição.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 27:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 825;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
public static void  _buttonbalancaup_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonBalancaUp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,742);
if (RapidSub.canDelegate("buttonbalancaup_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonbalancaup_click"); return;}
ResumableSub_ButtonBalancaUp_Click rsub = new ResumableSub_ButtonBalancaUp_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonBalancaUp_Click extends BA.ResumableSub {
public ResumableSub_ButtonBalancaUp_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonBalancaUp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,742);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 743;BA.debugLine="Try";
Debug.ShouldStop(64);
if (true) break;

case 1:
//try
this.state = 24;
this.catchState = 23;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 23;
 BA.debugLineNum = 744;BA.debugLine="Try";
Debug.ShouldStop(128);
if (true) break;

case 4:
//try
this.state = 15;
this.catchState = 14;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 14;
 BA.debugLineNum = 745;BA.debugLine="If PosBalanca=0 Then";
Debug.ShouldStop(256);
if (true) break;

case 7:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",parent._posbalanca,BA.numberCast(double.class, 0))) { 
this.state = 9;
}else 
{ BA.debugLineNum = 748;BA.debugLine="Else if PosBalanca >= ListViewTelaBalanca.Size-";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("g",parent._posbalanca,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewtelabalanca.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))) || RemoteObject.solveBoolean("k",parent._posbalanca,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewtelabalanca.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
this.state = 11;
}}
if (true) break;

case 9:
//C
this.state = 12;
 BA.debugLineNum = 746;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
Debug.ShouldStop(512);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("SetSelection",(Object)(parent._posbalanca));
 BA.debugLineNum = 747;BA.debugLine="positionDB2 = 1";
Debug.ShouldStop(1024);
parent._positiondb2 = BA.numberCast(int.class, 1);
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 749;BA.debugLine="positionDB2=  PosBalanca";
Debug.ShouldStop(4096);
parent._positiondb2 = parent._posbalanca;
 BA.debugLineNum = 750;BA.debugLine="PosBalanca =  PosBalanca-1";
Debug.ShouldStop(8192);
parent._posbalanca = RemoteObject.solve(new RemoteObject[] {parent._posbalanca,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 751;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
Debug.ShouldStop(16384);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("SetSelection",(Object)(parent._posbalanca));
 if (true) break;

case 12:
//C
this.state = 15;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 14:
//C
this.state = 15;
this.catchState = 23;
 BA.debugLineNum = 754;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
Debug.ShouldStop(131072);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("SetSelection",(Object)(parent._posbalanca));
 BA.debugLineNum = 755;BA.debugLine="positionDB2 = 1";
Debug.ShouldStop(262144);
parent._positiondb2 = BA.numberCast(int.class, 1);
 if (true) break;
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 23;
;
 BA.debugLineNum = 757;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(1048576);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="),parent._positiondb2,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 758;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(2097152);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 759;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(4194304);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 760;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonbalancaup_click"), (parent._job1));
this.state = 25;
return;
case 25:
//C
this.state = 16;
;
 BA.debugLineNum = 761;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(16777216);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 762;BA.debugLine="EditTextNomeBalanca.Text = XMLwork.SubString2(XM";
Debug.ShouldStop(33554432);
parent.mostCurrent._edittextnomebalanca.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>")))))));
 BA.debugLineNum = 763;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
Debug.ShouldStop(67108864);
parent.mostCurrent._edittextip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<ipbalanca>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</ipbalanca>")))))));
 BA.debugLineNum = 764;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(134217728);
parent.mostCurrent._edittextporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<portabalanca>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</portabalanca>")))))));
 BA.debugLineNum = 765;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwor";
Debug.ShouldStop(268435456);
parent.mostCurrent._edittextdivisor.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>")))))));
 BA.debugLineNum = 766;BA.debugLine="EditTextDecimais.Text = XMLwork.SubString2(XMLwo";
Debug.ShouldStop(536870912);
parent.mostCurrent._edittextdecimais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<decimais>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</decimais>")))))));
 BA.debugLineNum = 767;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipopes";
Debug.ShouldStop(1073741824);
if (true) break;

case 16:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),BA.ObjectToString("g"))) { 
this.state = 18;
}else {
this.state = 20;
}if (true) break;

case 18:
//C
this.state = 21;
 BA.debugLineNum = 768;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 769;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(1);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 770;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(2);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 771;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(4);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 773;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(16);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 774;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(32);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 775;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(64);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 776;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(128);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 21:
//C
this.state = 24;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 23:
//C
this.state = 24;
this.catchState = 0;
 BA.debugLineNum = 779;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao mudar a posição.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 24:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 781;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
public static void  _buttoncadastrabalnca_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonCadastraBalnca_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1094);
if (RapidSub.canDelegate("buttoncadastrabalnca_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttoncadastrabalnca_click"); return;}
ResumableSub_ButtonCadastraBalnca_Click rsub = new ResumableSub_ButtonCadastraBalnca_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonCadastraBalnca_Click extends BA.ResumableSub {
public ResumableSub_ButtonCadastraBalnca_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonCadastraBalnca_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1094);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1095;BA.debugLine="Try";
Debug.ShouldStop(64);
if (true) break;

case 1:
//try
this.state = 12;
this.catchState = 11;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 11;
 BA.debugLineNum = 1096;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(128);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num=1;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1097;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(256);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1098;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(512);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1099;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttoncadastrabalnca_click"), (parent._job1));
this.state = 13;
return;
case 13:
//C
this.state = 4;
;
 BA.debugLineNum = 1100;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(2048);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1101;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(4096);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1102;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(8192);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1103;BA.debugLine="EditTextNomeBalanca.Text = XMLwork.SubString2(XM";
Debug.ShouldStop(16384);
parent.mostCurrent._edittextnomebalanca.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>")))))));
 BA.debugLineNum = 1104;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
Debug.ShouldStop(32768);
parent.mostCurrent._edittextip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<ipbalanca>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</ipbalanca>")))))));
 BA.debugLineNum = 1105;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(65536);
parent.mostCurrent._edittextporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<portabalanca>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</portabalanca>")))))));
 BA.debugLineNum = 1106;BA.debugLine="decimal = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
Debug.ShouldStop(131072);
parent._decimal = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<decimais>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</decimais>"))))));
 BA.debugLineNum = 1107;BA.debugLine="divisor = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
Debug.ShouldStop(262144);
parent._divisor = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>"))))));
 BA.debugLineNum = 1108;BA.debugLine="EditTextDivisor.Text = divisor";
Debug.ShouldStop(524288);
parent.mostCurrent._edittextdivisor.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent._divisor));
 BA.debugLineNum = 1109;BA.debugLine="EditTextDecimais.Text = decimal";
Debug.ShouldStop(1048576);
parent.mostCurrent._edittextdecimais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent._decimal));
 BA.debugLineNum = 1110;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipopes";
Debug.ShouldStop(2097152);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),BA.ObjectToString("g"))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 1111;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(4194304);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1112;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(8388608);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 1113;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(16777216);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 1114;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(33554432);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1116;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(134217728);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1117;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(268435456);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 1118;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(536870912);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 1119;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(1073741824);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 9:
//C
this.state = 12;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 0;
 BA.debugLineNum = 1122;BA.debugLine="count = count";
Debug.ShouldStop(2);
parent._count = parent._count;
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1124;BA.debugLine="panelMenu.Visible =  False";
Debug.ShouldStop(8);
parent.mostCurrent._panelmenu.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 1125;BA.debugLine="panelConexao.Visible = True";
Debug.ShouldStop(16);
parent.mostCurrent._panelconexao.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1126;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
public static void  _buttoncadastroproduto_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonCadastroProduto_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,834);
if (RapidSub.canDelegate("buttoncadastroproduto_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttoncadastroproduto_click"); return;}
ResumableSub_ButtonCadastroProduto_Click rsub = new ResumableSub_ButtonCadastroProduto_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonCadastroProduto_Click extends BA.ResumableSub {
public ResumableSub_ButtonCadastroProduto_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
int step10;
int limit10;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonCadastroProduto_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,834);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 835;BA.debugLine="Try";
Debug.ShouldStop(4);
if (true) break;

case 1:
//try
this.state = 10;
this.catchState = 9;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 9;
 BA.debugLineNum = 836;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(8);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idproduto_cuc, codigoCUC, descricaoCUC, row_number() OVER (order by idproduto_cuc) as row_num FROM (SELECT idproduto_cuc, codigoCUC, descricaoCUC FROM unilever_pi.produto_cuc) t group by (CodigoCUC);"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 837;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(16);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 838;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(32);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 839;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttoncadastroproduto_click"), (parent._job1));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 BA.debugLineNum = 840;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(128);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 841;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(256);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 842;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(512);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 843;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
Debug.ShouldStop(1024);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 844;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(2048);
if (true) break;

case 4:
//for
this.state = 7;
step10 = 1;
limit10 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if ((step10 > 0 && parent._i.<Integer>get().intValue() <= limit10) || (step10 < 0 && parent._i.<Integer>get().intValue() >= limit10)) this.state = 6;
if (true) break;

case 13:
//C
this.state = 12;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step10)) ;
if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 845;BA.debugLine="ListViewCUC.AddSingleLine2(XMLCurrent.SubString";
Debug.ShouldStop(4096);
parent.mostCurrent._listviewcuc.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaoCUC>")))))))),(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>"))))))));
 BA.debugLineNum = 846;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
Debug.ShouldStop(8192);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 847;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.IndexO";
Debug.ShouldStop(16384);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
;
 BA.debugLineNum = 849;BA.debugLine="SelecionaCUC.Visible =  True";
Debug.ShouldStop(65536);
parent.mostCurrent._selecionacuc.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 850;BA.debugLine="panelMenu.Visible =  False";
Debug.ShouldStop(131072);
parent.mostCurrent._panelmenu.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 BA.debugLineNum = 852;BA.debugLine="SelecionaCUC.Visible =  True";
Debug.ShouldStop(524288);
parent.mostCurrent._selecionacuc.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 853;BA.debugLine="panelMenu.Visible =  False";
Debug.ShouldStop(1048576);
parent.mostCurrent._panelmenu.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 855;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
public static void  _buttoncarregarcuc_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonCarregarCUC_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,945);
if (RapidSub.canDelegate("buttoncarregarcuc_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttoncarregarcuc_click"); return;}
ResumableSub_ButtonCarregarCUC_Click rsub = new ResumableSub_ButtonCarregarCUC_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonCarregarCUC_Click extends BA.ResumableSub {
public ResumableSub_ButtonCarregarCUC_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
int step11;
int limit11;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonCarregarCUC_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,945);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 946;BA.debugLine="Try";
Debug.ShouldStop(131072);
if (true) break;

case 1:
//try
this.state = 10;
this.catchState = 9;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 9;
 BA.debugLineNum = 947;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(262144);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico, row_number() OVER (order by idproduto_cuc) as row_num FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico from unilever_pi.produto_cuc) t WHERE codigocuc="),parent.mostCurrent._edittextcodigocuc.runMethod(true,"getText"),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 948;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(524288);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 949;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 950;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttoncarregarcuc_click"), (parent._job1));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 BA.debugLineNum = 951;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(4194304);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 952;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(8388608);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 953;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(16777216);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 954;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
Debug.ShouldStop(33554432);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 955;BA.debugLine="ListViewProdutosCUC.Clear";
Debug.ShouldStop(67108864);
parent.mostCurrent._listviewprodutoscuc.runVoidMethod ("Clear");
 BA.debugLineNum = 956;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(134217728);
if (true) break;

case 4:
//for
this.state = 7;
step11 = 1;
limit11 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if ((step11 > 0 && parent._i.<Integer>get().intValue() <= limit11) || (step11 < 0 && parent._i.<Integer>get().intValue() >= limit11)) this.state = 6;
if (true) break;

case 13:
//C
this.state = 12;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step11)) ;
if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 957;BA.debugLine="ListViewProdutosCUC.AddSingleLine2(XMLCurrent.S";
Debug.ShouldStop(268435456);
parent.mostCurrent._listviewprodutoscuc.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaomaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaomaterial>"))))))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigomaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigomaterial>"))))))));
 BA.debugLineNum = 958;BA.debugLine="EditTextPordutoCUC.Text = XMLCurrent.SubString2";
Debug.ShouldStop(536870912);
parent.mostCurrent._edittextpordutocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaoCUC>")))))));
 BA.debugLineNum = 959;BA.debugLine="EditTextCodigoCuc.Text = XMLCurrent.SubString2(";
Debug.ShouldStop(1073741824);
parent.mostCurrent._edittextcodigocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>")))))));
 BA.debugLineNum = 960;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 961;BA.debugLine="XMLCurrent =  XMLwork.SubString2(5,XMLwork.Inde";
Debug.ShouldStop(1);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
;
 BA.debugLineNum = 963;BA.debugLine="panelProdutos.Visible =  True";
Debug.ShouldStop(4);
parent.mostCurrent._panelprodutos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 964;BA.debugLine="SelecionaCUC.Visible =  False";
Debug.ShouldStop(8);
parent.mostCurrent._selecionacuc.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 BA.debugLineNum = 966;BA.debugLine="panelProdutos.Visible =  True";
Debug.ShouldStop(32);
parent.mostCurrent._panelprodutos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 967;BA.debugLine="SelecionaCUC.Visible =  False";
Debug.ShouldStop(64);
parent.mostCurrent._selecionacuc.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 969;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
public static void  _buttonconcluirpesagem_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonConcluirPesagem_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1340);
if (RapidSub.canDelegate("buttonconcluirpesagem_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonconcluirpesagem_click"); return;}
ResumableSub_ButtonConcluirPesagem_Click rsub = new ResumableSub_ButtonConcluirPesagem_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonConcluirPesagem_Click extends BA.ResumableSub {
public ResumableSub_ButtonConcluirPesagem_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _pesobalanca = RemoteObject.createImmutable(0);
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork3 = RemoteObject.createImmutable("");
RemoteObject _count2 = RemoteObject.createImmutable(0);
RemoteObject _xmlcurrent2 = RemoteObject.createImmutable("");
int _x = 0;
int step22;
int limit22;
int step34;
int limit34;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonConcluirPesagem_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1340);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1341;BA.debugLine="Try";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//try
this.state = 32;
this.catchState = 31;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 31;
 BA.debugLineNum = 1342;BA.debugLine="Dim PesoBalanca As Double =  EditTextPeso.Text";
Debug.ShouldStop(536870912);
_pesobalanca = BA.numberCast(double.class, parent.mostCurrent._edittextpeso.runMethod(true,"getText"));Debug.locals.put("PesoBalanca", _pesobalanca);Debug.locals.put("PesoBalanca", _pesobalanca);
 BA.debugLineNum = 1343;BA.debugLine="If PesoAlvo =  0.0 Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 4:
//if
this.state = 29;
if (RemoteObject.solveBoolean("=",parent._pesoalvo,BA.numberCast(double.class, 0.0))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 29;
 BA.debugLineNum = 1344;BA.debugLine="MsgboxAsync(\"Peso já está correto\",\"Peso\")";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Peso já está correto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Peso"))),main.processBA);
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1346;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
Debug.ShouldStop(2);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryUPDATE unilever_pi.pesagemreceita SET PesoRota1="),_pesobalanca,RemoteObject.createImmutable(" WHERE IdCampanha="),parent.mostCurrent._campanha,RemoteObject.createImmutable(" AND CodigoMaterial="),parent.mostCurrent._cod,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1347;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(4);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1348;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(8);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1349;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonconcluirpesagem_click"), (parent._job1));
this.state = 33;
return;
case 33:
//C
this.state = 9;
;
 BA.debugLineNum = 1350;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(32);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1351;BA.debugLine="If XMLwork=\"1\" Then";
Debug.ShouldStop(64);
if (true) break;

case 9:
//if
this.state = 28;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("1"))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 1352;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySE";
Debug.ShouldStop(128);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idCampanha, idPesagemProg, DataHora, Usuario, IdProcesso, Impresso, row_number() OVER (order by idCampanha) as row_num FROM unilever_pi.campanha WHERE idPesagemProg="),parent.mostCurrent._idpesagemprog,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1353;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XM";
Debug.ShouldStop(256);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1354;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(512);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1355;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonconcluirpesagem_click"), (parent._job1));
this.state = 34;
return;
case 34:
//C
this.state = 12;
;
 BA.debugLineNum = 1356;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(2048);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1357;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(4096);
if (true) break;

case 12:
//if
this.state = 27;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 1358;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork";
Debug.ShouldStop(8192);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1359;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf";
Debug.ShouldStop(16384);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1360;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Ind";
Debug.ShouldStop(32768);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 1361;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(65536);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1362;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(131072);
if (true) break;

case 15:
//for
this.state = 26;
step22 = 1;
limit22 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 35;
if (true) break;

case 35:
//C
this.state = 26;
if ((step22 > 0 && parent._i.<Integer>get().intValue() <= limit22) || (step22 < 0 && parent._i.<Integer>get().intValue() >= limit22)) this.state = 17;
if (true) break;

case 36:
//C
this.state = 35;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step22)) ;
if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 1363;BA.debugLine="If i=1 Then";
Debug.ShouldStop(262144);
if (true) break;

case 18:
//if
this.state = 25;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, 1))) { 
this.state = 20;
}if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 1364;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuer";
Debug.ShouldStop(524288);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1365;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1366;BA.debugLine="Job1.GetRequest.SetContentType(\"application";
Debug.ShouldStop(2097152);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1367;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonconcluirpesagem_click"), (parent._job1));
this.state = 37;
return;
case 37:
//C
this.state = 21;
;
 BA.debugLineNum = 1368;BA.debugLine="Dim XMLwork3 As String = Job1.GetString";
Debug.ShouldStop(8388608);
_xmlwork3 = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLwork3", _xmlwork3);Debug.locals.put("XMLwork3", _xmlwork3);
 BA.debugLineNum = 1369;BA.debugLine="Dim count2 As Int = XMLwork3.SubString2(XML";
Debug.ShouldStop(16777216);
_count2 = BA.numberCast(int.class, _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));Debug.locals.put("count2", _count2);Debug.locals.put("count2", _count2);
 BA.debugLineNum = 1370;BA.debugLine="Dim XMLCurrent2 As String = XMLwork3.SubStr";
Debug.ShouldStop(33554432);
_xmlcurrent2 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XMLCurrent2", _xmlcurrent2);Debug.locals.put("XMLCurrent2", _xmlcurrent2);
 BA.debugLineNum = 1371;BA.debugLine="Campanha =  XMLCurrent.SubString2(XMLCurren";
Debug.ShouldStop(67108864);
parent.mostCurrent._campanha = parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>")))));
 BA.debugLineNum = 1372;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(134217728);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1373;BA.debugLine="ListProdutosPesagem.Clear";
Debug.ShouldStop(268435456);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1374;BA.debugLine="For x=1 To count2-1";
Debug.ShouldStop(536870912);
if (true) break;

case 21:
//for
this.state = 24;
step34 = 1;
limit34 = RemoteObject.solve(new RemoteObject[] {_count2,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_x = 1 ;
Debug.locals.put("x", _x);
this.state = 38;
if (true) break;

case 38:
//C
this.state = 24;
if ((step34 > 0 && _x <= limit34) || (step34 < 0 && _x >= limit34)) this.state = 23;
if (true) break;

case 39:
//C
this.state = 38;
_x = ((int)(0 + _x + step34)) ;
Debug.locals.put("x", _x);
if (true) break;

case 23:
//C
this.state = 39;
 BA.debugLineNum = 1375;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent2.SubStr";
Debug.ShouldStop(1073741824);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Add",(Object)((_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1376;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurre";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoMaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoMaterial>"))))).runMethod(true,"trim"),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Peso>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Peso>"))))),RemoteObject.createImmutable(" "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<EmbFechada>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</EmbFechada>"))))),RemoteObject.createImmutable(" "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" ("),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<UnidadeEmb>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</UnidadeEmb>"))))),RemoteObject.createImmutable(") | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota1>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota1>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota2>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota2>")))))))),(Object)((_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1377;BA.debugLine="XMLwork3 = XMLwork3.SubString(XMLwork3.Ind";
Debug.ShouldStop(1);
_xmlwork3 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));Debug.locals.put("XMLwork3", _xmlwork3);
 BA.debugLineNum = 1378;BA.debugLine="XMLCurrent2 =  XMLwork3.SubString2(XMLwork";
Debug.ShouldStop(2);
_xmlcurrent2 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XMLCurrent2", _xmlcurrent2);
 if (true) break;
if (true) break;

case 24:
//C
this.state = 25;
Debug.locals.put("x", _x);
;
 if (true) break;

case 25:
//C
this.state = 36;
;
 BA.debugLineNum = 1381;BA.debugLine="ListViewCampanha.AddSingleLine2(XMLCurrent.S";
Debug.ShouldStop(16);
parent.mostCurrent._listviewcampanha.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))))),(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))))));
 BA.debugLineNum = 1382;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(";
Debug.ShouldStop(32);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1383;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Ind";
Debug.ShouldStop(64);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 26:
//C
this.state = 27;
;
 if (true) break;

case 27:
//C
this.state = 28;
;
 if (true) break;

case 28:
//C
this.state = 29;
;
 if (true) break;

case 29:
//C
this.state = 32;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 31:
//C
this.state = 32;
this.catchState = 0;
 BA.debugLineNum = 1389;BA.debugLine="MsgboxAsync(\"Erro ao adicionar o peso.\",\"Erro\")";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao adicionar o peso.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 32:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1391;BA.debugLine="End Sub";
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
public static void  _buttondeletarbalanca_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonDeletarBalanca_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1276);
if (RapidSub.canDelegate("buttondeletarbalanca_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttondeletarbalanca_click"); return;}
ResumableSub_ButtonDeletarBalanca_Click rsub = new ResumableSub_ButtonDeletarBalanca_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonDeletarBalanca_Click extends BA.ResumableSub {
public ResumableSub_ButtonDeletarBalanca_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _idbalanca = RemoteObject.createImmutable(0);
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonDeletarBalanca_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1276);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1277;BA.debugLine="Try";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
 BA.debugLineNum = 1278;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(536870912);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="),parent._positiondb2,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1279;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1073741824);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1280;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(-2147483648);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1281;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttondeletarbalanca_click"), (parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 4;
;
 BA.debugLineNum = 1282;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(2);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1283;BA.debugLine="Dim idBalanca As Int = XMLwork.SubString2(XMLwor";
Debug.ShouldStop(4);
_idbalanca = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))));Debug.locals.put("idBalanca", _idbalanca);Debug.locals.put("idBalanca", _idbalanca);
 BA.debugLineNum = 1284;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryDELE";
Debug.ShouldStop(8);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryDELETE FROM unilever_pi.balancas WHERE idbalancas="),_idbalanca,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1285;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(16);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1286;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(32);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1287;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttondeletarbalanca_click"), (parent._job1));
this.state = 18;
return;
case 18:
//C
this.state = 4;
;
 BA.debugLineNum = 1288;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(128);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1289;BA.debugLine="ListViewTelaBalanca.Clear";
Debug.ShouldStop(256);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("Clear");
 BA.debugLineNum = 1290;BA.debugLine="ListViewBalanca.Clear";
Debug.ShouldStop(512);
parent.mostCurrent._listviewbalanca.runVoidMethod ("Clear");
 BA.debugLineNum = 1291;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(1024);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1292;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(2048);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1293;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(4096);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1294;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttondeletarbalanca_click"), (parent._job1));
this.state = 19;
return;
case 19:
//C
this.state = 4;
;
 BA.debugLineNum = 1295;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(16384);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1296;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(32768);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1297;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(65536);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1298;BA.debugLine="XMLCurrent= XMLwork.SubString2(XMLwork.IndexOf(\"";
Debug.ShouldStop(131072);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 1299;BA.debugLine="If count=1 Then";
Debug.ShouldStop(262144);
if (true) break;

case 4:
//if
this.state = 13;
if (RemoteObject.solveBoolean("=",parent._count,BA.numberCast(double.class, 1))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 1300;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLwo";
Debug.ShouldStop(524288);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1301;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&X";
Debug.ShouldStop(1048576);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1303;BA.debugLine="For i=1 To count";
Debug.ShouldStop(4194304);
if (true) break;

case 9:
//for
this.state = 12;
step27 = 1;
limit27 = parent._count.<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 12;
if ((step27 > 0 && parent._i.<Integer>get().intValue() <= limit27) || (step27 < 0 && parent._i.<Integer>get().intValue() >= limit27)) this.state = 11;
if (true) break;

case 21:
//C
this.state = 20;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step27)) ;
if (true) break;

case 11:
//C
this.state = 21;
 BA.debugLineNum = 1304;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubStri";
Debug.ShouldStop(8388608);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1305;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.Sub";
Debug.ShouldStop(16777216);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1306;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
Debug.ShouldStop(33554432);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1307;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
Debug.ShouldStop(67108864);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 12:
//C
this.state = 13;
;
 if (true) break;

case 13:
//C
this.state = 16;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 1311;BA.debugLine="MsgboxAsync(\"Eoo ao alterar o registro.\",\"Aviso\"";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Eoo ao alterar o registro.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1313;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
public static void  _buttonembalagem_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonEmbalagem_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1424);
if (RapidSub.canDelegate("buttonembalagem_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonembalagem_click"); return;}
ResumableSub_ButtonEmbalagem_Click rsub = new ResumableSub_ButtonEmbalagem_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonEmbalagem_Click extends BA.ResumableSub {
public ResumableSub_ButtonEmbalagem_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _pesoatual = RemoteObject.createImmutable(0);
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork3 = RemoteObject.createImmutable("");
RemoteObject _count2 = RemoteObject.createImmutable(0);
RemoteObject _xmlcurrent2 = RemoteObject.createImmutable("");
int _x = 0;
int step27;
int limit27;
int step39;
int limit39;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonEmbalagem_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1424);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1425;BA.debugLine="Try'";
Debug.ShouldStop(65536);
if (true) break;

case 1:
//try
this.state = 30;
this.catchState = 29;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 29;
 BA.debugLineNum = 1426;BA.debugLine="Dim PesoAtual As Double";
Debug.ShouldStop(131072);
_pesoatual = RemoteObject.createImmutable(0);Debug.locals.put("PesoAtual", _pesoatual);
 BA.debugLineNum = 1427;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(262144);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="),parent.mostCurrent._campanha,RemoteObject.createImmutable(" AND CodigoMaterial="),parent.mostCurrent._cod,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1428;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(524288);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1429;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1430;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonembalagem_click"), (parent._job1));
this.state = 31;
return;
case 31:
//C
this.state = 4;
;
 BA.debugLineNum = 1431;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(4194304);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1432;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(8388608);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 1433;BA.debugLine="PesoAtual  = XMLwork.SubString2(XMLwork.IndexOf";
Debug.ShouldStop(16777216);
_pesoatual = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota2>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota2>"))))));Debug.locals.put("PesoAtual", _pesoatual);
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 1435;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
Debug.ShouldStop(67108864);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryUPDATE unilever_pi.pesagemreceita SET PesoRota2="),(RemoteObject.solve(new RemoteObject[] {parent._embfechada,_pesoatual}, "+",1, 0)),RemoteObject.createImmutable(" WHERE IdCampanha="),parent.mostCurrent._campanha,RemoteObject.createImmutable(" AND CodigoMaterial="),parent.mostCurrent._cod,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1436;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(134217728);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1437;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(268435456);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1438;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonembalagem_click"), (parent._job1));
this.state = 32;
return;
case 32:
//C
this.state = 8;
;
 BA.debugLineNum = 1439;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(1073741824);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1440;BA.debugLine="If XMLwork=\"1\" Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 8:
//if
this.state = 27;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("1"))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 1441;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
Debug.ShouldStop(1);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idCampanha, idPesagemProg, DataHora, Usuario, IdProcesso, Impresso, row_number() OVER (order by idCampanha) as row_num FROM unilever_pi.campanha WHERE idPesagemProg="),parent.mostCurrent._idpesagemprog,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1442;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
Debug.ShouldStop(2);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1443;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(4);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1444;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonembalagem_click"), (parent._job1));
this.state = 33;
return;
case 33:
//C
this.state = 11;
;
 BA.debugLineNum = 1445;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(16);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1446;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(32);
if (true) break;

case 11:
//if
this.state = 26;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 1447;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(64);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1448;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(";
Debug.ShouldStop(128);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1449;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Inde";
Debug.ShouldStop(256);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 1450;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(512);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1451;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(1024);
if (true) break;

case 14:
//for
this.state = 25;
step27 = 1;
limit27 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 34;
if (true) break;

case 34:
//C
this.state = 25;
if ((step27 > 0 && parent._i.<Integer>get().intValue() <= limit27) || (step27 < 0 && parent._i.<Integer>get().intValue() >= limit27)) this.state = 16;
if (true) break;

case 35:
//C
this.state = 34;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step27)) ;
if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 1452;BA.debugLine="If i=1 Then";
Debug.ShouldStop(2048);
if (true) break;

case 17:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, 1))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 1453;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuery";
Debug.ShouldStop(4096);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1454;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(8192);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1455;BA.debugLine="Job1.GetRequest.SetContentType(\"application/";
Debug.ShouldStop(16384);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1456;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonembalagem_click"), (parent._job1));
this.state = 36;
return;
case 36:
//C
this.state = 20;
;
 BA.debugLineNum = 1457;BA.debugLine="Dim XMLwork3 As String = Job1.GetString";
Debug.ShouldStop(65536);
_xmlwork3 = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLwork3", _xmlwork3);Debug.locals.put("XMLwork3", _xmlwork3);
 BA.debugLineNum = 1458;BA.debugLine="Dim count2 As Int = XMLwork3.SubString2(XMLw";
Debug.ShouldStop(131072);
_count2 = BA.numberCast(int.class, _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));Debug.locals.put("count2", _count2);Debug.locals.put("count2", _count2);
 BA.debugLineNum = 1459;BA.debugLine="Dim XMLCurrent2 As String = XMLwork3.SubStri";
Debug.ShouldStop(262144);
_xmlcurrent2 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XMLCurrent2", _xmlcurrent2);Debug.locals.put("XMLCurrent2", _xmlcurrent2);
 BA.debugLineNum = 1460;BA.debugLine="Campanha =  XMLCurrent.SubString2(XMLCurrent";
Debug.ShouldStop(524288);
parent.mostCurrent._campanha = parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>")))));
 BA.debugLineNum = 1461;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(1048576);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1462;BA.debugLine="ListProdutosPesagem.Clear";
Debug.ShouldStop(2097152);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1463;BA.debugLine="For x=1 To count2-1";
Debug.ShouldStop(4194304);
if (true) break;

case 20:
//for
this.state = 23;
step39 = 1;
limit39 = RemoteObject.solve(new RemoteObject[] {_count2,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_x = 1 ;
Debug.locals.put("x", _x);
this.state = 37;
if (true) break;

case 37:
//C
this.state = 23;
if ((step39 > 0 && _x <= limit39) || (step39 < 0 && _x >= limit39)) this.state = 22;
if (true) break;

case 38:
//C
this.state = 37;
_x = ((int)(0 + _x + step39)) ;
Debug.locals.put("x", _x);
if (true) break;

case 22:
//C
this.state = 38;
 BA.debugLineNum = 1464;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent2.SubStri";
Debug.ShouldStop(8388608);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Add",(Object)((_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1465;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurren";
Debug.ShouldStop(16777216);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoMaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoMaterial>"))))).runMethod(true,"trim"),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Peso>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Peso>"))))),RemoteObject.createImmutable(" "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<EmbFechada>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</EmbFechada>"))))),RemoteObject.createImmutable(" "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" ("),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<UnidadeEmb>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</UnidadeEmb>"))))),RemoteObject.createImmutable(") | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota1>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota1>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota2>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota2>")))))))),(Object)((_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1466;BA.debugLine="XMLwork3 = XMLwork3.SubString(XMLwork3.Inde";
Debug.ShouldStop(33554432);
_xmlwork3 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));Debug.locals.put("XMLwork3", _xmlwork3);
 BA.debugLineNum = 1467;BA.debugLine="XMLCurrent2 =  XMLwork3.SubString2(XMLwork3";
Debug.ShouldStop(67108864);
_xmlcurrent2 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XMLCurrent2", _xmlcurrent2);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 24;
Debug.locals.put("x", _x);
;
 if (true) break;

case 24:
//C
this.state = 35;
;
 BA.debugLineNum = 1470;BA.debugLine="ListViewCampanha.AddSingleLine2(XMLCurrent.Su";
Debug.ShouldStop(536870912);
parent.mostCurrent._listviewcampanha.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))))),(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))))));
 BA.debugLineNum = 1471;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"";
Debug.ShouldStop(1073741824);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1472;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Inde";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 25:
//C
this.state = 26;
;
 if (true) break;

case 26:
//C
this.state = 27;
;
 if (true) break;

case 27:
//C
this.state = 30;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 29:
//C
this.state = 30;
this.catchState = 0;
 BA.debugLineNum = 1477;BA.debugLine="MsgboxAsync(\"Erro ao adicionar Embalagem Fechada";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao adicionar Embalagem Fechada")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 30:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1479;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
public static void  _buttongravardb_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonGravarDB_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1128);
if (RapidSub.canDelegate("buttongravardb_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttongravardb_click"); return;}
ResumableSub_ButtonGravarDB_Click rsub = new ResumableSub_ButtonGravarDB_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonGravarDB_Click extends BA.ResumableSub {
public ResumableSub_ButtonGravarDB_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
int step26;
int limit26;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonGravarDB_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1128);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 1129;BA.debugLine="Try";
Debug.ShouldStop(256);
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
 BA.debugLineNum = 1130;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(512);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="),parent._positiondb2,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1131;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1024);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1132;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(2048);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1133;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravardb_click"), (parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 4;
;
 BA.debugLineNum = 1134;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(8192);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1135;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryINSE";
Debug.ShouldStop(16384);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryINSERT INTO unilever_pi.balancas (balanca, tipopeso, tipocom, ipbalanca, portabalanca, divisor, decimais) VALUES ('"),parent.mostCurrent._edittextnomebalanca.runMethod(true,"getText"),RemoteObject.createImmutable("','"),parent.mostCurrent._listposition,RemoteObject.createImmutable("','rede','"),parent.mostCurrent._edittextip.runMethod(true,"getText"),RemoteObject.createImmutable("',"),parent.mostCurrent._edittextporta.runMethod(true,"getText"),RemoteObject.createImmutable(","),parent.mostCurrent._edittextdivisor.runMethod(true,"getText"),RemoteObject.createImmutable(", "),parent.mostCurrent._edittextdecimais.runMethod(true,"getText"),RemoteObject.createImmutable(")"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1136;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(32768);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1137;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(65536);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1138;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravardb_click"), (parent._job1));
this.state = 18;
return;
case 18:
//C
this.state = 4;
;
 BA.debugLineNum = 1139;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(262144);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1140;BA.debugLine="ListViewTelaBalanca.Clear";
Debug.ShouldStop(524288);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("Clear");
 BA.debugLineNum = 1141;BA.debugLine="ListViewBalanca.Clear";
Debug.ShouldStop(1048576);
parent.mostCurrent._listviewbalanca.runVoidMethod ("Clear");
 BA.debugLineNum = 1142;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(2097152);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1143;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(4194304);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1144;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(8388608);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1145;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravardb_click"), (parent._job1));
this.state = 19;
return;
case 19:
//C
this.state = 4;
;
 BA.debugLineNum = 1146;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(33554432);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1147;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(67108864);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1148;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(134217728);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1149;BA.debugLine="XMLCurrent = XMLwork.SubString2(XMLwork.IndexOf(";
Debug.ShouldStop(268435456);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 1150;BA.debugLine="If count=1 Then";
Debug.ShouldStop(536870912);
if (true) break;

case 4:
//if
this.state = 13;
if (RemoteObject.solveBoolean("=",parent._count,BA.numberCast(double.class, 1))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 BA.debugLineNum = 1151;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLwo";
Debug.ShouldStop(1073741824);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1152;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&X";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1154;BA.debugLine="For i=1 To count";
Debug.ShouldStop(2);
if (true) break;

case 9:
//for
this.state = 12;
step26 = 1;
limit26 = parent._count.<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 12;
if ((step26 > 0 && parent._i.<Integer>get().intValue() <= limit26) || (step26 < 0 && parent._i.<Integer>get().intValue() >= limit26)) this.state = 11;
if (true) break;

case 21:
//C
this.state = 20;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step26)) ;
if (true) break;

case 11:
//C
this.state = 21;
 BA.debugLineNum = 1155;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubString";
Debug.ShouldStop(4);
parent.mostCurrent._listviewbalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1156;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.SubS";
Debug.ShouldStop(8);
parent.mostCurrent._listviewtelabalanca.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<balanca>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</balanca>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")")))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))))));
 BA.debugLineNum = 1157;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
Debug.ShouldStop(16);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1158;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.IndexO";
Debug.ShouldStop(32);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 12:
//C
this.state = 13;
;
 if (true) break;

case 13:
//C
this.state = 16;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 1162;BA.debugLine="count =  count";
Debug.ShouldStop(512);
parent._count = parent._count;
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1164;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
public static void  _buttongravarproduto_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonGravarProduto_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,857);
if (RapidSub.canDelegate("buttongravarproduto_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttongravarproduto_click"); return;}
ResumableSub_ButtonGravarProduto_Click rsub = new ResumableSub_ButtonGravarProduto_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonGravarProduto_Click extends BA.ResumableSub {
public ResumableSub_ButtonGravarProduto_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
int step19;
int limit19;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonGravarProduto_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,857);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 858;BA.debugLine="Try";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//try
this.state = 14;
this.catchState = 13;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 13;
 BA.debugLineNum = 859;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryINSE";
Debug.ShouldStop(67108864);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryINSERT INTO unilever_pi.produtosCUC (codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico) VALUES("),parent.mostCurrent._edittextcodigocuc.runMethod(true,"getText"),RemoteObject.createImmutable(",'"),parent.mostCurrent._edittextnomeproduto.runMethod(true,"getText"),RemoteObject.createImmutable("',"),parent.mostCurrent._edittextcodigoproduto.runMethod(true,"getText"),RemoteObject.createImmutable(",'"),parent.mostCurrent._edittextnomeproduto.runMethod(true,"getText"),RemoteObject.createImmutable("',10,'KG',0,20,'Sacaria','334.31',4,0,0);"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 860;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(134217728);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 861;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(268435456);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 862;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravarproduto_click"), (parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 BA.debugLineNum = 863;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(1073741824);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 864;BA.debugLine="If XMLwork = \"0\" Or XMLwork = \"2\" Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("0")) || RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("2"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 865;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ai gravar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 867;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(4);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico, row_number=83113;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 868;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(8);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 869;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(16);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 870;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravarproduto_click"), (parent._job1));
this.state = 16;
return;
case 16:
//C
this.state = 8;
;
 BA.debugLineNum = 871;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(64);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 872;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(128);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 873;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(256);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 874;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
Debug.ShouldStop(512);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 875;BA.debugLine="ListViewProdutosCUC.Clear";
Debug.ShouldStop(1024);
parent.mostCurrent._listviewprodutoscuc.runVoidMethod ("Clear");
 BA.debugLineNum = 876;BA.debugLine="For i=0 To count-1";
Debug.ShouldStop(2048);
if (true) break;

case 8:
//for
this.state = 11;
step19 = 1;
limit19 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 0) ;
this.state = 17;
if (true) break;

case 17:
//C
this.state = 11;
if ((step19 > 0 && parent._i.<Integer>get().intValue() <= limit19) || (step19 < 0 && parent._i.<Integer>get().intValue() >= limit19)) this.state = 10;
if (true) break;

case 18:
//C
this.state = 17;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step19)) ;
if (true) break;

case 10:
//C
this.state = 18;
 BA.debugLineNum = 877;BA.debugLine="ListViewProdutosCUC.AddSingleLine2(XMLCurrent.S";
Debug.ShouldStop(4096);
parent.mostCurrent._listviewprodutoscuc.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaomaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaomaterial>")))))))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigomaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigomaterial>"))))))));
 BA.debugLineNum = 878;BA.debugLine="EditTextPordutoCUC.Text = XMLCurrent.SubString2";
Debug.ShouldStop(8192);
parent.mostCurrent._edittextpordutocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaoCUC>")))))));
 BA.debugLineNum = 879;BA.debugLine="EditTextCodigoCuc.Text = XMLCurrent.SubString2(";
Debug.ShouldStop(16384);
parent.mostCurrent._edittextcodigocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>")))))));
 BA.debugLineNum = 880;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
Debug.ShouldStop(32768);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 881;BA.debugLine="XMLCurrent =  XMLwork.SubString2(5,XMLwork.Inde";
Debug.ShouldStop(65536);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 if (true) break;
if (true) break;

case 11:
//C
this.state = 14;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 BA.debugLineNum = 884;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ai gravar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 886;BA.debugLine="End Sub";
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
public static void  _buttongravaruusario_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonGravarUusario_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,600);
if (RapidSub.canDelegate("buttongravaruusario_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttongravaruusario_click"); return;}
ResumableSub_ButtonGravarUusario_Click rsub = new ResumableSub_ButtonGravarUusario_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonGravarUusario_Click extends BA.ResumableSub {
public ResumableSub_ButtonGravarUusario_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _retu = RemoteObject.createImmutable("");
RemoteObject _usercurrent = RemoteObject.createImmutable("");
RemoteObject _cnt = RemoteObject.createImmutable(0);
RemoteObject _usermain = RemoteObject.createImmutable("");
int step20;
int limit20;
int step29;
int limit29;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonGravarUusario_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,600);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 601;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryINSER";
Debug.ShouldStop(16777216);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryINSERT INTO unilever_pi.usuarios (usuario, nivel, pesagem, processo, relatorio) VALUES ('"),parent.mostCurrent._edittextnomeusuario.runMethod(true,"getText"),RemoteObject.createImmutable("',"),parent._positionnivel,RemoteObject.createImmutable(",1,1,1);"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 602;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(33554432);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 603;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
Debug.ShouldStop(67108864);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 604;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravaruusario_click"), (parent._job1));
this.state = 27;
return;
case 27:
//C
this.state = 1;
;
 BA.debugLineNum = 605;BA.debugLine="Dim ret As String  = Job1.GetString";
Debug.ShouldStop(268435456);
_ret = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 606;BA.debugLine="If ret = \"0\" Then";
Debug.ShouldStop(536870912);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("0"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 607;BA.debugLine="MsgboxAsync(\"Falha ao gravar\",\"Erro\")";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Falha ao gravar")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 609;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
Debug.ShouldStop(1);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ListaUsuarios"))));
 BA.debugLineNum = 610;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttongravaruusario_click"), (parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 5;
;
 BA.debugLineNum = 611;BA.debugLine="Dim retu As String = Job1.GetString";
Debug.ShouldStop(4);
_retu = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("retu", _retu);Debug.locals.put("retu", _retu);
 BA.debugLineNum = 612;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
Debug.ShouldStop(8);
_ret = _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<return>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</return>")))));Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 613;BA.debugLine="Dim usercurrent As String = \"\"";
Debug.ShouldStop(16);
_usercurrent = BA.ObjectToString("");Debug.locals.put("usercurrent", _usercurrent);Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 614;BA.debugLine="Dim count As Int = ListViewUsuarios.Size";
Debug.ShouldStop(32);
parent._count = parent.mostCurrent._listviewusuarios.runMethod(true,"getSize");
 BA.debugLineNum = 615;BA.debugLine="ListViewUsuarios.Clear";
Debug.ShouldStop(64);
parent.mostCurrent._listviewusuarios.runVoidMethod ("Clear");
 BA.debugLineNum = 616;BA.debugLine="If ret = \"1\"  Then";
Debug.ShouldStop(128);
if (true) break;

case 5:
//if
this.state = 26;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("1"))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 617;BA.debugLine="Dim cnt As Int = retu.SubString2(retu.IndexOf(\"<";
Debug.ShouldStop(256);
_cnt = BA.numberCast(int.class, _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<count>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</count>"))))));Debug.locals.put("cnt", _cnt);Debug.locals.put("cnt", _cnt);
 BA.debugLineNum = 618;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
Debug.ShouldStop(512);
_usermain = _retu.runMethod(true,"substring",(Object)(_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</usuario>")))));Debug.locals.put("usermain", _usermain);Debug.locals.put("usermain", _usermain);
 BA.debugLineNum = 619;BA.debugLine="Try";
Debug.ShouldStop(1024);
if (true) break;

case 8:
//try
this.state = 25;
this.catchState = 24;
this.state = 10;
if (true) break;

case 10:
//C
this.state = 11;
this.catchState = 24;
 BA.debugLineNum = 620;BA.debugLine="For i=0 To cnt-1";
Debug.ShouldStop(2048);
if (true) break;

case 11:
//for
this.state = 22;
step20 = 1;
limit20 = RemoteObject.solve(new RemoteObject[] {_cnt,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 22;
if ((step20 > 0 && parent._i.<Integer>get().intValue() <= limit20) || (step20 < 0 && parent._i.<Integer>get().intValue() >= limit20)) this.state = 13;
if (true) break;

case 30:
//C
this.state = 29;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step20)) ;
if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 621;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
Debug.ShouldStop(4096);
_usercurrent = _usermain.runMethod(true,"substring",(Object)(_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 622;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
Debug.ShouldStop(8192);
_usercurrent = _usercurrent.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 623;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
Debug.ShouldStop(16384);
parent.mostCurrent._listviewusuarios.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>"))))))),(Object)((_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))))));
 BA.debugLineNum = 624;BA.debugLine="If i = PositionUser Then";
Debug.ShouldStop(32768);
if (true) break;

case 14:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, parent._positionuser))) { 
this.state = 16;
}if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 625;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
Debug.ShouldStop(65536);
parent.mostCurrent._edittextnomeusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>")))))));
 BA.debugLineNum = 626;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
Debug.ShouldStop(131072);
parent._positionnivel = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>"))))));
 BA.debugLineNum = 627;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
Debug.ShouldStop(262144);
parent._idusuario = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))));
 BA.debugLineNum = 628;BA.debugLine="ListViewAcesso.Clear";
Debug.ShouldStop(524288);
parent.mostCurrent._listviewacesso.runVoidMethod ("Clear");
 BA.debugLineNum = 629;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(1048576);
if (true) break;

case 17:
//for
this.state = 20;
step29 = 1;
limit29 = 4;
parent._i = BA.numberCast(int.class, 0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 20;
if ((step29 > 0 && parent._i.<Integer>get().intValue() <= limit29) || (step29 < 0 && parent._i.<Integer>get().intValue() >= limit29)) this.state = 19;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step29)) ;
if (true) break;

case 19:
//C
this.state = 32;
 BA.debugLineNum = 630;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
Debug.ShouldStop(2097152);
parent.mostCurrent._listviewacesso.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent._i)),(Object)((parent._i)));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 BA.debugLineNum = 632;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(8388608);
parent.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(parent._positionnivel));
 if (true) break;

case 21:
//C
this.state = 30;
;
 BA.debugLineNum = 634;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
Debug.ShouldStop(33554432);
_usermain = _usermain.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usermain", _usermain);
 if (true) break;
if (true) break;

case 22:
//C
this.state = 25;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 24:
//C
this.state = 25;
this.catchState = 0;
 BA.debugLineNum = 637;BA.debugLine="MsgboxAsync(\"Erro ao Alterar\",\"Erro\")";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao Alterar")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
;
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 640;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
public static RemoteObject  _buttonleiturabarcode_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonLeituraBarcode_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1044);
if (RapidSub.canDelegate("buttonleiturabarcode_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonleiturabarcode_click");}
 BA.debugLineNum = 1044;BA.debugLine="Sub ButtonLeituraBarcode_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 1045;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
Debug.ShouldStop(1048576);
main.mostCurrent._myabbarcode.runVoidMethod ("ABGetBarcode",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("myabbarcode")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1046;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonllimpar_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonlLimpar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,434);
if (RapidSub.canDelegate("buttonllimpar_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonllimpar_click");}
 BA.debugLineNum = 434;BA.debugLine="Sub ButtonlLimpar_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 435;BA.debugLine="EditTextUser.Text =  \"\"";
Debug.ShouldStop(262144);
main.mostCurrent._edittextuser.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 436;BA.debugLine="EditTextPassword.Text = \"\"";
Debug.ShouldStop(524288);
main.mostCurrent._edittextpassword.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 437;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("ButtonLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,390);
if (RapidSub.canDelegate("buttonlogin_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonlogin_click");}
 BA.debugLineNum = 390;BA.debugLine="Sub ButtonLogin_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 391;BA.debugLine="panelLogin.Visible = True";
Debug.ShouldStop(64);
main.mostCurrent._panellogin.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 392;BA.debugLine="panelMain.Visible =  False";
Debug.ShouldStop(128);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 393;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonmenu_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonMenu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,444);
if (RapidSub.canDelegate("buttonmenu_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonmenu_click");}
 BA.debugLineNum = 444;BA.debugLine="Sub ButtonMenu_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 445;BA.debugLine="panelMenu.Visible =  True";
Debug.ShouldStop(268435456);
main.mostCurrent._panelmenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 446;BA.debugLine="panelMain.Visible =  False";
Debug.ShouldStop(536870912);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 447;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonmenucuc_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonMenuCUC_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,935);
if (RapidSub.canDelegate("buttonmenucuc_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonmenucuc_click");}
 BA.debugLineNum = 935;BA.debugLine="Sub ButtonMenuCUC_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 936;BA.debugLine="panelMenu.Visible = True";
Debug.ShouldStop(128);
main.mostCurrent._panelmenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 937;BA.debugLine="SelecionaCUC.Visible = False";
Debug.ShouldStop(256);
main.mostCurrent._selecionacuc.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 938;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonniveldown_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonNivelDown_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,587);
if (RapidSub.canDelegate("buttonniveldown_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonniveldown_click");}
 BA.debugLineNum = 587;BA.debugLine="Sub ButtonNivelDown_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 588;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 589;BA.debugLine="If PositionNivel <= ListViewAcesso.Size-1 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("k",main._positionnivel,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._listviewacesso.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 590;BA.debugLine="PositionNivel =  PositionNivel+1";
Debug.ShouldStop(8192);
main._positionnivel = RemoteObject.solve(new RemoteObject[] {main._positionnivel,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 591;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(16384);
main.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(main._positionnivel));
 }else 
{ BA.debugLineNum = 592;BA.debugLine="Else if PositionNivel=1 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main._positionnivel,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 593;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(65536);
main.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(main._positionnivel));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e9.toString()); BA.debugLineNum = 596;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao mudar a posição.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 };
 BA.debugLineNum = 598;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonnivelup_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonNivelUp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,570);
if (RapidSub.canDelegate("buttonnivelup_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonnivelup_click");}
 BA.debugLineNum = 570;BA.debugLine="Sub ButtonNivelUp_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 571;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 572;BA.debugLine="If PositionNivel >= ListViewAcesso.Size-1 Or Pos";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",main._positionnivel,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._listviewacesso.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))) || RemoteObject.solveBoolean("k",main._positionnivel,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._listviewacesso.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 573;BA.debugLine="PositionNivel =  PositionNivel-1";
Debug.ShouldStop(268435456);
main._positionnivel = RemoteObject.solve(new RemoteObject[] {main._positionnivel,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 574;BA.debugLine="If PositionNivel=0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main._positionnivel,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 575;BA.debugLine="PositionNivel = 1";
Debug.ShouldStop(1073741824);
main._positionnivel = BA.numberCast(int.class, 1);
 BA.debugLineNum = 576;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(main._positionnivel));
 };
 BA.debugLineNum = 578;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(2);
main.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(main._positionnivel));
 }else 
{ BA.debugLineNum = 579;BA.debugLine="Else if PositionNivel=1 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main._positionnivel,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 580;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(8);
main.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(main._positionnivel));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e13) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e13.toString()); BA.debugLineNum = 583;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao mudar a posição.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 };
 BA.debugLineNum = 585;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _buttonprodutoalterar_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonProdutoAlterar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,888);
if (RapidSub.canDelegate("buttonprodutoalterar_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonprodutoalterar_click"); return;}
ResumableSub_ButtonProdutoAlterar_Click rsub = new ResumableSub_ButtonProdutoAlterar_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonProdutoAlterar_Click extends BA.ResumableSub {
public ResumableSub_ButtonProdutoAlterar_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
int step19;
int limit19;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonProdutoAlterar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,888);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 889;BA.debugLine="Try";
Debug.ShouldStop(16777216);
if (true) break;

case 1:
//try
this.state = 14;
this.catchState = 13;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 13;
 BA.debugLineNum = 890;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
Debug.ShouldStop(33554432);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQueryUPDATE unilever_pi.produtosCUC SET (codigoCUC=83113, descricaoCUC='"),parent.mostCurrent._edittextnomeproduto.runMethod(true,"getText"),RemoteObject.createImmutable("', codigomaterial="),parent.mostCurrent._edittextcodigoproduto.runMethod(true,"getText"),RemoteObject.createImmutable(", descricaomaterial='"),parent.mostCurrent._edittextnomeproduto.runMethod(true,"getText"),RemoteObject.createImmutable("', quant=10, unidade='KG', obrigatorio=0, embfechada=20, faseprod=1, unidadeemb='Sacaria', batch='334.31', rota=4, numeromix=0, alergenico=0);"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 891;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(67108864);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 892;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(134217728);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 893;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonprodutoalterar_click"), (parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 BA.debugLineNum = 894;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(536870912);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 895;BA.debugLine="If XMLwork = \"0\" Or XMLwork = \"2\" Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("0")) || RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("2"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 896;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ai gravar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 898;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(2);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico, row_number=83113;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 899;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(4);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 900;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(8);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 901;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonprodutoalterar_click"), (parent._job1));
this.state = 16;
return;
case 16:
//C
this.state = 8;
;
 BA.debugLineNum = 902;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(32);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 903;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
Debug.ShouldStop(64);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 904;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(128);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 905;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
Debug.ShouldStop(256);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 906;BA.debugLine="ListViewProdutosCUC.Clear";
Debug.ShouldStop(512);
parent.mostCurrent._listviewprodutoscuc.runVoidMethod ("Clear");
 BA.debugLineNum = 907;BA.debugLine="For i=0 To count-1";
Debug.ShouldStop(1024);
if (true) break;

case 8:
//for
this.state = 11;
step19 = 1;
limit19 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 0) ;
this.state = 17;
if (true) break;

case 17:
//C
this.state = 11;
if ((step19 > 0 && parent._i.<Integer>get().intValue() <= limit19) || (step19 < 0 && parent._i.<Integer>get().intValue() >= limit19)) this.state = 10;
if (true) break;

case 18:
//C
this.state = 17;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step19)) ;
if (true) break;

case 10:
//C
this.state = 18;
 BA.debugLineNum = 908;BA.debugLine="ListViewProdutosCUC.AddSingleLine2(XMLCurrent.S";
Debug.ShouldStop(2048);
parent.mostCurrent._listviewprodutoscuc.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaomaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaomaterial>")))))))),(Object)((parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigomaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigomaterial>"))))))));
 BA.debugLineNum = 909;BA.debugLine="EditTextPordutoCUC.Text = XMLCurrent.SubString2";
Debug.ShouldStop(4096);
parent.mostCurrent._edittextpordutocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaoCUC>")))))));
 BA.debugLineNum = 910;BA.debugLine="EditTextCodigoCuc.Text = XMLCurrent.SubString2(";
Debug.ShouldStop(8192);
parent.mostCurrent._edittextcodigocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>")))))));
 BA.debugLineNum = 911;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
Debug.ShouldStop(16384);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 912;BA.debugLine="XMLCurrent =  XMLwork.SubString2(5,XMLwork.Inde";
Debug.ShouldStop(32768);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 if (true) break;
if (true) break;

case 11:
//C
this.state = 14;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 BA.debugLineNum = 915;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
Debug.ShouldStop(262144);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ai gravar.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 917;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
public static RemoteObject  _buttonprodutosvolta_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonProdutosVolta_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,940);
if (RapidSub.canDelegate("buttonprodutosvolta_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonprodutosvolta_click");}
 BA.debugLineNum = 940;BA.debugLine="Sub ButtonProdutosVolta_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 941;BA.debugLine="panelProdutos.Visible =  False";
Debug.ShouldStop(4096);
main.mostCurrent._panelprodutos.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 942;BA.debugLine="SelecionaCUC.Visible =  True";
Debug.ShouldStop(8192);
main.mostCurrent._selecionacuc.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 943;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonreset_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonReset_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,464);
if (RapidSub.canDelegate("buttonreset_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonreset_click");}
 BA.debugLineNum = 464;BA.debugLine="Sub ButtonReset_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 465;BA.debugLine="MsgboxAsync(\"Reset\",\"\")";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Reset")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable(""))),main.processBA);
 BA.debugLineNum = 466;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonsair_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonSair_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,371);
if (RapidSub.canDelegate("buttonsair_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonsair_click");}
RemoteObject _answ = RemoteObject.createImmutable(0);
RemoteObject _msgyes = RemoteObject.createImmutable("");
RemoteObject _msgno = RemoteObject.createImmutable("");
 BA.debugLineNum = 371;BA.debugLine="Sub ButtonSair_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="Dim Answ As Int";
Debug.ShouldStop(524288);
_answ = RemoteObject.createImmutable(0);Debug.locals.put("Answ", _answ);
 BA.debugLineNum = 373;BA.debugLine="Dim msgYes As String = \"Sim\"";
Debug.ShouldStop(1048576);
_msgyes = BA.ObjectToString("Sim");Debug.locals.put("msgYes", _msgyes);Debug.locals.put("msgYes", _msgyes);
 BA.debugLineNum = 374;BA.debugLine="Dim msgNo As String = \"Não\"";
Debug.ShouldStop(2097152);
_msgno = BA.ObjectToString("Não");Debug.locals.put("msgNo", _msgno);Debug.locals.put("msgNo", _msgno);
 BA.debugLineNum = 375;BA.debugLine="Answ= Msgbox2(\"\",\"Tem certeza que deseja sair?\",m";
Debug.ShouldStop(4194304);
_answ = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToCharSequence("Tem certeza que deseja sair?")),(Object)(_msgyes),(Object)(BA.ObjectToString("")),(Object)(_msgno),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("Answ", _answ);
 BA.debugLineNum = 376;BA.debugLine="If Answ=DialogResponse.POSITIVE Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_answ,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 377;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 379;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonsairpeso_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonSairPeso_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,459);
if (RapidSub.canDelegate("buttonsairpeso_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonsairpeso_click");}
 BA.debugLineNum = 459;BA.debugLine="Sub ButtonSairPeso_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 460;BA.debugLine="panelPesagem.Visible =  False";
Debug.ShouldStop(2048);
main.mostCurrent._panelpesagem.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 461;BA.debugLine="panelMain.Visible =  True";
Debug.ShouldStop(4096);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 462;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttontelaleitura_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonTelaLeitura_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,454);
if (RapidSub.canDelegate("buttontelaleitura_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttontelaleitura_click");}
 BA.debugLineNum = 454;BA.debugLine="Sub ButtonTelaLeitura_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 455;BA.debugLine="DisableStrictMode";
Debug.ShouldStop(64);
_disablestrictmode();
 BA.debugLineNum = 456;BA.debugLine="CallSubDelayed(Me,\"Connect\")";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("Connect")));
 BA.debugLineNum = 457;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _buttontelalogin_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonTelaLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,397);
if (RapidSub.canDelegate("buttontelalogin_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttontelalogin_click"); return;}
ResumableSub_ButtonTelaLogin_Click rsub = new ResumableSub_ButtonTelaLogin_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonTelaLogin_Click extends BA.ResumableSub {
public ResumableSub_ButtonTelaLogin_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _ret = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonTelaLogin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,397);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 398;BA.debugLine="Try";
Debug.ShouldStop(8192);
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
 BA.debugLineNum = 399;BA.debugLine="If EditTextUser.Text = \"myDB\" Then";
Debug.ShouldStop(16384);
if (true) break;

case 4:
//if
this.state = 19;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._edittextuser.runMethod(true,"getText"),BA.ObjectToString("myDB"))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 19;
 BA.debugLineNum = 400;BA.debugLine="ButtonWebservice.Enabled =  True";
Debug.ShouldStop(32768);
parent.mostCurrent._buttonwebservice.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 401;BA.debugLine="panelMain.Visible =  True";
Debug.ShouldStop(65536);
parent.mostCurrent._panelmain.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 402;BA.debugLine="panelLogin.Visible = False";
Debug.ShouldStop(131072);
parent.mostCurrent._panellogin.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 404;BA.debugLine="Dim url As String =  URLglobal & \"/Login\"&EditT";
Debug.ShouldStop(524288);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/Login"),parent.mostCurrent._edittextuser.runMethod(true,"getText"),RemoteObject.createImmutable("-"),parent.mostCurrent._edittextpassword.runMethod(true,"getText"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 405;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 406;BA.debugLine="Job1.GetRequest.SetContentType(\"application/jso";
Debug.ShouldStop(2097152);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 407;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttontelalogin_click"), (parent._job1));
this.state = 23;
return;
case 23:
//C
this.state = 9;
;
 BA.debugLineNum = 408;BA.debugLine="Dim ret As String  = Job1.GetString";
Debug.ShouldStop(8388608);
_ret = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 409;BA.debugLine="Job1.Release";
Debug.ShouldStop(16777216);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 410;BA.debugLine="If ret.SubString2(ret.IndexOf(\"<Resultado>\")+11";
Debug.ShouldStop(33554432);
if (true) break;

case 9:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",_ret.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ret.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Resultado>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_ret.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Resultado>"))))),BA.ObjectToString("1"))) { 
this.state = 11;
}else {
this.state = 17;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 411;BA.debugLine="panelMain.Visible =  True";
Debug.ShouldStop(67108864);
parent.mostCurrent._panelmain.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 412;BA.debugLine="panelLogin.Visible = False";
Debug.ShouldStop(134217728);
parent.mostCurrent._panellogin.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 413;BA.debugLine="Usertext.Text =  EditTextUser.Text";
Debug.ShouldStop(268435456);
parent.mostCurrent._usertext.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._edittextuser.runMethod(true,"getText")));
 BA.debugLineNum = 414;BA.debugLine="NivelUsuario  = ret.SubString2(ret.IndexOf(\"<ni";
Debug.ShouldStop(536870912);
parent.mostCurrent._nivelusuario = _ret.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ret.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_ret.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>")))));
 BA.debugLineNum = 415;BA.debugLine="EditTextUser.Text = \"\"";
Debug.ShouldStop(1073741824);
parent.mostCurrent._edittextuser.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 416;BA.debugLine="EditTextPassword.Text =  \"\"";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._edittextpassword.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 417;BA.debugLine="If NivelUsuario =  4 Then";
Debug.ShouldStop(1);
if (true) break;

case 12:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._nivelusuario,BA.NumberToString(4))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 418;BA.debugLine="ButtonCadastraBalnca.Enabled =  True";
Debug.ShouldStop(2);
parent.mostCurrent._buttoncadastrabalnca.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 419;BA.debugLine="ButtonUsuarios.Enabled =  True";
Debug.ShouldStop(4);
parent.mostCurrent._buttonusuarios.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 420;BA.debugLine="ButtonMenu.Enabled = True";
Debug.ShouldStop(8);
parent.mostCurrent._buttonmenu.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 421;BA.debugLine="ButtonCadastroProduto.Enabled = True";
Debug.ShouldStop(16);
parent.mostCurrent._buttoncadastroproduto.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 422;BA.debugLine="ButtonWebservice.Enabled =  True";
Debug.ShouldStop(32);
parent.mostCurrent._buttonwebservice.runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 425;BA.debugLine="MsgboxAsync(\"Usuário ou senha invalido.\",\"Avis";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Usuário ou senha invalido.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;

case 18:
//C
this.state = 19;
;
 BA.debugLineNum = 427;BA.debugLine="Job1.Release";
Debug.ShouldStop(1024);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_release" /*RemoteObject*/ );
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
 BA.debugLineNum = 430;BA.debugLine="MsgboxAsync(\"Erro ao conectar, verifique sua con";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao conectar, verifique sua conexão.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;
if (true) break;

case 22:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 432;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static RemoteObject  _buttontelaloginvolta_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonTelaLoginVolta_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,385);
if (RapidSub.canDelegate("buttontelaloginvolta_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttontelaloginvolta_click");}
 BA.debugLineNum = 385;BA.debugLine="Sub ButtonTelaLoginVolta_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 386;BA.debugLine="panelLogin.Visible =  False";
Debug.ShouldStop(2);
main.mostCurrent._panellogin.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 387;BA.debugLine="panelMain.Visible = True";
Debug.ShouldStop(4);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 388;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttontelamain_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonTelaMain_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,449);
if (RapidSub.canDelegate("buttontelamain_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttontelamain_click");}
 BA.debugLineNum = 449;BA.debugLine="Sub ButtonTelaMain_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 450;BA.debugLine="panelMain.Visible =  True";
Debug.ShouldStop(2);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 451;BA.debugLine="panelConexao.Visible =  False";
Debug.ShouldStop(4);
main.mostCurrent._panelconexao.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 452;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttontelamenu_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonTelaMenu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,439);
if (RapidSub.canDelegate("buttontelamenu_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttontelamenu_click");}
 BA.debugLineNum = 439;BA.debugLine="Sub ButtonTelaMenu_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 440;BA.debugLine="panelMain.Visible =  True";
Debug.ShouldStop(8388608);
main.mostCurrent._panelmain.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 441;BA.debugLine="panelMenu.Visible =  False";
Debug.ShouldStop(16777216);
main.mostCurrent._panelmenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 442;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttontelawebservicemenu_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonTelawebserviceMenu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,827);
if (RapidSub.canDelegate("buttontelawebservicemenu_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttontelawebservicemenu_click");}
 BA.debugLineNum = 827;BA.debugLine="Sub ButtonTelawebserviceMenu_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 828;BA.debugLine="panelWebservice.Visible =  False";
Debug.ShouldStop(134217728);
main.mostCurrent._panelwebservice.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 829;BA.debugLine="panelMenu.Visible =  True";
Debug.ShouldStop(268435456);
main.mostCurrent._panelmenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 830;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _buttonuserdown_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonUserDown_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,541);
if (RapidSub.canDelegate("buttonuserdown_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonuserdown_click"); return;}
ResumableSub_ButtonUserDown_Click rsub = new ResumableSub_ButtonUserDown_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonUserDown_Click extends BA.ResumableSub {
public ResumableSub_ButtonUserDown_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
int step19;
int limit19;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonUserDown_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,541);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 542;BA.debugLine="Try";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 543;BA.debugLine="If PositionUser <= ListViewUsuarios.Size-1 Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("k",parent._positionuser,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewusuarios.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 544;BA.debugLine="PositionUser =  PositionUser+1";
Debug.ShouldStop(-2147483648);
parent._positionuser = RemoteObject.solve(new RemoteObject[] {parent._positionuser,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 545;BA.debugLine="PositionDB =  PositionUser+1";
Debug.ShouldStop(1);
parent._positiondb = RemoteObject.solve(new RemoteObject[] {parent._positionuser,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 546;BA.debugLine="ListViewUsuarios.SetSelection(PositionUser)";
Debug.ShouldStop(2);
parent.mostCurrent._listviewusuarios.runVoidMethod ("SetSelection",(Object)(parent._positionuser));
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 548;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(8);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idusuario, usuario, nivel, pesagem, processo, relatorio, row_number() OVER (order by idusuario) as row_num from unilever_pi.usuarios) t WHERE row_num="),parent._positiondb);Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 549;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(16);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 550;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(32);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 551;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonuserdown_click"), (parent._job1));
this.state = 21;
return;
case 21:
//C
this.state = 8;
;
 BA.debugLineNum = 552;BA.debugLine="XMLwork  = Job1.GetString";
Debug.ShouldStop(128);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 553;BA.debugLine="If XMLwork=\"<DocumentElement />\" Or XMLwork=\"0\"";
Debug.ShouldStop(256);
if (true) break;

case 8:
//if
this.state = 17;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("<DocumentElement />")) || RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork,BA.ObjectToString("0"))) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 17;
 if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 555;BA.debugLine="Dim XML As String = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(1024);
_xml = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XML", _xml);Debug.locals.put("XML", _xml);
 BA.debugLineNum = 556;BA.debugLine="EditTextNomeUsuario.Text = XML.SubString2(XML.I";
Debug.ShouldStop(2048);
parent.mostCurrent._edittextnomeusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_xml.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>")))))));
 BA.debugLineNum = 557;BA.debugLine="PositionNivel = XML.SubString2(XML.IndexOf(\"<ni";
Debug.ShouldStop(4096);
parent._positionnivel = BA.numberCast(int.class, _xml.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>"))))));
 BA.debugLineNum = 558;BA.debugLine="idusuario =  XML.SubString2(XML.IndexOf(\"<idusu";
Debug.ShouldStop(8192);
parent._idusuario = BA.numberCast(int.class, _xml.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))));
 BA.debugLineNum = 559;BA.debugLine="ListViewAcesso.Clear";
Debug.ShouldStop(16384);
parent.mostCurrent._listviewacesso.runVoidMethod ("Clear");
 BA.debugLineNum = 560;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(32768);
if (true) break;

case 13:
//for
this.state = 16;
step19 = 1;
limit19 = 4;
parent._i = BA.numberCast(int.class, 0) ;
this.state = 22;
if (true) break;

case 22:
//C
this.state = 16;
if ((step19 > 0 && parent._i.<Integer>get().intValue() <= limit19) || (step19 < 0 && parent._i.<Integer>get().intValue() >= limit19)) this.state = 15;
if (true) break;

case 23:
//C
this.state = 22;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step19)) ;
if (true) break;

case 15:
//C
this.state = 23;
 BA.debugLineNum = 561;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
Debug.ShouldStop(65536);
parent.mostCurrent._listviewacesso.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent._i)),(Object)((parent._i)));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
 BA.debugLineNum = 563;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(262144);
parent.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(parent._positionnivel));
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
 BA.debugLineNum = 566;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao mudar a posição.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 568;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
public static void  _buttonuserup_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonUserUp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,512);
if (RapidSub.canDelegate("buttonuserup_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonuserup_click"); return;}
ResumableSub_ButtonUserUp_Click rsub = new ResumableSub_ButtonUserUp_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonUserUp_Click extends BA.ResumableSub {
public ResumableSub_ButtonUserUp_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _xml = RemoteObject.createImmutable("");
int step20;
int limit20;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonUserUp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,512);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 513;BA.debugLine="Try";
Debug.ShouldStop(1);
if (true) break;

case 1:
//try
this.state = 16;
this.catchState = 15;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 15;
 BA.debugLineNum = 514;BA.debugLine="If PositionUser=0 Then";
Debug.ShouldStop(2);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",parent._positionuser,BA.numberCast(double.class, 0))) { 
this.state = 6;
}else 
{ BA.debugLineNum = 517;BA.debugLine="Else if PositionUser >= ListViewUsuarios.Size-1";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("g",parent._positionuser,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewusuarios.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))) || RemoteObject.solveBoolean("k",parent._positionuser,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._listviewusuarios.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
this.state = 8;
}}
if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 515;BA.debugLine="ListViewUsuarios.SetSelection(PositionUser)";
Debug.ShouldStop(4);
parent.mostCurrent._listviewusuarios.runVoidMethod ("SetSelection",(Object)(parent._positionuser));
 BA.debugLineNum = 516;BA.debugLine="PositionDB = 1";
Debug.ShouldStop(8);
parent._positiondb = BA.numberCast(int.class, 1);
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 518;BA.debugLine="PositionDB =  PositionUser";
Debug.ShouldStop(32);
parent._positiondb = parent._positionuser;
 BA.debugLineNum = 519;BA.debugLine="PositionUser =  PositionUser-1";
Debug.ShouldStop(64);
parent._positionuser = RemoteObject.solve(new RemoteObject[] {parent._positionuser,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 520;BA.debugLine="ListViewUsuarios.SetSelection(PositionUser)";
Debug.ShouldStop(128);
parent.mostCurrent._listviewusuarios.runVoidMethod ("SetSelection",(Object)(parent._positionuser));
 if (true) break;

case 9:
//C
this.state = 10;
;
 BA.debugLineNum = 522;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(512);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idusuario, usuario, nivel, pesagem, processo, relatorio, row_number() OVER (order by idusuario) as row_num from unilever_pi.usuarios) t WHERE row_num="),parent._positiondb);Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 523;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1024);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 524;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(2048);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 525;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonuserup_click"), (parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 10;
;
 BA.debugLineNum = 526;BA.debugLine="Dim ret As String  = Job1.GetString";
Debug.ShouldStop(8192);
_ret = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 527;BA.debugLine="Dim XML As String = ret.SubString2(ret.IndexOf(\"";
Debug.ShouldStop(16384);
_xml = _ret.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_ret.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_ret.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XML", _xml);Debug.locals.put("XML", _xml);
 BA.debugLineNum = 528;BA.debugLine="EditTextNomeUsuario.Text = XML.SubString2(XML.In";
Debug.ShouldStop(32768);
parent.mostCurrent._edittextnomeusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_xml.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>")))))));
 BA.debugLineNum = 529;BA.debugLine="PositionNivel = XML.SubString2(XML.IndexOf(\"<niv";
Debug.ShouldStop(65536);
parent._positionnivel = BA.numberCast(int.class, _xml.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>"))))));
 BA.debugLineNum = 530;BA.debugLine="idusuario =  XML.SubString2(XML.IndexOf(\"<idusua";
Debug.ShouldStop(131072);
parent._idusuario = BA.numberCast(int.class, _xml.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xml.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))));
 BA.debugLineNum = 531;BA.debugLine="ListViewAcesso.Clear";
Debug.ShouldStop(262144);
parent.mostCurrent._listviewacesso.runVoidMethod ("Clear");
 BA.debugLineNum = 532;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(524288);
if (true) break;

case 10:
//for
this.state = 13;
step20 = 1;
limit20 = 4;
parent._i = BA.numberCast(int.class, 0) ;
this.state = 18;
if (true) break;

case 18:
//C
this.state = 13;
if ((step20 > 0 && parent._i.<Integer>get().intValue() <= limit20) || (step20 < 0 && parent._i.<Integer>get().intValue() >= limit20)) this.state = 12;
if (true) break;

case 19:
//C
this.state = 18;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step20)) ;
if (true) break;

case 12:
//C
this.state = 19;
 BA.debugLineNum = 533;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
Debug.ShouldStop(1048576);
parent.mostCurrent._listviewacesso.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent._i)),(Object)((parent._i)));
 if (true) break;
if (true) break;

case 13:
//C
this.state = 16;
;
 BA.debugLineNum = 535;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(4194304);
parent.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(parent._positionnivel));
 Debug.CheckDeviceExceptions();
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 BA.debugLineNum = 537;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao mudar a posição.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 539;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
public static void  _buttonusuarios_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonUsuarios_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,475);
if (RapidSub.canDelegate("buttonusuarios_click")) { wrong.addition.main.remoteMe.runUserSub(false, "main","buttonusuarios_click"); return;}
ResumableSub_ButtonUsuarios_Click rsub = new ResumableSub_ButtonUsuarios_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ButtonUsuarios_Click extends BA.ResumableSub {
public ResumableSub_ButtonUsuarios_Click(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _retu = RemoteObject.createImmutable("");
RemoteObject _ret = RemoteObject.createImmutable("");
RemoteObject _usercurrent = RemoteObject.createImmutable("");
RemoteObject _cnt = RemoteObject.createImmutable(0);
RemoteObject _usermain = RemoteObject.createImmutable("");
int step11;
int limit11;
int step20;
int limit20;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ButtonUsuarios_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,475);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 476;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
Debug.ShouldStop(134217728);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ListaUsuarios"))));
 BA.debugLineNum = 477;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "buttonusuarios_click"), (parent._job1));
this.state = 25;
return;
case 25:
//C
this.state = 1;
;
 BA.debugLineNum = 478;BA.debugLine="Dim retu As String = Job1.GetString";
Debug.ShouldStop(536870912);
_retu = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("retu", _retu);Debug.locals.put("retu", _retu);
 BA.debugLineNum = 479;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
Debug.ShouldStop(1073741824);
_ret = _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<return>"))),RemoteObject.createImmutable(8)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</return>")))));Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 480;BA.debugLine="Dim usercurrent As String = \"\"";
Debug.ShouldStop(-2147483648);
_usercurrent = BA.ObjectToString("");Debug.locals.put("usercurrent", _usercurrent);Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 481;BA.debugLine="If ret = \"1\" Then";
Debug.ShouldStop(1);
if (true) break;

case 1:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",_ret,BA.ObjectToString("1"))) { 
this.state = 3;
}else {
this.state = 23;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 482;BA.debugLine="Dim cnt As Int = retu.SubString2(retu.LastIndexO";
Debug.ShouldStop(2);
_cnt = BA.numberCast(int.class, _retu.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<count>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</count>"))))));Debug.locals.put("cnt", _cnt);Debug.locals.put("cnt", _cnt);
 BA.debugLineNum = 483;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
Debug.ShouldStop(4);
_usermain = _retu.runMethod(true,"substring",(Object)(_retu.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))),(Object)(_retu.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</usuario>")))));Debug.locals.put("usermain", _usermain);Debug.locals.put("usermain", _usermain);
 BA.debugLineNum = 484;BA.debugLine="Dim count As Int = 0";
Debug.ShouldStop(8);
parent._count = BA.numberCast(int.class, 0);
 BA.debugLineNum = 485;BA.debugLine="Try";
Debug.ShouldStop(16);
if (true) break;

case 4:
//try
this.state = 21;
this.catchState = 20;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 20;
 BA.debugLineNum = 486;BA.debugLine="For i=0 To cnt-1";
Debug.ShouldStop(32);
if (true) break;

case 7:
//for
this.state = 18;
step11 = 1;
limit11 = RemoteObject.solve(new RemoteObject[] {_cnt,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 0) ;
this.state = 26;
if (true) break;

case 26:
//C
this.state = 18;
if ((step11 > 0 && parent._i.<Integer>get().intValue() <= limit11) || (step11 < 0 && parent._i.<Integer>get().intValue() >= limit11)) this.state = 9;
if (true) break;

case 27:
//C
this.state = 26;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step11)) ;
if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 487;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
Debug.ShouldStop(64);
_usercurrent = _usermain.runMethod(true,"substring",(Object)(_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<usuario>")))));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 488;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
Debug.ShouldStop(128);
_usercurrent = _usercurrent.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usercurrent", _usercurrent);
 BA.debugLineNum = 489;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
Debug.ShouldStop(256);
parent.mostCurrent._listviewusuarios.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>"))))))),(Object)((_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))))));
 BA.debugLineNum = 490;BA.debugLine="If i=0 Then";
Debug.ShouldStop(512);
if (true) break;

case 10:
//if
this.state = 17;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, 0))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 491;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
Debug.ShouldStop(1024);
parent.mostCurrent._edittextnomeusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nomeusuario>"))),RemoteObject.createImmutable(13)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nomeusuario>")))))));
 BA.debugLineNum = 492;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
Debug.ShouldStop(2048);
parent._positionnivel = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<nivel>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</nivel>"))))));
 BA.debugLineNum = 493;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
Debug.ShouldStop(4096);
parent._idusuario = BA.numberCast(int.class, _usercurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idusuario>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_usercurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idusuario>"))))));
 BA.debugLineNum = 494;BA.debugLine="ListViewAcesso.Clear";
Debug.ShouldStop(8192);
parent.mostCurrent._listviewacesso.runVoidMethod ("Clear");
 BA.debugLineNum = 495;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(16384);
if (true) break;

case 13:
//for
this.state = 16;
step20 = 1;
limit20 = 4;
parent._i = BA.numberCast(int.class, 0) ;
this.state = 28;
if (true) break;

case 28:
//C
this.state = 16;
if ((step20 > 0 && parent._i.<Integer>get().intValue() <= limit20) || (step20 < 0 && parent._i.<Integer>get().intValue() >= limit20)) this.state = 15;
if (true) break;

case 29:
//C
this.state = 28;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step20)) ;
if (true) break;

case 15:
//C
this.state = 29;
 BA.debugLineNum = 496;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
Debug.ShouldStop(32768);
parent.mostCurrent._listviewacesso.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent._i)),(Object)((parent._i)));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
 BA.debugLineNum = 498;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
Debug.ShouldStop(131072);
parent.mostCurrent._listviewacesso.runVoidMethod ("SetSelection",(Object)(parent._positionnivel));
 if (true) break;

case 17:
//C
this.state = 27;
;
 BA.debugLineNum = 500;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
Debug.ShouldStop(524288);
_usermain = _usermain.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_usermain.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</usuario>"))),RemoteObject.createImmutable(10)}, "+",1, 1)));Debug.locals.put("usermain", _usermain);
 if (true) break;
if (true) break;

case 18:
//C
this.state = 21;
;
 BA.debugLineNum = 502;BA.debugLine="panelUsuarios.Visible =  True";
Debug.ShouldStop(2097152);
parent.mostCurrent._panelusuarios.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 503;BA.debugLine="panelMenu.Visible =  False";
Debug.ShouldStop(4194304);
parent.mostCurrent._panelmenu.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
if (true) break;

case 20:
//C
this.state = 21;
this.catchState = 0;
 BA.debugLineNum = 505;BA.debugLine="MsgboxAsync(\"Erro ao carregar os usuários\",\"Err";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao carregar os usuários")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 21:
//C
this.state = 24;
this.catchState = 0;
;
 if (true) break;

case 23:
//C
this.state = 24;
 BA.debugLineNum = 508;BA.debugLine="MsgboxAsync(\"Erro ao conectar com o bando de dad";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao conectar com o bando de dados.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;

case 24:
//C
this.state = -1;
;
 BA.debugLineNum = 510;BA.debugLine="End Sub";
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
public static RemoteObject  _buttonvoltarmenuusuarios_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonVoltarMenuUsuarios_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,468);
if (RapidSub.canDelegate("buttonvoltarmenuusuarios_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonvoltarmenuusuarios_click");}
 BA.debugLineNum = 468;BA.debugLine="Sub ButtonVoltarMenuUsuarios_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 469;BA.debugLine="panelUsuarios.Visible =  False";
Debug.ShouldStop(1048576);
main.mostCurrent._panelusuarios.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 470;BA.debugLine="panelMenu.Visible =  True";
Debug.ShouldStop(2097152);
main.mostCurrent._panelmenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 471;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonwebservice_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonWebservice_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,727);
if (RapidSub.canDelegate("buttonwebservice_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonwebservice_click");}
 BA.debugLineNum = 727;BA.debugLine="Sub ButtonWebservice_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 728;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 729;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT * FROM Webservic";
Debug.ShouldStop(16777216);
main._cursor.setObject(main._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM Webservice"))));
 BA.debugLineNum = 730;BA.debugLine="cursor.Position=0";
Debug.ShouldStop(33554432);
main._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 731;BA.debugLine="EditTextWebserviceIP.Text = cursor.GetString2(1)";
Debug.ShouldStop(67108864);
main.mostCurrent._edittextwebserviceip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 732;BA.debugLine="EditTextWebservicePorta.Text = cursor.GetString2";
Debug.ShouldStop(134217728);
main.mostCurrent._edittextwebserviceporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 733;BA.debugLine="panelWebservice.Visible =  True";
Debug.ShouldStop(268435456);
main.mostCurrent._panelwebservice.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 734;BA.debugLine="panelMenu.Visible =  False";
Debug.ShouldStop(536870912);
main.mostCurrent._panelmenu.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e9.toString()); BA.debugLineNum = 736;BA.debugLine="MsgboxAsync(\"Eoo ao alterar ao carregar o webser";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Eoo ao alterar ao carregar o webservice.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 };
 BA.debugLineNum = 738;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonwebservicealterar_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonWebserviceAlterar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1166);
if (RapidSub.canDelegate("buttonwebservicealterar_click")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","buttonwebservicealterar_click");}
 BA.debugLineNum = 1166;BA.debugLine="Sub ButtonWebserviceAlterar_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1167;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 1168;BA.debugLine="sql1.ExecNonQuery(\"UPDATE 'Webservice' SET port=";
Debug.ShouldStop(32768);
main._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE 'Webservice' SET port='"),main.mostCurrent._edittextwebserviceip.runMethod(true,"getText"),RemoteObject.createImmutable("', ip='"),main.mostCurrent._edittextwebserviceporta.runMethod(true,"getText"),RemoteObject.createImmutable("'WHERE id=1"))));
 BA.debugLineNum = 1169;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT * FROM Webservic";
Debug.ShouldStop(65536);
main._cursor.setObject(main._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM Webservice"))));
 BA.debugLineNum = 1170;BA.debugLine="cursor.Position=0";
Debug.ShouldStop(131072);
main._cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 1171;BA.debugLine="EditTextWebserviceIP.Text = cursor.GetString2(1)";
Debug.ShouldStop(262144);
main.mostCurrent._edittextwebserviceip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 1172;BA.debugLine="EditTextWebservicePorta.Text = cursor.GetString2";
Debug.ShouldStop(524288);
main.mostCurrent._edittextwebserviceporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main._cursor.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 2)))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 1174;BA.debugLine="MsgboxAsync(\"Eoo ao alterar o registro.\",\"Aviso\"";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Eoo ao alterar o registro.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 };
 BA.debugLineNum = 1176;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _clock(RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Clock (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,288);
if (RapidSub.canDelegate("clock")) { wrong.addition.main.remoteMe.runUserSub(false, "main","clock", _value); return;}
ResumableSub_Clock rsub = new ResumableSub_Clock(null,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Clock extends BA.ResumableSub {
public ResumableSub_Clock(wrong.addition.main parent,RemoteObject _value) {
this.parent = parent;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _value;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Clock (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,288);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("value", _value);
 BA.debugLineNum = 289;BA.debugLine="Do While value =  True";
Debug.ShouldStop(1);
if (true) break;

case 1:
//do while
this.state = 4;
while (RemoteObject.solveBoolean("=",_value,parent.mostCurrent.__c.getField(true,"True"))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 BA.debugLineNum = 290;BA.debugLine="Sleep(500)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "clock"),BA.numberCast(int.class, 500));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 BA.debugLineNum = 291;BA.debugLine="LabelClock.Text = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(4);
parent.mostCurrent._labelclock.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 293;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
public static RemoteObject  _connect() throws Exception{
try {
		Debug.PushSubsStack("Connect (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,309);
if (RapidSub.canDelegate("connect")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","connect");}
 BA.debugLineNum = 309;BA.debugLine="Sub Connect";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 310;BA.debugLine="socket1.Initialize(\"CoonectTelnet\")";
Debug.ShouldStop(2097152);
main._socket1.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CoonectTelnet")));
 BA.debugLineNum = 311;BA.debugLine="CallSubDelayed(Me,\"CoonectTelnet\")";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("CoonectTelnet")));
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _coonecttelnet() throws Exception{
try {
		Debug.PushSubsStack("CoonectTelnet (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,314);
if (RapidSub.canDelegate("coonecttelnet")) { wrong.addition.main.remoteMe.runUserSub(false, "main","coonecttelnet"); return;}
ResumableSub_CoonectTelnet rsub = new ResumableSub_CoonectTelnet(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_CoonectTelnet extends BA.ResumableSub {
public ResumableSub_CoonectTelnet(wrong.addition.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("CoonectTelnet (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,314);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 315;BA.debugLine="Try";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//try
this.state = 10;
this.catchState = 9;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 9;
 BA.debugLineNum = 316;BA.debugLine="Sleep(1)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "coonecttelnet"),BA.numberCast(int.class, 1));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 BA.debugLineNum = 317;BA.debugLine="If socket1.IsInitialized = True And j=0 Then";
Debug.ShouldStop(268435456);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent._socket1.runMethod(true,"IsInitialized"),parent.mostCurrent.__c.getField(true,"True")) && RemoteObject.solveBoolean("=",parent._j,BA.numberCast(double.class, 0))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 318;BA.debugLine="socket1.Connect(EditTextIP.Text,EditTextPorta.T";
Debug.ShouldStop(536870912);
parent._socket1.runVoidMethod ("Connect",main.processBA,(Object)(parent.mostCurrent._edittextip.runMethod(true,"getText")),(Object)(BA.numberCast(int.class, parent.mostCurrent._edittextporta.runMethod(true,"getText"))),(Object)(BA.numberCast(int.class, 2500)));
 BA.debugLineNum = 319;BA.debugLine="CallSubDelayed2(Me,\"CoonectTelnet_Connected\",Tr";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.processBA,(Object)(main.getObject()),(Object)(BA.ObjectToString("CoonectTelnet_Connected")),(Object)((parent.mostCurrent.__c.getField(true,"True"))));
 BA.debugLineNum = 320;BA.debugLine="j=1";
Debug.ShouldStop(-2147483648);
parent._j = BA.numberCast(int.class, 1);
 if (true) break;

case 7:
//C
this.state = 10;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 BA.debugLineNum = 323;BA.debugLine="MsgboxAsync(\"No connection\",\"Network\")";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("No connection")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Network"))),main.processBA);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 325;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
public static void  _coonecttelnet_connected(RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("CoonectTelnet_Connected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,327);
if (RapidSub.canDelegate("coonecttelnet_connected")) { wrong.addition.main.remoteMe.runUserSub(false, "main","coonecttelnet_connected", _state); return;}
ResumableSub_CoonectTelnet_Connected rsub = new ResumableSub_CoonectTelnet_Connected(null,_state);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_CoonectTelnet_Connected extends BA.ResumableSub {
public ResumableSub_CoonectTelnet_Connected(wrong.addition.main parent,RemoteObject _state) {
this.parent = parent;
this._state = _state;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _state;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("CoonectTelnet_Connected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,327);
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
 BA.debugLineNum = 328;BA.debugLine="Do While socket1.Connected= True";
Debug.ShouldStop(128);
if (true) break;

case 1:
//do while
this.state = 44;
while (RemoteObject.solveBoolean("=",parent._socket1.runMethod(true,"getConnected"),parent.mostCurrent.__c.getField(true,"True"))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 329;BA.debugLine="str = socket1.InputStream";
Debug.ShouldStop(256);
parent.mostCurrent._str.setObject(parent._socket1.runMethod(false,"getInputStream"));
 BA.debugLineNum = 330;BA.debugLine="reader.Initialize(socket1.InputStream)";
Debug.ShouldStop(512);
parent.mostCurrent._reader.runVoidMethod ("Initialize",(Object)(parent._socket1.runMethod(false,"getInputStream")));
 BA.debugLineNum = 331;BA.debugLine="UnidadePeso = \"KG\"";
Debug.ShouldStop(1024);
parent.mostCurrent._unidadepeso = BA.ObjectToString("KG");
 BA.debugLineNum = 332;BA.debugLine="If str.BytesAvailable-str3 >= 9 Then";
Debug.ShouldStop(2048);
if (true) break;

case 4:
//if
this.state = 43;
if (RemoteObject.solveBoolean("g",RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._str.runMethod(true,"BytesAvailable"),parent._str3}, "-",1, 1),BA.numberCast(double.class, 9))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 333;BA.debugLine="Try";
Debug.ShouldStop(4096);
if (true) break;

case 7:
//try
this.state = 42;
this.catchState = 41;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 41;
 BA.debugLineNum = 334;BA.debugLine="str2 =  reader.ReadLine";
Debug.ShouldStop(8192);
parent._str2 = BA.numberCast(double.class, parent.mostCurrent._reader.runMethod(true,"ReadLine"));
 BA.debugLineNum = 335;BA.debugLine="str2 = str2 / divisor";
Debug.ShouldStop(16384);
parent._str2 = RemoteObject.solve(new RemoteObject[] {parent._str2,parent._divisor}, "/",0, 0);
 BA.debugLineNum = 336;BA.debugLine="If UnidadePeso =  \"KG\" Then";
Debug.ShouldStop(32768);
if (true) break;

case 10:
//if
this.state = 39;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._unidadepeso,BA.ObjectToString("KG"))) { 
this.state = 12;
}else 
{ BA.debugLineNum = 348;BA.debugLine="Else If UnidadePeso =  \"G\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",parent.mostCurrent._unidadepeso,BA.ObjectToString("G"))) { 
this.state = 26;
}}
if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 337;BA.debugLine="If str2 <= ToleranciaMinimo Or str2 >= Tolera";
Debug.ShouldStop(65536);
if (true) break;

case 13:
//if
this.state = 24;
if (RemoteObject.solveBoolean("k",parent._str2,parent._toleranciaminimo) || RemoteObject.solveBoolean("g",parent._str2,parent._toleranciamaximo)) { 
this.state = 15;
}else {
this.state = 23;
}if (true) break;

case 15:
//C
this.state = 16;
 BA.debugLineNum = 338;BA.debugLine="If  str2 >= (ToleranciaMinimo * 0.975) And s";
Debug.ShouldStop(131072);
if (true) break;

case 16:
//if
this.state = 21;
if (RemoteObject.solveBoolean("g",parent._str2,(RemoteObject.solve(new RemoteObject[] {parent._toleranciaminimo,RemoteObject.createImmutable(0.975)}, "*",0, 0))) && RemoteObject.solveBoolean("k",parent._str2,(RemoteObject.solve(new RemoteObject[] {parent._toleranciamaximo,RemoteObject.createImmutable(1.025)}, "*",0, 0)))) { 
this.state = 18;
}else {
this.state = 20;
}if (true) break;

case 18:
//C
this.state = 21;
 BA.debugLineNum = 339;BA.debugLine="EditTextPeso.TextColor = Colors.Yellow";
Debug.ShouldStop(262144);
parent.mostCurrent._edittextpeso.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow"));
 if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 341;BA.debugLine="EditTextPeso.TextColor = Colors.Red";
Debug.ShouldStop(1048576);
parent.mostCurrent._edittextpeso.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 BA.debugLineNum = 344;BA.debugLine="EditTextPeso.TextColor = Colors.Green";
Debug.ShouldStop(8388608);
parent.mostCurrent._edittextpeso.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 if (true) break;

case 24:
//C
this.state = 39;
;
 BA.debugLineNum = 346;BA.debugLine="EditTextPeso.Text = NumberFormat(str2,decimal";
Debug.ShouldStop(33554432);
parent.mostCurrent._edittextpeso.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(parent._str2),(Object)(parent._decimal),(Object)(BA.numberCast(int.class, 1))).runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 347;BA.debugLine="str3 = str.BytesAvailable";
Debug.ShouldStop(67108864);
parent._str3 = parent.mostCurrent._str.runMethod(true,"BytesAvailable");
 if (true) break;

case 26:
//C
this.state = 27;
 BA.debugLineNum = 349;BA.debugLine="If  str2 < ToleranciaMinimo Or str2 > Toleran";
Debug.ShouldStop(268435456);
if (true) break;

case 27:
//if
this.state = 38;
if (RemoteObject.solveBoolean("<",parent._str2,parent._toleranciaminimo) || RemoteObject.solveBoolean(">",parent._str2,parent._toleranciamaximo)) { 
this.state = 29;
}else {
this.state = 37;
}if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 350;BA.debugLine="If  str2 >= (ToleranciaMinimo * 0.975) And s";
Debug.ShouldStop(536870912);
if (true) break;

case 30:
//if
this.state = 35;
if (RemoteObject.solveBoolean("g",parent._str2,(RemoteObject.solve(new RemoteObject[] {parent._toleranciaminimo,RemoteObject.createImmutable(0.975)}, "*",0, 0))) && RemoteObject.solveBoolean("k",parent._str2,(RemoteObject.solve(new RemoteObject[] {parent._toleranciamaximo,RemoteObject.createImmutable(1.025)}, "*",0, 0)))) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 35;
 BA.debugLineNum = 351;BA.debugLine="EditTextPeso.TextColor = Colors.Red";
Debug.ShouldStop(1073741824);
parent.mostCurrent._edittextpeso.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 if (true) break;

case 34:
//C
this.state = 35;
 BA.debugLineNum = 353;BA.debugLine="EditTextPeso.TextColor = Colors.Yellow";
Debug.ShouldStop(1);
parent.mostCurrent._edittextpeso.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow"));
 if (true) break;

case 35:
//C
this.state = 38;
;
 if (true) break;

case 37:
//C
this.state = 38;
 BA.debugLineNum = 356;BA.debugLine="EditTextPeso.TextColor = Colors.Green";
Debug.ShouldStop(8);
parent.mostCurrent._edittextpeso.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 if (true) break;

case 38:
//C
this.state = 39;
;
 BA.debugLineNum = 358;BA.debugLine="EditTextPeso.Text = NumberFormat(str2,decimal";
Debug.ShouldStop(32);
parent.mostCurrent._edittextpeso.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(parent._str2),(Object)(parent._decimal),(Object)(BA.numberCast(int.class, 1))).runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 359;BA.debugLine="str3 = str.BytesAvailable";
Debug.ShouldStop(64);
parent._str3 = parent.mostCurrent._str.runMethod(true,"BytesAvailable");
 if (true) break;

case 39:
//C
this.state = 42;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 41:
//C
this.state = 42;
this.catchState = 0;
 BA.debugLineNum = 362;BA.debugLine="EditTextPeso.Text =  \"Erro ao ler, verifique a";
Debug.ShouldStop(512);
parent.mostCurrent._edittextpeso.runMethodAndSync(true,"setText",BA.ObjectToCharSequence("Erro ao ler, verifique a balança."));
 if (true) break;
if (true) break;

case 42:
//C
this.state = 43;
this.catchState = 0;
;
 if (true) break;

case 43:
//C
this.state = 1;
;
 BA.debugLineNum = 365;BA.debugLine="Sleep(500)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "coonecttelnet_connected"),BA.numberCast(int.class, 500));
this.state = 45;
return;
case 45:
//C
this.state = 1;
;
 if (true) break;

case 44:
//C
this.state = -1;
;
 BA.debugLineNum = 367;BA.debugLine="End Sub";
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
public static RemoteObject  _disablestrictmode() throws Exception{
try {
		Debug.PushSubsStack("DisableStrictMode (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,297);
if (RapidSub.canDelegate("disablestrictmode")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","disablestrictmode");}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _policy = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _sm = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 297;BA.debugLine="Sub DisableStrictMode";
Debug.ShouldStop(256);
 BA.debugLineNum = 298;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(512);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 299;BA.debugLine="jo.InitializeStatic(\"android.os.Build.VERSION\")";
Debug.ShouldStop(1024);
_jo.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.os.Build.VERSION")));
 BA.debugLineNum = 300;BA.debugLine="If jo.GetField(\"SDK_INT\") > 9 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, _jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("SDK_INT")))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 301;BA.debugLine="Dim policy As JavaObject";
Debug.ShouldStop(4096);
_policy = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("policy", _policy);
 BA.debugLineNum = 302;BA.debugLine="policy = policy.InitializeNewInstance(\"android.o";
Debug.ShouldStop(8192);
_policy = _policy.runMethod(false,"InitializeNewInstance",(Object)(BA.ObjectToString("android.os.StrictMode.ThreadPolicy.Builder")),(Object)((main.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("policy", _policy);
 BA.debugLineNum = 303;BA.debugLine="policy = policy.RunMethodJO(\"permitAll\", Null).R";
Debug.ShouldStop(16384);
_policy = _policy.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("permitAll")),(Object)((main.mostCurrent.__c.getField(false,"Null")))).runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("build")),(Object)((main.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("policy", _policy);
 BA.debugLineNum = 304;BA.debugLine="Dim sm As JavaObject";
Debug.ShouldStop(32768);
_sm = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("sm", _sm);
 BA.debugLineNum = 305;BA.debugLine="sm.InitializeStatic(\"android.os.StrictMode\").Run";
Debug.ShouldStop(65536);
_sm.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("android.os.StrictMode"))).runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setThreadPolicy")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_policy.getObject())})));
 };
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private ButtonSair As Button";
main.mostCurrent._buttonsair = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private ButtonLogin As Button";
main.mostCurrent._buttonlogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private LabelClock As Label";
main.mostCurrent._labelclock = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private ImageAplipack As ImageView";
main.mostCurrent._imageaplipack = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private ButtonMenu As Button";
main.mostCurrent._buttonmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim panelMain As Panel";
main.mostCurrent._panelmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim panelLogin As Panel";
main.mostCurrent._panellogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim panelMenu As Panel";
main.mostCurrent._panelmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim panelConexao As Panel";
main.mostCurrent._panelconexao = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim panelPesagem As Panel";
main.mostCurrent._panelpesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim panelUsuarios As Panel";
main.mostCurrent._panelusuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim panelWebservice As Panel";
main.mostCurrent._panelwebservice = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim panelProdutos As Panel";
main.mostCurrent._panelprodutos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim SelecionaCUC As Panel";
main.mostCurrent._selecionacuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private ButtonTelaLogin As Button";
main.mostCurrent._buttontelalogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private ButtonlLimpar As Button";
main.mostCurrent._buttonllimpar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private EditTextUser As EditText";
main.mostCurrent._edittextuser = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private EditTextPassword As EditText";
main.mostCurrent._edittextpassword = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private ButtonTelaMenu As Button";
main.mostCurrent._buttontelamenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Dim str As InputStream";
main.mostCurrent._str = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Dim str2 As Double";
main._str2 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 44;BA.debugLine="Dim str3 As Int";
main._str3 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 45;BA.debugLine="Dim reader As TextReader";
main.mostCurrent._reader = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.TextReaderWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private ButtonTelaMain As Button";
main.mostCurrent._buttontelamain = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private ButtonTelaLeitura As Button";
main.mostCurrent._buttontelaleitura = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private EditTextIP As EditText";
main.mostCurrent._edittextip = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private EditTextPorta As EditText";
main.mostCurrent._edittextporta = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private ButtonManualSoftware As Button";
main.mostCurrent._buttonmanualsoftware = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private ButtonConcluirPesagem As Button";
main.mostCurrent._buttonconcluirpesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private EditTextPeso As EditText";
main.mostCurrent._edittextpeso = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private ButtonSairPeso As Button";
main.mostCurrent._buttonsairpeso = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private ButtonCadastraBalnca As Button";
main.mostCurrent._buttoncadastrabalnca = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Dim myABBarcode As ABZxing";
main.mostCurrent._myabbarcode = RemoteObject.createNew ("com.AB.ABZxing.ABZxing");
 //BA.debugLineNum = 56;BA.debugLine="Private ButtonLeituraBarcode As Button";
main.mostCurrent._buttonleiturabarcode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private EditTextProduto As EditText";
main.mostCurrent._edittextproduto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private EditTextFabricacao As EditText";
main.mostCurrent._edittextfabricacao = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private EditTextValidadePdoruo As EditText";
main.mostCurrent._edittextvalidadepdoruo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private EditTextLote As EditText";
main.mostCurrent._edittextlote = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Dim i As Int";
main._i = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 62;BA.debugLine="Dim j As Int";
main._j = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 63;BA.debugLine="Dim count As Int";
main._count = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 64;BA.debugLine="Dim filename As String";
main.mostCurrent._filename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 65;BA.debugLine="Dim listPosition As String";
main.mostCurrent._listposition = RemoteObject.createImmutable("");
 //BA.debugLineNum = 66;BA.debugLine="Private EditTextNomeBalanca As EditText";
main.mostCurrent._edittextnomebalanca = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private ButtonGravarDB As Button";
main.mostCurrent._buttongravardb = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private ListViewBalanca As ListView";
main.mostCurrent._listviewbalanca = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private ListViewTelaBalanca As ListView";
main.mostCurrent._listviewtelabalanca = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private ButtonVoltarMenuUsuarios As Button";
main.mostCurrent._buttonvoltarmenuusuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private ButtonUsuarios As Button";
main.mostCurrent._buttonusuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private ButtonWebservice As Button";
main.mostCurrent._buttonwebservice = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private ButtonTelawebserviceMenu As Button";
main.mostCurrent._buttontelawebservicemenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private ButtonProdutosVolta As Button";
main.mostCurrent._buttonprodutosvolta = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private ButtonCadastroProduto As Button";
main.mostCurrent._buttoncadastroproduto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Private ListViewTipoPesagem As ListView";
main.mostCurrent._listviewtipopesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 77;BA.debugLine="Private EditTextWebserviceIP As EditText";
main.mostCurrent._edittextwebserviceip = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private EditTextWebservicePorta As EditText";
main.mostCurrent._edittextwebserviceporta = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private ButtonWebserviceAlterar As Button";
main.mostCurrent._buttonwebservicealterar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private EditTextXML As EditText";
main.mostCurrent._edittextxml = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Private ButtonBalancaUp As Button";
main.mostCurrent._buttonbalancaup = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 82;BA.debugLine="Private ButtonBalancaDown As Button";
main.mostCurrent._buttonbalancadown = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private ButtonBalanaAlterar As Button";
main.mostCurrent._buttonbalanaalterar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 84;BA.debugLine="Private ButtonDeletarBalanca As Button";
main.mostCurrent._buttondeletarbalanca = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private Usertext As EditText";
main.mostCurrent._usertext = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 86;BA.debugLine="Private ListViewUsuarios As ListView";
main.mostCurrent._listviewusuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 87;BA.debugLine="Private ListViewAcesso As ListView";
main.mostCurrent._listviewacesso = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private EditTextNomeUsuario As EditText";
main.mostCurrent._edittextnomeusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Private ButtonGravarUusario As Button";
main.mostCurrent._buttongravaruusario = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private ButtonAlterarUsuario As Button";
main.mostCurrent._buttonalterarusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private ButtonUserUp As Button";
main.mostCurrent._buttonuserup = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 92;BA.debugLine="Private ButtonUserDown As Button";
main.mostCurrent._buttonuserdown = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 93;BA.debugLine="Dim PositionUser As Int = 0";
main._positionuser = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 94;BA.debugLine="Dim PositionDB As Int = 1";
main._positiondb = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 95;BA.debugLine="Dim positionDB2 As Int = 1";
main._positiondb2 = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 96;BA.debugLine="Private ButtonNivelUp As Button";
main.mostCurrent._buttonnivelup = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 97;BA.debugLine="Private ButtonNivelDown As Button";
main.mostCurrent._buttonniveldown = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 98;BA.debugLine="Dim PositionNivel As Int = 0";
main._positionnivel = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 99;BA.debugLine="Dim idusuario As Int = 0";
main._idusuario = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 100;BA.debugLine="Private ButtonApagarUsuario As Button";
main.mostCurrent._buttonapagarusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 101;BA.debugLine="Private EditTextNomeProduto As EditText";
main.mostCurrent._edittextnomeproduto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 102;BA.debugLine="Private EditTextCodigoProduto As EditText";
main.mostCurrent._edittextcodigoproduto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 103;BA.debugLine="Private EditTextCodigoCuc As EditText";
main.mostCurrent._edittextcodigocuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 104;BA.debugLine="Private ButtonGravarProduto As Button";
main.mostCurrent._buttongravarproduto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 105;BA.debugLine="Private ButtonProdutoAlterar As Button";
main.mostCurrent._buttonprodutoalterar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 106;BA.debugLine="Private ListViewProdutosCUC As ListView";
main.mostCurrent._listviewprodutoscuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 107;BA.debugLine="Private EditTextPordutoCUC As EditText";
main.mostCurrent._edittextpordutocuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 108;BA.debugLine="Private ButtonMenuCUC As Button";
main.mostCurrent._buttonmenucuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 109;BA.debugLine="Private ButtonCarregarCUC As Button";
main.mostCurrent._buttoncarregarcuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 110;BA.debugLine="Private EditTextDescricaoCUC As EditText";
main.mostCurrent._edittextdescricaocuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 111;BA.debugLine="Private ListViewCUC As ListView";
main.mostCurrent._listviewcuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 112;BA.debugLine="Private EditTextCodigoCUCTela As EditText";
main.mostCurrent._edittextcodigocuctela = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 113;BA.debugLine="Private ButtonApgarProdutoCUC As Button";
main.mostCurrent._buttonapgarprodutocuc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 114;BA.debugLine="Private NivelUsuario As String=0";
main.mostCurrent._nivelusuario = BA.NumberToString(0);
 //BA.debugLineNum = 115;BA.debugLine="Private ListViewCUCMain As ListView";
main.mostCurrent._listviewcucmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 116;BA.debugLine="Private ListViewCUCPesagem As ListView";
main.mostCurrent._listviewcucpesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 117;BA.debugLine="Private Peso As Double";
main._peso = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 118;BA.debugLine="Private UnidadePeso As String";
main.mostCurrent._unidadepeso = RemoteObject.createImmutable("");
 //BA.debugLineNum = 119;BA.debugLine="Dim ToleranciaMinimo As Double";
main._toleranciaminimo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 120;BA.debugLine="Dim ToleranciaMaximo As Double";
main._toleranciamaximo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 121;BA.debugLine="Dim URLglobal As String";
main.mostCurrent._urlglobal = RemoteObject.createImmutable("");
 //BA.debugLineNum = 122;BA.debugLine="Dim PosBalanca As Int = 0";
main._posbalanca = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 123;BA.debugLine="Private ButtonTelaLoginVolta As Button";
main.mostCurrent._buttontelaloginvolta = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 124;BA.debugLine="Dim ListOrdemProdSAP As List";
main.mostCurrent._listordemprodsap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 125;BA.debugLine="Dim ListProdutosPesagem As List";
main.mostCurrent._listprodutospesagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 126;BA.debugLine="Private ListViewCampanha As ListView";
main.mostCurrent._listviewcampanha = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 127;BA.debugLine="Dim Campanha As String";
main.mostCurrent._campanha = RemoteObject.createImmutable("");
 //BA.debugLineNum = 128;BA.debugLine="Dim Cod As String";
main.mostCurrent._cod = RemoteObject.createImmutable("");
 //BA.debugLineNum = 129;BA.debugLine="Dim PesoRota1 As Double";
main._pesorota1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 130;BA.debugLine="Dim PesoAlvo As Double";
main._pesoalvo = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 131;BA.debugLine="Dim UnidadeAlvo As String";
main.mostCurrent._unidadealvo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 132;BA.debugLine="Dim IdPesagemProg As String";
main.mostCurrent._idpesagemprog = RemoteObject.createImmutable("");
 //BA.debugLineNum = 133;BA.debugLine="Private ButtonEmbalagem As Button";
main.mostCurrent._buttonembalagem = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 134;BA.debugLine="Dim EmbFechada As Double";
main._embfechada = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 135;BA.debugLine="Dim XMLCurrent As String";
main.mostCurrent._xmlcurrent = RemoteObject.createImmutable("");
 //BA.debugLineNum = 136;BA.debugLine="Dim XMLwork As String";
main.mostCurrent._xmlwork = RemoteObject.createImmutable("");
 //BA.debugLineNum = 137;BA.debugLine="Dim divisor As Int = 0";
main._divisor = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 138;BA.debugLine="Dim decimal As Int = 0";
main._decimal = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 139;BA.debugLine="Private EditTextDivisor As EditText";
main.mostCurrent._edittextdivisor = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 140;BA.debugLine="Private EditTextDecimais As EditText";
main.mostCurrent._edittextdecimais = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _listviewbalanca_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewBalanca_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1180);
if (RapidSub.canDelegate("listviewbalanca_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewbalanca_itemclick", _position, _value); return;}
ResumableSub_ListViewBalanca_ItemClick rsub = new ResumableSub_ListViewBalanca_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewBalanca_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewBalanca_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewBalanca_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1180);
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
 BA.debugLineNum = 1181;BA.debugLine="Sleep(2)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewbalanca_itemclick"),BA.numberCast(int.class, 2));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 BA.debugLineNum = 1182;BA.debugLine="Try";
Debug.ShouldStop(536870912);
if (true) break;

case 1:
//try
this.state = 6;
this.catchState = 5;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 6;
this.catchState = 5;
 BA.debugLineNum = 1183;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(1073741824);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE idBalancas="),_value,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1184;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(-2147483648);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1185;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(1);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1186;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewbalanca_itemclick"), (parent._job1));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 BA.debugLineNum = 1187;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(4);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1188;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(8);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1189;BA.debugLine="EditTextNomeBalanca.Text = \"Balança \"&XMLwork.Su";
Debug.ShouldStop(16);
parent.mostCurrent._edittextnomebalanca.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")"))));
 BA.debugLineNum = 1190;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
Debug.ShouldStop(32);
parent.mostCurrent._edittextip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<ipbalanca>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</ipbalanca>")))))));
 BA.debugLineNum = 1191;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(64);
parent.mostCurrent._edittextporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<portabalanca>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</portabalanca>")))))));
 BA.debugLineNum = 1192;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwor";
Debug.ShouldStop(128);
parent.mostCurrent._edittextdivisor.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>")))))));
 BA.debugLineNum = 1193;BA.debugLine="decimal = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
Debug.ShouldStop(256);
parent._decimal = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<decimais>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</decimais>"))))));
 BA.debugLineNum = 1194;BA.debugLine="divisor = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
Debug.ShouldStop(512);
parent._divisor = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>"))))));
 BA.debugLineNum = 1195;BA.debugLine="DisableStrictMode";
Debug.ShouldStop(1024);
_disablestrictmode();
 BA.debugLineNum = 1196;BA.debugLine="CallSubDelayed(Me,\"Connect\")";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("Connect")));
 Debug.CheckDeviceExceptions();
if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 BA.debugLineNum = 1198;BA.debugLine="MsgboxAsync(\"Não foi possivel se conectar com a";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Não foi possivel se conectar com a balança")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1200;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static void  _listviewcampanha_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewCampanha_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1315);
if (RapidSub.canDelegate("listviewcampanha_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewcampanha_itemclick", _position, _value); return;}
ResumableSub_ListViewCampanha_ItemClick rsub = new ResumableSub_ListViewCampanha_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewCampanha_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCampanha_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");
int step13;
int limit13;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewCampanha_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1315);
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
 BA.debugLineNum = 1316;BA.debugLine="Try";
Debug.ShouldStop(8);
if (true) break;

case 1:
//try
this.state = 14;
this.catchState = 13;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 13;
 BA.debugLineNum = 1317;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(16);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="),_value,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1318;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(32);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1319;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(64);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1320;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewcampanha_itemclick"), (parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 BA.debugLineNum = 1321;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(256);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1322;BA.debugLine="Campanha =  Value";
Debug.ShouldStop(512);
parent.mostCurrent._campanha = BA.ObjectToString(_value);
 BA.debugLineNum = 1323;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(1024);
if (true) break;

case 4:
//if
this.state = 11;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 1324;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.L";
Debug.ShouldStop(2048);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 1325;BA.debugLine="XMLCurrent = XMLwork.SubString2(XMLwork.IndexOf";
Debug.ShouldStop(4096);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 1326;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(8192);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1327;BA.debugLine="ListProdutosPesagem.Clear";
Debug.ShouldStop(16384);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1328;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(32768);
if (true) break;

case 7:
//for
this.state = 10;
step13 = 1;
limit13 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 16;
if (true) break;

case 16:
//C
this.state = 10;
if ((step13 > 0 && parent._i.<Integer>get().intValue() <= limit13) || (step13 < 0 && parent._i.<Integer>get().intValue() >= limit13)) this.state = 9;
if (true) break;

case 17:
//C
this.state = 16;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step13)) ;
if (true) break;

case 9:
//C
this.state = 17;
 BA.debugLineNum = 1329;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent.SubString2(";
Debug.ShouldStop(65536);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Add",(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1330;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurrent.S";
Debug.ShouldStop(131072);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoMaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoMaterial>"))))).runMethod(true,"trim"),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Peso>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Peso>"))))),RemoteObject.createImmutable(" "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<EmbFechada>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</EmbFechada>"))))),RemoteObject.createImmutable(" "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<UnidadeEmb>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</UnidadeEmb>"))))),RemoteObject.createImmutable(") | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota1>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota1>"))))),RemoteObject.createImmutable(" | "),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota2>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota2>")))))))),(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1331;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
Debug.ShouldStop(262144);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1332;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
Debug.ShouldStop(524288);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 10:
//C
this.state = 11;
;
 if (true) break;

case 11:
//C
this.state = 14;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 BA.debugLineNum = 1336;BA.debugLine="MsgboxAsync(\"Erro ao carregar as campanhas\", \"Er";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao carregar as campanhas")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1338;BA.debugLine="End Sub";
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
public static void  _listviewcuc_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewCUC_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,971);
if (RapidSub.canDelegate("listviewcuc_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewcuc_itemclick", _position, _value); return;}
ResumableSub_ListViewCUC_ItemClick rsub = new ResumableSub_ListViewCUC_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewCUC_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCUC_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewCUC_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,971);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 972;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELEC";
Debug.ShouldStop(2048);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT codigoCUC, descricaoCUC, row_number() OVER (order by idproduto_cuc) as row_num from unilever_pi.produto_cuc group by (codigoCUC)) t WHERE codigoCUC="),_value,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 973;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(4096);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 974;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
Debug.ShouldStop(8192);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 975;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewcuc_itemclick"), (parent._job1));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 BA.debugLineNum = 976;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(32768);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 977;BA.debugLine="EditTextDescricaoCUC.Text  = XMLwork.SubString2(X";
Debug.ShouldStop(65536);
parent.mostCurrent._edittextdescricaocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaoCUC>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaoCUC>")))))));
 BA.debugLineNum = 978;BA.debugLine="EditTextCodigoCuc.Text =  XMLwork.SubString2(XMLw";
Debug.ShouldStop(131072);
parent.mostCurrent._edittextcodigocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<codigoCUC>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</codigoCUC>")))))));
 BA.debugLineNum = 979;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
public static void  _listviewcucmain_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewCUCMain_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,981);
if (RapidSub.canDelegate("listviewcucmain_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewcucmain_itemclick", _position, _value); return;}
ResumableSub_ListViewCUCMain_ItemClick rsub = new ResumableSub_ListViewCUCMain_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewCUCMain_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCUCMain_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _xmlwork3 = RemoteObject.createImmutable("");
RemoteObject _count2 = RemoteObject.createImmutable(0);
RemoteObject _xmlcurrent2 = RemoteObject.createImmutable("");
int _x = 0;
int step16;
int limit16;
int step28;
int limit28;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewCUCMain_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,981);
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
 BA.debugLineNum = 982;BA.debugLine="If NivelUsuario=0 Then";
Debug.ShouldStop(2097152);
if (true) break;

case 1:
//if
this.state = 28;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._nivelusuario,BA.NumberToString(0))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 28;
 BA.debugLineNum = 983;BA.debugLine="MsgboxAsync(\"É necessario logar prmeiro\",\"Aviso\"";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("É necessario logar prmeiro")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 985;BA.debugLine="Try";
Debug.ShouldStop(16777216);
if (true) break;

case 6:
//try
this.state = 27;
this.catchState = 26;
this.state = 8;
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 26;
 BA.debugLineNum = 986;BA.debugLine="IdPesagemProg =  Value";
Debug.ShouldStop(33554432);
parent.mostCurrent._idpesagemprog = BA.ObjectToString(_value);
 BA.debugLineNum = 987;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
Debug.ShouldStop(67108864);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idCampanha, idPesagemProg, DataHora, Usuario, IdProcesso, Impresso, row_number() OVER (order by idCampanha) as row_num FROM unilever_pi.campanha WHERE idPesagemProg="),parent.mostCurrent._idpesagemprog,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 988;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
Debug.ShouldStop(134217728);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 989;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(268435456);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 990;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewcucmain_itemclick"), (parent._job1));
this.state = 29;
return;
case 29:
//C
this.state = 9;
;
 BA.debugLineNum = 991;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(1073741824);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 992;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 9:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 993;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(1);
parent._count = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));
 BA.debugLineNum = 994;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(";
Debug.ShouldStop(2);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 995;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Inde";
Debug.ShouldStop(4);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 5)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 BA.debugLineNum = 996;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(8);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 997;BA.debugLine="For i=1 To count-1";
Debug.ShouldStop(16);
if (true) break;

case 12:
//for
this.state = 23;
step16 = 1;
limit16 = RemoteObject.solve(new RemoteObject[] {parent._count,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
parent._i = BA.numberCast(int.class, 1) ;
this.state = 30;
if (true) break;

case 30:
//C
this.state = 23;
if ((step16 > 0 && parent._i.<Integer>get().intValue() <= limit16) || (step16 < 0 && parent._i.<Integer>get().intValue() >= limit16)) this.state = 14;
if (true) break;

case 31:
//C
this.state = 30;
parent._i = RemoteObject.createImmutable((int)(0 + parent._i.<Integer>get().intValue() + step16)) ;
if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 998;BA.debugLine="If i=1 Then";
Debug.ShouldStop(32);
if (true) break;

case 15:
//if
this.state = 22;
if (RemoteObject.solveBoolean("=",parent._i,BA.numberCast(double.class, 1))) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 999;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuery";
Debug.ShouldStop(64);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="),parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1000;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(128);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1001;BA.debugLine="Job1.GetRequest.SetContentType(\"application/";
Debug.ShouldStop(256);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1002;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewcucmain_itemclick"), (parent._job1));
this.state = 32;
return;
case 32:
//C
this.state = 18;
;
 BA.debugLineNum = 1003;BA.debugLine="Dim XMLwork3 As String = Job1.GetString";
Debug.ShouldStop(1024);
_xmlwork3 = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("XMLwork3", _xmlwork3);Debug.locals.put("XMLwork3", _xmlwork3);
 BA.debugLineNum = 1004;BA.debugLine="Dim count2 As Int = XMLwork3.SubString2(XMLw";
Debug.ShouldStop(2048);
_count2 = BA.numberCast(int.class, _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("<row_num>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</row_num>"))))));Debug.locals.put("count2", _count2);Debug.locals.put("count2", _count2);
 BA.debugLineNum = 1005;BA.debugLine="Dim XMLCurrent2 As String = XMLwork3.SubStri";
Debug.ShouldStop(4096);
_xmlcurrent2 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XMLCurrent2", _xmlcurrent2);Debug.locals.put("XMLCurrent2", _xmlcurrent2);
 BA.debugLineNum = 1006;BA.debugLine="Campanha =  XMLCurrent.SubString2(XMLCurrent";
Debug.ShouldStop(8192);
parent.mostCurrent._campanha = parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>")))));
 BA.debugLineNum = 1007;BA.debugLine="ListViewCUCPesagem.Clear";
Debug.ShouldStop(16384);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1008;BA.debugLine="ListProdutosPesagem.Clear";
Debug.ShouldStop(32768);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1009;BA.debugLine="For x=1 To count2-1";
Debug.ShouldStop(65536);
if (true) break;

case 18:
//for
this.state = 21;
step28 = 1;
limit28 = RemoteObject.solve(new RemoteObject[] {_count2,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_x = 1 ;
Debug.locals.put("x", _x);
this.state = 33;
if (true) break;

case 33:
//C
this.state = 21;
if ((step28 > 0 && _x <= limit28) || (step28 < 0 && _x >= limit28)) this.state = 20;
if (true) break;

case 34:
//C
this.state = 33;
_x = ((int)(0 + _x + step28)) ;
Debug.locals.put("x", _x);
if (true) break;

case 20:
//C
this.state = 34;
 BA.debugLineNum = 1010;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent2.SubStri";
Debug.ShouldStop(131072);
parent.mostCurrent._listprodutospesagem.runVoidMethod ("Add",(Object)((_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1011;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurren";
Debug.ShouldStop(262144);
parent.mostCurrent._listviewcucpesagem.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoMaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoMaterial>"))))).runMethod(true,"trim"),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Peso>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Peso>"))))),RemoteObject.createImmutable(" "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<EmbFechada>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</EmbFechada>"))))),RemoteObject.createImmutable(" "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>"))))),RemoteObject.createImmutable(" ("),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<UnidadeEmb>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</UnidadeEmb>"))))),RemoteObject.createImmutable(") | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota1>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota1>"))))),RemoteObject.createImmutable(" | "),_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota2>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota2>")))))))),(Object)((_xmlcurrent2.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<CodigoMaterial>"))),RemoteObject.createImmutable(16)}, "+",1, 1)),(Object)(_xmlcurrent2.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</CodigoMaterial>"))))))));
 BA.debugLineNum = 1012;BA.debugLine="XMLwork3 = XMLwork3.SubString(XMLwork3.Inde";
Debug.ShouldStop(524288);
_xmlwork3 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));Debug.locals.put("XMLwork3", _xmlwork3);
 BA.debugLineNum = 1013;BA.debugLine="XMLCurrent2 =  XMLwork3.SubString2(XMLwork3";
Debug.ShouldStop(1048576);
_xmlcurrent2 = _xmlwork3.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(_xmlwork3.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));Debug.locals.put("XMLCurrent2", _xmlcurrent2);
 if (true) break;
if (true) break;

case 21:
//C
this.state = 22;
Debug.locals.put("x", _x);
;
 if (true) break;

case 22:
//C
this.state = 31;
;
 BA.debugLineNum = 1016;BA.debugLine="ListViewCampanha.AddSingleLine2(XMLCurrent.Sub";
Debug.ShouldStop(8388608);
parent.mostCurrent._listviewcampanha.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))))),(Object)((parent.mostCurrent._xmlcurrent.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idCampanha>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlcurrent.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idCampanha>"))))))));
 BA.debugLineNum = 1017;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
Debug.ShouldStop(16777216);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1018;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
Debug.ShouldStop(33554432);
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>"))),RemoteObject.createImmutable(5)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</SQL>")))));
 if (true) break;
if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = 27;
;
 BA.debugLineNum = 1021;BA.debugLine="panelPesagem.Visible =  True";
Debug.ShouldStop(268435456);
parent.mostCurrent._panelpesagem.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 1022;BA.debugLine="panelMain.Visible =  False";
Debug.ShouldStop(536870912);
parent.mostCurrent._panelmain.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
if (true) break;

case 26:
//C
this.state = 27;
this.catchState = 0;
 BA.debugLineNum = 1024;BA.debugLine="MsgboxAsync(\"Erro ao carregar os produtos.\",\"Er";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao carregar os produtos.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 27:
//C
this.state = 28;
this.catchState = 0;
;
 if (true) break;

case 28:
//C
this.state = -1;
;
 BA.debugLineNum = 1027;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
public static void  _listviewcucpesagem_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewCUCPesagem_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1393);
if (RapidSub.canDelegate("listviewcucpesagem_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewcucpesagem_itemclick", _position, _value); return;}
ResumableSub_ListViewCUCPesagem_ItemClick rsub = new ResumableSub_ListViewCUCPesagem_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewCUCPesagem_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCUCPesagem_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewCUCPesagem_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1393);
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
 BA.debugLineNum = 1394;BA.debugLine="Try";
Debug.ShouldStop(131072);
if (true) break;

case 1:
//try
this.state = 14;
this.catchState = 13;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 13;
 BA.debugLineNum = 1395;BA.debugLine="Cod = Value";
Debug.ShouldStop(262144);
parent.mostCurrent._cod = BA.ObjectToString(_value);
 BA.debugLineNum = 1396;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(524288);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="),parent.mostCurrent._campanha,RemoteObject.createImmutable(" AND CodigoMaterial="),_value,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1397;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1398;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(2097152);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1399;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewcucpesagem_itemclick"), (parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 BA.debugLineNum = 1400;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(8388608);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1401;BA.debugLine="If XMLwork.Contains(\"<SQL>\")= True Then";
Debug.ShouldStop(16777216);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 1402;BA.debugLine="PesoRota1 = XMLwork.SubString2(XMLwork.IndexOf(";
Debug.ShouldStop(33554432);
parent._pesorota1 = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoRota1>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoRota1>"))))));
 BA.debugLineNum = 1403;BA.debugLine="EmbFechada = XMLwork.SubString2(XMLwork.IndexOf";
Debug.ShouldStop(67108864);
parent._embfechada = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<EmbFechada>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</EmbFechada>"))))));
 BA.debugLineNum = 1404;BA.debugLine="PesoAlvo = XMLwork.SubString2(XMLwork.IndexOf(\"";
Debug.ShouldStop(134217728);
parent._pesoalvo = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Peso>"))),RemoteObject.createImmutable(6)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Peso>"))))).runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 1405;BA.debugLine="UnidadeAlvo = XMLwork.SubString2(XMLwork.IndexO";
Debug.ShouldStop(268435456);
parent.mostCurrent._unidadealvo = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>")))));
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 1407;BA.debugLine="PesoAlvo = PesoAlvo-PesoRota1";
Debug.ShouldStop(1073741824);
parent._pesoalvo = RemoteObject.solve(new RemoteObject[] {parent._pesoalvo,parent._pesorota1}, "-",1, 0);
 BA.debugLineNum = 1408;BA.debugLine="UnidadeAlvo =  \"G\"";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._unidadealvo = BA.ObjectToString("G");
 BA.debugLineNum = 1409;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(1);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT (pesoMinimo-Tolerancia) As PesoMinimo, (pesoMaximo+Tolerancia) As PesoMaximo FROM unilever_pi.tolerancia WHERE "),parent._pesoalvo,RemoteObject.createImmutable(" >= PesoMinimo AND "),parent._pesoalvo,RemoteObject.createImmutable(" <= PesoMaximo AND UM='"),parent.mostCurrent._unidadealvo,RemoteObject.createImmutable("' LIMIT 1;"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1410;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(2);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1411;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(4);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1412;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewcucpesagem_itemclick"), (parent._job1));
this.state = 16;
return;
case 16:
//C
this.state = 8;
;
 BA.debugLineNum = 1413;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(16);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1414;BA.debugLine="Job1.Release";
Debug.ShouldStop(32);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 1415;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(64);
if (true) break;

case 8:
//if
this.state = 11;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 1416;BA.debugLine="ToleranciaMinimo = XMLwork.SubString2(XMLwork.I";
Debug.ShouldStop(128);
parent._toleranciaminimo = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoMinimo>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoMinimo>"))))));
 BA.debugLineNum = 1417;BA.debugLine="ToleranciaMaximo = XMLwork.SubString2(XMLwork.I";
Debug.ShouldStop(256);
parent._toleranciamaximo = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoMaximo>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoMaximo>"))))));
 if (true) break;

case 11:
//C
this.state = 14;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 BA.debugLineNum = 1420;BA.debugLine="MsgboxAsync(\"Erro ao carregar as campanhas\", \"Er";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao carregar as campanhas")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1422;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
public static void  _listviewprodutoscuc_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewProdutosCUC_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,919);
if (RapidSub.canDelegate("listviewprodutoscuc_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewprodutoscuc_itemclick", _position, _value); return;}
ResumableSub_ListViewProdutosCUC_ItemClick rsub = new ResumableSub_ListViewProdutosCUC_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewProdutosCUC_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewProdutosCUC_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewProdutosCUC_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,919);
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
 BA.debugLineNum = 920;BA.debugLine="Try";
Debug.ShouldStop(8388608);
if (true) break;

case 1:
//try
this.state = 6;
this.catchState = 5;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 6;
this.catchState = 5;
 BA.debugLineNum = 921;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(16777216);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, row_number() OVER (order by idproduto_cuc) as row_num from unilever_pi.produto_cuc) t WHERE codigomaterial="),_value,RemoteObject.createImmutable(" AND codigoCUC="),parent.mostCurrent._edittextcodigocuc.runMethod(true,"getText"),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 922;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(33554432);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 923;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(67108864);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 924;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewprodutoscuc_itemclick"), (parent._job1));
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 BA.debugLineNum = 925;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(268435456);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 926;BA.debugLine="EditTextPordutoCUC.Text =  EditTextDescricaoCUC.";
Debug.ShouldStop(536870912);
parent.mostCurrent._edittextpordutocuc.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._edittextdescricaocuc.runMethod(true,"getText")));
 BA.debugLineNum = 927;BA.debugLine="EditTextNomeProduto.Text  = XMLwork.SubString2(X";
Debug.ShouldStop(1073741824);
parent.mostCurrent._edittextnomeproduto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<descricaomaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</descricaomaterial>")))))));
 BA.debugLineNum = 928;BA.debugLine="EditTextCodigoProduto.Text = Value";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._edittextcodigoproduto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 929;BA.debugLine="EditTextCodigoCUCTela.Text =  EditTextCodigoCuc.";
Debug.ShouldStop(1);
parent.mostCurrent._edittextcodigocuctela.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._edittextcodigocuc.runMethod(true,"getText")));
 Debug.CheckDeviceExceptions();
if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 BA.debugLineNum = 931;BA.debugLine="MsgboxAsync(\"Erro ao ler.\",\"Erro\")";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Erro ao ler.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Erro"))),main.processBA);
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 933;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
public static void  _listviewtelabalanca_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewTelaBalanca_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1202);
if (RapidSub.canDelegate("listviewtelabalanca_itemclick")) { wrong.addition.main.remoteMe.runUserSub(false, "main","listviewtelabalanca_itemclick", _position, _value); return;}
ResumableSub_ListViewTelaBalanca_ItemClick rsub = new ResumableSub_ListViewTelaBalanca_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ListViewTelaBalanca_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewTelaBalanca_ItemClick(wrong.addition.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ListViewTelaBalanca_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1202);
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
 BA.debugLineNum = 1203;BA.debugLine="Try";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//try
this.state = 12;
this.catchState = 11;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 11;
 BA.debugLineNum = 1204;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
Debug.ShouldStop(524288);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE idBalancas="),_value,RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1205;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1206;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
Debug.ShouldStop(2097152);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1207;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listviewtelabalanca_itemclick"), (parent._job1));
this.state = 13;
return;
case 13:
//C
this.state = 4;
;
 BA.debugLineNum = 1208;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(8388608);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1209;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
Debug.ShouldStop(16777216);
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<SQL>")))),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("</SQL>"))),RemoteObject.createImmutable(6)}, "+",1, 1)));
 BA.debugLineNum = 1210;BA.debugLine="EditTextNomeBalanca.Text = \"Balança \"&XMLwork.Su";
Debug.ShouldStop(33554432);
parent.mostCurrent._edittextnomebalanca.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Balança "),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<idbalancas>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</idbalancas>"))))),RemoteObject.createImmutable(" ("),parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),RemoteObject.createImmutable(")"))));
 BA.debugLineNum = 1211;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
Debug.ShouldStop(67108864);
parent.mostCurrent._edittextip.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<ipbalanca>"))),RemoteObject.createImmutable(11)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</ipbalanca>")))))));
 BA.debugLineNum = 1212;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(134217728);
parent.mostCurrent._edittextporta.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<portabalanca>"))),RemoteObject.createImmutable(14)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</portabalanca>")))))));
 BA.debugLineNum = 1213;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwor";
Debug.ShouldStop(268435456);
parent.mostCurrent._edittextdivisor.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>")))))));
 BA.debugLineNum = 1214;BA.debugLine="EditTextDecimais.Text = XMLwork.SubString2(XMLwo";
Debug.ShouldStop(536870912);
parent.mostCurrent._edittextdecimais.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<decimais>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</decimais>")))))));
 BA.debugLineNum = 1215;BA.debugLine="decimal = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
Debug.ShouldStop(1073741824);
parent._decimal = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<decimais>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</decimais>"))))));
 BA.debugLineNum = 1216;BA.debugLine="divisor = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
Debug.ShouldStop(-2147483648);
parent._divisor = BA.numberCast(int.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<divisor>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</divisor>"))))));
 BA.debugLineNum = 1217;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipopes";
Debug.ShouldStop(1);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<tipopeso>"))),RemoteObject.createImmutable(10)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</tipopeso>"))))),BA.ObjectToString("g"))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 1218;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(2);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1219;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(4);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 1220;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(8);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 1221;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(16);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1223;BA.debugLine="ListViewTipoPesagem.Clear";
Debug.ShouldStop(64);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("Clear");
 BA.debugLineNum = 1224;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
Debug.ShouldStop(128);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("kg"))));
 BA.debugLineNum = 1225;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
Debug.ShouldStop(256);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("g"))));
 BA.debugLineNum = 1226;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
Debug.ShouldStop(512);
parent.mostCurrent._listviewtipopesagem.runVoidMethod ("SetSelection",(Object)(BA.numberCast(int.class, 0)));
 if (true) break;

case 9:
//C
this.state = 12;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 0;
 BA.debugLineNum = 1229;BA.debugLine="MsgboxAsync(\"Eoo ao carregar a balança.\",\"Aviso\"";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Eoo ao carregar a balança.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Aviso"))),main.processBA);
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 1231;BA.debugLine="End Sub";
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
public static RemoteObject  _listviewtipopesagem_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListViewTipoPesagem_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1233);
if (RapidSub.canDelegate("listviewtipopesagem_itemclick")) { return wrong.addition.main.remoteMe.runUserSub(false, "main","listviewtipopesagem_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 1233;BA.debugLine="Sub ListViewTipoPesagem_ItemClick (Position As Int";
Debug.ShouldStop(65536);
 BA.debugLineNum = 1234;BA.debugLine="listPosition =  Value";
Debug.ShouldStop(131072);
main.mostCurrent._listposition = BA.ObjectToString(_value);
 BA.debugLineNum = 1235;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _myabbarcode_barcodefound(RemoteObject _barcode,RemoteObject _formatname) throws Exception{
try {
		Debug.PushSubsStack("myABBarcode_BarcodeFound (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1048);
if (RapidSub.canDelegate("myabbarcode_barcodefound")) { wrong.addition.main.remoteMe.runUserSub(false, "main","myabbarcode_barcodefound", _barcode, _formatname); return;}
ResumableSub_myABBarcode_BarcodeFound rsub = new ResumableSub_myABBarcode_BarcodeFound(null,_barcode,_formatname);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_myABBarcode_BarcodeFound extends BA.ResumableSub {
public ResumableSub_myABBarcode_BarcodeFound(wrong.addition.main parent,RemoteObject _barcode,RemoteObject _formatname) {
this.parent = parent;
this._barcode = _barcode;
this._formatname = _formatname;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
wrong.addition.main parent;
RemoteObject _barcode;
RemoteObject _formatname;
RemoteObject _lote = RemoteObject.createImmutable("");
RemoteObject _cod2 = RemoteObject.createImmutable(0);
RemoteObject _url = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("myABBarcode_BarcodeFound (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1048);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("barCode", _barcode);
Debug.locals.put("formatName", _formatname);
 BA.debugLineNum = 1049;BA.debugLine="If barCode.Length=32 Then";
Debug.ShouldStop(16777216);
if (true) break;

case 1:
//if
this.state = 22;
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"length"),BA.numberCast(double.class, 32))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 22;
 BA.debugLineNum = 1050;BA.debugLine="barCode =  barCode.SubString2(16,32)";
Debug.ShouldStop(33554432);
_barcode = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 32)));Debug.locals.put("barCode", _barcode);
 BA.debugLineNum = 1051;BA.debugLine="EditTextValidadePdoruo.Text = barCode.SubString2";
Debug.ShouldStop(67108864);
parent.mostCurrent._edittextvalidadepdoruo.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 1052;BA.debugLine="EditTextValidadePdoruo.Text = EditTextValidadePd";
Debug.ShouldStop(134217728);
parent.mostCurrent._edittextvalidadepdoruo.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._edittextvalidadepdoruo.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable("/"),parent.mostCurrent._edittextvalidadepdoruo.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/"),parent.mostCurrent._edittextvalidadepdoruo.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 1053;BA.debugLine="EditTextFabricacao.Text = barCode.SubString(10)";
Debug.ShouldStop(268435456);
parent.mostCurrent._edittextfabricacao.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 1054;BA.debugLine="EditTextFabricacao.Text = EditTextFabricacao.Tex";
Debug.ShouldStop(536870912);
parent.mostCurrent._edittextfabricacao.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._edittextfabricacao.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 4)),(Object)(BA.numberCast(int.class, 6))),RemoteObject.createImmutable("/"),parent.mostCurrent._edittextfabricacao.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 4))),RemoteObject.createImmutable("/"),parent.mostCurrent._edittextfabricacao.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 1056;BA.debugLine="If barCode.StartsWith(\"90\") = True Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 6:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_barcode.runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("90"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 8;
}else {
this.state = 20;
}if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 1057;BA.debugLine="Cod = barCode.SubString2(2,10)";
Debug.ShouldStop(1);
parent.mostCurrent._cod = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 10)));
 BA.debugLineNum = 1058;BA.debugLine="Dim lote As String =  barCode.SubString(20)";
Debug.ShouldStop(2);
_lote = _barcode.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("lote", _lote);Debug.locals.put("lote", _lote);
 BA.debugLineNum = 1059;BA.debugLine="EditTextLote.Text =  lote";
Debug.ShouldStop(4);
parent.mostCurrent._edittextlote.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_lote));
 BA.debugLineNum = 1060;BA.debugLine="EditTextProduto.Text = Cod";
Debug.ShouldStop(8);
parent.mostCurrent._edittextproduto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._cod));
 BA.debugLineNum = 1061;BA.debugLine="Dim cod2 As Double = Cod";
Debug.ShouldStop(16);
_cod2 = BA.numberCast(double.class, parent.mostCurrent._cod);Debug.locals.put("cod2", _cod2);Debug.locals.put("cod2", _cod2);
 BA.debugLineNum = 1062;BA.debugLine="Cod = cod2";
Debug.ShouldStop(32);
parent.mostCurrent._cod = BA.NumberToString(_cod2);
 BA.debugLineNum = 1063;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
Debug.ShouldStop(64);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT * FROM unilever_pi.produto_cuc WHERE CodigoCUC="),parent.mostCurrent._campanha,RemoteObject.createImmutable(" AND CodigoMaterial="),RemoteObject.createImmutable("1874"),RemoteObject.createImmutable(";"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1064;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(128);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1065;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
Debug.ShouldStop(256);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1066;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "myabbarcode_barcodefound"), (parent._job1));
this.state = 23;
return;
case 23:
//C
this.state = 9;
;
 BA.debugLineNum = 1067;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(1024);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1068;BA.debugLine="Job1.Release";
Debug.ShouldStop(2048);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 1069;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(4096);
if (true) break;

case 9:
//if
this.state = 14;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 11;
}else {
this.state = 13;
}if (true) break;

case 11:
//C
this.state = 14;
 BA.debugLineNum = 1070;BA.debugLine="EditTextProduto.Text = XMLwork.SubString2(XMLw";
Debug.ShouldStop(8192);
parent.mostCurrent._edittextproduto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<DescricaoMaterial>"))),RemoteObject.createImmutable(19)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</DescricaoMaterial>")))))));
 BA.debugLineNum = 1071;BA.debugLine="Peso = XMLwork.SubString2(XMLwork.IndexOf(\"<Qu";
Debug.ShouldStop(16384);
parent._peso = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Quant>"))),RemoteObject.createImmutable(7)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Quant>"))))));
 BA.debugLineNum = 1072;BA.debugLine="UnidadePeso = XMLwork.SubString2(XMLwork.Index";
Debug.ShouldStop(32768);
parent.mostCurrent._unidadepeso = parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<Unidade>"))),RemoteObject.createImmutable(9)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</Unidade>")))));
 if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 1074;BA.debugLine="EditTextProduto.Text = Cod";
Debug.ShouldStop(131072);
parent.mostCurrent._edittextproduto.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._cod));
 if (true) break;

case 14:
//C
this.state = 15;
;
 BA.debugLineNum = 1076;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
Debug.ShouldStop(524288);
_url = RemoteObject.concat(parent.mostCurrent._urlglobal,RemoteObject.createImmutable("/ExecQuerySELECT (pesoMinimo-Tolerancia) As PesoMinimo, (pesoMaximo+Tolerancia) As PesoMaximo FROM unilever_pi.tolerancia WHERE "),parent._peso,RemoteObject.createImmutable(" >= PesoMinimo AND "),parent._peso,RemoteObject.createImmutable(" <= PesoMinimo AND UM='"),parent.mostCurrent._unidadepeso,RemoteObject.createImmutable("';"));Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 1077;BA.debugLine="Job1.PostString(url,\"\")";
Debug.ShouldStop(1048576);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_url),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1078;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
Debug.ShouldStop(2097152);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/XML")));
 BA.debugLineNum = 1079;BA.debugLine="Wait For (Job1) JobDone";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "myabbarcode_barcodefound"), (parent._job1));
this.state = 24;
return;
case 24:
//C
this.state = 15;
;
 BA.debugLineNum = 1080;BA.debugLine="XMLwork = Job1.GetString";
Debug.ShouldStop(8388608);
parent.mostCurrent._xmlwork = parent._job1.runClassMethod (wrong.addition.httpjob.class, "_getstring" /*RemoteObject*/ );
 BA.debugLineNum = 1081;BA.debugLine="Job1.Release";
Debug.ShouldStop(16777216);
parent._job1.runClassMethod (wrong.addition.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 1082;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
Debug.ShouldStop(33554432);
if (true) break;

case 15:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._xmlwork.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("<SQL>"))),parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 1083;BA.debugLine="ToleranciaMinimo =  XMLwork.SubString2(XMLwork";
Debug.ShouldStop(67108864);
parent._toleranciaminimo = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoMinimo>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoMinimo>"))))).runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable(""))));
 BA.debugLineNum = 1084;BA.debugLine="ToleranciaMaximo = XMLwork.SubString2(XMLwork.";
Debug.ShouldStop(134217728);
parent._toleranciamaximo = BA.numberCast(double.class, parent.mostCurrent._xmlwork.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("<PesoMaximo>"))),RemoteObject.createImmutable(12)}, "+",1, 1)),(Object)(parent.mostCurrent._xmlwork.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable("</PesoMaximo>"))))).runMethod(true,"replace",(Object)(BA.ObjectToString(".")),(Object)(RemoteObject.createImmutable(""))));
 if (true) break;

case 18:
//C
this.state = 21;
;
 if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 1087;BA.debugLine="MsgboxAsync(barCode,\"Enviado ao Webservice\")";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence(_barcode)),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Enviado ao Webservice"))),main.processBA);
 if (true) break;

case 21:
//C
this.state = 22;
;
 if (true) break;

case 22:
//C
this.state = -1;
;
 BA.debugLineNum = 1090;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("wrong.addition.main");
starter.myClass = BA.getDeviceClass ("wrong.addition.starter");
httputils2service.myClass = BA.getDeviceClass ("wrong.addition.httputils2service");
httpjob.myClass = BA.getDeviceClass ("wrong.addition.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim socket1 As Socket";
main._socket1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim Job1 As HttpJob";
main._job1 = RemoteObject.createNew ("wrong.addition.httpjob");
 //BA.debugLineNum = 18;BA.debugLine="Dim sql1 As SQL";
main._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 19;BA.debugLine="Dim cursor As Cursor";
main._cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}