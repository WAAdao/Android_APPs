package VinculaBomba.Unielver;


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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "VinculaBomba.Unielver", "VinculaBomba.Unielver.main");
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
		activityBA = new BA(this, layout, processBA, "VinculaBomba.Unielver", "VinculaBomba.Unielver.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "VinculaBomba.Unielver.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
public static anywheresoftware.b4a.objects.Serial _btconnection = null;
public com.AB.ABZxing.ABZxing _myabbarcode = null;
public static String _codigobomba = "";
public static String _idsscc = "";
public static int _mode = 0;
public static String _addresswebservice = "";
public anywheresoftware.b4a.objects.PanelWrapper _panellogin2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelleitura = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelconfig = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonconcluir = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttondesvincularbomba = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonregistrasscc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonscan = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvincularbomba = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextbalanca = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonimprimir = null;
public anywheresoftware.b4a.objects.streams.File.TextWriterWrapper _printer = null;
public static String _printbuffer = "";
public static String _nameprinter = "";
public static String _barcode1 = "";
public static String _barcode2 = "";
public static String _barcodesscc = "";
public static String _quantidade = "";
public static String _validade = "";
public static String _material = "";
public static String _lote = "";
public static String _codzpl = "";
public static String _nometerminal = "";
public static String _dataproducao = "";
public static String _filename = "";
public static int _statuslogin = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlimparlogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlogintela = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarlogin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextsenha = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextusuario = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonupdatedados = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarconfig = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextenderecowebservice = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextnomeimpressora = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextnometerminal = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageviewunilever = null;
public VinculaBomba.Unielver.starter _starter = null;
public VinculaBomba.Unielver.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="PanelLeitura.Initialize(\"\") : PanelLeitura.Visibl";
mostCurrent._panelleitura.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="PanelLeitura.Initialize(\"\") : PanelLeitura.Visibl";
mostCurrent._panelleitura.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="PanelLeitura.LoadLayout(\"Layout\")";
mostCurrent._panelleitura.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.AddView(PanelLeitura, 0, 0, 100%x, 100%y";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panelleitura.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="PanelLogin2.Initialize(\"\") : PanelLogin2.Visible";
mostCurrent._panellogin2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="PanelLogin2.Initialize(\"\") : PanelLogin2.Visible";
mostCurrent._panellogin2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="PanelLogin2.LoadLayout(\"Login\")";
mostCurrent._panellogin2.LoadLayout("Login",mostCurrent.activityBA);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Activity.AddView(PanelLogin2, 0, 0, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panellogin2.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="PanelConfig.Initialize(\"\") : PanelConfig.Visible";
mostCurrent._panelconfig.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="PanelConfig.Initialize(\"\") : PanelConfig.Visible";
mostCurrent._panelconfig.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="PanelConfig.LoadLayout(\"Config\")";
mostCurrent._panelconfig.LoadLayout("Config",mostCurrent.activityBA);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="Activity.AddView(PanelConfig, 0, 0, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panelconfig.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="filename  = \"dataterminalpesagem.db\"";
mostCurrent._filename = "dataterminalpesagem.db";
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="If File.Exists(File.DirInternal,filename) = False";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._filename)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="File.Copy(File.DirAssets,filename,File.DirIntern";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._filename);
 };
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="If sql1.IsInitialized = False Then";
if (_sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="sql1.Initialize(File.DirInternal, filename, Fals";
_sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._filename,anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, End";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql1.ExecQuery("SELECT NomeTerminal, EnderecoWebservice, NomeImpressora FROM Data WHERE id=1;")));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="cursor.Position =  0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="Nometerminal = cursor.GetString2(0)";
mostCurrent._nometerminal = _cursor.GetString2((int) (0));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="NamePrinter = cursor.GetString2(2)";
mostCurrent._nameprinter = _cursor.GetString2((int) (2));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="ButtonVincularBomba.Color = Colors.Green";
mostCurrent._buttonvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
mostCurrent._buttonvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Red";
mostCurrent._buttondesvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
mostCurrent._buttondesvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Red";
mostCurrent._buttonregistrasscc.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
mostCurrent._buttonregistrasscc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="Mode = 1";
_mode = (int) (1);
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="StatusLogin = 0";
_statuslogin = (int) (0);
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="ButtonScan.Enabled = False";
mostCurrent._buttonscan.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="ButtonConcluir.Enabled = False";
mostCurrent._buttonconcluir.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _buttonconcluir_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonconcluir_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonconcluir_click", null));}
int _b1 = 0;
int _b2 = 0;
int _bs = 0;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub ButtonConcluir_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="If StatusLogin =1 Then";
if (_statuslogin==1) { 
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="If idSSCC.Length > 0 And CodigoBomba.Length > 0";
if (mostCurrent._idsscc.length()>0 && mostCurrent._codigobomba.length()>0) { 
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="If Mode=1 Then";
if (_mode==1) { 
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="If idSSCC.Length > 0 And CodigoBomba.Length >";
if (mostCurrent._idsscc.length()>0 && mostCurrent._codigobomba.length()>0) { 
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="VinculaBomba";
_vinculabomba();
 };
 }else 
{RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Else If Mode=2 Then";
if (_mode==2) { 
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="idSSCC = 00";
mostCurrent._idsscc = BA.NumberToString(00);
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="If idSSCC.Length > 0 And CodigoBomba.Length >";
if (mostCurrent._idsscc.length()>0 && mostCurrent._codigobomba.length()>0) { 
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="VinculaBomba";
_vinculabomba();
 };
 }else 
{RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="Else If Mode=3 Then";
if (_mode==3) { 
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Dim B1 As Int = 0";
_b1 = (int) (0);
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Dim B2 As Int = 0";
_b2 = (int) (0);
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Dim BS As Int = 0";
_bs = (int) (0);
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="If Barcode1 = \"\" Then";
if ((mostCurrent._barcode1).equals("")) { 
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="ToastMessageShow(\"Faça a leitura do código de";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Faça a leitura do código de Lote."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="B1 = 1";
_b1 = (int) (1);
 };
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="If Barcode2 = \"\" Then";
if ((mostCurrent._barcode2).equals("")) { 
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="ToastMessageShow(\"Faça a leitura do código Va";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Faça a leitura do código Validade."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="B2 = 1";
_b2 = (int) (1);
 };
RDebugUtils.currentLine=589851;
 //BA.debugLineNum = 589851;BA.debugLine="If BarcodeSSCC = \"\" Then";
if ((mostCurrent._barcodesscc).equals("")) { 
RDebugUtils.currentLine=589852;
 //BA.debugLineNum = 589852;BA.debugLine="ToastMessageShow(\"Faça a leitura do código SS";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Faça a leitura do código SSCC."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589853;
 //BA.debugLineNum = 589853;BA.debugLine="BS = 1";
_bs = (int) (1);
 };
RDebugUtils.currentLine=589856;
 //BA.debugLineNum = 589856;BA.debugLine="If  B1 =1 And B2 =1 And BS =1 Then";
if (_b1==1 && _b2==1 && _bs==1) { 
RDebugUtils.currentLine=589857;
 //BA.debugLineNum = 589857;BA.debugLine="SendSSCC";
_sendsscc();
 };
 }}}
;
 };
 };
RDebugUtils.currentLine=589862;
 //BA.debugLineNum = 589862;BA.debugLine="End Sub";
return "";
}
public static void  _vinculabomba() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "vinculabomba", false))
	 {Debug.delegate(mostCurrent.activityBA, "vinculabomba", null); return;}
ResumableSub_VinculaBomba rsub = new ResumableSub_VinculaBomba(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_VinculaBomba extends BA.ResumableSub {
public ResumableSub_VinculaBomba(VinculaBomba.Unielver.main parent) {
this.parent = parent;
}
VinculaBomba.Unielver.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
VinculaBomba.Unielver.httpjob _jobop3 = null;
String _result = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Try";
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
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Dim JobOP3 As HttpJob";
_jobop3 = new VinculaBomba.Unielver.httpjob();
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="CodigoBomba = CodigoBomba.Replace(\" \",\"\")";
parent.mostCurrent._codigobomba = parent.mostCurrent._codigobomba.replace(" ","");
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="idSSCC = idSSCC.Replace(\" \",\"\")";
parent.mostCurrent._idsscc = parent.mostCurrent._idsscc.replace(" ","");
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
_xml = _xml+"xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>";
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="XML = XML & \"<soap:Body><VinculaBomba xmlns=`htt";
_xml = _xml+"<soap:Body><VinculaBomba xmlns=`http://www.aplipack.com.br/`>";
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="XML = XML & \"<idSSCC>\" & idSSCC & \"</idSSCC><Cod";
_xml = _xml+"<idSSCC>"+parent.mostCurrent._idsscc+"</idSSCC><CodigoBomba>"+parent.mostCurrent._codigobomba+"</CodigoBomba>";
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="XML = XML & \"</VinculaBomba></soap:Body></soap:E";
_xml = _xml+"</VinculaBomba></soap:Body></soap:Envelope>";
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
_jobop3._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="JobOP3.PostString(URL,XML)";
_jobop3._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=851990;
 //BA.debugLineNum = 851990;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
_jobop3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="Wait For (JobOP3) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "vinculabomba"), (Object)(_jobop3));
this.state = 27;
return;
case 27:
//C
this.state = 4;
;
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "vinculabomba"),(int) (100));
this.state = 28;
return;
case 28:
//C
this.state = 4;
;
RDebugUtils.currentLine=851994;
 //BA.debugLineNum = 851994;BA.debugLine="If JobOP3.Success = True Then";
if (true) break;

case 4:
//if
this.state = 23;
if (_jobop3._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="XMLWork2 = JobOP3.GetString";
_xmlwork2 = _jobop3._getstring /*String*/ (null);
RDebugUtils.currentLine=851996;
 //BA.debugLineNum = 851996;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=851997;
 //BA.debugLineNum = 851997;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=851998;
 //BA.debugLineNum = 851998;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=851999;
 //BA.debugLineNum = 851999;BA.debugLine="If XMLWork2.Contains(\"<VinculaBombaResult>\") =";
if (true) break;

case 7:
//if
this.state = 22;
if (_xmlwork2.contains("<VinculaBombaResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=852001;
 //BA.debugLineNum = 852001;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 10:
//if
this.state = 21;
if ((_result).equals("sucesso")) { 
this.state = 12;
}else {
this.state = 20;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=852002;
 //BA.debugLineNum = 852002;BA.debugLine="If Mode = 1 Then";
if (true) break;

case 13:
//if
this.state = 18;
if (parent._mode==1) { 
this.state = 15;
}else 
{RDebugUtils.currentLine=852004;
 //BA.debugLineNum = 852004;BA.debugLine="Else If Mode=2 Then";
if (parent._mode==2) { 
this.state = 17;
}}
if (true) break;

case 15:
//C
this.state = 18;
RDebugUtils.currentLine=852003;
 //BA.debugLineNum = 852003;BA.debugLine="ToastMessageShow(\"Bomba Vinculada com sucess";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bomba Vinculada com sucesso.."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="ToastMessageShow(\"Bomba Desvinculada com suc";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bomba Desvinculada com sucesso.."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 18:
//C
this.state = 21;
;
 if (true) break;

case 20:
//C
this.state = 21;
RDebugUtils.currentLine=852008;
 //BA.debugLineNum = 852008;BA.debugLine="ToastMessageShow(Result,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_result),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=852012;
 //BA.debugLineNum = 852012;BA.debugLine="JobOP3.Release";
_jobop3._release /*String*/ (null);
 if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
RDebugUtils.currentLine=852014;
 //BA.debugLineNum = 852014;BA.debugLine="ToastMessageShow(\"Erro ao registtar SCCC.\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao registtar SCCC."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=852016;
 //BA.debugLineNum = 852016;BA.debugLine="End Sub";
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
public static void  _sendsscc() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sendsscc", false))
	 {Debug.delegate(mostCurrent.activityBA, "sendsscc", null); return;}
ResumableSub_SendSSCC rsub = new ResumableSub_SendSSCC(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_SendSSCC extends BA.ResumableSub {
public ResumableSub_SendSSCC(VinculaBomba.Unielver.main parent) {
this.parent = parent;
}
VinculaBomba.Unielver.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
VinculaBomba.Unielver.httpjob _jobop3 = null;
String _result = "";
String _nova = "";
String _userregistro = "";
String _datahoraregistro = "";
String _idssccget = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Try";
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
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="Dim JobOP3 As HttpJob";
_jobop3 = new VinculaBomba.Unielver.httpjob();
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.replace(" ","");
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.replace(" ","");
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.replace(" ","");
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=917518;
 //BA.debugLineNum = 917518;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
_xml = _xml+"xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>";
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="XML = XML & \"<soap:Body><RegistraSSCC xmlns='htt";
_xml = _xml+"<soap:Body><RegistraSSCC xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="XML = XML & \"<Barcode1>\" & Barcode1 & \"</Barcode";
_xml = _xml+"<Barcode1>"+parent.mostCurrent._barcode1+"</Barcode1><Barcode2>"+parent.mostCurrent._barcode2+"</Barcode2>";
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="XML = XML & \"<BarcodeSSCC>\" & BarcodeSSCC & \"</B";
_xml = _xml+"<BarcodeSSCC>"+parent.mostCurrent._barcodesscc+"</BarcodeSSCC><UsuarioLeitura>user</UsuarioLeitura>";
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="XML = XML & \"<Quantidade>\" & Quantidade & \"</Qua";
_xml = _xml+"<Quantidade>"+parent.mostCurrent._quantidade+"</Quantidade></RegistraSSCC></soap:Body></soap:Envelope>";
RDebugUtils.currentLine=917526;
 //BA.debugLineNum = 917526;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
_jobop3._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=917527;
 //BA.debugLineNum = 917527;BA.debugLine="JobOP3.PostString(URL,XML)";
_jobop3._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=917528;
 //BA.debugLineNum = 917528;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
_jobop3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=917529;
 //BA.debugLineNum = 917529;BA.debugLine="Wait For (JobOP3) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "sendsscc"), (Object)(_jobop3));
this.state = 27;
return;
case 27:
//C
this.state = 4;
;
RDebugUtils.currentLine=917530;
 //BA.debugLineNum = 917530;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "sendsscc"),(int) (100));
this.state = 28;
return;
case 28:
//C
this.state = 4;
;
RDebugUtils.currentLine=917532;
 //BA.debugLineNum = 917532;BA.debugLine="If JobOP3.Success = True Then";
if (true) break;

case 4:
//if
this.state = 23;
if (_jobop3._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=917533;
 //BA.debugLineNum = 917533;BA.debugLine="XMLWork2 = JobOP3.GetString";
_xmlwork2 = _jobop3._getstring /*String*/ (null);
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=917535;
 //BA.debugLineNum = 917535;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=917536;
 //BA.debugLineNum = 917536;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=917537;
 //BA.debugLineNum = 917537;BA.debugLine="If XMLWork2.Contains(\"<RegistraSSCCResult>\") =";
if (true) break;

case 7:
//if
this.state = 22;
if (_xmlwork2.contains("<RegistraSSCCResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=917538;
 //BA.debugLineNum = 917538;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=917539;
 //BA.debugLineNum = 917539;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 10:
//if
this.state = 21;
if ((_result).equals("sucesso")) { 
this.state = 12;
}else {
this.state = 20;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=917540;
 //BA.debugLineNum = 917540;BA.debugLine="Dim Nova As String = XMLWork2.SubString2(XMLW";
_nova = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Nova>")+6),_xmlwork2.indexOf("</Nova>"));
RDebugUtils.currentLine=917541;
 //BA.debugLineNum = 917541;BA.debugLine="If Nova = \"True\" Then";
if (true) break;

case 13:
//if
this.state = 18;
if ((_nova).equals("True")) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
RDebugUtils.currentLine=917542;
 //BA.debugLineNum = 917542;BA.debugLine="ToastMessageShow(\"SSCC registrado com sucess";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SSCC registrado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=917544;
 //BA.debugLineNum = 917544;BA.debugLine="Dim UserRegistro As String = XMLWork2.SubStr";
_userregistro = _xmlwork2.substring((int) (_xmlwork2.indexOf("<UsuarioRegistro>")+16),_xmlwork2.indexOf("</UsuarioRegistro>"));
RDebugUtils.currentLine=917545;
 //BA.debugLineNum = 917545;BA.debugLine="Dim DataHoraRegistro As String = XMLWork2.Su";
_datahoraregistro = _xmlwork2.substring((int) (_xmlwork2.indexOf("<DataHoraRegistro>")+18),_xmlwork2.indexOf("</DataHoraRegistro>"));
RDebugUtils.currentLine=917546;
 //BA.debugLineNum = 917546;BA.debugLine="Dim IDSSCCGet As String = XMLWork2.SubString";
_idssccget = _xmlwork2.substring((int) (_xmlwork2.indexOf("<IdSSCC>")+8),_xmlwork2.indexOf("</IdSSCC>"));
RDebugUtils.currentLine=917547;
 //BA.debugLineNum = 917547;BA.debugLine="ToastMessageShow(\"SSCC já registrada por \" &";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SSCC já registrada por "+_userregistro+" em "+_datahoraregistro+"  com o ID "+_idssccget),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917548;
 //BA.debugLineNum = 917548;BA.debugLine="ButtonImprimir.Enabled = True";
parent.mostCurrent._buttonimprimir.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917549;
 //BA.debugLineNum = 917549;BA.debugLine="GetZPLSSCC(IDSSCCGet)";
_getzplsscc(_idssccget);
 if (true) break;

case 18:
//C
this.state = 21;
;
RDebugUtils.currentLine=917551;
 //BA.debugLineNum = 917551;BA.debugLine="Barcode1 = \"\"";
parent.mostCurrent._barcode1 = "";
RDebugUtils.currentLine=917552;
 //BA.debugLineNum = 917552;BA.debugLine="Barcode2 = \"\"";
parent.mostCurrent._barcode2 = "";
RDebugUtils.currentLine=917553;
 //BA.debugLineNum = 917553;BA.debugLine="BarcodeSSCC = \"\"";
parent.mostCurrent._barcodesscc = "";
 if (true) break;

case 20:
//C
this.state = 21;
RDebugUtils.currentLine=917555;
 //BA.debugLineNum = 917555;BA.debugLine="ToastMessageShow(Result,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_result),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=917559;
 //BA.debugLineNum = 917559;BA.debugLine="JobOP3.Release";
_jobop3._release /*String*/ (null);
 if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
RDebugUtils.currentLine=917561;
 //BA.debugLineNum = 917561;BA.debugLine="ToastMessageShow(\"Erro ao registtar SCCC.\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao registtar SCCC."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=917564;
 //BA.debugLineNum = 917564;BA.debugLine="End Sub";
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
public static String  _buttondesvincularbomba_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttondesvincularbomba_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttondesvincularbomba_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub ButtonDesvincularBomba_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="ButtonVincularBomba.Color = Colors.Red";
mostCurrent._buttonvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
mostCurrent._buttonvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Green";
mostCurrent._buttondesvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
mostCurrent._buttondesvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Red";
mostCurrent._buttonregistrasscc.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
mostCurrent._buttonregistrasscc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Mode = 2";
_mode = (int) (2);
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="End Sub";
return "";
}
public static String  _buttonimprimir_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonimprimir_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonimprimir_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub ButtonImprimir_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="PrintBT";
_printbt();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _printbt() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "printbt", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "printbt", null));}
anywheresoftware.b4a.objects.collections.Map _paireddevices = null;
anywheresoftware.b4a.objects.collections.List _l = null;
String _devicename = "";
String _macaddress = "";
int _i = 0;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub PrintBT()";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Try";
try {RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim PairedDevices As Map";
_paireddevices = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="BTConnection.Initialize(\"ConnectBT\")";
_btconnection.Initialize("ConnectBT");
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Dim DeviceName, MacAddress As String";
_devicename = "";
_macaddress = "";
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="PairedDevices = BTConnection.GetPairedDevices";
_paireddevices = _btconnection.GetPairedDevices();
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="l.Initialize";
_l.Initialize();
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="For i = 0 To PairedDevices.Size - 1 'Check all d";
{
final int step8 = 1;
final int limit8 = (int) (_paireddevices.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="l.Add(PairedDevices.GetKeyAt(i))";
_l.Add(_paireddevices.GetKeyAt(_i));
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="DeviceName=PairedDevices.Getkeyat(i)";
_devicename = BA.ObjectToString(_paireddevices.GetKeyAt(_i));
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="MacAddress=PairedDevices.GetValueAt(i)";
_macaddress = BA.ObjectToString(_paireddevices.GetValueAt(_i));
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="If DeviceName.Contains(NamePrinter) Then 'Inser";
if (_devicename.contains(mostCurrent._nameprinter)) { 
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="Exit";
if (true) break;
 };
 }
};
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="BTConnection.Connect(MacAddress)";
_btconnection.Connect(processBA,_macaddress);
 } 
       catch (Exception e18) {
			processBA.setLastException(e18);RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="ToastMessageShow(\"Erro ao conectar o Bluetootth.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao conectar o Bluetootth."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlimparlogin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonlimparlogin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonlimparlogin_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub ButtonLimparLogin_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="EditTextSenha.Text = \"\"";
mostCurrent._edittextsenha.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="EditTextUsuario.Text = \"\"";
mostCurrent._edittextusuario.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlogin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonlogin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonlogin_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub ButtonLogin_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="PanelLogin2.Visible = True";
mostCurrent._panellogin2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="PanelLeitura.Visible = False";
mostCurrent._panelleitura.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="End Sub";
return "";
}
public static void  _buttonlogintela_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonlogintela_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "buttonlogintela_click", null); return;}
ResumableSub_ButtonLoginTela_Click rsub = new ResumableSub_ButtonLoginTela_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonLoginTela_Click extends BA.ResumableSub {
public ResumableSub_ButtonLoginTela_Click(VinculaBomba.Unielver.main parent) {
this.parent = parent;
}
VinculaBomba.Unielver.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
VinculaBomba.Unielver.httpjob _jobop3 = null;
String _result = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Try";
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
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If EditTextUsuario.Text = \"admin\" And EditTextSe";
if (true) break;

case 4:
//if
this.state = 23;
if ((parent.mostCurrent._edittextusuario.getText()).equals("admin") && (parent.mostCurrent._edittextsenha.getText()).equals("password")) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 23;
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="PanelLeitura.Visible = False";
parent.mostCurrent._panelleitura.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="PanelConfig.Visible = True";
parent.mostCurrent._panelconfig.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="Dim JobOP3 As HttpJob";
_jobop3 = new VinculaBomba.Unielver.httpjob();
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.replace(" ","");
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.replace(" ","");
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.replace(" ","");
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=1245204;
 //BA.debugLineNum = 1245204;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap";
_xml = _xml+"xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body>  ";
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="XML = XML & \"<LoginSoftware xmlns='http://www.a";
_xml = _xml+"<LoginSoftware xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="XML = XML & \"<Usuario>\" & EditTextUsuario.Text";
_xml = _xml+"<Usuario>"+parent.mostCurrent._edittextusuario.getText()+"</Usuario>";
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="XML = XML & \"<Password>\" & EditTextSenha.Text &";
_xml = _xml+"<Password>"+parent.mostCurrent._edittextsenha.getText()+"</Password></LoginSoftware>";
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="XML = XML & \"</soap:Body></soap:Envelope>\"";
_xml = _xml+"</soap:Body></soap:Envelope>";
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
_jobop3._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=1245211;
 //BA.debugLineNum = 1245211;BA.debugLine="JobOP3.PostString(URL,XML)";
_jobop3._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=1245212;
 //BA.debugLineNum = 1245212;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
_jobop3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=1245213;
 //BA.debugLineNum = 1245213;BA.debugLine="Wait For (JobOP3) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "buttonlogintela_click"), (Object)(_jobop3));
this.state = 27;
return;
case 27:
//C
this.state = 9;
;
RDebugUtils.currentLine=1245214;
 //BA.debugLineNum = 1245214;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "buttonlogintela_click"),(int) (100));
this.state = 28;
return;
case 28:
//C
this.state = 9;
;
RDebugUtils.currentLine=1245216;
 //BA.debugLineNum = 1245216;BA.debugLine="If JobOP3.Success = True Then";
if (true) break;

case 9:
//if
this.state = 22;
if (_jobop3._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=1245217;
 //BA.debugLineNum = 1245217;BA.debugLine="XMLWork2 = JobOP3.GetString";
_xmlwork2 = _jobop3._getstring /*String*/ (null);
RDebugUtils.currentLine=1245218;
 //BA.debugLineNum = 1245218;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=1245219;
 //BA.debugLineNum = 1245219;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=1245220;
 //BA.debugLineNum = 1245220;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=1245221;
 //BA.debugLineNum = 1245221;BA.debugLine="If XMLWork2.Contains(\"<LoginSoftwareResult>\")";
if (true) break;

case 12:
//if
this.state = 21;
if (_xmlwork2.contains("<LoginSoftwareResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=1245222;
 //BA.debugLineNum = 1245222;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=1245223;
 //BA.debugLineNum = 1245223;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 15:
//if
this.state = 20;
if ((_result).equals("sucesso")) { 
this.state = 17;
}else {
this.state = 19;
}if (true) break;

case 17:
//C
this.state = 20;
RDebugUtils.currentLine=1245224;
 //BA.debugLineNum = 1245224;BA.debugLine="StatusLogin = 1";
parent._statuslogin = (int) (1);
RDebugUtils.currentLine=1245225;
 //BA.debugLineNum = 1245225;BA.debugLine="PanelLeitura.Visible = True";
parent.mostCurrent._panelleitura.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245226;
 //BA.debugLineNum = 1245226;BA.debugLine="PanelLogin2.Visible = False";
parent.mostCurrent._panellogin2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245227;
 //BA.debugLineNum = 1245227;BA.debugLine="ButtonScan.Enabled = True";
parent.mostCurrent._buttonscan.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245228;
 //BA.debugLineNum = 1245228;BA.debugLine="ButtonConcluir.Enabled = True";
parent.mostCurrent._buttonconcluir.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1245229;
 //BA.debugLineNum = 1245229;BA.debugLine="ToastMessageShow(Result,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_result),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=1245231;
 //BA.debugLineNum = 1245231;BA.debugLine="StatusLogin = 0";
parent._statuslogin = (int) (0);
RDebugUtils.currentLine=1245232;
 //BA.debugLineNum = 1245232;BA.debugLine="ButtonScan.Enabled = False";
parent.mostCurrent._buttonscan.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245233;
 //BA.debugLineNum = 1245233;BA.debugLine="ButtonConcluir.Enabled = False";
parent.mostCurrent._buttonconcluir.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245234;
 //BA.debugLineNum = 1245234;BA.debugLine="ToastMessageShow(Result,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_result),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=1245238;
 //BA.debugLineNum = 1245238;BA.debugLine="JobOP3.Release";
_jobop3._release /*String*/ (null);
 if (true) break;

case 23:
//C
this.state = 26;
;
 if (true) break;

case 25:
//C
this.state = 26;
this.catchState = 0;
RDebugUtils.currentLine=1245241;
 //BA.debugLineNum = 1245241;BA.debugLine="ToastMessageShow(\"Erro no processo de login.\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro no processo de login."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=1245244;
 //BA.debugLineNum = 1245244;BA.debugLine="End Sub";
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
public static String  _buttonregistrasscc_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonregistrasscc_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonregistrasscc_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub ButtonRegistraSSCC_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="ButtonVincularBomba.Color = Colors.Red";
mostCurrent._buttonvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
mostCurrent._buttonvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Red";
mostCurrent._buttondesvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
mostCurrent._buttondesvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Green";
mostCurrent._buttonregistrasscc.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
mostCurrent._buttonregistrasscc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Mode = 3";
_mode = (int) (3);
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="End Sub";
return "";
}
public static String  _buttonscan_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonscan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonscan_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub ButtonScan_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="myABBarcode.ABGetBarcode(\"myABBarcode\",\"\")";
mostCurrent._myabbarcode.ABGetBarcode(mostCurrent.activityBA,"myABBarcode","");
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _buttonupdatedados_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonupdatedados_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonupdatedados_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub ButtonUpdateDados_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Try";
try {RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="sql1.ExecNonQuery(\"UPDATE Data SET  NomeTerminal";
_sql1.ExecNonQuery("UPDATE Data SET  NomeTerminal ='"+mostCurrent._edittextnometerminal.getText()+"', EnderecoWebservice='"+mostCurrent._edittextenderecowebservice.getText()+"', NomeImpressora='"+BA.ObjectToString(mostCurrent._edittextnomeimpressora.getTag())+"' WHERE id=1;");
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql1.ExecQuery("SELECT NomeTerminal, EnderecoWebservice, NomeImpressora FROM Data WHERE id=1;")));
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="cursor.Position =  0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="Nometerminal = cursor.GetString2(0)";
mostCurrent._nometerminal = _cursor.GetString2((int) (0));
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="NamePrinter = cursor.GetString2(2)";
mostCurrent._nameprinter = _cursor.GetString2((int) (2));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="MsgboxAsync(\"Erro ao gravar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao gravar."),BA.ObjectToCharSequence("Erro"),processBA);
 };
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvincularbomba_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvincularbomba_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvincularbomba_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub ButtonVincularBomba_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="ButtonVincularBomba.Color = Colors.Green";
mostCurrent._buttonvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="ButtonVincularBomba.TextColor = Colors.White";
mostCurrent._buttonvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="ButtonDesvincularBomba.Color = Colors.Red";
mostCurrent._buttondesvincularbomba.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="ButtonDesvincularBomba.TextColor = Colors.White";
mostCurrent._buttondesvincularbomba.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="ButtonRegistraSSCC.Color = Colors.Red";
mostCurrent._buttonregistrasscc.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="ButtonRegistraSSCC.TextColor = Colors.White";
mostCurrent._buttonregistrasscc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="Mode = 1";
_mode = (int) (1);
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltarconfig_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvoltarconfig_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvoltarconfig_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub ButtonVoltarConfig_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="PanelLeitura.Visible = True";
mostCurrent._panelleitura.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="PanelConfig.Visible = False";
mostCurrent._panelconfig.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltarlogin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvoltarlogin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvoltarlogin_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub ButtonVoltarLogin_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="PanelLogin2.Visible = False";
mostCurrent._panellogin2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="PanelLeitura.Visible = True";
mostCurrent._panelleitura.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
public static String  _edittextbalanca_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edittextbalanca_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edittextbalanca_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub EditTextBalanca_TextChanged (Old As St";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Try";
try {RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="If New.SubString2(0,1) = \"@\" And New.Length >= 3";
if ((_new.substring((int) (0),(int) (1))).equals("@") && _new.length()>=3) { 
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="CodigoBomba = New.SubString(2)";
mostCurrent._codigobomba = _new.substring((int) (2));
 };
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="ToastMessageShow(LastException,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getObject()),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="ToastMessageShow(\"Erro ao processsar código.\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao processsar código."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="End Sub";
return "";
}
public static void  _getzplsscc(String _sscc) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getzplsscc", false))
	 {Debug.delegate(mostCurrent.activityBA, "getzplsscc", new Object[] {_sscc}); return;}
ResumableSub_GetZPLSSCC rsub = new ResumableSub_GetZPLSSCC(null,_sscc);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetZPLSSCC extends BA.ResumableSub {
public ResumableSub_GetZPLSSCC(VinculaBomba.Unielver.main parent,String _sscc) {
this.parent = parent;
this._sscc = _sscc;
}
VinculaBomba.Unielver.main parent;
String _sscc;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
VinculaBomba.Unielver.httpjob _jobop3 = null;
String _result = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Try";
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
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Dim JobOP3 As HttpJob";
_jobop3 = new VinculaBomba.Unielver.httpjob();
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.replace(" ","");
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.replace(" ","");
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.replace(" ","");
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
_xml = _xml+"xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>";
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="XML = XML & \"<soap:Body><GeraZPL_SSCC xmlns='htt";
_xml = _xml+"<soap:Body><GeraZPL_SSCC xmlns='http://www.aplipack.com.br/'";
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="XML = XML & \"><UserSoftware>user</UserSoftware><";
_xml = _xml+"><UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="XML = XML & \"<idSSCC>\" & SSCC & \"</idSSCC><Impri";
_xml = _xml+"<idSSCC>"+_sscc+"</idSSCC><Imprimir>0</Imprimir>";
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="XML = XML & \"<UsuarioSoft>\" & EditTextUsuario.Te";
_xml = _xml+"<UsuarioSoft>"+parent.mostCurrent._edittextusuario.getText()+"</UsuarioSoft>";
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="XML = XML & \"<Terminal>\" & Nometerminal & \"</Ter";
_xml = _xml+"<Terminal>"+parent.mostCurrent._nometerminal+"</Terminal></GeraZPL_SSCC></soap:Body></soap:Envelope>";
RDebugUtils.currentLine=983062;
 //BA.debugLineNum = 983062;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
_jobop3._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="JobOP3.PostString(URL,XML)";
_jobop3._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
_jobop3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=983065;
 //BA.debugLineNum = 983065;BA.debugLine="Wait For (JobOP3) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getzplsscc"), (Object)(_jobop3));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
RDebugUtils.currentLine=983066;
 //BA.debugLineNum = 983066;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getzplsscc"),(int) (100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
RDebugUtils.currentLine=983068;
 //BA.debugLineNum = 983068;BA.debugLine="If JobOP3.Success = True Then";
if (true) break;

case 4:
//if
this.state = 17;
if (_jobop3._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=983069;
 //BA.debugLineNum = 983069;BA.debugLine="XMLWork2 = JobOP3.GetString";
_xmlwork2 = _jobop3._getstring /*String*/ (null);
RDebugUtils.currentLine=983070;
 //BA.debugLineNum = 983070;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=983071;
 //BA.debugLineNum = 983071;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=983072;
 //BA.debugLineNum = 983072;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="If XMLWork2.Contains(\"<GeraZPL_SSCCResult>\") =";
if (true) break;

case 7:
//if
this.state = 16;
if (_xmlwork2.contains("<GeraZPL_SSCCResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=983074;
 //BA.debugLineNum = 983074;BA.debugLine="Dim Result As String = XMLWork2.SubString2(XML";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=983075;
 //BA.debugLineNum = 983075;BA.debugLine="If Result = \"sucesso\" Then";
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
RDebugUtils.currentLine=983076;
 //BA.debugLineNum = 983076;BA.debugLine="CodZPL = XMLWork2.SubString2(XMLWork2.IndexOf";
parent.mostCurrent._codzpl = _xmlwork2.substring((int) (_xmlwork2.indexOf("<CodZPL>")+8),_xmlwork2.indexOf("</CodZPL>"));
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="PrintBT";
_printbt();
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=983079;
 //BA.debugLineNum = 983079;BA.debugLine="ToastMessageShow(Result,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_result),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=983083;
 //BA.debugLineNum = 983083;BA.debugLine="JobOP3.Release";
_jobop3._release /*String*/ (null);
 if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
RDebugUtils.currentLine=983085;
 //BA.debugLineNum = 983085;BA.debugLine="ToastMessageShow(\"Erro ao obter etiqueta.\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao obter etiqueta."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=983088;
 //BA.debugLineNum = 983088;BA.debugLine="End Sub";
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
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "myabbarcode_barcodefound", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "myabbarcode_barcodefound", new Object[] {_barcode,_formatname}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub myABBarcode_BarcodeFound (Barcode As String, f";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Try";
try {RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="If formatName=\"QR_CODE\" And Barcode.Contains(\"|\"";
if ((_formatname).equals("QR_CODE") && _barcode.contains("|")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="idSSCC = Barcode.SubString2(0,9)";
mostCurrent._idsscc = _barcode.substring((int) (0),(int) (9));
 }else 
{RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Else If formatName = \"CODE_128\" Then";
if ((_formatname).equals("CODE_128")) { 
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="If Barcode.Length = 40 And Barcode.SubString2(0";
if (_barcode.length()==40 && (_barcode.substring((int) (0),(int) (2))).equals("90") && (_barcode.substring((int) (10),(int) (12))).equals("37") && (_barcode.substring((int) (18),(int) (20))).equals("10")) { 
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="Barcode1 = Barcode";
mostCurrent._barcode1 = _barcode;
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="Barcode1 = Barcode1.Replace(Chr(29),\"\")";
mostCurrent._barcode1 = mostCurrent._barcode1.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (29))),"");
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="Quantidade = Barcode1.SubString2(12,18)";
mostCurrent._quantidade = mostCurrent._barcode1.substring((int) (12),(int) (18));
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="ToastMessageShow(\"Bracode Lote capturado com s";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bracode Lote capturado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="Material = Barcode1.SubString2(2,10)";
mostCurrent._material = mostCurrent._barcode1.substring((int) (2),(int) (10));
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="Lote = Barcode1.SubString(20)";
mostCurrent._lote = mostCurrent._barcode1.substring((int) (20));
 }else 
{RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="Else if Barcode.Length = 32 Then";
if (_barcode.length()==32) { 
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="If Barcode.SubString2(0,2) = \"02\" And Barcode.";
if ((_barcode.substring((int) (0),(int) (2))).equals("02") && (_barcode.substring((int) (16),(int) (18))).equals("17") && (_barcode.substring((int) (24),(int) (26))).equals("11")) { 
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="Barcode2 = Barcode";
mostCurrent._barcode2 = _barcode;
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="Barcode2 = Barcode2.Replace(Chr(29),\"\")";
mostCurrent._barcode2 = mostCurrent._barcode2.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (29))),"");
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="ToastMessageShow(\"Bracode Validade capturado";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bracode Validade capturado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="Validade = Barcode2.SubString2(18,24)";
mostCurrent._validade = mostCurrent._barcode2.substring((int) (18),(int) (24));
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="Validade = Validade.SubString(4) & \"/\" & Vali";
mostCurrent._validade = mostCurrent._validade.substring((int) (4))+"/"+mostCurrent._validade.substring((int) (2),(int) (4))+"/20"+mostCurrent._validade.substring((int) (0),(int) (2));
RDebugUtils.currentLine=786452;
 //BA.debugLineNum = 786452;BA.debugLine="DataProducao = DataProducao.SubString(4) & \"/";
mostCurrent._dataproducao = mostCurrent._dataproducao.substring((int) (4))+"/"+mostCurrent._dataproducao.substring((int) (2),(int) (4))+"/20"+mostCurrent._dataproducao.substring((int) (0),(int) (2));
 };
 }else 
{RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="Else if Barcode.Length = 20 And Barcode.SubStri";
if (_barcode.length()==20 && (_barcode.substring((int) (0),(int) (2))).equals("00")) { 
RDebugUtils.currentLine=786455;
 //BA.debugLineNum = 786455;BA.debugLine="BarcodeSSCC = Barcode";
mostCurrent._barcodesscc = _barcode;
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="BarcodeSSCC = BarcodeSSCC.SubString(2).Replace";
mostCurrent._barcodesscc = mostCurrent._barcodesscc.substring((int) (2)).replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (29))),"");
RDebugUtils.currentLine=786457;
 //BA.debugLineNum = 786457;BA.debugLine="ToastMessageShow(\"Bracode SSCC capturado com s";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bracode SSCC capturado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=786459;
 //BA.debugLineNum = 786459;BA.debugLine="ToastMessageShow(\"Código Invalido.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código Invalido."),anywheresoftware.b4a.keywords.Common.False);
 }}}
;
 }}
;
 } 
       catch (Exception e30) {
			processBA.setLastException(e30);RDebugUtils.currentLine=786463;
 //BA.debugLineNum = 786463;BA.debugLine="ToastMessageShow(\"Erro ao processar código.\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao processar código."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=786466;
 //BA.debugLineNum = 786466;BA.debugLine="End Sub";
return "";
}
public static String  _printer_connected(boolean _success) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "printer_connected", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "printer_connected", new Object[] {_success}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Printer_Connected (Success As Boolean)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Try";
try {RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Printer.Initialize2(BTConnection.OutputStream,\"";
mostCurrent._printer.Initialize2(_btconnection.getOutputStream(),"windows-1252");
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="PrintBuffer=Chr(27)&\"t\"&Chr(16)&\"Teste de impre";
mostCurrent._printbuffer = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (27)))+"t"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (16)))+"Teste de impressão.";
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="PrintBuffer = CodZPL";
mostCurrent._printbuffer = mostCurrent._codzpl;
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Printer.WriteLine(PrintBuffer)";
mostCurrent._printer.WriteLine(mostCurrent._printbuffer);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="Printer.Flush";
mostCurrent._printer.Flush();
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="ToastMessageShow(\"Impresso com sucesso.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Impresso com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="Printer.Close";
mostCurrent._printer.Close();
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="BTConnection.Disconnect 'disable this if you li";
_btconnection.Disconnect();
 }else {
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="MsgboxAsync(\"No printer found...\",\"Print error\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("No printer found..."),BA.ObjectToCharSequence("Print error"),processBA);
 };
 } 
       catch (Exception e15) {
			processBA.setLastException(e15);RDebugUtils.currentLine=1114127;
 //BA.debugLineNum = 1114127;BA.debugLine="ToastMessageShow(\"Erro ao realizar a impressão.\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao realizar a impressão."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1114129;
 //BA.debugLineNum = 1114129;BA.debugLine="End Sub";
return "";
}
}