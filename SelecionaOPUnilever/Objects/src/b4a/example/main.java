package b4a.example;


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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, autostart.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, httputils2service.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewop = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelclockmain = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelmain = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelsettings = null;
public anywheresoftware.b4a.objects.PanelWrapper _panellogin = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelpesagem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonconfig = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelqrcode2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvalidate = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextbarcode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarpesagem = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlimparbarcode = null;
public static String _barcode1 = "";
public static String _barcode2 = "";
public static String _barcodesscc = "";
public com.AB.ABZxing.ABZxing _myabbarcode = null;
public com.AB.ABZxing.ABZxing _myabbarcode2 = null;
public static int _quantidade = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonscan = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextbarcode1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextbarcode2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextbarcodesscc = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextlote = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextproduto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextquantidade = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextvalidade = null;
public static String _validade = "";
public static int _lote = 0;
public static String _material = "";
public static String _dataproducao = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edittextfabricacao = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextlinha = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextwebservice = null;
public static String _filename = "";
public static String _nometerminal = "";
public static String _addresswebservice = "";
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlimparlogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarlogin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextsenhalogin = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextusuariologin = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelclocklogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btscan2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarop = null;
public static String _bomba = "";
public static String _sscc = "";
public static String _codmaterial = "";
public static String _opsap = "";
public static String[] _ordemprodsap = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelscan = null;
public static String _idpesagem = "";
public static String _peso = "";
public anywheresoftware.b4a.objects.ButtonWrapper _buttonloginop2 = null;
public static boolean _logado = false;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonop6 = null;
public static int _opselecionadabutton = 0;
public b4a.example.starter _starter = null;
public b4a.example.autostart _autostart = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Try";
try {RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="PanelMain.Initialize(\"\") : PanelMain.Visible = T";
mostCurrent._panelmain.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="PanelMain.Initialize(\"\") : PanelMain.Visible = T";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="PanelMain.LoadLayout(\"Layout\")";
mostCurrent._panelmain.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.AddView(PanelMain, 0, 0, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panelmain.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="PanelSettings.Initialize(\"\") : PanelSettings.Vis";
mostCurrent._panelsettings.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="PanelSettings.Initialize(\"\") : PanelSettings.Vis";
mostCurrent._panelsettings.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="PanelSettings.LoadLayout(\"Settings\")";
mostCurrent._panelsettings.LoadLayout("Settings",mostCurrent.activityBA);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Activity.AddView(PanelSettings, 0, 0, 100%x, 100";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panelsettings.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="PanelLogin.Initialize(\"\") : PanelLogin.Visible =";
mostCurrent._panellogin.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="PanelLogin.Initialize(\"\") : PanelLogin.Visible =";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="PanelLogin.LoadLayout(\"Login\")";
mostCurrent._panellogin.LoadLayout("Login",mostCurrent.activityBA);
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="Activity.AddView(PanelLogin, 0, 0, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panellogin.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="PanelPesagem.Initialize(\"\") : PanelPesagem.Visib";
mostCurrent._panelpesagem.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="PanelPesagem.Initialize(\"\") : PanelPesagem.Visib";
mostCurrent._panelpesagem.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="PanelPesagem.LoadLayout(\"Pesagem\")";
mostCurrent._panelpesagem.LoadLayout("Pesagem",mostCurrent.activityBA);
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="Activity.AddView(PanelPesagem, 0, 0, 100%x, 100%";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panelpesagem.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="PanelQRCode2.Initialize(\"\") : PanelQRCode2.Visib";
mostCurrent._panelqrcode2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="PanelQRCode2.Initialize(\"\") : PanelQRCode2.Visib";
mostCurrent._panelqrcode2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="PanelQRCode2.LoadLayout(\"QRCode2\")";
mostCurrent._panelqrcode2.LoadLayout("QRCode2",mostCurrent.activityBA);
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="Activity.AddView(PanelQRCode2,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._panelqrcode2.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="filename  = \"dataterminalpesagem6.db\"";
mostCurrent._filename = "dataterminalpesagem6.db";
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="If File.Exists(File.DirInternal,filename) = Fals";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._filename)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="File.Copy(File.DirAssets,filename,File.DirInter";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._filename);
 };
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="If sql1.IsInitialized = False Then";
if (_sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="sql1.Initialize(File.DirInternal, filename, Fal";
_sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._filename,anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql1.ExecQuery("SELECT NomeTerminal, EnderecoWebservice FROM Data WHERE id=1;")));
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="cursor.Position =  0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="NomeTerminal = cursor.GetString2(0)";
mostCurrent._nometerminal = _cursor.GetString2((int) (0));
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="AddressWebservice = cursor.GetString2(1)";
mostCurrent._addresswebservice = _cursor.GetString2((int) (1));
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="ButtonOP1.Color = Colors.Green";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="ButtonOP5.Color = Colors.Red";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="ButtonOP6.Color = Colors.Red";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="OPSelecionadaButton = 1";
_opselecionadabutton = (int) (1);
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="GetOPAtiva(True)";
_getopativa(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="Clock(True)";
_clock(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e43) {
			processBA.setLastException(e43);RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="ToastMessageShow(\"Erro ao inicar aplicativo.\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao inicar aplicativo."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="End Sub";
return "";
}
public static void  _getopativa(boolean _state) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getopativa", false))
	 {Debug.delegate(mostCurrent.activityBA, "getopativa", new Object[] {_state}); return;}
ResumableSub_GetOPAtiva rsub = new ResumableSub_GetOPAtiva(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetOPAtiva extends BA.ResumableSub {
public ResumableSub_GetOPAtiva(b4a.example.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
b4a.example.main parent;
boolean _state;
String _url = "";
String _xmlwork = "";
String _xml = "";
b4a.example.httpjob _jobop = null;
String _result = "";
int _quant = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _c = null;
String _ordens = "";
String _ordemprod = "";
String _statusop = "";
String _idordemprod = "";
String _ordemproduc = "";
String _descricaocuc = "";
String _datahorasap = "";
int _setorselec = 0;
int _j = 0;
int step52;
int limit52;

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
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Do While state = True";
if (true) break;

case 1:
//do while
this.state = 51;
while (_state==anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Try";
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
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Sleep(1000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getopativa"),(int) (1000));
this.state = 52;
return;
case 52:
//C
this.state = 7;
;
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="Dim XMLWork As String";
_xmlwork = "";
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="Dim JobOP As HttpJob";
_jobop = new b4a.example.httpjob();
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="Dim Quant As Int";
_quant = 0;
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Dim b As Bitmap";
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="Dim c As Bitmap";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="Dim Ordens As String";
_ordens = "";
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="Dim OrdemProd As String";
_ordemprod = "";
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="Dim StatusOP As String";
_statusop = "";
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="Dim IdOrdemProd As String";
_idordemprod = "";
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="Dim OrdemProduc As String";
_ordemproduc = "";
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="Dim DescricaoCUC As String";
_descricaocuc = "";
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="Dim DataHoraSAP As String";
_datahorasap = "";
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="Dim SetorSelec As Int";
_setorselec = 0;
RDebugUtils.currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=393238;
 //BA.debugLineNum = 393238;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=393240;
 //BA.debugLineNum = 393240;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=393241;
 //BA.debugLineNum = 393241;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
RDebugUtils.currentLine=393242;
 //BA.debugLineNum = 393242;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
RDebugUtils.currentLine=393243;
 //BA.debugLineNum = 393243;BA.debugLine="XML = XML & \"<GetOrdensAbertasP xmlns='http://w";
_xml = _xml+"<GetOrdensAbertasP xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=393244;
 //BA.debugLineNum = 393244;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=393245;
 //BA.debugLineNum = 393245;BA.debugLine="XML = XML & \"<StatusOP>2</StatusOP></GetOrdensA";
_xml = _xml+"<StatusOP>2</StatusOP></GetOrdensAbertasP>";
RDebugUtils.currentLine=393246;
 //BA.debugLineNum = 393246;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
RDebugUtils.currentLine=393247;
 //BA.debugLineNum = 393247;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
RDebugUtils.currentLine=393249;
 //BA.debugLineNum = 393249;BA.debugLine="JobOP.Initialize(\"JOBSOAP0\", Me)";
_jobop._initialize /*String*/ (null,processBA,"JOBSOAP0",main.getObject());
RDebugUtils.currentLine=393250;
 //BA.debugLineNum = 393250;BA.debugLine="JobOP.PostString(URL,XML)";
_jobop._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=393251;
 //BA.debugLineNum = 393251;BA.debugLine="JobOP.GetRequest.SetContentType(\"text/xml\")";
_jobop._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=393252;
 //BA.debugLineNum = 393252;BA.debugLine="Wait For (JobOP) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getopativa"), (Object)(_jobop));
this.state = 53;
return;
case 53:
//C
this.state = 7;
;
RDebugUtils.currentLine=393253;
 //BA.debugLineNum = 393253;BA.debugLine="Sleep(200)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getopativa"),(int) (200));
this.state = 54;
return;
case 54:
//C
this.state = 7;
;
RDebugUtils.currentLine=393255;
 //BA.debugLineNum = 393255;BA.debugLine="If JobOP.Success = True Then";
if (true) break;

case 7:
//if
this.state = 47;
if (_jobop._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=393256;
 //BA.debugLineNum = 393256;BA.debugLine="XMLWork = JobOP.GetString";
_xmlwork = _jobop._getstring /*String*/ (null);
RDebugUtils.currentLine=393257;
 //BA.debugLineNum = 393257;BA.debugLine="XMLWork = XMLWork.Replace(\"&lt;\",\"<\")";
_xmlwork = _xmlwork.replace("&lt;","<");
RDebugUtils.currentLine=393258;
 //BA.debugLineNum = 393258;BA.debugLine="XMLWork = XMLWork.Replace(\"&gt;\",\">\")";
_xmlwork = _xmlwork.replace("&gt;",">");
RDebugUtils.currentLine=393259;
 //BA.debugLineNum = 393259;BA.debugLine="XMLWork = XMLWork.Replace(\"&amp;\",\"-\")";
_xmlwork = _xmlwork.replace("&amp;","-");
RDebugUtils.currentLine=393260;
 //BA.debugLineNum = 393260;BA.debugLine="Sleep(500)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getopativa"),(int) (500));
this.state = 55;
return;
case 55:
//C
this.state = 10;
;
RDebugUtils.currentLine=393261;
 //BA.debugLineNum = 393261;BA.debugLine="JobOP.Release";
_jobop._release /*String*/ (null);
RDebugUtils.currentLine=393263;
 //BA.debugLineNum = 393263;BA.debugLine="If XMLWork.Contains(\"<GetOrdensAbertasPResult>";
if (true) break;

case 10:
//if
this.state = 46;
if (_xmlwork.contains("<GetOrdensAbertasPResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=393264;
 //BA.debugLineNum = 393264;BA.debugLine="Result = XMLWork.SubString2(XMLWork.IndexOf(\"";
_result = _xmlwork.substring((int) (_xmlwork.indexOf("<Erro>")+6),_xmlwork.indexOf("</Erro>"));
RDebugUtils.currentLine=393265;
 //BA.debugLineNum = 393265;BA.debugLine="Quant = XMLWork.SubString2(XMLWork.IndexOf(\"<";
_quant = (int)(Double.parseDouble(_xmlwork.substring((int) (_xmlwork.indexOf("<Quantidade>")+12),_xmlwork.indexOf("</Quantidade>"))));
RDebugUtils.currentLine=393266;
 //BA.debugLineNum = 393266;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 13:
//if
this.state = 45;
if ((_result).equals("sucesso")) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
RDebugUtils.currentLine=393267;
 //BA.debugLineNum = 393267;BA.debugLine="b.InitializeResize(File.DirAssets,\"data_ok.p";
_b.InitializeResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"data_ok.png",(int)(Double.parseDouble("24")),(int)(Double.parseDouble("24")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393269;
 //BA.debugLineNum = 393269;BA.debugLine="c.InitializeResize(File.DirAssets,\"data.png\"";
_c.InitializeResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"data.png",(int)(Double.parseDouble("24")),(int)(Double.parseDouble("24")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393271;
 //BA.debugLineNum = 393271;BA.debugLine="ListViewOP.Clear";
parent.mostCurrent._listviewop.Clear();
RDebugUtils.currentLine=393273;
 //BA.debugLineNum = 393273;BA.debugLine="If Quant > 0 Then";
if (true) break;

case 16:
//if
this.state = 44;
if (_quant>0) { 
this.state = 18;
}else {
this.state = 43;
}if (true) break;

case 18:
//C
this.state = 19;
RDebugUtils.currentLine=393274;
 //BA.debugLineNum = 393274;BA.debugLine="Ordens = XMLWork.SubString2(XMLWork.IndexOf";
_ordens = _xmlwork.substring((int) (_xmlwork.indexOf("<Ordens>")+8),_xmlwork.indexOf("</Ordens>"));
RDebugUtils.currentLine=393276;
 //BA.debugLineNum = 393276;BA.debugLine="For j=0 To Quant-1";
if (true) break;

case 19:
//for
this.state = 41;
step52 = 1;
limit52 = (int) (_quant-1);
_j = (int) (0) ;
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
if (true) break;

case 21:
//C
this.state = 22;
RDebugUtils.currentLine=393277;
 //BA.debugLineNum = 393277;BA.debugLine="OrdemProd =  Ordens.SubString2(Ordens.Inde";
_ordemprod = _ordens.substring((int) (_ordens.indexOf("<OrdemProducao>")+15),_ordens.indexOf("</OrdemProducao>"));
RDebugUtils.currentLine=393278;
 //BA.debugLineNum = 393278;BA.debugLine="StatusOP = OrdemProd.SubString2(OrdemProd.";
_statusop = _ordemprod.substring((int) (_ordemprod.indexOf("<StatusOP>")+10),_ordemprod.indexOf("</StatusOP>"));
RDebugUtils.currentLine=393279;
 //BA.debugLineNum = 393279;BA.debugLine="IdOrdemProd = OrdemProd.SubString2(OrdemPr";
_idordemprod = _ordemprod.substring((int) (_ordemprod.indexOf("<IdOrdemProd>")+13),_ordemprod.indexOf("</IdOrdemProd>"));
RDebugUtils.currentLine=393280;
 //BA.debugLineNum = 393280;BA.debugLine="OrdemProduc = OrdemProd.SubString2(OrdemPr";
_ordemproduc = _ordemprod.substring((int) (_ordemprod.indexOf("<OrdemProd>")+11),_ordemprod.indexOf("</OrdemProd>"));
RDebugUtils.currentLine=393281;
 //BA.debugLineNum = 393281;BA.debugLine="DescricaoCUC = OrdemProd.SubString2(OrdemP";
_descricaocuc = _ordemprod.substring((int) (_ordemprod.indexOf("<DescricaoCUC>")+14),_ordemprod.indexOf("</DescricaoCUC>"));
RDebugUtils.currentLine=393282;
 //BA.debugLineNum = 393282;BA.debugLine="DataHoraSAP = OrdemProd.SubString2(OrdemPr";
_datahorasap = _ordemprod.substring((int) (_ordemprod.indexOf("<dataHoraSAP>")+13),_ordemprod.indexOf("</dataHoraSAP>"));
RDebugUtils.currentLine=393283;
 //BA.debugLineNum = 393283;BA.debugLine="SetorSelec = OrdemProd.SubString2(OrdemPro";
_setorselec = (int)(Double.parseDouble(_ordemprod.substring((int) (_ordemprod.indexOf("<SetorSelec>")+12),_ordemprod.indexOf("</SetorSelec>"))));
RDebugUtils.currentLine=393285;
 //BA.debugLineNum = 393285;BA.debugLine="OrdemProdSAP(j) = OrdemProduc";
parent.mostCurrent._ordemprodsap[_j] = _ordemproduc;
RDebugUtils.currentLine=393286;
 //BA.debugLineNum = 393286;BA.debugLine="DataHoraSAP = DataHoraSAP.SubString2(0,9)";
_datahorasap = _datahorasap.substring((int) (0),(int) (9));
RDebugUtils.currentLine=393287;
 //BA.debugLineNum = 393287;BA.debugLine="DataHoraSAP = DataHoraSAP.SubString(8) & \"";
_datahorasap = _datahorasap.substring((int) (8))+"/"+_datahorasap.substring((int) (5),(int) (7))+"/"+_datahorasap.substring((int) (0),(int) (4));
RDebugUtils.currentLine=393289;
 //BA.debugLineNum = 393289;BA.debugLine="If StatusOP = \"2\" Then";
if (true) break;

case 22:
//if
this.state = 37;
if ((_statusop).equals("2")) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=393290;
 //BA.debugLineNum = 393290;BA.debugLine="If SetorSelec > 0 Then";
if (true) break;

case 25:
//if
this.state = 36;
if (_setorselec>0) { 
this.state = 27;
}else {
this.state = 35;
}if (true) break;

case 27:
//C
this.state = 28;
RDebugUtils.currentLine=393292;
 //BA.debugLineNum = 393292;BA.debugLine="If SetorSelec = OPSelecionadaButton Then";
if (true) break;

case 28:
//if
this.state = 33;
if (_setorselec==parent._opselecionadabutton) { 
this.state = 30;
}else {
this.state = 32;
}if (true) break;

case 30:
//C
this.state = 33;
RDebugUtils.currentLine=393293;
 //BA.debugLineNum = 393293;BA.debugLine="ListViewOP.AddTwoLinesAndBitmap2(\"OP \"";
parent.mostCurrent._listviewop.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("OP "+_ordemproduc+" | Data:"+_datahorasap),BA.ObjectToCharSequence(_descricaocuc),(android.graphics.Bitmap)(_b.getObject()),(Object)(_idordemprod));
 if (true) break;

case 32:
//C
this.state = 33;
RDebugUtils.currentLine=393295;
 //BA.debugLineNum = 393295;BA.debugLine="ListViewOP.AddTwoLinesAndBitmap2(\"OP \"";
parent.mostCurrent._listviewop.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("OP "+_ordemproduc+" | Data:"+_datahorasap),BA.ObjectToCharSequence(_descricaocuc),(android.graphics.Bitmap)(_c.getObject()),(Object)(_idordemprod));
 if (true) break;

case 33:
//C
this.state = 36;
;
 if (true) break;

case 35:
//C
this.state = 36;
RDebugUtils.currentLine=393299;
 //BA.debugLineNum = 393299;BA.debugLine="ListViewOP.AddTwoLinesAndBitmap2(\"OP \" &";
parent.mostCurrent._listviewop.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("OP "+_ordemproduc+" | Data:"+_datahorasap),BA.ObjectToCharSequence(_descricaocuc),(android.graphics.Bitmap)(_c.getObject()),(Object)(_idordemprod));
 if (true) break;

case 36:
//C
this.state = 37;
;
 if (true) break;
;
RDebugUtils.currentLine=393305;
 //BA.debugLineNum = 393305;BA.debugLine="If  j < Quant-1 Then";

case 37:
//if
this.state = 40;
if (_j<_quant-1) { 
this.state = 39;
}if (true) break;

case 39:
//C
this.state = 40;
RDebugUtils.currentLine=393306;
 //BA.debugLineNum = 393306;BA.debugLine="Ordens = Ordens.SubString(Ordens.IndexOf(";
_ordens = _ordens.substring((int) (_ordens.indexOf("</OrdemProducao>")+16));
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
;
RDebugUtils.currentLine=393310;
 //BA.debugLineNum = 393310;BA.debugLine="ListViewOP.TwoLinesAndBitmap.ItemHeight = 6";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=393311;
 //BA.debugLineNum = 393311;BA.debugLine="ListViewOP.TwoLinesAndBitmap.SecondLabel.Te";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().SecondLabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=393312;
 //BA.debugLineNum = 393312;BA.debugLine="ListViewOP.TwoLinesAndBitmap.SecondLabel.Te";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().SecondLabel.setTextSize((float) (18));
RDebugUtils.currentLine=393313;
 //BA.debugLineNum = 393313;BA.debugLine="ListViewOP.TwoLinesAndBitmap.Label.TextSize";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().Label.setTextSize((float) (18));
RDebugUtils.currentLine=393314;
 //BA.debugLineNum = 393314;BA.debugLine="ListViewOP.TwoLinesAndBitmap.Label.TextColo";
parent.mostCurrent._listviewop.getTwoLinesAndBitmap().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 if (true) break;

case 43:
//C
this.state = 44;
RDebugUtils.currentLine=393316;
 //BA.debugLineNum = 393316;BA.debugLine="ToastMessageShow(\"Sem Ordens abertas.\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Sem Ordens abertas."),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=393321;
 //BA.debugLineNum = 393321;BA.debugLine="JobOP.Release";
_jobop._release /*String*/ (null);
 if (true) break;

case 49:
//C
this.state = 50;
this.catchState = 0;
RDebugUtils.currentLine=393323;
 //BA.debugLineNum = 393323;BA.debugLine="ToastMessageShow(\"Erro ao carregar OPs.\", False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao carregar OPs."),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=393327;
 //BA.debugLineNum = 393327;BA.debugLine="End Sub";
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
public static void  _clock(boolean _state) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clock", false))
	 {Debug.delegate(mostCurrent.activityBA, "clock", new Object[] {_state}); return;}
ResumableSub_Clock rsub = new ResumableSub_Clock(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_Clock extends BA.ResumableSub {
public ResumableSub_Clock(b4a.example.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
b4a.example.main parent;
boolean _state;
String _time = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Do While state = True";
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
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Dim time As String = DateTime.Time(DateTime.Now)";
_time = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="LabelClockLogin.Text = time";
parent.mostCurrent._labelclocklogin.setText(BA.ObjectToCharSequence(_time));
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="LabelClockMain.Text = time";
parent.mostCurrent._labelclockmain.setText(BA.ObjectToCharSequence(_time));
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Sleep(500)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "clock"),(int) (500));
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
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
ResumableSub_Activity_Pause rsub = new ResumableSub_Activity_Pause(null,_userclosed);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Pause extends BA.ResumableSub {
public ResumableSub_Activity_Pause(b4a.example.main parent,boolean _userclosed) {
this.parent = parent;
this._userclosed = _userclosed;
}
b4a.example.main parent;
boolean _userclosed;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Do While UserClosed = True";
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
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Sleep(1000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "activity_pause"),(int) (1000));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Clock(False)";
_clock(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="GetOPAtiva(False)";
_getopativa(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="GetOPAtiva(True)";
_getopativa(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Clock(True)";
_clock(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="End Sub";
return "";
}
public static String  _btscan2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btscan2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btscan2_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub BtScan2_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="myABBarcode2.ABGetBarcode(\"myabbarcode2\", \"\")";
mostCurrent._myabbarcode2.ABGetBarcode(mostCurrent.activityBA,"myabbarcode2","");
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _buttonconfig_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonconfig_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonconfig_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub ButtonConfig_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="PanelLogin.Visible = True";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="PanelMain.Visible = False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="End Sub";
return "";
}
public static String  _buttongravar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttongravar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttongravar_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub ButtonGravar_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Try";
try {RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="sql1.ExecNonQuery(\"UPDATE Data SET  NomeTerminal";
_sql1.ExecNonQuery("UPDATE Data SET  NomeTerminal ='"+mostCurrent._edittextlinha.getText()+"', EnderecoWebservice='"+mostCurrent._edittextwebservice.getText()+"' WHERE id=1;");
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT NomeTerminal, En";
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql1.ExecQuery("SELECT NomeTerminal, EnderecoWebservice FROM Data WHERE id=1;")));
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="cursor.Position =  0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="NomeTerminal = cursor.GetString2(0)";
mostCurrent._nometerminal = _cursor.GetString2((int) (0));
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="AddressWebservice = cursor.GetString2(1)";
mostCurrent._addresswebservice = _cursor.GetString2((int) (1));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="MsgboxAsync(\"Erro ao gravar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao gravar."),BA.ObjectToCharSequence("Erro"),processBA);
 };
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlimparbarcode_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonlimparbarcode_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonlimparbarcode_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub ButtonLimparBarcode_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="EditTextBarcode.Text = \"\"";
mostCurrent._edittextbarcode.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlimparlogin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonlimparlogin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonlimparlogin_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub ButtonLimparLogin_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="EditTextLinha.Text = \"\"";
mostCurrent._edittextlinha.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="EditTextWebservice.Text = \"\"";
mostCurrent._edittextwebservice.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="End Sub";
return "";
}
public static void  _buttonlogin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonlogin_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "buttonlogin_click", null); return;}
ResumableSub_ButtonLogin_Click rsub = new ResumableSub_ButtonLogin_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonLogin_Click extends BA.ResumableSub {
public ResumableSub_ButtonLogin_Click(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
b4a.example.httpjob _jobop2 = null;
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
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
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
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="Dim JobOP2 As HttpJob";
_jobop2 = new b4a.example.httpjob();
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
RDebugUtils.currentLine=720922;
 //BA.debugLineNum = 720922;BA.debugLine="XML = XML & \"<LoginSoftware xmlns='http://www.ap";
_xml = _xml+"<LoginSoftware xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="XML = XML & \"<Usuario>\" & EditTextUsuarioLogin.T";
_xml = _xml+"<Usuario>"+parent.mostCurrent._edittextusuariologin.getText()+"</Usuario>";
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="XML = XML & \"<Password>\" & EditTextSenhaLogin.Te";
_xml = _xml+"<Password>"+parent.mostCurrent._edittextsenhalogin.getText()+"</Password></LoginSoftware>";
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
RDebugUtils.currentLine=720926;
 //BA.debugLineNum = 720926;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
RDebugUtils.currentLine=720928;
 //BA.debugLineNum = 720928;BA.debugLine="JobOP2.Initialize(\"JOBSOAP2\", Me)";
_jobop2._initialize /*String*/ (null,processBA,"JOBSOAP2",main.getObject());
RDebugUtils.currentLine=720929;
 //BA.debugLineNum = 720929;BA.debugLine="JobOP2.PostString(URL,XML)";
_jobop2._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=720930;
 //BA.debugLineNum = 720930;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml; char";
_jobop2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml; charset=utf-8");
RDebugUtils.currentLine=720931;
 //BA.debugLineNum = 720931;BA.debugLine="Wait For (JobOP2) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "buttonlogin_click"), (Object)(_jobop2));
this.state = 23;
return;
case 23:
//C
this.state = 4;
;
RDebugUtils.currentLine=720932;
 //BA.debugLineNum = 720932;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "buttonlogin_click"),(int) (100));
this.state = 24;
return;
case 24:
//C
this.state = 4;
;
RDebugUtils.currentLine=720934;
 //BA.debugLineNum = 720934;BA.debugLine="If JobOP2.Success = True Then";
if (true) break;

case 4:
//if
this.state = 19;
if (_jobop2._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}else {
this.state = 18;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=720935;
 //BA.debugLineNum = 720935;BA.debugLine="XMLWork2 = JobOP2.GetString";
_xmlwork2 = _jobop2._getstring /*String*/ (null);
RDebugUtils.currentLine=720936;
 //BA.debugLineNum = 720936;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=720937;
 //BA.debugLineNum = 720937;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=720938;
 //BA.debugLineNum = 720938;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=720940;
 //BA.debugLineNum = 720940;BA.debugLine="If XMLWork2.Contains(\"<LoginSoftwareResult>\") =";
if (true) break;

case 7:
//if
this.state = 16;
if (_xmlwork2.contains("<LoginSoftwareResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=720941;
 //BA.debugLineNum = 720941;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=720942;
 //BA.debugLineNum = 720942;BA.debugLine="If Result = \"sucesso\" Then";
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
RDebugUtils.currentLine=720943;
 //BA.debugLineNum = 720943;BA.debugLine="ToastMessageShow(\"Logado com sucesso.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Logado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720944;
 //BA.debugLineNum = 720944;BA.debugLine="Logado = True";
parent._logado = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=720945;
 //BA.debugLineNum = 720945;BA.debugLine="PanelMain.Visible = True";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720946;
 //BA.debugLineNum = 720946;BA.debugLine="PanelLogin.Visible = False";
parent.mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=720948;
 //BA.debugLineNum = 720948;BA.debugLine="ToastMessageShow(Result,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_result),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=720952;
 //BA.debugLineNum = 720952;BA.debugLine="ToastMessageShow(\"Problema no processo de Login";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Problema no processo de Login. Tente Novamente."),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 19:
//C
this.state = 22;
;
 if (true) break;

case 21:
//C
this.state = 22;
this.catchState = 0;
RDebugUtils.currentLine=720955;
 //BA.debugLineNum = 720955;BA.debugLine="ToastMessageShow(\"Erro ao fazer Login.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao fazer Login."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 22:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=720957;
 //BA.debugLineNum = 720957;BA.debugLine="End Sub";
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
public static String  _buttonloginop2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonloginop2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonloginop2_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub ButtonLoginOP2_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="PanelLogin.Visible = True";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="PanelMain.Visible = False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonop1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonop1_click", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Private Sub ButtonOP1_Click";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="ButtonOP1.Color = Colors.Green";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="ButtonOP5.Color = Colors.Red";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="ButtonOP6.Color = Colors.Red";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="OPSelecionadaButton = 1";
_opselecionadabutton = (int) (1);
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonop2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonop2_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub ButtonOP2_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="ButtonOP2.Color = Colors.Green";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="ButtonOP5.Color = Colors.Red";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="ButtonOP6.Color = Colors.Red";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="OPSelecionadaButton = 2";
_opselecionadabutton = (int) (2);
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop3_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonop3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonop3_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub ButtonOP3_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="ButtonOP3.Color = Colors.Green";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="ButtonOP5.Color = Colors.Red";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="ButtonOP6.Color = Colors.Red";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="OPSelecionadaButton = 3";
_opselecionadabutton = (int) (3);
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonop4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonop4_click", null));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub ButtonOP4_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="ButtonOP4.Color = Colors.Green";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="ButtonOP5.Color = Colors.Red";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="ButtonOP6.Color = Colors.Red";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="OPSelecionadaButton = 4";
_opselecionadabutton = (int) (4);
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonop5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonop5_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub ButtonOP5_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="ButtonOP5.Color = Colors.Green";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="ButtonOP6.Color = Colors.Red";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="OPSelecionadaButton = 5";
_opselecionadabutton = (int) (5);
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="End Sub";
return "";
}
public static String  _buttonop6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonop6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonop6_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub ButtonOP6_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="ButtonOP1.Color = Colors.Red";
mostCurrent._buttonop1.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="ButtonOP2.Color = Colors.Red";
mostCurrent._buttonop2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="ButtonOP3.Color = Colors.Red";
mostCurrent._buttonop3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="ButtonOP4.Color = Colors.Red";
mostCurrent._buttonop4.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="ButtonOP5.Color = Colors.Red";
mostCurrent._buttonop5.setColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="ButtonOP6.Color = Colors.Green";
mostCurrent._buttonop6.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="OPSelecionadaButton = 6";
_opselecionadabutton = (int) (6);
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="End Sub";
return "";
}
public static String  _buttonscan_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonscan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonscan_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub ButtonScan_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
mostCurrent._myabbarcode.ABGetBarcode(mostCurrent.activityBA,"myabbarcode","");
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvalidate_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvalidate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvalidate_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub ButtonValidate_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If Barcode1.Length > 0 And Barcode2.Length > 0 An";
if (mostCurrent._barcode1.length()>0 && mostCurrent._barcode2.length()>0 && mostCurrent._barcodesscc.length()>0) { 
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="SendSSCC";
_sendsscc();
 }else 
{RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="Else if Barcode1.Length = 0 Then";
if (mostCurrent._barcode1.length()==0) { 
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="ToastMessageShow(\"Barcode 1 Vazio.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Barcode 1 Vazio."),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Else if Barcode2.Length = 0 Then";
if (mostCurrent._barcode2.length()==0) { 
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="ToastMessageShow(\"Barcode 2 Vazio.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Barcode 2 Vazio."),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="Else if BarcodeSSCC.Length = 0 Then";
if (mostCurrent._barcodesscc.length()==0) { 
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="ToastMessageShow(\"Barcode SSCC Vazio.\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Barcode SSCC Vazio."),anywheresoftware.b4a.keywords.Common.False);
 }}}}
;
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="End Sub";
return "";
}
public static void  _sendsscc() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sendsscc", false))
	 {Debug.delegate(mostCurrent.activityBA, "sendsscc", null); return;}
ResumableSub_SendSSCC rsub = new ResumableSub_SendSSCC(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_SendSSCC extends BA.ResumableSub {
public ResumableSub_SendSSCC(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
b4a.example.httpjob _jobop3 = null;
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
this.state = 20;
this.catchState = 19;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 19;
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Dim JobOP3 As HttpJob";
_jobop3 = new b4a.example.httpjob();
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="XML = XML & \"xmlns:soap='http://schemas.xmlsoap.";
_xml = _xml+"xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>";
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="XML = XML & \"<soap:Body><RegistraSSCC xmlns='htt";
_xml = _xml+"<soap:Body><RegistraSSCC xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="XML = XML & \"<Barcode1>\" & Barcode1 & \"</Barcode";
_xml = _xml+"<Barcode1>"+parent.mostCurrent._barcode1+"</Barcode1><Barcode2>"+parent.mostCurrent._barcode2+"</Barcode2>";
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="XML = XML & \"<BarcodeSSCC>\" & BarcodeSSCC & \"</B";
_xml = _xml+"<BarcodeSSCC>"+parent.mostCurrent._barcodesscc+"</BarcodeSSCC>";
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="XML = XML & \"<UsuarioLeitura>user</UsuarioLeitur";
_xml = _xml+"<UsuarioLeitura>user</UsuarioLeitura><Quantidade>"+BA.NumberToString(parent._quantidade)+"</Quantidade>";
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="XML = XML & \"</RegistraSSCC></soap:Body></soap:E";
_xml = _xml+"</RegistraSSCC></soap:Body></soap:Envelope>";
RDebugUtils.currentLine=1245204;
 //BA.debugLineNum = 1245204;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
parent.mostCurrent._barcode1 = parent.mostCurrent._barcode1.replace(" ","");
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
parent.mostCurrent._barcode2 = parent.mostCurrent._barcode2.replace(" ","");
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(\" \",\"\")";
parent.mostCurrent._barcodesscc = parent.mostCurrent._barcodesscc.replace(" ","");
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="JobOP3.Initialize(\"JOBSOAP\", Me)";
_jobop3._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=1245209;
 //BA.debugLineNum = 1245209;BA.debugLine="JobOP3.PostString(URL,XML)";
_jobop3._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="JobOP3.GetRequest.SetContentType(\"text/xml\")";
_jobop3._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=1245211;
 //BA.debugLineNum = 1245211;BA.debugLine="Wait For (JobOP3) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "sendsscc"), (Object)(_jobop3));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
RDebugUtils.currentLine=1245212;
 //BA.debugLineNum = 1245212;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "sendsscc"),(int) (100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
RDebugUtils.currentLine=1245214;
 //BA.debugLineNum = 1245214;BA.debugLine="If JobOP3.Success = True Then";
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
RDebugUtils.currentLine=1245215;
 //BA.debugLineNum = 1245215;BA.debugLine="XMLWork2 = JobOP3.GetString";
_xmlwork2 = _jobop3._getstring /*String*/ (null);
RDebugUtils.currentLine=1245216;
 //BA.debugLineNum = 1245216;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=1245217;
 //BA.debugLineNum = 1245217;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=1245218;
 //BA.debugLineNum = 1245218;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=1245220;
 //BA.debugLineNum = 1245220;BA.debugLine="If XMLWork2.Contains(\"<RegistraSSCCResult>\") =";
if (true) break;

case 7:
//if
this.state = 16;
if (_xmlwork2.contains("<RegistraSSCCResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=1245221;
 //BA.debugLineNum = 1245221;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=1245223;
 //BA.debugLineNum = 1245223;BA.debugLine="If Result = \"sucesso\" Then";
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
RDebugUtils.currentLine=1245224;
 //BA.debugLineNum = 1245224;BA.debugLine="ToastMessageShow(\"SSCC registrado com sucesso";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SSCC registrado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245225;
 //BA.debugLineNum = 1245225;BA.debugLine="Barcode1 = \"\"";
parent.mostCurrent._barcode1 = "";
RDebugUtils.currentLine=1245226;
 //BA.debugLineNum = 1245226;BA.debugLine="Barcode2 = \"\"";
parent.mostCurrent._barcode2 = "";
RDebugUtils.currentLine=1245227;
 //BA.debugLineNum = 1245227;BA.debugLine="BarcodeSSCC = \"\"";
parent.mostCurrent._barcodesscc = "";
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=1245229;
 //BA.debugLineNum = 1245229;BA.debugLine="ToastMessageShow(Result,False)";
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
RDebugUtils.currentLine=1245233;
 //BA.debugLineNum = 1245233;BA.debugLine="JobOP3.Release";
_jobop3._release /*String*/ (null);
 if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
RDebugUtils.currentLine=1245235;
 //BA.debugLineNum = 1245235;BA.debugLine="ToastMessageShow(\"Erro ao registtar SCCC.\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao registtar SCCC."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=1245238;
 //BA.debugLineNum = 1245238;BA.debugLine="End Sub";
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
public static String  _buttonvoltarlogin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvoltarlogin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvoltarlogin_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub ButtonVoltarLogin_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="PanelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="PanelLogin.Visible = False";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltarop_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvoltarop_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvoltarop_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub ButtonVoltarOP_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="PanelQRCode2.Visible=False";
mostCurrent._panelqrcode2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="PanelMain.Visible=True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _buttonvoltarpesagem_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonvoltarpesagem_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonvoltarpesagem_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub ButtonVoltarPesagem_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="PanelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="PanelPesagem.Visible = False";
mostCurrent._panelpesagem.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="End Sub";
return "";
}
public static String  _edittextbarcode_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edittextbarcode_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edittextbarcode_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub EditTextBarcode_TextChanged (Old As St";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Try";
try {RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="If EditTextBarcode.Text.Length = 42 And EditText";
if (mostCurrent._edittextbarcode.getText().length()==42 && (mostCurrent._edittextbarcode.getText().substring((int) (0),(int) (2))).equals("90")) { 
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Barcode1 = EditTextBarcode.Text";
mostCurrent._barcode1 = mostCurrent._edittextbarcode.getText();
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Barcode1 = Barcode1.Replace(Chr(29),\"\")";
mostCurrent._barcode1 = mostCurrent._barcode1.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (29))),"");
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Barcode1 = Barcode1.Replace(\" \",\"\")";
mostCurrent._barcode1 = mostCurrent._barcode1.replace(" ","");
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Quantidade = Barcode1.SubString2(12,18)";
_quantidade = (int)(Double.parseDouble(mostCurrent._barcode1.substring((int) (12),(int) (18))));
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="ToastMessageShow(\"Bracode 1 capturado com suces";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bracode 1 capturado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="EditTextQuantidade.Text = Quantidade";
mostCurrent._edittextquantidade.setText(BA.ObjectToCharSequence(_quantidade));
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="Material = Barcode1.SubString2(2,10)";
mostCurrent._material = mostCurrent._barcode1.substring((int) (2),(int) (10));
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="EditTextProduto.Text = Material";
mostCurrent._edittextproduto.setText(BA.ObjectToCharSequence(mostCurrent._material));
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="Lote = Barcode1.SubString(20)";
_lote = (int)(Double.parseDouble(mostCurrent._barcode1.substring((int) (20))));
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="EditTextLote.Text = Lote";
mostCurrent._edittextlote.setText(BA.ObjectToCharSequence(_lote));
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="EditTextBarcode1.Text = Barcode1";
mostCurrent._edittextbarcode1.setText(BA.ObjectToCharSequence(mostCurrent._barcode1));
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="EditTextBarcode.Text = \"\"";
mostCurrent._edittextbarcode.setText(BA.ObjectToCharSequence(""));
 }else 
{RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="Else if EditTextBarcode.Text.Length = 33 Then";
if (mostCurrent._edittextbarcode.getText().length()==33) { 
RDebugUtils.currentLine=1048592;
 //BA.debugLineNum = 1048592;BA.debugLine="If EditTextBarcode.Text.SubString2(0,2) = \"02\"";
if ((mostCurrent._edittextbarcode.getText().substring((int) (0),(int) (2))).equals("02")) { 
RDebugUtils.currentLine=1048593;
 //BA.debugLineNum = 1048593;BA.debugLine="Barcode2 = EditTextBarcode.Text";
mostCurrent._barcode2 = mostCurrent._edittextbarcode.getText();
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="Barcode2 = Barcode2.Replace(Chr(29),\"\")";
mostCurrent._barcode2 = mostCurrent._barcode2.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (29))),"");
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="Barcode2 = Barcode2.Replace(\" \",\"\")";
mostCurrent._barcode2 = mostCurrent._barcode2.replace(" ","");
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="ToastMessageShow(\"Bracode 2 capturado com suce";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bracode 2 capturado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048597;
 //BA.debugLineNum = 1048597;BA.debugLine="Validade = Barcode2.SubString2(18,24)";
mostCurrent._validade = mostCurrent._barcode2.substring((int) (18),(int) (24));
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="Validade = Validade.SubString(4) & \"/\" & Valid";
mostCurrent._validade = mostCurrent._validade.substring((int) (4))+"/"+mostCurrent._validade.substring((int) (2),(int) (4))+"/20"+mostCurrent._validade.substring((int) (0),(int) (2));
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="EditTextValidade.Text = Validade";
mostCurrent._edittextvalidade.setText(BA.ObjectToCharSequence(mostCurrent._validade));
RDebugUtils.currentLine=1048600;
 //BA.debugLineNum = 1048600;BA.debugLine="DataProducao = Barcode2.SubString(26)";
mostCurrent._dataproducao = mostCurrent._barcode2.substring((int) (26));
RDebugUtils.currentLine=1048601;
 //BA.debugLineNum = 1048601;BA.debugLine="DataProducao = DataProducao.SubString(4) & \"/\"";
mostCurrent._dataproducao = mostCurrent._dataproducao.substring((int) (4))+"/"+mostCurrent._dataproducao.substring((int) (2),(int) (4))+"/20"+mostCurrent._dataproducao.substring((int) (0),(int) (2));
RDebugUtils.currentLine=1048602;
 //BA.debugLineNum = 1048602;BA.debugLine="EditTextFabricacao.Text = DataProducao";
mostCurrent._edittextfabricacao.setText(BA.ObjectToCharSequence(mostCurrent._dataproducao));
RDebugUtils.currentLine=1048603;
 //BA.debugLineNum = 1048603;BA.debugLine="EditTextBarcode2.Text = Barcode2";
mostCurrent._edittextbarcode2.setText(BA.ObjectToCharSequence(mostCurrent._barcode2));
RDebugUtils.currentLine=1048604;
 //BA.debugLineNum = 1048604;BA.debugLine="EditTextBarcode.Text = \"\"";
mostCurrent._edittextbarcode.setText(BA.ObjectToCharSequence(""));
 };
 }else 
{RDebugUtils.currentLine=1048606;
 //BA.debugLineNum = 1048606;BA.debugLine="Else if EditTextBarcode.Text.Length = 17 Then";
if (mostCurrent._edittextbarcode.getText().length()==17) { 
RDebugUtils.currentLine=1048607;
 //BA.debugLineNum = 1048607;BA.debugLine="If EditTextBarcode.Text.SubString2(0,2) = \"00\"";
if ((mostCurrent._edittextbarcode.getText().substring((int) (0),(int) (2))).equals("00")) { 
RDebugUtils.currentLine=1048608;
 //BA.debugLineNum = 1048608;BA.debugLine="BarcodeSSCC = EditTextBarcode.Text";
mostCurrent._barcodesscc = mostCurrent._edittextbarcode.getText();
RDebugUtils.currentLine=1048609;
 //BA.debugLineNum = 1048609;BA.debugLine="BarcodeSSCC = BarcodeSSCC.Replace(Chr(29),\"\")";
mostCurrent._barcodesscc = mostCurrent._barcodesscc.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (29))),"");
RDebugUtils.currentLine=1048610;
 //BA.debugLineNum = 1048610;BA.debugLine="ToastMessageShow(\"Bracode SSCC capturado com s";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bracode SSCC capturado com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048611;
 //BA.debugLineNum = 1048611;BA.debugLine="EditTextBarcodeSSCC.Text = BarcodeSSCC";
mostCurrent._edittextbarcodesscc.setText(BA.ObjectToCharSequence(mostCurrent._barcodesscc));
RDebugUtils.currentLine=1048612;
 //BA.debugLineNum = 1048612;BA.debugLine="EditTextBarcode.Text = \"\"";
mostCurrent._edittextbarcode.setText(BA.ObjectToCharSequence(""));
 };
 }}}
;
 } 
       catch (Exception e40) {
			processBA.setLastException(e40);RDebugUtils.currentLine=1048616;
 //BA.debugLineNum = 1048616;BA.debugLine="ToastMessageShow(\"Erro ao processar código.\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao processar código."),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1048619;
 //BA.debugLineNum = 1048619;BA.debugLine="End Sub";
return "";
}
public static void  _getidpesagem() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getidpesagem", false))
	 {Debug.delegate(mostCurrent.activityBA, "getidpesagem", null); return;}
ResumableSub_GetIdPesagem rsub = new ResumableSub_GetIdPesagem(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_GetIdPesagem extends BA.ResumableSub {
public ResumableSub_GetIdPesagem(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
b4a.example.httpjob _jobop2 = null;
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
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Try";
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
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Dim JobOP2 As HttpJob";
_jobop2 = new b4a.example.httpjob();
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="XML = XML & \"<GetidPesagem xmlns='http://www.apl";
_xml = _xml+"<GetidPesagem xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="XML = XML & \"<idOrdemProdSAP>\" & OPSap.Trim & \"<";
_xml = _xml+"<idOrdemProdSAP>"+parent.mostCurrent._opsap.trim()+"</idOrdemProdSAP>";
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="XML = XML & \"<CodigoMaterial>\" & CodMaterial.Tri";
_xml = _xml+"<CodigoMaterial>"+parent.mostCurrent._codmaterial.trim()+"</CodigoMaterial>";
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="XML = XML & \"<eptRota>\" & \"1\" & \"</eptRota><IDSS";
_xml = _xml+"<eptRota>"+"1"+"</eptRota><IDSSCC>"+parent.mostCurrent._sscc.trim()+"</IDSSCC>";
RDebugUtils.currentLine=1507347;
 //BA.debugLineNum = 1507347;BA.debugLine="XML = XML & \"<Settore>\" & OPSelecionadaButton &";
_xml = _xml+"<Settore>"+BA.NumberToString(parent._opselecionadabutton)+"</Settore><Usuario>"+"Teste"+"</Usuario>";
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="XML = XML & \"<idTerminal>\" & \"1\" & \"</idTerminal";
_xml = _xml+"<idTerminal>"+"1"+"</idTerminal></GetidPesagem>";
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
RDebugUtils.currentLine=1507350;
 //BA.debugLineNum = 1507350;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
RDebugUtils.currentLine=1507352;
 //BA.debugLineNum = 1507352;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
_jobop2._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="JobOP2.PostString(URL,XML)";
_jobop2._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
_jobop2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="Wait For (JobOP2) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getidpesagem"), (Object)(_jobop2));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
RDebugUtils.currentLine=1507356;
 //BA.debugLineNum = 1507356;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "getidpesagem"),(int) (100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="If JobOP2.Success = True Then";
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
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="XMLWork2 = JobOP2.GetString";
_xmlwork2 = _jobop2._getstring /*String*/ (null);
RDebugUtils.currentLine=1507360;
 //BA.debugLineNum = 1507360;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=1507361;
 //BA.debugLineNum = 1507361;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=1507362;
 //BA.debugLineNum = 1507362;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=1507364;
 //BA.debugLineNum = 1507364;BA.debugLine="If XMLWork2.Contains(\"<GetidPesagemResult>\") =";
if (true) break;

case 7:
//if
this.state = 16;
if (_xmlwork2.contains("<GetidPesagemResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=1507365;
 //BA.debugLineNum = 1507365;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=1507367;
 //BA.debugLineNum = 1507367;BA.debugLine="If Result = \"sucesso\" Then";
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
RDebugUtils.currentLine=1507368;
 //BA.debugLineNum = 1507368;BA.debugLine="IdPesagem = XMLWork2.SubString2(XMLWork2.Inde";
parent.mostCurrent._idpesagem = _xmlwork2.substring((int) (_xmlwork2.indexOf("<IdPesagem>")+11),_xmlwork2.indexOf("</IdPesagem>"));
RDebugUtils.currentLine=1507369;
 //BA.debugLineNum = 1507369;BA.debugLine="Peso = XMLWork2.SubString2(XMLWork2.IndexOf(\"";
parent.mostCurrent._peso = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Peso>")+6),_xmlwork2.indexOf("</Peso>"));
RDebugUtils.currentLine=1507370;
 //BA.debugLineNum = 1507370;BA.debugLine="ToastMessageShow(\"ID da Pesagem valido.\",Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("ID da Pesagem valido."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=1507372;
 //BA.debugLineNum = 1507372;BA.debugLine="ToastMessageShow(Result,False)";
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
 if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
RDebugUtils.currentLine=1507377;
 //BA.debugLineNum = 1507377;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61507377",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=1507379;
 //BA.debugLineNum = 1507379;BA.debugLine="End Sub";
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
public static String  _labelscan_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "labelscan_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "labelscan_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub LabelScan_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
mostCurrent._myabbarcode.ABGetBarcode(mostCurrent.activityBA,"myabbarcode","");
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public static void  _listviewop_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listviewop_itemclick", false))
	 {Debug.delegate(mostCurrent.activityBA, "listviewop_itemclick", new Object[] {_position,_value}); return;}
ResumableSub_ListViewOP_ItemClick rsub = new ResumableSub_ListViewOP_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewOP_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewOP_ItemClick(b4a.example.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
b4a.example.main parent;
int _position;
Object _value;
String _url = "";
String _xmlwork2 = "";
int _opselecionada = 0;
String _xml = "";
b4a.example.httpjob _jobop2 = null;
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
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Try";
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
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="If Logado = True Then";
if (true) break;

case 4:
//if
this.state = 23;
if (parent._logado==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}else {
this.state = 22;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Dim OPSelecionada As Int = Value";
_opselecionada = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Dim JobOP2 As HttpJob";
_jobop2 = new b4a.example.httpjob();
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="OPSap = OrdemProdSAP(Position)";
parent.mostCurrent._opsap = parent.mostCurrent._ordemprodsap[_position];
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://w";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="XML = XML & \"<SelecionaOP xmlns='http://www.apl";
_xml = _xml+"<SelecionaOP xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="XML = XML & \"<Settore>\" & OPSelecionadaButton &";
_xml = _xml+"<Settore>"+BA.NumberToString(parent._opselecionadabutton)+"</Settore>";
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="XML = XML & \"<IdOrdemProd>\" & OPSelecionada & \"";
_xml = _xml+"<IdOrdemProd>"+BA.NumberToString(_opselecionada)+"</IdOrdemProd></SelecionaOP>";
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
RDebugUtils.currentLine=458776;
 //BA.debugLineNum = 458776;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
_jobop2._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="JobOP2.PostString(URL,XML)";
_jobop2._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=458778;
 //BA.debugLineNum = 458778;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
_jobop2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=458779;
 //BA.debugLineNum = 458779;BA.debugLine="Wait For (JobOP2) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "listviewop_itemclick"), (Object)(_jobop2));
this.state = 27;
return;
case 27:
//C
this.state = 7;
;
RDebugUtils.currentLine=458780;
 //BA.debugLineNum = 458780;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "listviewop_itemclick"),(int) (100));
this.state = 28;
return;
case 28:
//C
this.state = 7;
;
RDebugUtils.currentLine=458782;
 //BA.debugLineNum = 458782;BA.debugLine="If JobOP2.Success = True Then";
if (true) break;

case 7:
//if
this.state = 20;
if (_jobop2._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=458783;
 //BA.debugLineNum = 458783;BA.debugLine="XMLWork2 = JobOP2.GetString";
_xmlwork2 = _jobop2._getstring /*String*/ (null);
RDebugUtils.currentLine=458784;
 //BA.debugLineNum = 458784;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=458785;
 //BA.debugLineNum = 458785;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=458786;
 //BA.debugLineNum = 458786;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=458788;
 //BA.debugLineNum = 458788;BA.debugLine="If XMLWork2.Contains(\"<SelecionaOPResult>\") =";
if (true) break;

case 10:
//if
this.state = 19;
if (_xmlwork2.contains("<SelecionaOPResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=458789;
 //BA.debugLineNum = 458789;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=458791;
 //BA.debugLineNum = 458791;BA.debugLine="If Result = \"sucesso\" Then";
if (true) break;

case 13:
//if
this.state = 18;
if ((_result).equals("sucesso")) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
RDebugUtils.currentLine=458792;
 //BA.debugLineNum = 458792;BA.debugLine="ToastMessageShow(\"OP selecionada com sucesso";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("OP selecionada com sucesso."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458793;
 //BA.debugLineNum = 458793;BA.debugLine="PanelMain.Visible = False";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458794;
 //BA.debugLineNum = 458794;BA.debugLine="PanelQRCode2.Visible = True";
parent.mostCurrent._panelqrcode2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458795;
 //BA.debugLineNum = 458795;BA.debugLine="Barcode1 = \"\"";
parent.mostCurrent._barcode1 = "";
RDebugUtils.currentLine=458796;
 //BA.debugLineNum = 458796;BA.debugLine="Barcode2 = \"\"";
parent.mostCurrent._barcode2 = "";
RDebugUtils.currentLine=458797;
 //BA.debugLineNum = 458797;BA.debugLine="BarcodeSSCC = \"\"";
parent.mostCurrent._barcodesscc = "";
 if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=458799;
 //BA.debugLineNum = 458799;BA.debugLine="ToastMessageShow(\"Falha so selecionar OP, te";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Falha so selecionar OP, tente novamente."),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=458803;
 //BA.debugLineNum = 458803;BA.debugLine="JobOP2.Release";
_jobop2._release /*String*/ (null);
 if (true) break;

case 22:
//C
this.state = 23;
RDebugUtils.currentLine=458805;
 //BA.debugLineNum = 458805;BA.debugLine="ToastMessageShow(\"Por favor faça o Login para a";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Por favor faça o Login para acessar funções do sistema."),anywheresoftware.b4a.keywords.Common.False);
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
RDebugUtils.currentLine=458808;
 //BA.debugLineNum = 458808;BA.debugLine="ToastMessageShow(\"Erro ao enviar OP selecionada.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Erro ao enviar OP selecionada.."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=458811;
 //BA.debugLineNum = 458811;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub myABBarcode_BarcodeFound (barCode As String, f";
RDebugUtils.currentLine=1179686;
 //BA.debugLineNum = 1179686;BA.debugLine="Try";
try {RDebugUtils.currentLine=1179687;
 //BA.debugLineNum = 1179687;BA.debugLine="If barCode.SubString2(0,1) = \"@\" Then";
if ((_barcode.substring((int) (0),(int) (1))).equals("@")) { 
RDebugUtils.currentLine=1179695;
 //BA.debugLineNum = 1179695;BA.debugLine="Bomba = barCode.SubString(3)";
mostCurrent._bomba = _barcode.substring((int) (3));
RDebugUtils.currentLine=1179696;
 //BA.debugLineNum = 1179696;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código lido com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1179698;
 //BA.debugLineNum = 1179698;BA.debugLine="SSCC = barCode.SubString2(0,9)";
mostCurrent._sscc = _barcode.substring((int) (0),(int) (9));
RDebugUtils.currentLine=1179699;
 //BA.debugLineNum = 1179699;BA.debugLine="CodMaterial = barCode.SubString2(10,18)";
mostCurrent._codmaterial = _barcode.substring((int) (10),(int) (18));
RDebugUtils.currentLine=1179700;
 //BA.debugLineNum = 1179700;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código lido com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 };
 } 
       catch (Exception e11) {
			processBA.setLastException(e11);RDebugUtils.currentLine=1179703;
 //BA.debugLineNum = 1179703;BA.debugLine="ToastMessageShow(\"Código Invalido\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código Invalido"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1179706;
 //BA.debugLineNum = 1179706;BA.debugLine="If Bomba.Length > 0 And SSCC.Length > 0 And CodMa";
if (mostCurrent._bomba.length()>0 && mostCurrent._sscc.length()>0 && mostCurrent._codmaterial.length()>0) { 
RDebugUtils.currentLine=1179707;
 //BA.debugLineNum = 1179707;BA.debugLine="VinculaBomba";
_vinculabomba();
 };
RDebugUtils.currentLine=1179709;
 //BA.debugLineNum = 1179709;BA.debugLine="End Sub";
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
public ResumableSub_VinculaBomba(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _url = "";
String _xmlwork2 = "";
String _xml = "";
b4a.example.httpjob _jobop2 = null;
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
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Try";
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
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim URL As String";
_url = "";
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim XMLWork2 As String";
_xmlwork2 = "";
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="Dim XML As String";
_xml = "";
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="Dim JobOP2 As HttpJob";
_jobop2 = new b4a.example.httpjob();
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="Dim Result As String";
_result = "";
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="URL = AddressWebservice";
_url = parent.mostCurrent._addresswebservice;
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="XML = \"<?xml version='1.0' encoding='utf-8'?>\"";
_xml = "<?xml version='1.0' encoding='utf-8'?>";
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="XML = XML & \"<soap:Envelope xmlns:xsi='http://ww";
_xml = _xml+"<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' ";
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="XML = XML & \"xmlns:xsd='http://www.w3.org/2001/X";
_xml = _xml+"xmlns:xsd='http://www.w3.org/2001/XMLSchema' ";
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="XML = XML & \"xmlns:soap='http://www.w3.org/2003/";
_xml = _xml+"xmlns:soap='http://www.w3.org/2003/05/soap-envelope'>";
RDebugUtils.currentLine=1572877;
 //BA.debugLineNum = 1572877;BA.debugLine="XML = XML & \"<soap:Body>\"";
_xml = _xml+"<soap:Body>";
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="XML = XML & \"<VinculaBomba xmlns='http://www.apl";
_xml = _xml+"<VinculaBomba xmlns='http://www.aplipack.com.br/'>";
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="XML = XML & \"<UserSoftware>user</UserSoftware><P";
_xml = _xml+"<UserSoftware>user</UserSoftware><PasswordSoftware>1234</PasswordSoftware>";
RDebugUtils.currentLine=1572880;
 //BA.debugLineNum = 1572880;BA.debugLine="XML = XML & \"<IdSSCC>\" & SSCC.Trim & \"</IdSSCC>\"";
_xml = _xml+"<IdSSCC>"+parent.mostCurrent._sscc.trim()+"</IdSSCC>";
RDebugUtils.currentLine=1572881;
 //BA.debugLineNum = 1572881;BA.debugLine="XML = XML & \"<CodigoBomba>\" & Bomba.Trim & \"</Co";
_xml = _xml+"<CodigoBomba>"+parent.mostCurrent._bomba.trim()+"</CodigoBomba></VinculaBomba>";
RDebugUtils.currentLine=1572882;
 //BA.debugLineNum = 1572882;BA.debugLine="XML = XML & \"</soap:Body>\"";
_xml = _xml+"</soap:Body>";
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="XML = XML & \"</soap:Envelope>\"";
_xml = _xml+"</soap:Envelope>";
RDebugUtils.currentLine=1572885;
 //BA.debugLineNum = 1572885;BA.debugLine="JobOP2.Initialize(\"JOBSOAP\", Me)";
_jobop2._initialize /*String*/ (null,processBA,"JOBSOAP",main.getObject());
RDebugUtils.currentLine=1572886;
 //BA.debugLineNum = 1572886;BA.debugLine="JobOP2.PostString(URL,XML)";
_jobop2._poststring /*String*/ (null,_url,_xml);
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="JobOP2.GetRequest.SetContentType(\"text/xml\")";
_jobop2._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("text/xml");
RDebugUtils.currentLine=1572888;
 //BA.debugLineNum = 1572888;BA.debugLine="Wait For (JobOP2) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "vinculabomba"), (Object)(_jobop2));
this.state = 21;
return;
case 21:
//C
this.state = 4;
;
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "vinculabomba"),(int) (100));
this.state = 22;
return;
case 22:
//C
this.state = 4;
;
RDebugUtils.currentLine=1572891;
 //BA.debugLineNum = 1572891;BA.debugLine="If JobOP2.Success = True Then";
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
RDebugUtils.currentLine=1572892;
 //BA.debugLineNum = 1572892;BA.debugLine="XMLWork2 = JobOP2.GetString";
_xmlwork2 = _jobop2._getstring /*String*/ (null);
RDebugUtils.currentLine=1572893;
 //BA.debugLineNum = 1572893;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&lt;\",\"<\")";
_xmlwork2 = _xmlwork2.replace("&lt;","<");
RDebugUtils.currentLine=1572894;
 //BA.debugLineNum = 1572894;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&gt;\",\">\")";
_xmlwork2 = _xmlwork2.replace("&gt;",">");
RDebugUtils.currentLine=1572895;
 //BA.debugLineNum = 1572895;BA.debugLine="XMLWork2 = XMLWork2.Replace(\"&amp;\",\"-\")";
_xmlwork2 = _xmlwork2.replace("&amp;","-");
RDebugUtils.currentLine=1572897;
 //BA.debugLineNum = 1572897;BA.debugLine="If XMLWork2.Contains(\"<VinculaBombaResult>\") =";
if (true) break;

case 7:
//if
this.state = 16;
if (_xmlwork2.contains("<VinculaBombaResult>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=1572898;
 //BA.debugLineNum = 1572898;BA.debugLine="Result = XMLWork2.SubString2(XMLWork2.IndexOf(";
_result = _xmlwork2.substring((int) (_xmlwork2.indexOf("<Erro>")+6),_xmlwork2.indexOf("</Erro>"));
RDebugUtils.currentLine=1572899;
 //BA.debugLineNum = 1572899;BA.debugLine="If Result = \"sucesso\" Then";
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
RDebugUtils.currentLine=1572900;
 //BA.debugLineNum = 1572900;BA.debugLine="ToastMessageShow(\"Bomba vinculada com sucesso";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Bomba vinculada com sucesso"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=1572902;
 //BA.debugLineNum = 1572902;BA.debugLine="ToastMessageShow(Result,False)";
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
 if (true) break;

case 19:
//C
this.state = 20;
this.catchState = 0;
RDebugUtils.currentLine=1572907;
 //BA.debugLineNum = 1572907;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("61572907",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=1572909;
 //BA.debugLineNum = 1572909;BA.debugLine="End Sub";
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
public static String  _myabbarcode2_barcodefound(String _barcode,String _formatname) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "myabbarcode2_barcodefound", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "myabbarcode2_barcodefound", new Object[] {_barcode,_formatname}));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub myABBarcode2_BarcodeFound (barCode As String,";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Try";
try {RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="If Logado = True Then";
if (_logado==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="If barCode.SubString2(0,1) = \"@\" Then";
if ((_barcode.substring((int) (0),(int) (1))).equals("@")) { 
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="Bomba = barCode.SubString(3)";
mostCurrent._bomba = _barcode.substring((int) (3));
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código lido com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="SSCC = barCode.SubString2(0,9)";
mostCurrent._sscc = _barcode.substring((int) (0),(int) (9));
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="CodMaterial = barCode.SubString2(10,18)";
mostCurrent._codmaterial = _barcode.substring((int) (10),(int) (18));
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="ToastMessageShow(\"Código lido com sucesso.\",Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código lido com sucesso."),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 } 
       catch (Exception e13) {
			processBA.setLastException(e13);RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="ToastMessageShow(\"Código Invalido\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Código Invalido"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1376279;
 //BA.debugLineNum = 1376279;BA.debugLine="If Bomba.Length > 0 And SSCC.Length > 0 And CodMa";
if (mostCurrent._bomba.length()>0 && mostCurrent._sscc.length()>0 && mostCurrent._codmaterial.length()>0) { 
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="GetIdPesagem";
_getidpesagem();
 };
RDebugUtils.currentLine=1376282;
 //BA.debugLineNum = 1376282;BA.debugLine="End Sub";
return "";
}
}