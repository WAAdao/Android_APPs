package unileverSU.pesagem;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "unileverSU.pesagem", "unileverSU.pesagem.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "unileverSU.pesagem", "unileverSU.pesagem.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "unileverSU.pesagem.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
public com.AB.ABZxing.ABZxing _myabbarcode = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public static String _xmlwork = "";
public static String _url = "";
public anywheresoftware.b4a.objects.ImageViewWrapper _imageviewaplipack = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageviewunilever = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelclocktv = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelop = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelpesgaemttitulo = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewop = null;
public static String _idordemprodlist = "";
public static String _idordemprodlistcompare = "";
public anywheresoftware.b4a.objects.ListViewWrapper _listviewavisos = null;
public unileverSU.pesagem.b4xtable _b4xtablepesagem = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelpesagem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop0 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop4 = null;
public static int _opselecionadabutton = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonbarcodescan = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonclearbarcode = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextbarcode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonrota1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonrota2 = null;
public static int _rotaselcionada = 0;
public static String _idsscc = "";
public static String _idproduto = "";
public static String _sscc = "";
public anywheresoftware.b4a.objects.ButtonWrapper _buttongravar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlimpar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextlinha = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextwebservice = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelmain = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelsettings = null;
public anywheresoftware.b4a.objects.PanelWrapper _panellogin = null;
public static String _addresswebservice = "";
public static String _nometerminal = "";
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlimparlogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarlogin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextsenhalogin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextusuariologin = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelclocklogin = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelpesagem2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoncancelarpesagem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonconcluirpesagem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttondesligarbomba = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonligarbomba = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelfuncaobomba = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarpesagem = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewavisopesagem = null;
public static String _xerro = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edittextpesorequerido = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextpesobomba = null;
public static boolean _statusbomba = false;
public static boolean _finalizadodosagem = false;
public static boolean _habilitaimpressaoetq = false;
public static String _impressoraip = "";
public static String _impressoraporta = "";
public static String _zpletiqueta = "";
public static boolean _retornobalancastatus = false;
public static boolean _retorno_bomba = false;
public static String _xml_bombastatus = "";
public static boolean _login_status = false;
public static String _current_user = "";
public static String _current_pwd = "";
public static String _current_bombaid = "";
public static String _prefix_bomba = "";
public static String _prefix_balanca = "";
public static String _prefix_clp = "";
public static String _peso = "";
public unileverSU.pesagem.b4xtable._b4xtablecolumn _col1 = null;
public unileverSU.pesagem.b4xtable._b4xtablecolumn _col2 = null;
public unileverSU.pesagem.b4xtable._b4xtablecolumn _col3 = null;
public unileverSU.pesagem.b4xtable._b4xtablecolumn _col4 = null;
public unileverSU.pesagem.b4xtable._b4xtablecolumn _col5 = null;
public unileverSU.pesagem.b4xtable._b4xtablecolumn _col6 = null;
public b4a.example.dateutils _dateutils = null;
public unileverSU.pesagem.autostart _autostart = null;
public unileverSU.pesagem.starter _starter = null;
public unileverSU.pesagem.httputils2service _httputils2service = null;
public unileverSU.pesagem.xuiviewsutils _xuiviewsutils = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(unileverSU.pesagem.main parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
unileverSU.pesagem.main parent;
boolean _firsttime;
String _filename = "";
anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 142;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 13;
this.catchState = 12;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 12;
 //BA.debugLineNum = 143;BA.debugLine="PanelMain.Initialize(\"\") : PanelMain.Visible = T";
parent.mostCurrent._panelmain.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 143;BA.debugLine="PanelMain.Initialize(\"\") : PanelMain.Visible = T";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 144;BA.debugLine="PanelMain.LoadLayout(\"Layout2\")";
parent.mostCurrent._panelmain.LoadLayout("Layout2",mostCurrent.activityBA);
 //BA.debugLineNum = 145;BA.debugLine="Activity.AddView(PanelMain, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelmain.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 147;BA.debugLine="PanelSettings.Initialize(\"\") : PanelSettings.Vis";
parent.mostCurrent._panelsettings.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 147;BA.debugLine="PanelSettings.Initialize(\"\") : PanelSettings.Vis";
parent.mostCurrent._panelsettings.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 148;BA.debugLine="PanelSettings.LoadLayout(\"Settings\")";
parent.mostCurrent._panelsettings.LoadLayout("Settings",mostCurrent.activityBA);
 //BA.debugLineNum = 149;BA.debugLine="Activity.AddView(PanelSettings, 0, 0, 100%x, 100";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelsettings.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 151;BA.debugLine="PanelLogin.Initialize(\"\") : PanelLogin.Visible =";
parent.mostCurrent._panellogin.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 151;BA.debugLine="PanelLogin.Initialize(\"\") : PanelLogin.Visible =";
parent.mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 152;BA.debugLine="PanelLogin.LoadLayout(\"Login\")";
parent.mostCurrent._panellogin.LoadLayout("Login",mostCurrent.activityBA);
 //BA.debugLineNum = 153;BA.debugLine="Activity.AddView(PanelLogin, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panellogin.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 155;BA.debugLine="PanelPesagem2.Initialize(\"\") : PanelPesagem2.Vis";
parent.mostCurrent._panelpesagem2.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 155;BA.debugLine="PanelPesagem2.Initialize(\"\") : PanelPesagem2.Vis";
parent.mostCurrent._panelpesagem2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 156;BA.debugLine="PanelPesagem2.LoadLayout(\"Pesagem\")";
parent.mostCurrent._panelpesagem2.LoadLayout("Pesagem",mostCurrent.activityBA);
 //BA.debugLineNum = 157;BA.debugLine="Activity.AddView(PanelPesagem2, 0, 0, 100%x, 100";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelpesagem2.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 160;BA.debugLine="Dim Filename As String";
_filename = "";
 //BA.debugLineNum = 161;BA.debugLine="Filename  = \"dataterminalpesagem5.db\"";
_filename = "dataterminalpesagem5.db";
 //BA.debugLineNum = 162;BA.debugLine="If File.Exists(File.DirInternal,Filename) = Fals";
if (true) break;

case 4:
//if
this.state = 7;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename)==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 163;BA.debugLine="File.Copy(File.DirAssets,Filename,File.DirInter";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename);
 if (true) break;
;
 //BA.debugLineNum = 166;BA.debugLine="If sql1.IsInitialized = False Then";

case 7:
//if
this.state = 10;
if (parent._sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 167;BA.debugLine="sql1.Initialize(File.DirInternal, Filename, Fal";
parent._sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_filename,anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 10:
//C
this.state = 13;
;
 //BA.debugLineNum = 170;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
parent._cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent._sql1.ExecQuery("SELECT NomeTerminal, EnderecoWebservice FROM Data WHERE id=1;")));
 //BA.debugLineNum = 171;BA.debugLine="cursor.Position = 0";
parent._cursor.setPosition((int) (0));
 //BA.debugLineNum = 172;BA.debugLine="NomeTerminal = cursor.GetString2(0).Trim";
parent.mostCurrent._nometerminal = parent._cursor.GetString2((int) (0)).trim();
 //BA.debugLineNum = 173;BA.debugLine="AddressWebservice = cursor.GetString2(1)";
parent.mostCurrent._addresswebservice = parent._cursor.GetString2((int) (1));
 //BA.debugLineNum = 176;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 14;
return;
case 14:
//C
this.state = 13;
;
 //BA.debugLineNum = 179;BA.debugLine="ListViewOP.TwoLinesLayout.ItemHeight =  45dip '7";
parent.mostCurrent._listviewop.getTwoLinesLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (45)));
 //BA.debugLineNum = 181;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 190;BA.debugLine="col1 = B4XTablePesagem.AddColumn(\"Material\",B4XT";
parent.mostCurrent._col1 = parent.mostCurrent._b4xtablepesagem._addcolumn /*unileverSU.pesagem.b4xtable._b4xtablecolumn*/ ("Material",parent.mostCurrent._b4xtablepesagem._column_type_text /*int*/ );
 //BA.debugLineNum = 191;BA.debugLine="col2 = B4XTablePesagem.AddColumn(\"Unidade\", B4XT";
parent.mostCurrent._col2 = parent.mostCurrent._b4xtablepesagem._addcolumn /*unileverSU.pesagem.b4xtable._b4xtablecolumn*/ ("Unidade",parent.mostCurrent._b4xtablepesagem._column_type_text /*int*/ );
 //BA.debugLineNum = 192;BA.debugLine="col3 = B4XTablePesagem.AddColumn(\"P. Requerido\",";
parent.mostCurrent._col3 = parent.mostCurrent._b4xtablepesagem._addcolumn /*unileverSU.pesagem.b4xtable._b4xtablecolumn*/ ("P. Requerido",parent.mostCurrent._b4xtablepesagem._column_type_text /*int*/ );
 //BA.debugLineNum = 193;BA.debugLine="col4 = B4XTablePesagem.AddColumn(\"Rota 1\",B4XTab";
parent.mostCurrent._col4 = parent.mostCurrent._b4xtablepesagem._addcolumn /*unileverSU.pesagem.b4xtable._b4xtablecolumn*/ ("Rota 1",parent.mostCurrent._b4xtablepesagem._column_type_text /*int*/ );
 //BA.debugLineNum = 194;BA.debugLine="col5 = B4XTablePesagem.AddColumn(\"Rota 2\",B4XTab";
parent.mostCurrent._col5 = parent.mostCurrent._b4xtablepesagem._addcolumn /*unileverSU.pesagem.b4xtable._b4xtablecolumn*/ ("Rota 2",parent.mostCurrent._b4xtablepesagem._column_type_text /*int*/ );
 //BA.debugLineNum = 195;BA.debugLine="col6 = B4XTablePesagem.AddColumn(\"Bomba\",B4XTabl";
parent.mostCurrent._col6 = parent.mostCurrent._b4xtablepesagem._addcolumn /*unileverSU.pesagem.b4xtable._b4xtablecolumn*/ ("Bomba",parent.mostCurrent._b4xtablepesagem._column_type_text /*int*/ );
 //BA.debugLineNum = 198;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 199;BA.debugLine="B4XTablePesagem.HeaderFont = xui.CreateDefaultBo";
parent.mostCurrent._b4xtablepesagem._headerfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xui.CreateDefaultBoldFont((float) (10));
 //BA.debugLineNum = 200;BA.debugLine="B4XTablePesagem.LabelsFont = xui.CreateDefaultFo";
parent.mostCurrent._b4xtablepesagem._labelsfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xui.CreateDefaultFont((float) (8));
 //BA.debugLineNum = 204;BA.debugLine="Clock(True)";
_clock(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 205;BA.debugLine="GetOPselecionada(True)";
_getopselecionada(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 206;BA.debugLine="GetReceita(True)";
_getreceita(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 207;BA.debugLine="ButtonOP0.Color = Colors.Red";
parent.mostCurrent._buttonop0.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 208;BA.debugLine="ButtonOP1.Color = Colors.Green";
parent.mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 209;BA.debugLine="ButtonOP2.Color = Colors.Red";
parent.mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 210;BA.debugLine="ButtonOP3.Color = Colors.Red";
parent.mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 211;BA.debugLine="ButtonOP4.Color = Colors.Red";
parent.mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 212;BA.debugLine="OPSelecionadaButton = 1";
parent._opselecionadabutton = (int) (1);
 //BA.debugLineNum = 213;BA.debugLine="LabelFuncaoBomba.Color = Colors.Red";
parent.mostCurrent._labelfuncaobomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 214;BA.debugLine="StatusBomba = False";
parent._statusbomba = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 217;BA.debugLine="ButtonRota1.Color = Colors.Green";
parent.mostCurrent._buttonrota1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 218;BA.debugLine="ButtonRota2.Color = Colors.Red";
parent.mostCurrent._buttonrota2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 219;BA.debugLine="RotaSelcionada = 1";
parent._rotaselcionada = (int) (1);
 //BA.debugLineNum = 223;BA.debugLine="URL = \"http://10.0.2.30:4000/WSWrongAdditionSU.a";
parent.mostCurrent._url = "http://10.0.2.30:4000/WSWrongAdditionSU.asmx";
 //BA.debugLineNum = 226;BA.debugLine="CFG_Prefixos";
_cfg_prefixos();
 if (true) break;

case 12:
//C
this.state = 13;
this.catchState = 0;
 //BA.debugLineNum = 228;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5131159",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 229;BA.debugLine="ToastMessageShow(LastException,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 13:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _activity_pause(boolean _userclosed) throws Exception{
ResumableSub_Activity_Pause rsub = new ResumableSub_Activity_Pause(null,_userclosed);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Pause extends BA.ResumableSub {
public ResumableSub_Activity_Pause(unileverSU.pesagem.main parent,boolean _userclosed) {
this.parent = parent;
this._userclosed = _userclosed;
}
unileverSU.pesagem.main parent;
boolean _userclosed;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 241;BA.debugLine="Do While UserClosed = True";
if (true) break;

case 1:
//do while
this.state = 4;
while (_userclosed==anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 242;BA.debugLine="Sleep(1000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (1000));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 243;BA.debugLine="Clock(False)";
_clock(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 244;BA.debugLine="GetOPselecionada(False)";
_getopselecionada(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 245;BA.debugLine="GetReceita(False)";
_getreceita(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 234;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 235;BA.debugLine="Clock(True)";
_clock(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 236;BA.debugLine="GetOPselecionada(True)";
_getopselecionada(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 237;BA.debugLine="GetReceita(False)";
_getreceita(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public static String  _b4xtablepesagem_cellclicked(String _columnid,long _rowid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _rowdata = null;
String _produto = "";
String _bomba = "";
String _mensagem = "";
int _i = 0;
 //BA.debugLineNum = 604;BA.debugLine="Sub B4XTablePesagem_CellClicked (ColumnId As Strin";
 //BA.debugLineNum = 605;BA.debugLine="Dim RowData As Map = B4XTablePesagem.GetRow(RowId";
_rowdata = new anywheresoftware.b4a.objects.collections.Map();
_rowdata = mostCurrent._b4xtablepesagem._getrow /*anywheresoftware.b4a.objects.collections.Map*/ (_rowid);
 //BA.debugLineNum = 607;BA.debugLine="Dim Produto As String = RowData.Get(\"Material\")";
_produto = BA.ObjectToString(_rowdata.Get((Object)("Material")));
 //BA.debugLineNum = 610;BA.debugLine="Peso = RowData.Get(\"P. Requerido\")";
mostCurrent._peso = BA.ObjectToString(_rowdata.Get((Object)("P. Requerido")));
 //BA.debugLineNum = 611;BA.debugLine="Peso = Peso.Replace(\",\",\"\")";
mostCurrent._peso = mostCurrent._peso.replace(",","");
 //BA.debugLineNum = 613;BA.debugLine="Dim Bomba As String = RowData.Get(\"Bomba\")";
_bomba = BA.ObjectToString(_rowdata.Get((Object)("Bomba")));
 //BA.debugLineNum = 615;BA.debugLine="If Bomba = \"Não vinculado.\" Then";
if ((_bomba).equals("Não vinculado.")) { 
 //BA.debugLineNum = 616;BA.debugLine="ToastMessageShow(\"Produto não vinculado a uma bo";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Produto não vinculado a uma bomba. Verifique"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 617;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 621;BA.debugLine="Current_BombaID = Prefix_Bomba & \"003\"";
mostCurrent._current_bombaid = mostCurrent._prefix_bomba+"003";
 //BA.debugLineNum = 622;BA.debugLine="Current_BombaID = \"MBO403_003\"";
mostCurrent._current_bombaid = "MBO403_003";
 //BA.debugLineNum = 624;BA.debugLine="Dim Mensagem As String";
_mensagem = "";
 //BA.debugLineNum = 625;BA.debugLine="Mensagem = \"Deseja iniciar o processo de pesagem";
_mensagem = "Deseja iniciar o processo de pesagem do produto "+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 626;BA.debugLine="Mensagem = Mensagem & Produto & \" ,pesando \" & Pe";
_mensagem = _mensagem+_produto+" ,pesando "+mostCurrent._peso.trim()+"g na bomba "+_bomba.trim();
 //BA.debugLineNum = 628;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 629;BA.debugLine="i = Msgbox2(Mensagem, \"Confirmar inicio da pesage";
_i = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(_mensagem),BA.ObjectToCharSequence("Confirmar inicio da pesagem"),"Sim","Cancela","Não",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 630;BA.debugLine="Select i";
switch (BA.switchObjectToInt(_i,anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE,anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL,anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE)) {
case 0: {
 //BA.debugLineNum = 638;BA.debugLine="ToastMessageShow(\"Confirmou\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Confirmou"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 639;BA.debugLine="PanelPesagem2.Visible = True";
mostCurrent._panelpesagem2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 640;BA.debugLine="EditTextPesoRequerido.Text = Peso";
mostCurrent._edittextpesorequerido.setText(BA.ObjectToCharSequence(mostCurrent._peso));
 break; }
case 1: {
 //BA.debugLineNum = 645;BA.debugLine="ToastMessageShow(\"Operação cancelada.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Operação cancelada."),anywheresoftware.b4a.keywords.Common.False);
 break; }
case 2: {
 //BA.debugLineNum = 647;BA.debugLine="ToastMessageShow(\"Operação cancelada.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Operação cancelada."),anywheresoftware.b4a.keywords.Common.False);
 break; }
}
;
 //BA.debugLineNum = 649;BA.debugLine="End Sub";
return "";
}
public static String  _b4xtablepesagem_dataupdated() throws Exception{
 //BA.debugLineNum = 451;BA.debugLine="Sub B4XTablePesagem_DataUpdated";
 //BA.debugLineNum = 485;BA.debugLine="End Sub";
return "";
}
public static String  _buttonbarcodescan_click() throws Exception{
 //BA.debugLineNum = 867;BA.debugLine="Private Sub ButtonBarcodeScan_Click";
 //BA.debugLineNum = 868;BA.debugLine="myABBarcode.ABGetBarcode(\"myABBarcode\",\"\")";
mostCurrent._myabbarcode.ABGetBarcode(mostCurrent.activityBA,"myABBarcode","");
 //BA.debugLineNum = 869;BA.debugLine="End Sub";
return "";
}
public static String  _buttoncancelarpesagem_click() throws Exception{
 //BA.debugLineNum = 991;BA.debugLine="Private Sub ButtonCancelarPesagem_Click";
 //BA.debugLineNum = 993;BA.debugLine="End Sub";
return "";
}
public static String  _buttonclearbarcode_click() throws Exception{
 //BA.debugLineNum = 863;BA.debugLine="Private Sub ButtonClearBarcode_Click";
 //BA.debugLineNum = 864;BA.debugLine="EditTextBarcode.Text = \"\"";
mostCurrent._edittextbarcode.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 865;BA.debugLine="End Sub";
return "";
}
public static String  _buttonconcluirpesagem_click() throws Exception{
 //BA.debugLineNum = 955;BA.debugLine="Private Sub ButtonConcluirPesagem_Click";
 //BA.debugLineNum = 982;BA.debugLine="ImprimeZebra(ZPLEtiqueta, ImpressoraIP, Impressor";
_imprimezebra(mostCurrent._zpletiqueta,mostCurrent._impressoraip,(int)(Double.parseDouble(mostCurrent._impressoraporta)));
 //BA.debugLineNum = 984;BA.debugLine="ToastMessageShow(\"Pesagem concluída.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Pesagem concluída."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 987;BA.debugLine="PanelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 988;BA.debugLine="PanelPesagem2.Visible = False";
mostCurrent._panelpesagem2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 989;BA.debugLine="End Sub";
return "";
}
public static String  _buttondesligarbomba_click() throws Exception{
String _xml_bombastart = "";
 //BA.debugLineNum = 929;BA.debugLine="Private Sub ButtonDesligarBomba_Click";
 //BA.debugLineNum = 930;BA.debugLine="Dim XML_BombaStart As String";
_xml_bombastart = "";
 //BA.debugLineNum = 932;BA.debugLine="XML_BombaStart = \"<?xml version='1.0' encoding='u";
_xml_bombastart = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 933;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<soap12:Envelo";
_xml_bombastart = _xml_bombastart+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 934;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<soap12:Body>\"";
_xml_bombastart = _xml_bombastart+"<soap12:Body>";
 //BA.debugLineNum = 935;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<Bomba_SetStar";
_xml_bombastart = _xml_bombastart+"<Bomba_SetStartDosagem  xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 938;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<UserSoftware>";
_xml_bombastart = _xml_bombastart+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 939;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<PasswordSoftw";
_xml_bombastart = _xml_bombastart+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 940;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<BombaTag>\" &";
_xml_bombastart = _xml_bombastart+"<BombaTag>"+mostCurrent._current_bombaid+"</BombaTag>";
 //BA.debugLineNum = 941;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<start>false</";
_xml_bombastart = _xml_bombastart+"<start>false</start>";
 //BA.debugLineNum = 942;BA.debugLine="XML_BombaStart = XML_BombaStart & \"</Bomba_SetSta";
_xml_bombastart = _xml_bombastart+"</Bomba_SetStartDosagem >";
 //BA.debugLineNum = 943;BA.debugLine="XML_BombaStart = XML_BombaStart & \"</soap12:Body>";
_xml_bombastart = _xml_bombastart+"</soap12:Body>";
 //BA.debugLineNum = 944;BA.debugLine="XML_BombaStart = XML_BombaStart & \"</soap12:Envel";
_xml_bombastart = _xml_bombastart+"</soap12:Envelope>";
 //BA.debugLineNum = 946;BA.debugLine="LabelFuncaoBomba.Color = Colors.Red";
mostCurrent._labelfuncaobomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 951;BA.debugLine="StatusBomba = False";
_statusbomba = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 952;BA.debugLine="ToastMessageShow(\"Dosagem cancelada.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Dosagem cancelada."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 953;BA.debugLine="End Sub";
return "";
}
public static String  _buttongravar_click() throws Exception{
 //BA.debugLineNum = 683;BA.debugLine="Sub ButtonGravar_Click";
 //BA.debugLineNum = 684;BA.debugLine="Try";
try { //BA.debugLineNum = 685;BA.debugLine="sql1.ExecNonQuery(\"UPDATE Data SET  NomeTerminal";
_sql1.ExecNonQuery("UPDATE Data SET  NomeTerminal ='"+mostCurrent._edittextlinha.getText()+"', EnderecoWebservice='"+mostCurrent._edittextwebservice.getText()+"' WHERE id=1;");
 //BA.debugLineNum = 686;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql1.ExecQuery("SELECT NomeTerminal, EnderecoWebservice FROM Data WHERE id=1;")));
 //BA.debugLineNum = 687;BA.debugLine="cursor.Position =  0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 688;BA.debugLine="NomeTerminal = cursor.GetString2(0)";
mostCurrent._nometerminal = _cursor.GetString2((int) (0));
 //BA.debugLineNum = 689;BA.debugLine="AddressWebservice = cursor.GetString2(1)";
mostCurrent._addresswebservice = _cursor.GetString2((int) (1));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 691;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5983048",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 692;BA.debugLine="ToastMessageShow(\"Erro ao gravar\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao gravar"),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 695;BA.debugLine="End Sub";
return "";
}
public static String  _buttonligarbomba_click() throws Exception{
 //BA.debugLineNum = 902;BA.debugLine="Private Sub ButtonLigarBomba_Click";
 //BA.debugLineNum = 903;BA.debugLine="LabelFuncaoBomba.Color = Colors.Green";
mostCurrent._labelfuncaobomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 911;BA.debugLine="Try";
try { //BA.debugLineNum = 912;BA.debugLine="FinalizadoDosagem = False";
_finalizadodosagem = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 914;BA.debugLine="StartDosagem(Current_BombaID, Peso)";
_startdosagem(mostCurrent._current_bombaid,(int)(Double.parseDouble(mostCurrent._peso)));
 //BA.debugLineNum = 918;BA.debugLine="Clock_VerificaFimDosagem(True)";
_clock_verificafimdosagem(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e7) {
			processBA.setLastException(e7); //BA.debugLineNum = 922;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52031636",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 923;BA.debugLine="ToastMessageShow(\"ERRO ao iniciar o processo de";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ERRO ao iniciar o processo de dosagem. Verifique."),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 927;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlimpar_click() throws Exception{
 //BA.debugLineNum = 678;BA.debugLine="Sub ButtonLimpar_Click";
 //BA.debugLineNum = 679;BA.debugLine="EditTextLinha.Text = \"\"";
mostCurrent._edittextlinha.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 680;BA.debugLine="EditTextWebservice.Text = \"\"";
mostCurrent._edittextwebservice.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlimparlogin_click() throws Exception{
 //BA.debugLineNum = 744;BA.debugLine="Sub ButtonLimparLogin_Click";
 //BA.debugLineNum = 745;BA.debugLine="EditTextUsuarioLogin.Text = \"\"";
mostCurrent._edittextusuariologin.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 746;BA.debugLine="EditTextSenhaLogin.Text = \"\"";
mostCurrent._edittextsenhalogin.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 747;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlogin_click() throws Exception{
 //BA.debugLineNum = 704;BA.debugLine="Sub ButtonLogin_Click";
 //BA.debugLineNum = 705;BA.debugLine="Try";
try { //BA.debugLineNum = 707;BA.debugLine="If EditTextUsuarioLogin.Text = \"admin\" And EditT";
if ((mostCurrent._edittextusuariologin.getText()).equals("admin") && (mostCurrent._edittextsenhalogin.getText()).equals("passwordfrota")) { 
 //BA.debugLineNum = 708;BA.debugLine="PanelLogin.Visible = False";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 709;BA.debugLine="PanelSettings.Visible = True";
mostCurrent._panelsettings.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 710;BA.debugLine="EditTextWebservice.Text = AddressWebservice";
mostCurrent._edittextwebservice.setText(BA.ObjectToCharSequence(mostCurrent._addresswebservice));
 //BA.debugLineNum = 711;BA.debugLine="EditTextLinha.Text = NomeTerminal";
mostCurrent._edittextlinha.setText(BA.ObjectToCharSequence(mostCurrent._nometerminal));
 //BA.debugLineNum = 712;BA.debugLine="EditTextUsuarioLogin.Text = \"\"";
mostCurrent._edittextusuariologin.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 713;BA.debugLine="EditTextSenhaLogin.Text = \"\"";
mostCurrent._edittextsenhalogin.setText(BA.ObjectToCharSequence(""));
 }else {
 //BA.debugLineNum = 715;BA.debugLine="ToastMessageShow(\"Senha ou usuario não são corr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Senha ou usuario não são corretos."),anywheresoftware.b4a.keywords.Common.False);
 };
 } 
       catch (Exception e13) {
			processBA.setLastException(e13); //BA.debugLineNum = 718;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("51114126",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 719;BA.debugLine="ToastMessageShow(\"Erro ao fazer Login.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao fazer Login."),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 722;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop0_click() throws Exception{
 //BA.debugLineNum = 843;BA.debugLine="Private Sub ButtonOP0_Click";
 //BA.debugLineNum = 844;BA.debugLine="ButtonOP0.Color = Colors.Green";
mostCurrent._buttonop0.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 845;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 846;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 847;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 848;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 849;BA.debugLine="OPSelecionadaButton = 0";
_opselecionadabutton = (int) (0);
 //BA.debugLineNum = 850;BA.debugLine="CFG_Prefixos";
_cfg_prefixos();
 //BA.debugLineNum = 851;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop1_click() throws Exception{
 //BA.debugLineNum = 833;BA.debugLine="Private Sub ButtonOP1_Click";
 //BA.debugLineNum = 834;BA.debugLine="ButtonOP0.Color = Colors.Red";
mostCurrent._buttonop0.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 835;BA.debugLine="ButtonOP1.Color = Colors.Green";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 836;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 837;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 838;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 839;BA.debugLine="OPSelecionadaButton = 1";
_opselecionadabutton = (int) (1);
 //BA.debugLineNum = 840;BA.debugLine="CFG_Prefixos";
_cfg_prefixos();
 //BA.debugLineNum = 841;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop2_click() throws Exception{
 //BA.debugLineNum = 823;BA.debugLine="Private Sub ButtonOP2_Click";
 //BA.debugLineNum = 824;BA.debugLine="ButtonOP0.Color = Colors.Red";
mostCurrent._buttonop0.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 825;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 826;BA.debugLine="ButtonOP2.Color = Colors.Green";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 827;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 828;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 829;BA.debugLine="OPSelecionadaButton = 2";
_opselecionadabutton = (int) (2);
 //BA.debugLineNum = 830;BA.debugLine="CFG_Prefixos";
_cfg_prefixos();
 //BA.debugLineNum = 831;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop3_click() throws Exception{
 //BA.debugLineNum = 813;BA.debugLine="Private Sub ButtonOP3_Click";
 //BA.debugLineNum = 814;BA.debugLine="ButtonOP0.Color = Colors.Red";
mostCurrent._buttonop0.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 815;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 816;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 817;BA.debugLine="ButtonOP3.Color = Colors.Green";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 818;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 819;BA.debugLine="OPSelecionadaButton = 3";
_opselecionadabutton = (int) (3);
 //BA.debugLineNum = 820;BA.debugLine="CFG_Prefixos";
_cfg_prefixos();
 //BA.debugLineNum = 821;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop4_click() throws Exception{
 //BA.debugLineNum = 803;BA.debugLine="Private Sub ButtonOP4_Click";
 //BA.debugLineNum = 804;BA.debugLine="ButtonOP0.Color = Colors.Red";
mostCurrent._buttonop0.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 805;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 806;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 807;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 808;BA.debugLine="ButtonOP4.Color = Colors.Green";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 809;BA.debugLine="OPSelecionadaButton = 4";
_opselecionadabutton = (int) (4);
 //BA.debugLineNum = 810;BA.debugLine="CFG_Prefixos";
_cfg_prefixos();
 //BA.debugLineNum = 811;BA.debugLine="End Sub";
return "";
}
public static String  _buttonrota1_click() throws Exception{
 //BA.debugLineNum = 888;BA.debugLine="Private Sub ButtonRota1_Click";
 //BA.debugLineNum = 889;BA.debugLine="ButtonRota1.Color = Colors.Green";
mostCurrent._buttonrota1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 890;BA.debugLine="ButtonRota2.Color = Colors.Red";
mostCurrent._buttonrota2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 891;BA.debugLine="RotaSelcionada = 1";
_rotaselcionada = (int) (1);
 //BA.debugLineNum = 892;BA.debugLine="ToastMessageShow(\"Selecionada a ROTA 1.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Selecionada a ROTA 1."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 893;BA.debugLine="End Sub";
return "";
}
public static String  _buttonrota2_click() throws Exception{
 //BA.debugLineNum = 895;BA.debugLine="Private Sub ButtonRota2_Click";
 //BA.debugLineNum = 896;BA.debugLine="ButtonRota1.Color = Colors.Red";
mostCurrent._buttonrota1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 897;BA.debugLine="ButtonRota2.Color = Colors.Green";
mostCurrent._buttonrota2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 898;BA.debugLine="RotaSelcionada = 2";
_rotaselcionada = (int) (2);
 //BA.debugLineNum = 899;BA.debugLine="ToastMessageShow(\"Selecionada a ROTA 2.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Selecionada a ROTA 2."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 900;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltar_click() throws Exception{
 //BA.debugLineNum = 673;BA.debugLine="Sub ButtonVoltar_Click";
 //BA.debugLineNum = 674;BA.debugLine="PanelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 675;BA.debugLine="PanelSettings.Visible = False";
mostCurrent._panelsettings.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 676;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltarlogin_click() throws Exception{
 //BA.debugLineNum = 699;BA.debugLine="Sub ButtonVoltarLogin_Click";
 //BA.debugLineNum = 700;BA.debugLine="PanelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 701;BA.debugLine="PanelLogin.Visible = False";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 702;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltarpesagem_click() throws Exception{
 //BA.debugLineNum = 995;BA.debugLine="Private Sub ButtonVoltarPesagem_Click";
 //BA.debugLineNum = 996;BA.debugLine="PanelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 997;BA.debugLine="PanelPesagem2.Visible = False";
mostCurrent._panelpesagem2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 998;BA.debugLine="End Sub";
return "";
}
public static String  _cfg_prefixos() throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Private Sub CFG_Prefixos ()";
 //BA.debugLineNum = 259;BA.debugLine="Select OPSelecionadaButton";
switch (_opselecionadabutton) {
case 1: {
 //BA.debugLineNum = 261;BA.debugLine="Prefix_Bomba = \"MBO401_\"";
mostCurrent._prefix_bomba = "MBO401_";
 //BA.debugLineNum = 262;BA.debugLine="Prefix_Balanca = \"WT401_\"";
mostCurrent._prefix_balanca = "WT401_";
 //BA.debugLineNum = 263;BA.debugLine="Prefix_CLP = \"RC401_\"";
mostCurrent._prefix_clp = "RC401_";
 break; }
case 2: {
 //BA.debugLineNum = 265;BA.debugLine="Prefix_Bomba = \"MBO402_\"";
mostCurrent._prefix_bomba = "MBO402_";
 //BA.debugLineNum = 266;BA.debugLine="Prefix_Balanca = \"WT402_\"";
mostCurrent._prefix_balanca = "WT402_";
 //BA.debugLineNum = 267;BA.debugLine="Prefix_CLP = \"RC402_\"";
mostCurrent._prefix_clp = "RC402_";
 break; }
case 3: {
 //BA.debugLineNum = 269;BA.debugLine="Prefix_Bomba = \"MBO403_\"";
mostCurrent._prefix_bomba = "MBO403_";
 //BA.debugLineNum = 270;BA.debugLine="Prefix_Balanca = \"WT403_\"";
mostCurrent._prefix_balanca = "WT403_";
 //BA.debugLineNum = 271;BA.debugLine="Prefix_CLP = \"RC403_\"";
mostCurrent._prefix_clp = "RC403_";
 break; }
case 4: {
 //BA.debugLineNum = 273;BA.debugLine="Prefix_Bomba = \"MBO404_\"";
mostCurrent._prefix_bomba = "MBO404_";
 //BA.debugLineNum = 274;BA.debugLine="Prefix_Balanca = \"WT404_\"";
mostCurrent._prefix_balanca = "WT404_";
 //BA.debugLineNum = 275;BA.debugLine="Prefix_CLP = \"RC404_\"";
mostCurrent._prefix_clp = "RC404_";
 break; }
}
;
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return "";
}
public static void  _clock(boolean _state) throws Exception{
ResumableSub_Clock rsub = new ResumableSub_Clock(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_Clock extends BA.ResumableSub {
public ResumableSub_Clock(unileverSU.pesagem.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
unileverSU.pesagem.main parent;
boolean _state;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 251;BA.debugLine="Do While state = True";
if (true) break;

case 1:
//do while
this.state = 4;
while (_state==anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 252;BA.debugLine="LabelClockTV.Text  = DateTime.Time(DateTime.Now)";
parent.mostCurrent._labelclocktv.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 //BA.debugLineNum = 253;BA.debugLine="Sleep(500)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (500));
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
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _clock_verificafimdosagem(boolean _state) throws Exception{
ResumableSub_Clock_VerificaFimDosagem rsub = new ResumableSub_Clock_VerificaFimDosagem(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_Clock_VerificaFimDosagem extends BA.ResumableSub {
public ResumableSub_Clock_VerificaFimDosagem(unileverSU.pesagem.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
unileverSU.pesagem.main parent;
boolean _state;
String _xml_bomba = "";
String _xxstringa = "";
boolean _xxstatus = false;
unileverSU.pesagem.httpjob _job = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1217;BA.debugLine="Dim XML_Bomba As String";
_xml_bomba = "";
 //BA.debugLineNum = 1218;BA.debugLine="Dim xxStringa As String";
_xxstringa = "";
 //BA.debugLineNum = 1219;BA.debugLine="Dim xxstatus As Boolean";
_xxstatus = false;
 //BA.debugLineNum = 1220;BA.debugLine="Dim Job As HttpJob";
_job = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1222;BA.debugLine="XML_Bomba = \"<?xml version='1.0' encoding='utf-8'";
_xml_bomba = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1223;BA.debugLine="XML_Bomba = XML_Bomba & \"<soap12:Envelope xmlns:x";
_xml_bomba = _xml_bomba+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1224;BA.debugLine="XML_Bomba = XML_Bomba & \"<soap12:Body>\"";
_xml_bomba = _xml_bomba+"<soap12:Body>";
 //BA.debugLineNum = 1225;BA.debugLine="XML_Bomba = XML_Bomba & \"<Bomba_GetFinalizadoDosa";
_xml_bomba = _xml_bomba+"<Bomba_GetFinalizadoDosagem xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1228;BA.debugLine="XML_Bomba = XML_Bomba & \"<UserSoftware>user</User";
_xml_bomba = _xml_bomba+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1229;BA.debugLine="XML_Bomba = XML_Bomba & \"<PasswordSoftware>1234</";
_xml_bomba = _xml_bomba+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1230;BA.debugLine="XML_Bomba = XML_Bomba & \"<BombaTag>\" & Current_Bo";
_xml_bomba = _xml_bomba+"<BombaTag>"+parent.mostCurrent._current_bombaid+"</BombaTag>";
 //BA.debugLineNum = 1231;BA.debugLine="XML_Bomba = XML_Bomba & \"</Bomba_GetFinalizadoDos";
_xml_bomba = _xml_bomba+"</Bomba_GetFinalizadoDosagem>";
 //BA.debugLineNum = 1232;BA.debugLine="XML_Bomba = XML_Bomba & \"</soap12:Body>\"";
_xml_bomba = _xml_bomba+"</soap12:Body>";
 //BA.debugLineNum = 1233;BA.debugLine="XML_Bomba = XML_Bomba & \"</soap12:Envelope>\"";
_xml_bomba = _xml_bomba+"</soap12:Envelope>";
 //BA.debugLineNum = 1235;BA.debugLine="Do While state = True";
if (true) break;

case 1:
//do while
this.state = 18;
while (_state==anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 1236;BA.debugLine="If StatusBomba = True Then";
if (true) break;

case 4:
//if
this.state = 17;
if (parent._statusbomba==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1237;BA.debugLine="Try";
if (true) break;

case 7:
//try
this.state = 16;
this.catchState = 15;
this.state = 9;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 15;
 //BA.debugLineNum = 1238;BA.debugLine="Job.Initialize(\"JOBSOAP\", Me)";
_job._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1239;BA.debugLine="Job.PostString(URL, XML_Bomba)";
_job._poststring /*String*/ (parent.mostCurrent._url,_xml_bomba);
 //BA.debugLineNum = 1240;BA.debugLine="Job.GetRequest.SetContentType(\"text/xml\")";
_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1241;BA.debugLine="WaiT For (Job) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_job));
this.state = 19;
return;
case 19:
//C
this.state = 10;
;
 //BA.debugLineNum = 1242;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 20;
return;
case 20:
//C
this.state = 10;
;
 //BA.debugLineNum = 1243;BA.debugLine="XMLWork = Job.GetString";
parent.mostCurrent._xmlwork = _job._getstring /*String*/ ();
 //BA.debugLineNum = 1244;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1245;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1247;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1248;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<x";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1249;BA.debugLine="xxstatus = XMLWork.SubString2(XMLWork.IndexOf(";
_xxstatus = BA.ObjectToBoolean(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xStatus>")+9),parent.mostCurrent._xmlwork.indexOf("</xStatus>")));
 //BA.debugLineNum = 1251;BA.debugLine="If xxstatus = True Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_xxstatus==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 1252;BA.debugLine="state = False";
_state = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1253;BA.debugLine="FinalizadoDosagem = True";
parent._finalizadodosagem = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1254;BA.debugLine="GetPesoDosado(Current_BombaID)";
_getpesodosado(parent.mostCurrent._current_bombaid);
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 1258;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52555946",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
this.catchState = 0;
;
 if (true) break;

case 17:
//C
this.state = 1;
;
 //BA.debugLineNum = 1261;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 21;
return;
case 21:
//C
this.state = 1;
;
 if (true) break;

case 18:
//C
this.state = -1;
;
 //BA.debugLineNum = 1263;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _edittextbarcode_enterpressed() throws Exception{
 //BA.debugLineNum = 853;BA.debugLine="Private Sub EditTextBarcode_EnterPressed";
 //BA.debugLineNum = 854;BA.debugLine="If EditTextBarcode.Text.Contains(\"|\") = True Then";
if (mostCurrent._edittextbarcode.getText().contains("|")==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 855;BA.debugLine="idSSCC = EditTextBarcode.Text.SubString2(0,9)";
mostCurrent._idsscc = mostCurrent._edittextbarcode.getText().substring((int) (0),(int) (9));
 //BA.debugLineNum = 856;BA.debugLine="idProduto =  EditTextBarcode.Text.SubString2(10,";
mostCurrent._idproduto = mostCurrent._edittextbarcode.getText().substring((int) (10),(int) (18));
 //BA.debugLineNum = 857;BA.debugLine="SSCC =  EditTextBarcode.Text.SubString(19)";
mostCurrent._sscc = mostCurrent._edittextbarcode.getText().substring((int) (19));
 //BA.debugLineNum = 858;BA.debugLine="PanelPesagem2.Visible = True";
mostCurrent._panelpesagem2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 859;BA.debugLine="PanelMain.Visible = False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 861;BA.debugLine="End Sub";
return "";
}
public static void  _getlistaop() throws Exception{
ResumableSub_GetListaOP rsub = new ResumableSub_GetListaOP(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetListaOP extends BA.ResumableSub {
public ResumableSub_GetListaOP(unileverSU.pesagem.main parent) {
this.parent = parent;
}
unileverSU.pesagem.main parent;
String _result = "";
int _quant = 0;
String _ordens = "";
String _ordemprod = "";
unileverSU.pesagem.httpjob _jobop = null;
String _xml = "";
Object _obj = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _c = null;
int _j = 0;
String _statusop = "";
String _idordemprod = "";
String _ordemproduc = "";
String _descricaocuc = "";
String _datahorasap = "";
int _setorselec = 0;
int _i = 0;
String _value = "";
int step51;
int limit51;
int step76;
int limit76;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 335;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 52;
this.catchState = 51;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 51;
 //BA.debugLineNum = 338;BA.debugLine="Dim Result As String";
_result = "";
 //BA.debugLineNum = 339;BA.debugLine="Dim Quant As Int";
_quant = 0;
 //BA.debugLineNum = 340;BA.debugLine="Dim Ordens As String";
_ordens = "";
 //BA.debugLineNum = 341;BA.debugLine="Dim OrdemProd As String";
_ordemprod = "";
 //BA.debugLineNum = 342;BA.debugLine="Dim JobOP As HttpJob";
_jobop = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 343;BA.debugLine="Dim XML As String";
_xml = "";
 //BA.debugLineNum = 344;BA.debugLine="Dim obj As Object";
_obj = new Object();
 //BA.debugLineNum = 346;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 347;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
 //BA.debugLineNum = 348;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
 //BA.debugLineNum = 349;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 350;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
 //BA.debugLineNum = 351;BA.debugLine="XML = XML & \"<GetOrdensAbertasP xmlns='http://ww";
_xml = _xml+"<GetOrdensAbertasP xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 352;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware>\"";
_xml = _xml+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 353;BA.debugLine="XML = XML & \"<PasswordSoftware>1234</PasswordSof";
_xml = _xml+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 354;BA.debugLine="XML = XML & \"<StatusOP>2</StatusOP>\"";
_xml = _xml+"<StatusOP>2</StatusOP>";
 //BA.debugLineNum = 355;BA.debugLine="XML = XML & \"</GetOrdensAbertasP>\"";
_xml = _xml+"</GetOrdensAbertasP>";
 //BA.debugLineNum = 356;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
 //BA.debugLineNum = 357;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
 //BA.debugLineNum = 359;BA.debugLine="JobOP.Initialize(\"JOBSOAP0\", Me)";
_jobop._initialize /*String*/ (processBA,"JOBSOAP0",main.getObject());
 //BA.debugLineNum = 360;BA.debugLine="JobOP.PostString(URL.Trim,XML)";
_jobop._poststring /*String*/ (parent.mostCurrent._url.trim(),_xml);
 //BA.debugLineNum = 361;BA.debugLine="JobOP.GetRequest.SetContentType(\"text/xml\")";
_jobop._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 362;BA.debugLine="Wait For (JobOP) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobop));
this.state = 53;
return;
case 53:
//C
this.state = 4;
;
 //BA.debugLineNum = 363;BA.debugLine="Sleep(200)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (200));
this.state = 54;
return;
case 54:
//C
this.state = 4;
;
 //BA.debugLineNum = 365;BA.debugLine="If JobOP.Success = True Then";
if (true) break;

case 4:
//if
this.state = 49;
if (_jobop._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 366;BA.debugLine="XMLWork = JobOP.GetString";
parent.mostCurrent._xmlwork = _jobop._getstring /*String*/ ();
 //BA.debugLineNum = 367;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 368;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 369;BA.debugLine="XMLWork = XMLWork.Replace(\"&amp;\",\"-\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&amp;","-");
 //BA.debugLineNum = 372;BA.debugLine="JobOP.Release";
_jobop._release /*String*/ ();
 //BA.debugLineNum = 373;BA.debugLine="If XMLWork.Contains(\"<GetOrdensAbertasPResult>\"";
if (true) break;

case 7:
//if
this.state = 48;
if (parent.mostCurrent._xmlwork.contains("<GetOrdensAbertasPResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 374;BA.debugLine="Result = XMLWork.SubString2(XMLWork.IndexOf(\"<";
_result = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Erro>")+6),parent.mostCurrent._xmlwork.indexOf("</Erro>"));
 //BA.debugLineNum = 375;BA.debugLine="Quant = XMLWork.SubString2(XMLWork.IndexOf(\"<Q";
_quant = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Quantidade>")+12),parent.mostCurrent._xmlwork.indexOf("</Quantidade>"))));
 //BA.debugLineNum = 377;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 10:
//if
this.state = 47;
if ((_result).equals("sucesso")) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 379;BA.debugLine="Dim b As Bitmap";
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 380;BA.debugLine="b.InitializeResize(File.DirAssets,\"data_ok.pn";
_b.InitializeResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"data_ok.png",(int)(Double.parseDouble("24")),(int)(Double.parseDouble("24")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 382;BA.debugLine="Dim c As Bitmap";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 383;BA.debugLine="c.InitializeResize(File.DirAssets,\"data.png\",";
_c.InitializeResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"data.png",(int)(Double.parseDouble("24")),(int)(Double.parseDouble("24")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 385;BA.debugLine="ListViewOP.Clear";
parent.mostCurrent._listviewop.Clear();
 //BA.debugLineNum = 386;BA.debugLine="ListViewOP.TwoLinesLayout.ItemHeight = 45dip";
parent.mostCurrent._listviewop.getTwoLinesLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (45)));
 //BA.debugLineNum = 387;BA.debugLine="ListViewOP.TwoLinesLayout.SecondLabel.TextCol";
parent.mostCurrent._listviewop.getTwoLinesLayout().SecondLabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 388;BA.debugLine="ListViewOP.TwoLinesLayout.SecondLabel.TextSiz";
parent.mostCurrent._listviewop.getTwoLinesLayout().SecondLabel.setTextSize((float) (8));
 //BA.debugLineNum = 389;BA.debugLine="ListViewOP.TwoLinesLayout.Label.TextSize = 8";
parent.mostCurrent._listviewop.getTwoLinesLayout().Label.setTextSize((float) (8));
 //BA.debugLineNum = 390;BA.debugLine="ListViewOP.TwoLinesLayout.Label.TextColor = C";
parent.mostCurrent._listviewop.getTwoLinesLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 391;BA.debugLine="ListViewOP.TwoLinesAndBitmap.Label.TextSize =";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().Label.setTextSize((float) (8));
 //BA.debugLineNum = 392;BA.debugLine="ListViewOP.TwoLinesAndBitmap.SecondLabel.Text";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().SecondLabel.setTextSize((float) (8));
 //BA.debugLineNum = 395;BA.debugLine="If Quant > 0 Then";
if (true) break;

case 13:
//if
this.state = 46;
if (_quant>0) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 396;BA.debugLine="Ordens = XMLWork.SubString2(XMLWork.IndexOf(";
_ordens = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Ordens>")+8),parent.mostCurrent._xmlwork.indexOf("</Ordens>"));
 //BA.debugLineNum = 397;BA.debugLine="OrdemProd = Ordens.SubString2(Ordens.IndexOf";
_ordemprod = _ordens.substring((int) (_ordens.indexOf("<OrdemProducao>")+15),_ordens.indexOf("</OrdemProducao>"));
 //BA.debugLineNum = 399;BA.debugLine="For j=0 To Quant-1";
if (true) break;

case 16:
//for
this.state = 38;
step51 = 1;
limit51 = (int) (_quant-1);
_j = (int) (0) ;
this.state = 55;
if (true) break;

case 55:
//C
this.state = 38;
if ((step51 > 0 && _j <= limit51) || (step51 < 0 && _j >= limit51)) this.state = 18;
if (true) break;

case 56:
//C
this.state = 55;
_j = ((int)(0 + _j + step51)) ;
if (true) break;

case 18:
//C
this.state = 19;
 //BA.debugLineNum = 400;BA.debugLine="OrdemProd =  Ordens.SubString2(Ordens.Index";
_ordemprod = _ordens.substring((int) (_ordens.indexOf("<OrdemProducao>")+15),_ordens.indexOf("</OrdemProducao>"));
 //BA.debugLineNum = 401;BA.debugLine="Dim StatusOP As String = OrdemProd.SubStrin";
_statusop = _ordemprod.substring((int) (_ordemprod.indexOf("<StatusOP>")+10),_ordemprod.indexOf("</StatusOP>"));
 //BA.debugLineNum = 402;BA.debugLine="Dim IdOrdemProd As String = OrdemProd.SubSt";
_idordemprod = _ordemprod.substring((int) (_ordemprod.indexOf("<IdOrdemProd>")+13),_ordemprod.indexOf("</IdOrdemProd>"));
 //BA.debugLineNum = 403;BA.debugLine="Dim OrdemProduc As String = OrdemProd.SubSt";
_ordemproduc = _ordemprod.substring((int) (_ordemprod.indexOf("<OrdemProd>")+11),_ordemprod.indexOf("</OrdemProd>"));
 //BA.debugLineNum = 404;BA.debugLine="Dim DescricaoCUC As String = OrdemProd.SubS";
_descricaocuc = _ordemprod.substring((int) (_ordemprod.indexOf("<DescricaoCUC>")+14),_ordemprod.indexOf("</DescricaoCUC>"));
 //BA.debugLineNum = 405;BA.debugLine="Dim DataHoraSAP As String = OrdemProd.SubSt";
_datahorasap = _ordemprod.substring((int) (_ordemprod.indexOf("<dataHoraSAP>")+13),_ordemprod.indexOf("</dataHoraSAP>"));
 //BA.debugLineNum = 406;BA.debugLine="Dim SetorSelec As Int = OrdemProd.SubString";
_setorselec = (int)(Double.parseDouble(_ordemprod.substring((int) (_ordemprod.indexOf("<SetorSelec>")+12),_ordemprod.indexOf("</SetorSelec>"))));
 //BA.debugLineNum = 408;BA.debugLine="DataHoraSAP = DataHoraSAP.SubString2(0,9)";
_datahorasap = _datahorasap.substring((int) (0),(int) (9));
 //BA.debugLineNum = 409;BA.debugLine="DataHoraSAP = DataHoraSAP.SubString(8) & \"/";
_datahorasap = _datahorasap.substring((int) (8))+"/"+_datahorasap.substring((int) (5),(int) (7))+"/"+_datahorasap.substring((int) (0),(int) (4));
 //BA.debugLineNum = 411;BA.debugLine="If StatusOP = \"2\" Then";
if (true) break;

case 19:
//if
this.state = 34;
if ((_statusop).equals("2")) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 412;BA.debugLine="If SetorSelec = OPSelecionadaButton Then";
if (true) break;

case 22:
//if
this.state = 33;
if (_setorselec==parent._opselecionadabutton) { 
this.state = 24;
}else {
this.state = 32;
}if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 413;BA.debugLine="If SetorSelec = OPSelecionadaButton Then";
if (true) break;

case 25:
//if
this.state = 30;
if (_setorselec==parent._opselecionadabutton) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 30;
 //BA.debugLineNum = 415;BA.debugLine="ListViewOP.AddTwoLines2(\"OP \" & OrdemPro";
parent.mostCurrent._listviewop.AddTwoLines2(BA.ObjectToCharSequence("OP "+_ordemproduc+" | Data:"+_datahorasap),BA.ObjectToCharSequence(_descricaocuc+" - "+_idordemprod),(Object)(_idordemprod));
 if (true) break;

case 29:
//C
this.state = 30;
 //BA.debugLineNum = 418;BA.debugLine="ListViewOP.AddTwoLines2(\"OP \" & OrdemPro";
parent.mostCurrent._listviewop.AddTwoLines2(BA.ObjectToCharSequence("OP "+_ordemproduc+" | Data:"+_datahorasap),BA.ObjectToCharSequence(_descricaocuc+" - "+_idordemprod),(Object)(_idordemprod));
 if (true) break;

case 30:
//C
this.state = 33;
;
 if (true) break;

case 32:
//C
this.state = 33;
 //BA.debugLineNum = 422;BA.debugLine="ListViewOP.AddTwoLines2(\"OP \" & OrdemProd";
parent.mostCurrent._listviewop.AddTwoLines2(BA.ObjectToCharSequence("OP "+_ordemproduc+" | Data:"+_datahorasap),BA.ObjectToCharSequence(_descricaocuc+" - "+_idordemprod),(Object)(_idordemprod));
 if (true) break;

case 33:
//C
this.state = 34;
;
 if (true) break;
;
 //BA.debugLineNum = 427;BA.debugLine="If  j < Quant-1 Then";

case 34:
//if
this.state = 37;
if (_j<_quant-1) { 
this.state = 36;
}if (true) break;

case 36:
//C
this.state = 37;
 //BA.debugLineNum = 428;BA.debugLine="Ordens = Ordens.SubString(Ordens.IndexOf(\"";
_ordens = _ordens.substring((int) (_ordens.indexOf("</OrdemProducao>")+16));
 if (true) break;

case 37:
//C
this.state = 56;
;
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 432;BA.debugLine="For i=0 To ListViewOP.Size-1";

case 38:
//for
this.state = 45;
step76 = 1;
limit76 = (int) (parent.mostCurrent._listviewop.getSize()-1);
_i = (int) (0) ;
this.state = 57;
if (true) break;

case 57:
//C
this.state = 45;
if ((step76 > 0 && _i <= limit76) || (step76 < 0 && _i >= limit76)) this.state = 40;
if (true) break;

case 58:
//C
this.state = 57;
_i = ((int)(0 + _i + step76)) ;
if (true) break;

case 40:
//C
this.state = 41;
 //BA.debugLineNum = 433;BA.debugLine="Dim Value As String = ListViewOP.GetItem(i)";
_value = BA.ObjectToString(parent.mostCurrent._listviewop.GetItem(_i));
 //BA.debugLineNum = 434;BA.debugLine="If IdOrdemProdList == Value Then";
if (true) break;

case 41:
//if
this.state = 44;
if ((parent.mostCurrent._idordemprodlist).equals(_value)) { 
this.state = 43;
}if (true) break;

case 43:
//C
this.state = 44;
 //BA.debugLineNum = 436;BA.debugLine="ListViewOP.SetSelection(i)";
parent.mostCurrent._listviewop.SetSelection(_i);
 //BA.debugLineNum = 437;BA.debugLine="Exit";
this.state = 45;
if (true) break;
 if (true) break;

case 44:
//C
this.state = 58;
;
 if (true) break;
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
this.state = 48;
;
 if (true) break;

case 48:
//C
this.state = 49;
;
 if (true) break;

case 49:
//C
this.state = 52;
;
 if (true) break;

case 51:
//C
this.state = 52;
this.catchState = 0;
 //BA.debugLineNum = 445;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5524399",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 446;BA.debugLine="ToastMessageShow(LastException,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 52:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 449;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _getopselecionada(boolean _state) throws Exception{
ResumableSub_GetOPselecionada rsub = new ResumableSub_GetOPselecionada(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetOPselecionada extends BA.ResumableSub {
public ResumableSub_GetOPselecionada(unileverSU.pesagem.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
unileverSU.pesagem.main parent;
boolean _state;
String _result = "";
unileverSU.pesagem.httpjob _jobop = null;
String _xmlwork2 = "";
String _xml = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 281;BA.debugLine="Try";
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
 //BA.debugLineNum = 282;BA.debugLine="Do While state = True";
if (true) break;

case 4:
//do while
this.state = 21;
while (_state==anywheresoftware.b4a.keywords.Common.True) {
this.state = 6;
if (true) break;
}
if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 283;BA.debugLine="Dim Result As String";
_result = "";
 //BA.debugLineNum = 284;BA.debugLine="Dim JobOP As HttpJob";
_jobop = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 285;BA.debugLine="Dim XMLWork2 As String = \"\"";
_xmlwork2 = "";
 //BA.debugLineNum = 286;BA.debugLine="Dim XML As String = \"\"";
_xml = "";
 //BA.debugLineNum = 289;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 290;BA.debugLine="XML = XML & \"<soap12:Envelope xmlns:xsi='http:/";
_xml = _xml+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
 //BA.debugLineNum = 291;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
 //BA.debugLineNum = 292;BA.debugLine="XML = XML & \"xmlns:soap12='http://www.w3.org/20";
_xml = _xml+"xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 293;BA.debugLine="XML = XML & \"<soap12:Body>\"";
_xml = _xml+"<soap12:Body>";
 //BA.debugLineNum = 294;BA.debugLine="XML = XML & \"<GetOPSelecionada xmlns='http://ww";
_xml = _xml+"<GetOPSelecionada xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 295;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware>\"";
_xml = _xml+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 296;BA.debugLine="XML = XML & \"<PasswordSoftware>1234</PasswordSo";
_xml = _xml+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 297;BA.debugLine="XML = XML & \"<Settore>\" & OPSelecionadaButton &";
_xml = _xml+"<Settore>"+BA.NumberToString(parent._opselecionadabutton)+"</Settore>";
 //BA.debugLineNum = 298;BA.debugLine="XML = XML & \"</GetOPSelecionada>\"";
_xml = _xml+"</GetOPSelecionada>";
 //BA.debugLineNum = 299;BA.debugLine="XML = XML & \"</soap12:Body>\"";
_xml = _xml+"</soap12:Body>";
 //BA.debugLineNum = 300;BA.debugLine="XML = XML & \"</soap12:Envelope>\"";
_xml = _xml+"</soap12:Envelope>";
 //BA.debugLineNum = 302;BA.debugLine="JobOP.Initialize(\"JOBSOAPOP\", Me)";
_jobop._initialize /*String*/ (processBA,"JOBSOAPOP",main.getObject());
 //BA.debugLineNum = 303;BA.debugLine="JobOP.PostString(URL.Trim,XML)";
_jobop._poststring /*String*/ (parent.mostCurrent._url.trim(),_xml);
 //BA.debugLineNum = 304;BA.debugLine="JobOP.GetRequest.SetContentType(\"text/xml\")";
_jobop._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 305;BA.debugLine="Wait For (JobOP) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobop));
this.state = 25;
return;
case 25:
//C
this.state = 7;
;
 //BA.debugLineNum = 308;BA.debugLine="If JobOP.Success = True Then";
if (true) break;

case 7:
//if
this.state = 20;
if (_jobop._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 309;BA.debugLine="XMLWork2 = JobOP.GetString";
_xmlwork2 = _jobop._getstring /*String*/ ();
 //BA.debugLineNum = 310;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
 //BA.debugLineNum = 311;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
 //BA.debugLineNum = 313;BA.debugLine="JobOP.Release";
_jobop._release /*String*/ ();
 //BA.debugLineNum = 315;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
 //BA.debugLineNum = 317;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 10:
//if
this.state = 19;
if ((_result).equals("sucesso")) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 318;BA.debugLine="IdOrdemProdListCompare = IdOrdemProdList";
parent.mostCurrent._idordemprodlistcompare = parent.mostCurrent._idordemprodlist;
 //BA.debugLineNum = 319;BA.debugLine="IdOrdemProdList = XMLWork2.SubString2(XMLWork";
parent.mostCurrent._idordemprodlist = _xmlwork2.substring((int) (_xmlwork2.indexOf("<IDOrdemProd>")+13),_xmlwork2.indexOf("</IDOrdemProd>"));
 //BA.debugLineNum = 320;BA.debugLine="If IdOrdemProdList == IdOrdemProdListCompare";
if (true) break;

case 13:
//if
this.state = 18;
if ((parent.mostCurrent._idordemprodlist).equals(parent.mostCurrent._idordemprodlistcompare)) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
 //BA.debugLineNum = 321;BA.debugLine="GetListaOP";
_getlistaop();
 if (true) break;

case 17:
//C
this.state = 18;
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
this.state = 4;
;
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
this.catchState = 0;
 //BA.debugLineNum = 329;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5458801",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 330;BA.debugLine="ToastMessageShow(LastException,\"False\")";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),BA.ObjectToBoolean("False"));
 if (true) break;
if (true) break;

case 24:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _getpesodosado(String _bombatag) throws Exception{
ResumableSub_GetPesoDosado rsub = new ResumableSub_GetPesoDosado(null,_bombatag);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetPesoDosado extends BA.ResumableSub {
public ResumableSub_GetPesoDosado(unileverSU.pesagem.main parent,String _bombatag) {
this.parent = parent;
this._bombatag = _bombatag;
}
unileverSU.pesagem.main parent;
String _bombatag;
String _xxstringa = "";
String _xxpeso = "";
unileverSU.pesagem.httpjob _jobbomba = null;
String _xml_bombavdosado = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1267;BA.debugLine="Dim xxStringa As String";
_xxstringa = "";
 //BA.debugLineNum = 1268;BA.debugLine="Dim xxPeso As String";
_xxpeso = "";
 //BA.debugLineNum = 1269;BA.debugLine="Dim JobBomba As HttpJob";
_jobbomba = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1270;BA.debugLine="Dim XML_BombaVDosado As String";
_xml_bombavdosado = "";
 //BA.debugLineNum = 1275;BA.debugLine="XML_BombaVDosado = \"<?xml version='1.0' encoding=";
_xml_bombavdosado = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1276;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"<soap12:En";
_xml_bombavdosado = _xml_bombavdosado+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1277;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"<soap12:Bo";
_xml_bombavdosado = _xml_bombavdosado+"<soap12:Body>";
 //BA.debugLineNum = 1278;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"<Bomba_Get";
_xml_bombavdosado = _xml_bombavdosado+"<Bomba_GetValorDosado xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1279;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"<UserSoftw";
_xml_bombavdosado = _xml_bombavdosado+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1280;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"<PasswordS";
_xml_bombavdosado = _xml_bombavdosado+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1281;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"<BombaTag>";
_xml_bombavdosado = _xml_bombavdosado+"<BombaTag>"+_bombatag+"</BombaTag>";
 //BA.debugLineNum = 1282;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"</Bomba_Ge";
_xml_bombavdosado = _xml_bombavdosado+"</Bomba_GetValorDosado>";
 //BA.debugLineNum = 1283;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"</soap12:B";
_xml_bombavdosado = _xml_bombavdosado+"</soap12:Body>";
 //BA.debugLineNum = 1284;BA.debugLine="XML_BombaVDosado = XML_BombaVDosado & \"</soap12:E";
_xml_bombavdosado = _xml_bombavdosado+"</soap12:Envelope>";
 //BA.debugLineNum = 1286;BA.debugLine="Try";
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
 //BA.debugLineNum = 1287;BA.debugLine="JobBomba.Initialize(\"JOBSOAP\", Me)";
_jobbomba._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1288;BA.debugLine="JobBomba.PostString(URL, XML_BombaVDosado)";
_jobbomba._poststring /*String*/ (parent.mostCurrent._url,_xml_bombavdosado);
 //BA.debugLineNum = 1289;BA.debugLine="JobBomba.GetRequest.SetContentType(\"text/xml\")";
_jobbomba._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1290;BA.debugLine="WaiT For (JobBomba) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobbomba));
this.state = 13;
return;
case 13:
//C
this.state = 4;
;
 //BA.debugLineNum = 1291;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 14;
return;
case 14:
//C
this.state = 4;
;
 //BA.debugLineNum = 1292;BA.debugLine="XMLWork = JobBomba.GetString";
parent.mostCurrent._xmlwork = _jobbomba._getstring /*String*/ ();
 //BA.debugLineNum = 1293;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1294;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1296;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf(\"";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1297;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<xMs";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1298;BA.debugLine="xxPeso = XMLWork.SubString2(XMLWork.IndexOf(\"<xV";
_xxpeso = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xValor>")+8),parent.mostCurrent._xmlwork.indexOf("</xValor>"));
 //BA.debugLineNum = 1300;BA.debugLine="xxPeso = (xxPeso * 1000)";
_xxpeso = BA.NumberToString(((double)(Double.parseDouble(_xxpeso))*1000));
 //BA.debugLineNum = 1302;BA.debugLine="ToastMessageShow(xErro,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(parent.mostCurrent._xerro),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1304;BA.debugLine="If xxStringa = \"0\" Then";
if (true) break;

case 4:
//if
this.state = 9;
if ((_xxstringa).equals("0")) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 1305;BA.debugLine="EditTextPesoBomba.Text = xxPeso";
parent.mostCurrent._edittextpesobomba.setText(BA.ObjectToCharSequence(_xxpeso));
 //BA.debugLineNum = 1306;BA.debugLine="habilitaImpressaoETQ = True";
parent._habilitaimpressaoetq = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1308;BA.debugLine="ToastMessageShow(\"Não foi possível recuperar o";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Não foi possível recuperar o valor dosado da Bomba "+parent.mostCurrent._current_bombaid+". Verifique."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 9:
//C
this.state = 12;
;
 //BA.debugLineNum = 1311;BA.debugLine="JobBomba.Release";
_jobbomba._release /*String*/ ();
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 0;
 //BA.debugLineNum = 1314;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52621489",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 1315;BA.debugLine="ToastMessageShow(\"ERRO ao tentar recuperar o val";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ERRO ao tentar recuperar o valor dosado da Bomba "+parent.mostCurrent._current_bombaid+". Verifique."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1319;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _getreceita(boolean _state) throws Exception{
ResumableSub_GetReceita rsub = new ResumableSub_GetReceita(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetReceita extends BA.ResumableSub {
public ResumableSub_GetReceita(unileverSU.pesagem.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
unileverSU.pesagem.main parent;
boolean _state;
String _xml = "";
unileverSU.pesagem.httpjob _jobreceita = null;
String _xmlworkreceita = "";
anywheresoftware.b4a.objects.collections.List _l = null;
String _result = "";
int _quant = 0;
String _receita = "";
String _itemreceita = "";
int _j = 0;
String _codigomaterial = "";
String _descricaomaterial = "";
float _pesoreceita = 0f;
float _pesorota1 = 0f;
float _pesorota2 = 0f;
String _bomba = "";
String _unidade = "";
int _i = 0;
String _value = "";
int step38;
int limit38;
int step58;
int limit58;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 489;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 54;
this.catchState = 53;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 53;
 //BA.debugLineNum = 490;BA.debugLine="Do While state = True";
if (true) break;

case 4:
//do while
this.state = 51;
while (_state==anywheresoftware.b4a.keywords.Common.True) {
this.state = 6;
if (true) break;
}
if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 493;BA.debugLine="Dim XML As String";
_xml = "";
 //BA.debugLineNum = 494;BA.debugLine="Dim JobReceita As HttpJob";
_jobreceita = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 495;BA.debugLine="Dim XMLWorkReceita As String = \"\"";
_xmlworkreceita = "";
 //BA.debugLineNum = 497;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 498;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
 //BA.debugLineNum = 499;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
 //BA.debugLineNum = 500;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 501;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
 //BA.debugLineNum = 502;BA.debugLine="XML = XML & \"<GetReceita xmlns='http://www.apli";
_xml = _xml+"<GetReceita xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 503;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware>\"";
_xml = _xml+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 504;BA.debugLine="XML = XML & \"<PasswordSoftware>1234</PasswordSo";
_xml = _xml+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 505;BA.debugLine="XML = XML & \"<IdOrdemProducaoSAP>\" & IdOrdemPro";
_xml = _xml+"<IdOrdemProducaoSAP>"+parent.mostCurrent._idordemprodlist+"</IdOrdemProducaoSAP>";
 //BA.debugLineNum = 506;BA.debugLine="XML = XML & \"<Settore>\" & NomeTerminal & \"</Set";
_xml = _xml+"<Settore>"+parent.mostCurrent._nometerminal+"</Settore>";
 //BA.debugLineNum = 507;BA.debugLine="XML = XML & \"</GetReceita>\"";
_xml = _xml+"</GetReceita>";
 //BA.debugLineNum = 508;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
 //BA.debugLineNum = 509;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
 //BA.debugLineNum = 511;BA.debugLine="JobReceita.Initialize(\"JOBSOAPReceita\", Me)";
_jobreceita._initialize /*String*/ (processBA,"JOBSOAPReceita",main.getObject());
 //BA.debugLineNum = 512;BA.debugLine="JobReceita.PostString(URL.Trim,XML)";
_jobreceita._poststring /*String*/ (parent.mostCurrent._url.trim(),_xml);
 //BA.debugLineNum = 513;BA.debugLine="JobReceita.GetRequest.SetContentType(\"text/xml\"";
_jobreceita._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 514;BA.debugLine="Wait For (JobReceita) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobreceita));
this.state = 55;
return;
case 55:
//C
this.state = 7;
;
 //BA.debugLineNum = 517;BA.debugLine="If JobReceita.Success = True Then";
if (true) break;

case 7:
//if
this.state = 50;
if (_jobreceita._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 518;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 519;BA.debugLine="l.Initialize";
_l.Initialize();
 //BA.debugLineNum = 520;BA.debugLine="XMLWorkReceita = JobReceita.GetString";
_xmlworkreceita = _jobreceita._getstring /*String*/ ();
 //BA.debugLineNum = 521;BA.debugLine="XMLWorkReceita = XMLWorkReceita.Replace(\"&lt;\"";
_xmlworkreceita = _xmlworkreceita.replace("&lt;","<");
 //BA.debugLineNum = 522;BA.debugLine="XMLWorkReceita = XMLWorkReceita.Replace(\"&gt;\"";
_xmlworkreceita = _xmlworkreceita.replace("&gt;",">");
 //BA.debugLineNum = 524;BA.debugLine="JobReceita.Release";
_jobreceita._release /*String*/ ();
 //BA.debugLineNum = 526;BA.debugLine="If XMLWorkReceita.Contains(\"<GetReceitaResult>";
if (true) break;

case 10:
//if
this.state = 49;
if (_xmlworkreceita.contains("<GetReceitaResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 527;BA.debugLine="Dim Result As String = XMLWorkReceita.SubStri";
_result = _xmlworkreceita.substring((int) (_xmlworkreceita.indexOf("<Erro>")+6),_xmlworkreceita.indexOf("</Erro>"));
 //BA.debugLineNum = 528;BA.debugLine="Dim Quant As Int = XMLWorkReceita.SubString2(";
_quant = (int)(Double.parseDouble(_xmlworkreceita.substring((int) (_xmlworkreceita.indexOf("<Quantidade>")+12),_xmlworkreceita.indexOf("</Quantidade>"))));
 //BA.debugLineNum = 530;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 13:
//if
this.state = 48;
if ((_result).equals("sucesso")) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 531;BA.debugLine="Dim Receita As String =  XMLWorkReceita.SubS";
_receita = _xmlworkreceita.substring((int) (_xmlworkreceita.indexOf("<Receitas>")+9),_xmlworkreceita.indexOf("</Receitas>"));
 //BA.debugLineNum = 533;BA.debugLine="LabelPesgaemTTitulo.Text = \"CUC/Material: \"";
parent.mostCurrent._labelpesgaemttitulo.setText(BA.ObjectToCharSequence("CUC/Material: "+parent.mostCurrent._idordemprodlist));
 //BA.debugLineNum = 535;BA.debugLine="If Quant > 0 Then";
if (true) break;

case 16:
//if
this.state = 47;
if (_quant>0) { 
this.state = 18;
}else {
this.state = 46;
}if (true) break;

case 18:
//C
this.state = 19;
 //BA.debugLineNum = 536;BA.debugLine="Dim ItemReceita As String =  Receita.SubStr";
_itemreceita = _receita.substring((int) (_receita.indexOf("<ItemReceita>")+13),_receita.indexOf("</ItemReceita>"));
 //BA.debugLineNum = 537;BA.debugLine="For j=0 To Quant-1";
if (true) break;

case 19:
//for
this.state = 44;
step38 = 1;
limit38 = (int) (_quant-1);
_j = (int) (0) ;
this.state = 56;
if (true) break;

case 56:
//C
this.state = 44;
if ((step38 > 0 && _j <= limit38) || (step38 < 0 && _j >= limit38)) this.state = 21;
if (true) break;

case 57:
//C
this.state = 56;
_j = ((int)(0 + _j + step38)) ;
if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 538;BA.debugLine="If Receita.Contains(\"<ItemReceita>\") = Tru";
if (true) break;

case 22:
//if
this.state = 25;
if (_receita.contains("<ItemReceita>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 539;BA.debugLine="ItemReceita =  Receita.SubString2(Receita";
_itemreceita = _receita.substring((int) (_receita.indexOf("<ItemReceita>")+13),_receita.indexOf("</ItemReceita>"));
 if (true) break;

case 25:
//C
this.state = 26;
;
 //BA.debugLineNum = 542;BA.debugLine="Dim CodigoMaterial As String = ItemReceita";
_codigomaterial = _itemreceita.substring((int) (_itemreceita.indexOf("<CodigoMaterial>")+16),_itemreceita.indexOf("</CodigoMaterial>"));
 //BA.debugLineNum = 543;BA.debugLine="Dim DescricaoMaterial As String = ItemRece";
_descricaomaterial = _itemreceita.substring((int) (_itemreceita.indexOf("<DescricaoMaterial>")+19),_itemreceita.indexOf("</DescricaoMaterial>"));
 //BA.debugLineNum = 544;BA.debugLine="Dim PesoReceita As Float = ItemReceita.Sub";
_pesoreceita = (float)(Double.parseDouble(_itemreceita.substring((int) (_itemreceita.indexOf("<PesoReceita>")+13),_itemreceita.indexOf("</PesoReceita>"))));
 //BA.debugLineNum = 545;BA.debugLine="Dim PesoRota1 As Float = ItemReceita.SubSt";
_pesorota1 = (float)(Double.parseDouble(_itemreceita.substring((int) (_itemreceita.indexOf("<PesoRota1>")+11),_itemreceita.indexOf("</PesoRota1>"))));
 //BA.debugLineNum = 546;BA.debugLine="Dim PesoRota2 As Float = ItemReceita.SubSt";
_pesorota2 = (float)(Double.parseDouble(_itemreceita.substring((int) (_itemreceita.indexOf("<PesoRota2>")+11),_itemreceita.indexOf("</PesoRota2>"))));
 //BA.debugLineNum = 549;BA.debugLine="Dim Bomba As String = ItemReceita.SubStrin";
_bomba = _itemreceita.substring((int) (_itemreceita.indexOf("<IdBomba>")+9),_itemreceita.indexOf("</IdBomba>"));
 //BA.debugLineNum = 551;BA.debugLine="If Bomba = \"0\" Then";
if (true) break;

case 26:
//if
this.state = 29;
if ((_bomba).equals("0")) { 
this.state = 28;
}if (true) break;

case 28:
//C
this.state = 29;
 //BA.debugLineNum = 552;BA.debugLine="Bomba = \"Não vinculado.\"";
_bomba = "Não vinculado.";
 if (true) break;
;
 //BA.debugLineNum = 555;BA.debugLine="If ItemReceita.Contains(\"<UnidadePeso>\") T";

case 29:
//if
this.state = 32;
if (_itemreceita.contains("<UnidadePeso>")) { 
this.state = 31;
}if (true) break;

case 31:
//C
this.state = 32;
 //BA.debugLineNum = 556;BA.debugLine="Dim Unidade As String = ItemReceita.SubSt";
_unidade = _itemreceita.substring((int) (_itemreceita.indexOf("<UnidadePeso>")+13),_itemreceita.indexOf("</UnidadePeso>"));
 if (true) break;

case 32:
//C
this.state = 33;
;
 //BA.debugLineNum = 566;BA.debugLine="l.Add(Array(CodigoMaterial & \" - \" & Descr";
_l.Add((Object)(new Object[]{(Object)(_codigomaterial+" - "+_descricaomaterial),(Object)(_unidade),(Object)(anywheresoftware.b4a.keywords.Common.NumberFormat(_pesoreceita,(int) (1),(int) (3))),(Object)(anywheresoftware.b4a.keywords.Common.NumberFormat(_pesorota1,(int) (1),(int) (3))),(Object)(anywheresoftware.b4a.keywords.Common.NumberFormat(_pesorota2,(int) (1),(int) (3))),(Object)(_bomba)}));
 //BA.debugLineNum = 567;BA.debugLine="If j < Quant And Receita.Contains(\"<ItemRe";
if (true) break;

case 33:
//if
this.state = 36;
if (_j<_quant && _receita.contains("<ItemReceita>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 35;
}if (true) break;

case 35:
//C
this.state = 36;
 //BA.debugLineNum = 568;BA.debugLine="Receita = Receita.SubString(Receita.Index";
_receita = _receita.substring((int) (_receita.indexOf("</ItemReceita>")+14));
 if (true) break;
;
 //BA.debugLineNum = 571;BA.debugLine="For i=0 To ListViewOP.Size-1";

case 36:
//for
this.state = 43;
step58 = 1;
limit58 = (int) (parent.mostCurrent._listviewop.getSize()-1);
_i = (int) (0) ;
this.state = 58;
if (true) break;

case 58:
//C
this.state = 43;
if ((step58 > 0 && _i <= limit58) || (step58 < 0 && _i >= limit58)) this.state = 38;
if (true) break;

case 59:
//C
this.state = 58;
_i = ((int)(0 + _i + step58)) ;
if (true) break;

case 38:
//C
this.state = 39;
 //BA.debugLineNum = 572;BA.debugLine="Dim Value As String = ListViewOP.GetItem(";
_value = BA.ObjectToString(parent.mostCurrent._listviewop.GetItem(_i));
 //BA.debugLineNum = 573;BA.debugLine="If IdOrdemProdList == Value Then";
if (true) break;

case 39:
//if
this.state = 42;
if ((parent.mostCurrent._idordemprodlist).equals(_value)) { 
this.state = 41;
}if (true) break;

case 41:
//C
this.state = 42;
 //BA.debugLineNum = 574;BA.debugLine="ListViewOP.SetSelection(i)";
parent.mostCurrent._listviewop.SetSelection(_i);
 if (true) break;

case 42:
//C
this.state = 59;
;
 if (true) break;
if (true) break;

case 43:
//C
this.state = 57;
;
 if (true) break;
if (true) break;

case 44:
//C
this.state = 47;
;
 if (true) break;

case 46:
//C
this.state = 47;
 //BA.debugLineNum = 579;BA.debugLine="l.Clear";
_l.Clear();
 if (true) break;

case 47:
//C
this.state = 48;
;
 //BA.debugLineNum = 582;BA.debugLine="B4XTablePesagem.SetData(l)";
parent.mostCurrent._b4xtablepesagem._setdata /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (_l);
 //BA.debugLineNum = 583;BA.debugLine="col1.Width = 400";
parent.mostCurrent._col1.Width /*int*/  = (int) (400);
 //BA.debugLineNum = 584;BA.debugLine="col2.Width = 200";
parent.mostCurrent._col2.Width /*int*/  = (int) (200);
 //BA.debugLineNum = 585;BA.debugLine="col3.Width = 200";
parent.mostCurrent._col3.Width /*int*/  = (int) (200);
 //BA.debugLineNum = 586;BA.debugLine="col4.Width = 150";
parent.mostCurrent._col4.Width /*int*/  = (int) (150);
 //BA.debugLineNum = 587;BA.debugLine="col5.Width = 150";
parent.mostCurrent._col5.Width /*int*/  = (int) (150);
 //BA.debugLineNum = 588;BA.debugLine="col6.Width = 150";
parent.mostCurrent._col6.Width /*int*/  = (int) (150);
 //BA.debugLineNum = 591;BA.debugLine="B4XTablePesagem.Refresh";
parent.mostCurrent._b4xtablepesagem._refresh /*String*/ ();
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
this.state = 4;
;
 if (true) break;

case 51:
//C
this.state = 54;
;
 if (true) break;

case 53:
//C
this.state = 54;
this.catchState = 0;
 //BA.debugLineNum = 597;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("5655469",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 598;BA.debugLine="ToastMessageShow(LastException,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 54:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 600;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Dim myABBarcode As ABZxing";
mostCurrent._myabbarcode = new com.AB.ABZxing.ABZxing();
 //BA.debugLineNum = 23;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private XMLWork As String";
mostCurrent._xmlwork = "";
 //BA.debugLineNum = 25;BA.debugLine="Private URL As String = \"\"";
mostCurrent._url = "";
 //BA.debugLineNum = 26;BA.debugLine="Private ImageViewAplipack As ImageView";
mostCurrent._imageviewaplipack = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private ImageViewUnilever As ImageView";
mostCurrent._imageviewunilever = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private LabelClockTV As Label";
mostCurrent._labelclocktv = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private LabelOP As Label";
mostCurrent._labelop = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private LabelPesgaemTTitulo As Label";
mostCurrent._labelpesgaemttitulo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private ListViewOP As ListView";
mostCurrent._listviewop = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim IdOrdemProdList As String = \"0\"";
mostCurrent._idordemprodlist = "0";
 //BA.debugLineNum = 33;BA.debugLine="Dim IdOrdemProdListCompare As String = \"0\"";
mostCurrent._idordemprodlistcompare = "0";
 //BA.debugLineNum = 34;BA.debugLine="Private ListViewAvisos As ListView";
mostCurrent._listviewavisos = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private B4XTablePesagem As B4XTable";
mostCurrent._b4xtablepesagem = new unileverSU.pesagem.b4xtable();
 //BA.debugLineNum = 36;BA.debugLine="Private PanelPesagem As Panel";
mostCurrent._panelpesagem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private ButtonOP0 As Button";
mostCurrent._buttonop0 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private ButtonOP1 As Button";
mostCurrent._buttonop1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private ButtonOP2 As Button";
mostCurrent._buttonop2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private ButtonOP3 As Button";
mostCurrent._buttonop3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private ButtonOP4 As Button";
mostCurrent._buttonop4 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Dim OPSelecionadaButton As Int = 1";
_opselecionadabutton = (int) (1);
 //BA.debugLineNum = 43;BA.debugLine="Private ButtonBarcodeScan As Button";
mostCurrent._buttonbarcodescan = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private ButtonClearBarcode As Button";
mostCurrent._buttonclearbarcode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private EditTextBarcode As EditText";
mostCurrent._edittextbarcode = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private ButtonRota1 As Button";
mostCurrent._buttonrota1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private ButtonRota2 As Button";
mostCurrent._buttonrota2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Dim RotaSelcionada As Int";
_rotaselcionada = 0;
 //BA.debugLineNum = 49;BA.debugLine="Dim idSSCC As String";
mostCurrent._idsscc = "";
 //BA.debugLineNum = 50;BA.debugLine="Dim idProduto As String";
mostCurrent._idproduto = "";
 //BA.debugLineNum = 51;BA.debugLine="Dim SSCC As String";
mostCurrent._sscc = "";
 //BA.debugLineNum = 53;BA.debugLine="Private ButtonGravar As Button";
mostCurrent._buttongravar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private ButtonLimpar As Button";
mostCurrent._buttonlimpar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private ButtonVoltar As Button";
mostCurrent._buttonvoltar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private EditTextLinha As EditText";
mostCurrent._edittextlinha = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private EditTextWebservice As EditText";
mostCurrent._edittextwebservice = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private PanelMain As Panel";
mostCurrent._panelmain = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private PanelSettings As Panel";
mostCurrent._panelsettings = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private PanelLogin As Panel";
mostCurrent._panellogin = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private AddressWebservice As String = \"\"";
mostCurrent._addresswebservice = "";
 //BA.debugLineNum = 64;BA.debugLine="Private NomeTerminal As String = \"\"";
mostCurrent._nometerminal = "";
 //BA.debugLineNum = 66;BA.debugLine="Private ButtonLimparLogin As Button";
mostCurrent._buttonlimparlogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private ButtonLogin As Button";
mostCurrent._buttonlogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private ButtonVoltarLogin As Button";
mostCurrent._buttonvoltarlogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private EditTextSenhaLogin As EditText";
mostCurrent._edittextsenhalogin = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private EditTextUsuarioLogin As EditText";
mostCurrent._edittextusuariologin = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private LabelClockLogin As Label";
mostCurrent._labelclocklogin = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Dim PanelPesagem2 As Panel";
mostCurrent._panelpesagem2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private ButtonCancelarPesagem As Button";
mostCurrent._buttoncancelarpesagem = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private ButtonConcluirPesagem As Button";
mostCurrent._buttonconcluirpesagem = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private ButtonDesligarBomba As Button";
mostCurrent._buttondesligarbomba = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private ButtonLigarBomba As Button";
mostCurrent._buttonligarbomba = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private LabelFuncaoBomba As Label";
mostCurrent._labelfuncaobomba = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private ButtonVoltarPesagem As Button";
mostCurrent._buttonvoltarpesagem = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private ListViewAvisoPesagem As ListView";
mostCurrent._listviewavisopesagem = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Dim xErro As String";
mostCurrent._xerro = "";
 //BA.debugLineNum = 85;BA.debugLine="Private EditTextPesoRequerido As EditText";
mostCurrent._edittextpesorequerido = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Private EditTextPesoBomba As EditText";
mostCurrent._edittextpesobomba = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Dim StatusBomba As Boolean";
_statusbomba = false;
 //BA.debugLineNum = 89;BA.debugLine="Dim FinalizadoDosagem As Boolean";
_finalizadodosagem = false;
 //BA.debugLineNum = 91;BA.debugLine="Dim habilitaImpressaoETQ As Boolean";
_habilitaimpressaoetq = false;
 //BA.debugLineNum = 92;BA.debugLine="Dim ImpressoraIP As String = \"\"";
mostCurrent._impressoraip = "";
 //BA.debugLineNum = 93;BA.debugLine="Dim ImpressoraPorta As String = \"9100\"";
mostCurrent._impressoraporta = "9100";
 //BA.debugLineNum = 94;BA.debugLine="Dim ZPLEtiqueta As String";
mostCurrent._zpletiqueta = "";
 //BA.debugLineNum = 96;BA.debugLine="ZPLEtiqueta = \"^XA^PW1279\"";
mostCurrent._zpletiqueta = "^XA^PW1279";
 //BA.debugLineNum = 97;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^BY4,3,112^FT37,984^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^BY4,3,112^FT37,984^BCN,,Y,N";
 //BA.debugLineNum = 98;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FD&gt;:@peso@^FS\"";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FD&gt;:@peso@^FS";
 //BA.debugLineNum = 99;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^BY4,3,112^FT36,748^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^BY4,3,112^FT36,748^BCN,,Y,N";
 //BA.debugLineNum = 100;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FD&gt;;100000000000";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FD&gt;;10000000000000000001^FS";
 //BA.debugLineNum = 101;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^BY4,3,112^FT37,509^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^BY4,3,112^FT37,509^BCN,,Y,N";
 //BA.debugLineNum = 102;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FD&gt;:@codmaterial";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FD&gt;:@codmaterial@^FS";
 //BA.debugLineNum = 103;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT412,260^A0N,28,28";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT412,260^A0N,28,28^FH\\^FDTamanho Batch: @batch@^FS";
 //BA.debugLineNum = 104;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT36,259^A0N,28,28^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT36,259^A0N,28,28^FH\\^FDOrdem Prod: @ordemprod@^FS";
 //BA.debugLineNum = 105;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^BY2,3,56^FT43,95^BC";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^BY2,3,56^FT43,95^BCN,,Y,N";
 //BA.debugLineNum = 106;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FD&gt;:@barcode@^FS";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FD&gt;:@barcode@^FS";
 //BA.debugLineNum = 107;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT37,850^A0N,45,45^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT37,850^A0N,45,45^FH\\^FDPeso KG^FS";
 //BA.debugLineNum = 108;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT37,615^A0N,45,45^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT37,615^A0N,45,45^FH\\^FDLote^FS";
 //BA.debugLineNum = 109;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT36,208^A0N,28,28^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT36,208^A0N,28,28^FH\\^FDDescricao: @descris@^FS";
 //BA.debugLineNum = 110;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT37,376^A0N,45,45^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT37,376^A0N,45,45^FH\\^FDMaterial^FS";
 //BA.debugLineNum = 111;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT466,1112^A0N,28,2";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT466,1112^A0N,28,28^FH\\^FDPhysical Hazard: @phys@^FS";
 //BA.debugLineNum = 112;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT328,1159^A0N,28,2";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT328,1159^A0N,28,28^FH\\^FDData Prod: @dataprod@^FS";
 //BA.debugLineNum = 113;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT37,1159^A0N,28,28";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT37,1159^A0N,28,28^FH\\^FDValidade: @validade@^FS";
 //BA.debugLineNum = 114;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT266,1112^A0N,28,2";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT266,1112^A0N,28,28^FH\\^FDFlam: @flam@^FS";
 //BA.debugLineNum = 115;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT421,180^A0N,23,24";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT421,180^A0N,23,24^FH\\^FDTerminal: @terminal@^FS";
 //BA.debugLineNum = 116;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT421,141^A0N,23,24";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT421,141^A0N,23,24^FH\\^FDBalanca: @balanca@^FS";
 //BA.debugLineNum = 117;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT421,105^A0N,23,24";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT421,105^A0N,23,24^FH\\^FDUsuario: @user@^FS";
 //BA.debugLineNum = 118;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT38,1112^A0N,28,28";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT38,1112^A0N,28,28^FH\\^FDHealth: @health@^FS";
 //BA.debugLineNum = 119;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT421,65^A0N,23,24^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT421,65^A0N,23,24^FH\\^FD@data@^FS";
 //BA.debugLineNum = 120;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT36,159^A0N,28,28^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT36,159^A0N,28,28^FH\\^FDCodigo: @cod@^FS";
 //BA.debugLineNum = 121;BA.debugLine="ZPLEtiqueta = ZPLEtiqueta & \"^FT815,999^BQN,2,10^";
mostCurrent._zpletiqueta = mostCurrent._zpletiqueta+"^FT815,999^BQN,2,10^FDMA,@cod@|@peso@|10000000000000000001^FS^PQ1,0,1,Y^XZ";
 //BA.debugLineNum = 123;BA.debugLine="Dim retornoBalancaStatus As Boolean";
_retornobalancastatus = false;
 //BA.debugLineNum = 124;BA.debugLine="Dim retorno_Bomba As Boolean";
_retorno_bomba = false;
 //BA.debugLineNum = 126;BA.debugLine="Dim XML_BombaStatus As String";
mostCurrent._xml_bombastatus = "";
 //BA.debugLineNum = 128;BA.debugLine="Dim Login_Status As Boolean";
_login_status = false;
 //BA.debugLineNum = 129;BA.debugLine="Dim Current_User As String";
mostCurrent._current_user = "";
 //BA.debugLineNum = 130;BA.debugLine="Dim Current_PWD As String";
mostCurrent._current_pwd = "";
 //BA.debugLineNum = 132;BA.debugLine="Dim Current_BombaID As String";
mostCurrent._current_bombaid = "";
 //BA.debugLineNum = 133;BA.debugLine="Dim Prefix_Bomba As String";
mostCurrent._prefix_bomba = "";
 //BA.debugLineNum = 134;BA.debugLine="Dim Prefix_Balanca As String";
mostCurrent._prefix_balanca = "";
 //BA.debugLineNum = 135;BA.debugLine="Dim Prefix_CLP As String";
mostCurrent._prefix_clp = "";
 //BA.debugLineNum = 136;BA.debugLine="Dim Peso As String";
mostCurrent._peso = "";
 //BA.debugLineNum = 138;BA.debugLine="Private col1, col2, col3, col4, col5, col6 As B4X";
mostCurrent._col1 = new unileverSU.pesagem.b4xtable._b4xtablecolumn();
mostCurrent._col2 = new unileverSU.pesagem.b4xtable._b4xtablecolumn();
mostCurrent._col3 = new unileverSU.pesagem.b4xtable._b4xtablecolumn();
mostCurrent._col4 = new unileverSU.pesagem.b4xtable._b4xtablecolumn();
mostCurrent._col5 = new unileverSU.pesagem.b4xtable._b4xtablecolumn();
mostCurrent._col6 = new unileverSU.pesagem.b4xtable._b4xtablecolumn();
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _imageviewaplipack_click() throws Exception{
 //BA.debugLineNum = 667;BA.debugLine="Sub ImageViewAplipack_Click";
 //BA.debugLineNum = 668;BA.debugLine="PanelLogin.Visible = True";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 669;BA.debugLine="PanelMain.Visible = False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 670;BA.debugLine="End Sub";
return "";
}
public static void  _imprimezebra(String _eptzpl,String _eptip,int _eptporta) throws Exception{
ResumableSub_ImprimeZebra rsub = new ResumableSub_ImprimeZebra(null,_eptzpl,_eptip,_eptporta);
rsub.resume(processBA, null);
}
public static class ResumableSub_ImprimeZebra extends BA.ResumableSub {
public ResumableSub_ImprimeZebra(unileverSU.pesagem.main parent,String _eptzpl,String _eptip,int _eptporta) {
this.parent = parent;
this._eptzpl = _eptzpl;
this._eptip = _eptip;
this._eptporta = _eptporta;
}
unileverSU.pesagem.main parent;
String _eptzpl;
String _eptip;
int _eptporta;
String _xxstringa = "";
unileverSU.pesagem.httpjob _jobzebra = null;
String _xml_zebra = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1374;BA.debugLine="Dim xxStringa As String";
_xxstringa = "";
 //BA.debugLineNum = 1375;BA.debugLine="Dim JobZebra As HttpJob";
_jobzebra = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1376;BA.debugLine="Dim XML_Zebra As String";
_xml_zebra = "";
 //BA.debugLineNum = 1379;BA.debugLine="retornoBalancaStatus = False";
parent._retornobalancastatus = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1381;BA.debugLine="XML_Zebra = \"<?xml version='1.0' encoding='utf-8'";
_xml_zebra = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1382;BA.debugLine="XML_Zebra = XML_Zebra & \"<soap12:Envelope xmlns:x";
_xml_zebra = _xml_zebra+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1383;BA.debugLine="XML_Zebra = XML_Zebra & \"<soap12:Body>\"";
_xml_zebra = _xml_zebra+"<soap12:Body>";
 //BA.debugLineNum = 1384;BA.debugLine="XML_Zebra = XML_Zebra & \"<ImprimeZPL xmlns='http:";
_xml_zebra = _xml_zebra+"<ImprimeZPL xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1385;BA.debugLine="XML_Zebra = XML_Zebra & \"<UserSoftware>user</User";
_xml_zebra = _xml_zebra+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1386;BA.debugLine="XML_Zebra = XML_Zebra & \"<PasswordSoftware>1234</";
_xml_zebra = _xml_zebra+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1387;BA.debugLine="XML_Zebra = XML_Zebra & \"<EptZPL>\" & eptZPL & \"</";
_xml_zebra = _xml_zebra+"<EptZPL>"+_eptzpl+"</EptZPL>";
 //BA.debugLineNum = 1388;BA.debugLine="XML_Zebra = XML_Zebra & \"<eptIP>\" & eptIP & \"</ep";
_xml_zebra = _xml_zebra+"<eptIP>"+_eptip+"</eptIP>";
 //BA.debugLineNum = 1389;BA.debugLine="XML_Zebra = XML_Zebra & \"<eptPorta>\" & eptPorta &";
_xml_zebra = _xml_zebra+"<eptPorta>"+BA.NumberToString(_eptporta)+"</eptPorta>";
 //BA.debugLineNum = 1390;BA.debugLine="XML_Zebra = XML_Zebra & \"</ImprimeZPL>\"";
_xml_zebra = _xml_zebra+"</ImprimeZPL>";
 //BA.debugLineNum = 1391;BA.debugLine="XML_Zebra = XML_Zebra & \"</soap12:Body>\"";
_xml_zebra = _xml_zebra+"</soap12:Body>";
 //BA.debugLineNum = 1392;BA.debugLine="XML_Zebra = XML_Zebra & \"</soap12:Envelope>\"";
_xml_zebra = _xml_zebra+"</soap12:Envelope>";
 //BA.debugLineNum = 1394;BA.debugLine="Try";
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
 //BA.debugLineNum = 1395;BA.debugLine="JobZebra.Initialize(\"JOBSOAP\", Me)";
_jobzebra._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1396;BA.debugLine="JobZebra.PostString(URL, XML_Zebra)";
_jobzebra._poststring /*String*/ (parent.mostCurrent._url,_xml_zebra);
 //BA.debugLineNum = 1397;BA.debugLine="JobZebra.GetRequest.SetContentType(\"text/xml\")";
_jobzebra._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1398;BA.debugLine="WaiT For (JobZebra) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobzebra));
this.state = 13;
return;
case 13:
//C
this.state = 4;
;
 //BA.debugLineNum = 1399;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 14;
return;
case 14:
//C
this.state = 4;
;
 //BA.debugLineNum = 1401;BA.debugLine="XMLWork = JobZebra.GetString";
parent.mostCurrent._xmlwork = _jobzebra._getstring /*String*/ ();
 //BA.debugLineNum = 1402;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1403;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1405;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf(\"";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1408;BA.debugLine="If xxStringa.Trim() = \"\" Then";
if (true) break;

case 4:
//if
this.state = 9;
if ((_xxstringa.trim()).equals("")) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 1410;BA.debugLine="ToastMessageShow(\"Etiqueta enviada para impress";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Etiqueta enviada para impressão."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1412;BA.debugLine="ToastMessageShow(\"ERRO ao tentar imprimir a eti";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ERRO ao tentar imprimir a etiqueta. Verifique."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 9:
//C
this.state = 12;
;
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 0;
 //BA.debugLineNum = 1415;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52752555",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1419;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _jobdone(unileverSU.pesagem.httpjob _job) throws Exception{
 //BA.debugLineNum = 1000;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 1002;BA.debugLine="End Sub";
return "";
}
public static void  _listviewop_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewOP_ItemClick rsub = new ResumableSub_ListViewOP_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewOP_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewOP_ItemClick(unileverSU.pesagem.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
unileverSU.pesagem.main parent;
int _position;
Object _value;
String _xmlwork2 = "";
int _opselecionada = 0;
unileverSU.pesagem.httpjob _jobop2 = null;
String _xml = "";
String _result = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 750;BA.debugLine="Try";
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
 //BA.debugLineNum = 753;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
 //BA.debugLineNum = 754;BA.debugLine="Dim OPSelecionada As Int = Value";
_opselecionada = (int)(BA.ObjectToNumber(_value));
 //BA.debugLineNum = 755;BA.debugLine="Dim JobOP2 As HttpJob";
_jobop2 = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 757;BA.debugLine="Dim XML As String";
_xml = "";
 //BA.debugLineNum = 759;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 760;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
 //BA.debugLineNum = 761;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
 //BA.debugLineNum = 762;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 763;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
 //BA.debugLineNum = 764;BA.debugLine="XML = XML & \"<SelecionaOP xmlns='http://www.apli";
_xml = _xml+"<SelecionaOP xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 765;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware>\"";
_xml = _xml+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 766;BA.debugLine="XML = XML & \"<PasswordSoftware>1234</PasswordSof";
_xml = _xml+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 767;BA.debugLine="XML = XML & \"<Settore>\" & OPSelecionadaButton &";
_xml = _xml+"<Settore>"+BA.NumberToString(parent._opselecionadabutton)+"</Settore>";
 //BA.debugLineNum = 768;BA.debugLine="XML = XML & \"<IdOrdemProd>\" & OPSelecionada & \"<";
_xml = _xml+"<IdOrdemProd>"+BA.NumberToString(_opselecionada)+"</IdOrdemProd>";
 //BA.debugLineNum = 769;BA.debugLine="XML = XML & \"</SelecionaOP>\"";
_xml = _xml+"</SelecionaOP>";
 //BA.debugLineNum = 770;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
 //BA.debugLineNum = 771;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
 //BA.debugLineNum = 773;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
_jobop2._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 774;BA.debugLine="JobOP2.PostString(URL,XML.Trim)";
_jobop2._poststring /*String*/ (parent.mostCurrent._url,_xml.trim());
 //BA.debugLineNum = 775;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
_jobop2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 776;BA.debugLine="Wait For (JobOP2) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobop2));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
 //BA.debugLineNum = 779;BA.debugLine="If JobOP2.Success = True Then";
if (true) break;

case 4:
//if
this.state = 17;
if (_jobop2._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 780;BA.debugLine="XMLWork2 = JobOP2.GetString";
_xmlwork2 = _jobop2._getstring /*String*/ ();
 //BA.debugLineNum = 781;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
 //BA.debugLineNum = 782;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
 //BA.debugLineNum = 783;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
 //BA.debugLineNum = 785;BA.debugLine="If XMLWork2.Contains(\"<SelecionaOPResult>\") = T";
if (true) break;

case 7:
//if
this.state = 16;
if (_xmlwork2.contains("<SelecionaOPResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 786;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
 //BA.debugLineNum = 787;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 10:
//if
this.state = 15;
if ((_result).equals("sucesso")) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 //BA.debugLineNum = 788;BA.debugLine="ToastMessageShow(\"OP selecionada com sucesso.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("OP selecionada com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 789;BA.debugLine="LabelPesgaemTTitulo.Text = \"CUC/Material: \" &";
parent.mostCurrent._labelpesgaemttitulo.setText(BA.ObjectToCharSequence("CUC/Material: "+BA.NumberToString(_opselecionada)));
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 791;BA.debugLine="ToastMessageShow(\"Falha ao selecionar OP, ten";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Falha ao selecionar OP, tente novamente."),anywheresoftware.b4a.keywords.Common.False);
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
 //BA.debugLineNum = 795;BA.debugLine="JobOP2.Release";
_jobop2._release /*String*/ ();
 if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
 //BA.debugLineNum = 797;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("51245232",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 798;BA.debugLine="ToastMessageShow(\"Erro ao enviar OP selecionada.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao enviar OP selecionada."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 801;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _myabbarcode_barcodefound(String _barcode,String _formatname) throws Exception{
 //BA.debugLineNum = 871;BA.debugLine="Sub myABBarcode_BarcodeFound (Barcode As String, f";
 //BA.debugLineNum = 873;BA.debugLine="Try";
try { //BA.debugLineNum = 874;BA.debugLine="If formatName=\"QR_CODE\" And Barcode.Contains(\"|\"";
if ((_formatname).equals("QR_CODE") && _barcode.contains("|")==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 875;BA.debugLine="idSSCC = Barcode.SubString2(0,9)";
mostCurrent._idsscc = _barcode.substring((int) (0),(int) (9));
 //BA.debugLineNum = 876;BA.debugLine="idProduto =  Barcode.SubString2(10,18)";
mostCurrent._idproduto = _barcode.substring((int) (10),(int) (18));
 //BA.debugLineNum = 877;BA.debugLine="SSCC =  Barcode.SubString(19)";
mostCurrent._sscc = _barcode.substring((int) (19));
 //BA.debugLineNum = 878;BA.debugLine="PanelPesagem2.Visible = True";
mostCurrent._panelpesagem2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 879;BA.debugLine="PanelMain.Visible = False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 } 
       catch (Exception e10) {
			processBA.setLastException(e10); //BA.debugLineNum = 882;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("51835019",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 883;BA.debugLine="ToastMessageShow(\"Erro ao processar código.\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao processar código."),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 886;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
autostart._process_globals();
starter._process_globals();
httputils2service._process_globals();
xuiviewsutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim sql1 As SQL";
_sql1 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 17;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static void  _startdosagem(String _bombaid,int _pesodosagem) throws Exception{
ResumableSub_StartDosagem rsub = new ResumableSub_StartDosagem(null,_bombaid,_pesodosagem);
rsub.resume(processBA, null);
}
public static class ResumableSub_StartDosagem extends BA.ResumableSub {
public ResumableSub_StartDosagem(unileverSU.pesagem.main parent,String _bombaid,int _pesodosagem) {
this.parent = parent;
this._bombaid = _bombaid;
this._pesodosagem = _pesodosagem;
}
unileverSU.pesagem.main parent;
String _bombaid;
int _pesodosagem;
String _xxstringa = "";
unileverSU.pesagem.httpjob _jobbomba = null;
unileverSU.pesagem.httpjob _jobbomba2 = null;
unileverSU.pesagem.httpjob _jobbomba3 = null;
String _xml_bombasetpoint = "";
String _xml_bombastart = "";
String _bombastart = "";
boolean _retorno = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1071;BA.debugLine="Dim xxStringa As String";
_xxstringa = "";
 //BA.debugLineNum = 1072;BA.debugLine="Dim JobBomba As HttpJob";
_jobbomba = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1073;BA.debugLine="Dim JobBomba2 As HttpJob";
_jobbomba2 = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1074;BA.debugLine="Dim JobBomba3 As HttpJob";
_jobbomba3 = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1075;BA.debugLine="Dim XML_BombaStatus As String";
parent.mostCurrent._xml_bombastatus = "";
 //BA.debugLineNum = 1076;BA.debugLine="Dim XML_BombaSetPoint As String";
_xml_bombasetpoint = "";
 //BA.debugLineNum = 1077;BA.debugLine="Dim XML_BombaStart As String";
_xml_bombastart = "";
 //BA.debugLineNum = 1079;BA.debugLine="Dim BombaStart As String = \"true\"";
_bombastart = "true";
 //BA.debugLineNum = 1080;BA.debugLine="Dim retorno As Boolean = True";
_retorno = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1087;BA.debugLine="XML_BombaStatus = \"<?xml version='1.0' encoding='";
parent.mostCurrent._xml_bombastatus = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1088;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<soap12:Enve";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1089;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<soap12:Body";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<soap12:Body>";
 //BA.debugLineNum = 1090;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<Bomba_GetSt";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<Bomba_GetStatus xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1093;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<UserSoftwar";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1094;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<PasswordSof";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1095;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<BombaTag>\"";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<BombaTag>"+_bombaid+"</BombaTag>";
 //BA.debugLineNum = 1096;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"</Bomba_GetS";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"</Bomba_GetStatus>";
 //BA.debugLineNum = 1097;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"</soap12:Bod";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"</soap12:Body>";
 //BA.debugLineNum = 1098;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"</soap12:Env";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"</soap12:Envelope>";
 //BA.debugLineNum = 1100;BA.debugLine="PesoDosagem = 5000";
_pesodosagem = (int) (5000);
 //BA.debugLineNum = 1102;BA.debugLine="XML_BombaSetPoint = \"<?xml version='1.0' encoding";
_xml_bombasetpoint = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1103;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<soap12:";
_xml_bombasetpoint = _xml_bombasetpoint+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1104;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<soap12:";
_xml_bombasetpoint = _xml_bombasetpoint+"<soap12:Body>";
 //BA.debugLineNum = 1105;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<Bomba_S";
_xml_bombasetpoint = _xml_bombasetpoint+"<Bomba_SetPoint  xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1108;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<UserSof";
_xml_bombasetpoint = _xml_bombasetpoint+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1109;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<Passwor";
_xml_bombasetpoint = _xml_bombasetpoint+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1110;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<BombaTa";
_xml_bombasetpoint = _xml_bombasetpoint+"<BombaTag>"+_bombaid+"</BombaTag>";
 //BA.debugLineNum = 1111;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"<qtdeDos";
_xml_bombasetpoint = _xml_bombasetpoint+"<qtdeDosagem>"+BA.NumberToString(_pesodosagem)+"</qtdeDosagem>";
 //BA.debugLineNum = 1112;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"</Bomba_";
_xml_bombasetpoint = _xml_bombasetpoint+"</Bomba_SetPoint >";
 //BA.debugLineNum = 1113;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"</soap12";
_xml_bombasetpoint = _xml_bombasetpoint+"</soap12:Body>";
 //BA.debugLineNum = 1114;BA.debugLine="XML_BombaSetPoint = XML_BombaSetPoint & \"</soap12";
_xml_bombasetpoint = _xml_bombasetpoint+"</soap12:Envelope>";
 //BA.debugLineNum = 1116;BA.debugLine="XML_BombaStart = \"<?xml version='1.0' encoding='u";
_xml_bombastart = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1117;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<soap12:Envelo";
_xml_bombastart = _xml_bombastart+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1118;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<soap12:Body>\"";
_xml_bombastart = _xml_bombastart+"<soap12:Body>";
 //BA.debugLineNum = 1119;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<Bomba_SetStar";
_xml_bombastart = _xml_bombastart+"<Bomba_SetStartDosagem  xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1122;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<UserSoftware>";
_xml_bombastart = _xml_bombastart+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1123;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<PasswordSoftw";
_xml_bombastart = _xml_bombastart+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1124;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<BombaTag>\" &";
_xml_bombastart = _xml_bombastart+"<BombaTag>"+_bombaid+"</BombaTag>";
 //BA.debugLineNum = 1125;BA.debugLine="XML_BombaStart = XML_BombaStart & \"<start>\" & Bom";
_xml_bombastart = _xml_bombastart+"<start>"+_bombastart+"</start>";
 //BA.debugLineNum = 1126;BA.debugLine="XML_BombaStart = XML_BombaStart & \"</Bomba_SetSta";
_xml_bombastart = _xml_bombastart+"</Bomba_SetStartDosagem >";
 //BA.debugLineNum = 1127;BA.debugLine="XML_BombaStart = XML_BombaStart & \"</soap12:Body>";
_xml_bombastart = _xml_bombastart+"</soap12:Body>";
 //BA.debugLineNum = 1128;BA.debugLine="XML_BombaStart = XML_BombaStart & \"</soap12:Envel";
_xml_bombastart = _xml_bombastart+"</soap12:Envelope>";
 //BA.debugLineNum = 1130;BA.debugLine="Try";
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
 //BA.debugLineNum = 1136;BA.debugLine="LabelFuncaoBomba.Text = \"Iniciando o processo de";
parent.mostCurrent._labelfuncaobomba.setText(BA.ObjectToCharSequence("Iniciando o processo de start da Bomba "+_bombaid));
 //BA.debugLineNum = 1138;BA.debugLine="JobBomba.Initialize(\"JOBSOAP\", Me)";
_jobbomba._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1139;BA.debugLine="JobBomba.PostString(URL, XML_BombaStatus)";
_jobbomba._poststring /*String*/ (parent.mostCurrent._url,parent.mostCurrent._xml_bombastatus);
 //BA.debugLineNum = 1141;BA.debugLine="JobBomba.GetRequest.SetContentType(\"text/xml\")";
_jobbomba._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1142;BA.debugLine="WaiT For (JobBomba) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobbomba));
this.state = 25;
return;
case 25:
//C
this.state = 4;
;
 //BA.debugLineNum = 1143;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 26;
return;
case 26:
//C
this.state = 4;
;
 //BA.debugLineNum = 1144;BA.debugLine="XMLWork = JobBomba.GetString";
parent.mostCurrent._xmlwork = _jobbomba._getstring /*String*/ ();
 //BA.debugLineNum = 1145;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1146;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1148;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf(\"";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1149;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<xMs";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1151;BA.debugLine="LabelFuncaoBomba.Text = xErro";
parent.mostCurrent._labelfuncaobomba.setText(BA.ObjectToCharSequence(parent.mostCurrent._xerro));
 //BA.debugLineNum = 1153;BA.debugLine="If xxStringa.Trim() = \"11\" Then";
if (true) break;

case 4:
//if
this.state = 21;
if ((_xxstringa.trim()).equals("11")) { 
this.state = 6;
}else {
this.state = 20;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1157;BA.debugLine="JobBomba2.Initialize(\"JOBSOAP\", Me)";
_jobbomba2._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1158;BA.debugLine="JobBomba2.PostString(URL, XML_BombaSetPoint)";
_jobbomba2._poststring /*String*/ (parent.mostCurrent._url,_xml_bombasetpoint);
 //BA.debugLineNum = 1159;BA.debugLine="JobBomba2.GetRequest.SetContentType(\"text/xml\")";
_jobbomba2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1160;BA.debugLine="WaiT For (JobBomba2) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobbomba2));
this.state = 27;
return;
case 27:
//C
this.state = 7;
;
 //BA.debugLineNum = 1161;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 28;
return;
case 28:
//C
this.state = 7;
;
 //BA.debugLineNum = 1162;BA.debugLine="XMLWork = JobBomba2.GetString";
parent.mostCurrent._xmlwork = _jobbomba2._getstring /*String*/ ();
 //BA.debugLineNum = 1163;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1164;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1166;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf(";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1167;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<xM";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1169;BA.debugLine="If xxStringa.Trim() = \"0\" Then";
if (true) break;

case 7:
//if
this.state = 18;
if ((_xxstringa.trim()).equals("0")) { 
this.state = 9;
}else {
this.state = 17;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 1173;BA.debugLine="JobBomba3.Initialize(\"JOBSOAP\", Me)";
_jobbomba3._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1174;BA.debugLine="JobBomba3.PostString(URL, XML_BombaStart)";
_jobbomba3._poststring /*String*/ (parent.mostCurrent._url,_xml_bombastart);
 //BA.debugLineNum = 1175;BA.debugLine="JobBomba3.GetRequest.SetContentType(\"text/xml\"";
_jobbomba3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1176;BA.debugLine="WaiT For (JobBomba3) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobbomba3));
this.state = 29;
return;
case 29:
//C
this.state = 10;
;
 //BA.debugLineNum = 1177;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 30;
return;
case 30:
//C
this.state = 10;
;
 //BA.debugLineNum = 1178;BA.debugLine="XMLWork = JobBomba3.GetString";
parent.mostCurrent._xmlwork = _jobbomba3._getstring /*String*/ ();
 //BA.debugLineNum = 1179;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1180;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1182;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1183;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<x";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1185;BA.debugLine="StatusBomba = False";
parent._statusbomba = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1186;BA.debugLine="If xxStringa.Trim() = \"0\" Then";
if (true) break;

case 10:
//if
this.state = 15;
if ((_xxstringa.trim()).equals("0")) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 //BA.debugLineNum = 1187;BA.debugLine="StatusBomba = True";
parent._statusbomba = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1189;BA.debugLine="ToastMessageShow(\"Bomba \" & BombaID & \"inicia";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bomba "+_bombaid+"iniciada...aguardando o final da dosagem ("+BA.NumberToString(_pesodosagem)+")."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 1192;BA.debugLine="retorno = False";
_retorno = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1193;BA.debugLine="ToastMessageShow(\"Não foi possivel iniciar a";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Não foi possivel iniciar a dosagem na Bomba "+_bombaid+". Verifique."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 1198;BA.debugLine="retorno = False";
_retorno = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;

case 18:
//C
this.state = 21;
;
 if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 1203;BA.debugLine="retorno = False";
_retorno = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1204;BA.debugLine="LabelFuncaoBomba.Text = xErro";
parent.mostCurrent._labelfuncaobomba.setText(BA.ObjectToCharSequence(parent.mostCurrent._xerro));
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
this.catchState = 0;
 //BA.debugLineNum = 1207;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52490510",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 1208;BA.debugLine="LabelFuncaoBomba.Text = LastException.Message";
parent.mostCurrent._labelfuncaobomba.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()));
 //BA.debugLineNum = 1210;BA.debugLine="retorno = False";
_retorno = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;
if (true) break;

case 24:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1213;BA.debugLine="Return";
if (true) return ;
 //BA.debugLineNum = 1214;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _verificabalanca(String _balancatag) throws Exception{
ResumableSub_VerificaBalanca rsub = new ResumableSub_VerificaBalanca(null,_balancatag);
rsub.resume(processBA, null);
}
public static class ResumableSub_VerificaBalanca extends BA.ResumableSub {
public ResumableSub_VerificaBalanca(unileverSU.pesagem.main parent,String _balancatag) {
this.parent = parent;
this._balancatag = _balancatag;
}
unileverSU.pesagem.main parent;
String _balancatag;
String _xxstringa = "";
unileverSU.pesagem.httpjob _jobbalanca = null;
String _xml_balancastatus = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1324;BA.debugLine="Dim xxStringa As String";
_xxstringa = "";
 //BA.debugLineNum = 1325;BA.debugLine="Dim JobBalanca As HttpJob";
_jobbalanca = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1326;BA.debugLine="Dim XML_BalancaStatus As String";
_xml_balancastatus = "";
 //BA.debugLineNum = 1329;BA.debugLine="retornoBalancaStatus = False";
parent._retornobalancastatus = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1331;BA.debugLine="XML_BalancaStatus = \"<?xml version='1.0' encoding";
_xml_balancastatus = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1332;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"<soap12:";
_xml_balancastatus = _xml_balancastatus+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1333;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"<soap12:";
_xml_balancastatus = _xml_balancastatus+"<soap12:Body>";
 //BA.debugLineNum = 1334;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"<Balanca";
_xml_balancastatus = _xml_balancastatus+"<Balanca_GetStatus xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1335;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"<UserSof";
_xml_balancastatus = _xml_balancastatus+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1336;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"<Passwor";
_xml_balancastatus = _xml_balancastatus+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1337;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"<Balanca";
_xml_balancastatus = _xml_balancastatus+"<BalancaTag>"+_balancatag+"</BalancaTag>";
 //BA.debugLineNum = 1338;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"</Balanc";
_xml_balancastatus = _xml_balancastatus+"</Balanca_GetStatus>";
 //BA.debugLineNum = 1339;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"</soap12";
_xml_balancastatus = _xml_balancastatus+"</soap12:Body>";
 //BA.debugLineNum = 1340;BA.debugLine="XML_BalancaStatus = XML_BalancaStatus & \"</soap12";
_xml_balancastatus = _xml_balancastatus+"</soap12:Envelope>";
 //BA.debugLineNum = 1342;BA.debugLine="Try";
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
 //BA.debugLineNum = 1343;BA.debugLine="JobBalanca.Initialize(\"JOBSOAP\", Me)";
_jobbalanca._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1344;BA.debugLine="JobBalanca.PostString(URL, XML_BalancaStatus)";
_jobbalanca._poststring /*String*/ (parent.mostCurrent._url,_xml_balancastatus);
 //BA.debugLineNum = 1345;BA.debugLine="JobBalanca.GetRequest.SetContentType(\"text/xml\")";
_jobbalanca._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1346;BA.debugLine="WaiT For (JobBalanca) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobbalanca));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 //BA.debugLineNum = 1347;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 12;
return;
case 12:
//C
this.state = 4;
;
 //BA.debugLineNum = 1348;BA.debugLine="XMLWork = JobBalanca.GetString";
parent.mostCurrent._xmlwork = _jobbalanca._getstring /*String*/ ();
 //BA.debugLineNum = 1349;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1350;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1352;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf(\"";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1353;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<xMs";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1361;BA.debugLine="If xxStringa.Trim() = \"2\" Then";
if (true) break;

case 4:
//if
this.state = 7;
if ((_xxstringa.trim()).equals("2")) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1362;BA.debugLine="retornoBalancaStatus = True";
parent._retornobalancastatus = anywheresoftware.b4a.keywords.Common.True;
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 //BA.debugLineNum = 1366;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52687020",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1370;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _verificabomba(String _bombaid) throws Exception{
ResumableSub_VerificaBomba rsub = new ResumableSub_VerificaBomba(null,_bombaid);
rsub.resume(processBA, null);
}
public static class ResumableSub_VerificaBomba extends BA.ResumableSub {
public ResumableSub_VerificaBomba(unileverSU.pesagem.main parent,String _bombaid) {
this.parent = parent;
this._bombaid = _bombaid;
}
unileverSU.pesagem.main parent;
String _bombaid;
String _xxstringa = "";
unileverSU.pesagem.httpjob _jobbomba = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1006;BA.debugLine="Dim xxStringa As String";
_xxstringa = "";
 //BA.debugLineNum = 1007;BA.debugLine="Dim JobBomba As HttpJob";
_jobbomba = new unileverSU.pesagem.httpjob();
 //BA.debugLineNum = 1009;BA.debugLine="XML_BombaStatus = \"<?xml version='1.0' encoding='";
parent.mostCurrent._xml_bombastatus = "<?xml version='1.0' encoding='utf-8'?>";
 //BA.debugLineNum = 1010;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<soap12:Enve";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>";
 //BA.debugLineNum = 1011;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<soap12:Body";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<soap12:Body>";
 //BA.debugLineNum = 1012;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<Bomba_GetSt";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<Bomba_GetStatus xmlns='http://www.aplipack.com.br/'>";
 //BA.debugLineNum = 1015;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<UserSoftwar";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<UserSoftware>user</UserSoftware>";
 //BA.debugLineNum = 1016;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<PasswordSof";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<PasswordSoftware>1234</PasswordSoftware>";
 //BA.debugLineNum = 1017;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"<BombaTag>\"";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"<BombaTag>"+_bombaid+"</BombaTag>";
 //BA.debugLineNum = 1018;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"</Bomba_GetS";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"</Bomba_GetStatus>";
 //BA.debugLineNum = 1019;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"</soap12:Bod";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"</soap12:Body>";
 //BA.debugLineNum = 1020;BA.debugLine="XML_BombaStatus = XML_BombaStatus & \"</soap12:Env";
parent.mostCurrent._xml_bombastatus = parent.mostCurrent._xml_bombastatus+"</soap12:Envelope>";
 //BA.debugLineNum = 1022;BA.debugLine="retorno_Bomba = False";
parent._retorno_bomba = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1024;BA.debugLine="Current_BombaID = \"\"";
parent.mostCurrent._current_bombaid = "";
 //BA.debugLineNum = 1026;BA.debugLine="Try";
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
 //BA.debugLineNum = 1027;BA.debugLine="VerificaBalanca(\"AA\")";
_verificabalanca("AA");
 //BA.debugLineNum = 1028;BA.debugLine="If retornoBalancaStatus = False Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent._retornobalancastatus==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1029;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 1032;BA.debugLine="JobBomba.Initialize(\"JOBSOAP\", Me)";
_jobbomba._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 1033;BA.debugLine="JobBomba.PostString(URL, XML_BombaStatus)";
_jobbomba._poststring /*String*/ (parent.mostCurrent._url,parent.mostCurrent._xml_bombastatus);
 //BA.debugLineNum = 1034;BA.debugLine="JobBomba.GetRequest.SetContentType(\"text/xml\")";
_jobbomba._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("text/xml");
 //BA.debugLineNum = 1035;BA.debugLine="WaiT For (JobBomba) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_jobbomba));
this.state = 17;
return;
case 17:
//C
this.state = 8;
;
 //BA.debugLineNum = 1036;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 18;
return;
case 18:
//C
this.state = 8;
;
 //BA.debugLineNum = 1037;BA.debugLine="XMLWork = JobBomba.GetString";
parent.mostCurrent._xmlwork = _jobbomba._getstring /*String*/ ();
 //BA.debugLineNum = 1038;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&lt;","<");
 //BA.debugLineNum = 1039;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.replace("&gt;",">");
 //BA.debugLineNum = 1041;BA.debugLine="xxStringa = XMLWork.SubString2(XMLWork.IndexOf(\"";
_xxstringa = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xCodigo>")+9),parent.mostCurrent._xmlwork.indexOf("</xCodigo>"));
 //BA.debugLineNum = 1042;BA.debugLine="xErro = XMLWork.SubString2(XMLWork.IndexOf(\"<xMs";
parent.mostCurrent._xerro = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<xMsg>")+6),parent.mostCurrent._xmlwork.indexOf("</xMsg>"));
 //BA.debugLineNum = 1044;BA.debugLine="If xxStringa.Trim() = \"11\" Then";
if (true) break;

case 8:
//if
this.state = 13;
if ((_xxstringa.trim()).equals("11")) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 13;
 //BA.debugLineNum = 1046;BA.debugLine="ToastMessageShow(xErro,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(parent.mostCurrent._xerro),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1047;BA.debugLine="retorno_Bomba = True";
parent._retorno_bomba = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1048;BA.debugLine="Current_BombaID = BombaID";
parent.mostCurrent._current_bombaid = _bombaid;
 if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 1050;BA.debugLine="retorno_Bomba = False";
parent._retorno_bomba = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1051;BA.debugLine="ToastMessageShow(xErro,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(parent.mostCurrent._xerro),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 13:
//C
this.state = 16;
;
 //BA.debugLineNum = 1053;BA.debugLine="LabelFuncaoBomba.Text = xErro";
parent.mostCurrent._labelfuncaobomba.setText(BA.ObjectToCharSequence(parent.mostCurrent._xerro));
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 1055;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("52424883",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 1056;BA.debugLine="ToastMessageShow(\"Ocorreu um erro ao tentar obte";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Ocorreu um erro ao tentar obter o status da bomba. Verifique."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1057;BA.debugLine="LabelFuncaoBomba.Text = xErro";
parent.mostCurrent._labelfuncaobomba.setText(BA.ObjectToCharSequence(parent.mostCurrent._xerro));
 //BA.debugLineNum = 1058;BA.debugLine="retorno_Bomba = False";
parent._retorno_bomba = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1061;BA.debugLine="Return";
if (true) return ;
 //BA.debugLineNum = 1063;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
}
