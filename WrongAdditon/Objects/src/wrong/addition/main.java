package wrong.addition;


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
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "wrong.addition", "wrong.addition.main");
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
		activityBA = new BA(this, layout, processBA, "wrong.addition", "wrong.addition.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "wrong.addition.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
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
public static anywheresoftware.b4a.objects.SocketWrapper _socket1 = null;
public static wrong.addition.httpjob _job1 = null;
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonsair = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonlogin = null;
public anywheresoftware.b4a.objects.LabelWrapper _labelclock = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageaplipack = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonmenu = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelmain = null;
public anywheresoftware.b4a.objects.PanelWrapper _panellogin = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelmenu = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelconexao = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelpesagem = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelusuarios = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelwebservice = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelprodutos = null;
public anywheresoftware.b4a.objects.PanelWrapper _selecionacuc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttontelalogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonllimpar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextuser = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextpassword = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttontelamenu = null;
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _str = null;
public static double _str2 = 0;
public static int _str3 = 0;
public anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _reader = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttontelamain = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttontelaleitura = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextip = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextporta = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonmanualsoftware = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonconcluirpesagem = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextpeso = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonsairpeso = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoncadastrabalnca = null;
public com.AB.ABZxing.ABZxing _myabbarcode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonleiturabarcode = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextproduto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextfabricacao = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextvalidadepdoruo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextlote = null;
public static int _i = 0;
public static int _j = 0;
public static int _count = 0;
public static String _filename = "";
public static String _listposition = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edittextnomebalanca = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttongravardb = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewbalanca = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewtelabalanca = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonvoltarmenuusuarios = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonusuarios = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonwebservice = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttontelawebservicemenu = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonprodutosvolta = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoncadastroproduto = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewtipopesagem = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextwebserviceip = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextwebserviceporta = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonwebservicealterar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextxml = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonbalancaup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonbalancadown = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonbalanaalterar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttondeletarbalanca = null;
public anywheresoftware.b4a.objects.EditTextWrapper _usertext = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewusuarios = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewacesso = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextnomeusuario = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttongravaruusario = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonalterarusuario = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonuserup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonuserdown = null;
public static int _positionuser = 0;
public static int _positiondb = 0;
public static int _positiondb2 = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonnivelup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonniveldown = null;
public static int _positionnivel = 0;
public static int _idusuario = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonapagarusuario = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextnomeproduto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextcodigoproduto = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextcodigocuc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttongravarproduto = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonprodutoalterar = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewprodutoscuc = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextpordutocuc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonmenucuc = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttoncarregarcuc = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextdescricaocuc = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewcuc = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextcodigocuctela = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonapgarprodutocuc = null;
public static String _nivelusuario = "";
public anywheresoftware.b4a.objects.ListViewWrapper _listviewcucmain = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewcucpesagem = null;
public static double _peso = 0;
public static String _unidadepeso = "";
public static double _toleranciaminimo = 0;
public static double _toleranciamaximo = 0;
public static String _urlglobal = "";
public static int _posbalanca = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _buttontelaloginvolta = null;
public anywheresoftware.b4a.objects.collections.List _listordemprodsap = null;
public anywheresoftware.b4a.objects.collections.List _listprodutospesagem = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listviewcampanha = null;
public static String _campanha = "";
public static String _cod = "";
public static double _pesorota1 = 0;
public static double _pesoalvo = 0;
public static String _unidadealvo = "";
public static String _idpesagemprog = "";
public anywheresoftware.b4a.objects.ButtonWrapper _buttonembalagem = null;
public static double _embfechada = 0;
public static String _xmlcurrent = "";
public static String _xmlwork = "";
public static int _divisor = 0;
public static int _decimal = 0;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextdivisor = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextdecimais = null;
public wrong.addition.starter _starter = null;
public wrong.addition.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(wrong.addition.main parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
wrong.addition.main parent;
boolean _firsttime;
String _url = "";
long _t = 0L;
String _s = "";
String _ordemprod = "";
int step64;
int limit64;
int step96;
int limit96;
int step115;
int limit115;

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
 //BA.debugLineNum = 144;BA.debugLine="panelMain.Initialize(\"\") : panelMain.Visible = Tr";
parent.mostCurrent._panelmain.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 144;BA.debugLine="panelMain.Initialize(\"\") : panelMain.Visible = Tr";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 145;BA.debugLine="panelMain.LoadLayout(\"Main\")";
parent.mostCurrent._panelmain.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 146;BA.debugLine="Activity.AddView(panelMain, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelmain.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 147;BA.debugLine="panelLogin.Initialize(\"\") : panelLogin.Visible =";
parent.mostCurrent._panellogin.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 147;BA.debugLine="panelLogin.Initialize(\"\") : panelLogin.Visible =";
parent.mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 148;BA.debugLine="panelLogin.LoadLayout(\"Login\")";
parent.mostCurrent._panellogin.LoadLayout("Login",mostCurrent.activityBA);
 //BA.debugLineNum = 149;BA.debugLine="Activity.AddView(panelLogin, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panellogin.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 150;BA.debugLine="panelMenu.Initialize(\"\") : panelMenu.Visible = Fa";
parent.mostCurrent._panelmenu.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 150;BA.debugLine="panelMenu.Initialize(\"\") : panelMenu.Visible = Fa";
parent.mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 151;BA.debugLine="panelMenu.LoadLayout(\"Menu\")";
parent.mostCurrent._panelmenu.LoadLayout("Menu",mostCurrent.activityBA);
 //BA.debugLineNum = 152;BA.debugLine="Activity.AddView(panelMenu, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelmenu.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 153;BA.debugLine="panelConexao.Initialize(\"\") : panelConexao.Visibl";
parent.mostCurrent._panelconexao.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 153;BA.debugLine="panelConexao.Initialize(\"\") : panelConexao.Visibl";
parent.mostCurrent._panelconexao.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 154;BA.debugLine="panelConexao.LoadLayout(\"Conexao\")";
parent.mostCurrent._panelconexao.LoadLayout("Conexao",mostCurrent.activityBA);
 //BA.debugLineNum = 155;BA.debugLine="Activity.AddView(panelConexao, 0, 0, 100%x, 100%y";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelconexao.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 156;BA.debugLine="panelPesagem.Initialize(\"\") : panelPesagem.Visibl";
parent.mostCurrent._panelpesagem.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 156;BA.debugLine="panelPesagem.Initialize(\"\") : panelPesagem.Visibl";
parent.mostCurrent._panelpesagem.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 157;BA.debugLine="panelPesagem.LoadLayout(\"pesgaem\")";
parent.mostCurrent._panelpesagem.LoadLayout("pesgaem",mostCurrent.activityBA);
 //BA.debugLineNum = 158;BA.debugLine="Activity.AddView(panelPesagem, 0, 0, 100%x, 100%y";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelpesagem.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 159;BA.debugLine="panelUsuarios.Initialize(\"\") : panelUsuarios.Visi";
parent.mostCurrent._panelusuarios.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 159;BA.debugLine="panelUsuarios.Initialize(\"\") : panelUsuarios.Visi";
parent.mostCurrent._panelusuarios.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 160;BA.debugLine="panelUsuarios.LoadLayout(\"usuarios\")";
parent.mostCurrent._panelusuarios.LoadLayout("usuarios",mostCurrent.activityBA);
 //BA.debugLineNum = 161;BA.debugLine="Activity.AddView(panelUsuarios, 0, 0, 100%x, 100%";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelusuarios.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 162;BA.debugLine="panelWebservice.Initialize(\"\") : panelWebservice.";
parent.mostCurrent._panelwebservice.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 162;BA.debugLine="panelWebservice.Initialize(\"\") : panelWebservice.";
parent.mostCurrent._panelwebservice.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 163;BA.debugLine="panelWebservice.LoadLayout(\"webservice\")";
parent.mostCurrent._panelwebservice.LoadLayout("webservice",mostCurrent.activityBA);
 //BA.debugLineNum = 164;BA.debugLine="Activity.AddView(panelWebservice, 0, 0, 100%x, 10";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelwebservice.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 165;BA.debugLine="panelProdutos.Initialize(\"\") : panelProdutos.Visi";
parent.mostCurrent._panelprodutos.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 165;BA.debugLine="panelProdutos.Initialize(\"\") : panelProdutos.Visi";
parent.mostCurrent._panelprodutos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 166;BA.debugLine="panelProdutos.LoadLayout(\"cadastroproduto\")";
parent.mostCurrent._panelprodutos.LoadLayout("cadastroproduto",mostCurrent.activityBA);
 //BA.debugLineNum = 167;BA.debugLine="Activity.AddView(panelProdutos, 0, 0, 100%x, 100%";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._panelprodutos.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 168;BA.debugLine="SelecionaCUC.Initialize(\"\") : SelecionaCUC.Visibl";
parent.mostCurrent._selecionacuc.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 168;BA.debugLine="SelecionaCUC.Initialize(\"\") : SelecionaCUC.Visibl";
parent.mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 169;BA.debugLine="SelecionaCUC.LoadLayout(\"selectCUC\")";
parent.mostCurrent._selecionacuc.LoadLayout("selectCUC",mostCurrent.activityBA);
 //BA.debugLineNum = 170;BA.debugLine="Activity.AddView(SelecionaCUC, 0, 0, 100%x, 100%y";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._selecionacuc.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 171;BA.debugLine="Clock(True)";
_clock(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 172;BA.debugLine="filename  = \"data7.db\"";
parent.mostCurrent._filename = "data7.db";
 //BA.debugLineNum = 173;BA.debugLine="If File.Exists(File.DirInternal,filename) = False";
if (true) break;

case 1:
//if
this.state = 4;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),parent.mostCurrent._filename)==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 174;BA.debugLine="File.Copy(File.DirAssets,filename,File.DirIntern";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),parent.mostCurrent._filename,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),parent.mostCurrent._filename);
 if (true) break;
;
 //BA.debugLineNum = 176;BA.debugLine="If sql1.IsInitialized = False Then";

case 4:
//if
this.state = 7;
if (parent._sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 177;BA.debugLine="sql1.Initialize(File.DirInternal, filename, Fals";
parent._sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),parent.mostCurrent._filename,anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 179;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 79;
return;
case 79:
//C
this.state = 8;
;
 //BA.debugLineNum = 180;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT * FROM webservice";
parent._cursor.setObject((android.database.Cursor)(parent._sql1.ExecQuery("SELECT * FROM webservice")));
 //BA.debugLineNum = 181;BA.debugLine="cursor.Position =  0";
parent._cursor.setPosition((int) (0));
 //BA.debugLineNum = 182;BA.debugLine="URLglobal =  \"http://\"& cursor.GetString2(1) &\":\"";
parent.mostCurrent._urlglobal = "http://"+parent._cursor.GetString2((int) (1))+":"+parent._cursor.GetString2((int) (2));
 //BA.debugLineNum = 183;BA.debugLine="Job1.Initialize(\"JOBSOAP\", Me)";
parent._job1._initialize /*String*/ (processBA,"JOBSOAP",main.getObject());
 //BA.debugLineNum = 184;BA.debugLine="Try";
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
 //BA.debugLineNum = 185;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;";
 //BA.debugLineNum = 186;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 187;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 188;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 80;
return;
case 80:
//C
this.state = 11;
;
 //BA.debugLineNum = 189;BA.debugLine="If Job1.Success = True Then";
if (true) break;

case 11:
//if
this.state = 24;
if (parent._job1._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 190;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 191;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.L";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 192;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 193;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Index";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 194;BA.debugLine="If count=1 Then";
if (true) break;

case 14:
//if
this.state = 23;
if (parent._count==1) { 
this.state = 16;
}else {
this.state = 18;
}if (true) break;

case 16:
//C
this.state = 23;
 //BA.debugLineNum = 195;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLw";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 //BA.debugLineNum = 196;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 if (true) break;

case 18:
//C
this.state = 19;
 //BA.debugLineNum = 198;BA.debugLine="For i=1 To count";
if (true) break;

case 19:
//for
this.state = 22;
step64 = 1;
limit64 = parent._count;
parent._i = (int) (1) ;
this.state = 81;
if (true) break;

case 81:
//C
this.state = 22;
if ((step64 > 0 && parent._i <= limit64) || (step64 < 0 && parent._i >= limit64)) this.state = 21;
if (true) break;

case 82:
//C
this.state = 81;
parent._i = ((int)(0 + parent._i + step64)) ;
if (true) break;

case 21:
//C
this.state = 82;
 //BA.debugLineNum = 199;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubStr";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 200;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.Su";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 201;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 202;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 26:
//C
this.state = 27;
this.catchState = 0;
 //BA.debugLineNum = 207;BA.debugLine="count = count";
parent._count = parent._count;
 if (true) break;
if (true) break;

case 27:
//C
this.state = 28;
this.catchState = 0;
;
 //BA.debugLineNum = 209;BA.debugLine="Sleep(2)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (2));
this.state = 83;
return;
case 83:
//C
this.state = 28;
;
 //BA.debugLineNum = 210;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 211;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 212;BA.debugLine="Try";
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
 //BA.debugLineNum = 213;BA.debugLine="DateTime.DateFormat = \"dd-MM-yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd-MM-yyyy");
 //BA.debugLineNum = 214;BA.debugLine="Dim t As Long";
_t = 0L;
 //BA.debugLineNum = 215;BA.debugLine="t = DateTime.DateParse(DateTime.Date(DateTime.no";
_t = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(anywheresoftware.b4a.keywords.Common.DateTime.Date((long) (anywheresoftware.b4a.keywords.Common.DateTime.getNow()-31622400000L)));
 //BA.debugLineNum = 216;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd HH:mm:ss\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd HH:mm:ss");
 //BA.debugLineNum = 217;BA.debugLine="Dim s As String";
_s = "";
 //BA.debugLineNum = 218;BA.debugLine="s = DateTime.Date(t)";
_s = anywheresoftware.b4a.keywords.Common.DateTime.Date(_t);
 //BA.debugLineNum = 219;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idOrdemProdSAP, DataHora, OrdemProd, StatusOP, Usuario , TipoOP, CodigoCUC, QuantMax, PesoMax, Prioridade, NumeroWeek, row_number() OVER (order by DataHora) as row_num FROM (SELECT idOrdemProdSAP, DataHora, OrdemProd, StatusOP, Usuario , TipoOP, CodigoCUC, QuantMax, PesoMax, Prioridade, NumeroWeek FROM (SELECT * FROM unilever_pi.ordemprodsap WHERE DataHora > '"+_s+"' ORDER BY DataHora) t) t;";
 //BA.debugLineNum = 220;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 221;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 222;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 84;
return;
case 84:
//C
this.state = 31;
;
 //BA.debugLineNum = 223;BA.debugLine="If Job1.Success = True Then";
if (true) break;

case 31:
//if
this.state = 50;
if (parent._job1._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 33;
}if (true) break;

case 33:
//C
this.state = 34;
 //BA.debugLineNum = 224;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 225;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 34:
//if
this.state = 49;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 36;
}if (true) break;

case 36:
//C
this.state = 37;
 //BA.debugLineNum = 226;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 227;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 228;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 229;BA.debugLine="ListOrdemProdSAP.Initialize";
parent.mostCurrent._listordemprodsap.Initialize();
 //BA.debugLineNum = 230;BA.debugLine="For i=1 To count";
if (true) break;

case 37:
//for
this.state = 48;
step96 = 1;
limit96 = parent._count;
parent._i = (int) (1) ;
this.state = 85;
if (true) break;

case 85:
//C
this.state = 48;
if ((step96 > 0 && parent._i <= limit96) || (step96 < 0 && parent._i >= limit96)) this.state = 39;
if (true) break;

case 86:
//C
this.state = 85;
parent._i = ((int)(0 + parent._i + step96)) ;
if (true) break;

case 39:
//C
this.state = 40;
 //BA.debugLineNum = 231;BA.debugLine="If i > count Then";
if (true) break;

case 40:
//if
this.state = 47;
if (parent._i>parent._count) { 
this.state = 42;
}else if(parent._i==parent._count) { 
this.state = 44;
}else {
this.state = 46;
}if (true) break;

case 42:
//C
this.state = 47;
 if (true) break;

case 44:
//C
this.state = 47;
 //BA.debugLineNum = 233;BA.debugLine="ListOrdemProdSAP.Add(XMLCurrent.SubString2(X";
parent.mostCurrent._listordemprodsap.Add((Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<OrdemProd>")+11),parent.mostCurrent._xmlcurrent.indexOf("</OrdemProd>"))));
 if (true) break;

case 46:
//C
this.state = 47;
 //BA.debugLineNum = 235;BA.debugLine="ListOrdemProdSAP.Add(XMLCurrent.SubString2(X";
parent.mostCurrent._listordemprodsap.Add((Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<OrdemProd>")+11),parent.mostCurrent._xmlcurrent.indexOf("</OrdemProd>"))));
 //BA.debugLineNum = 236;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 237;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Ind";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 //BA.debugLineNum = 242;BA.debugLine="ListOrdemProdSAP.Add(\"Fim\")";
parent.mostCurrent._listordemprodsap.Add((Object)("Fim"));
 if (true) break;

case 52:
//C
this.state = 53;
this.catchState = 0;
 //BA.debugLineNum = 244;BA.debugLine="MsgboxAsync(\"Erro ao carregar os CUCs\",\"Aviso\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao carregar os CUCs"),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 246;BA.debugLine="Try";

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
 //BA.debugLineNum = 247;BA.debugLine="Dim count As Int = ListOrdemProdSAP.Size";
parent._count = parent.mostCurrent._listordemprodsap.getSize();
 //BA.debugLineNum = 248;BA.debugLine="Dim OrdemProd As String";
_ordemprod = "";
 //BA.debugLineNum = 249;BA.debugLine="For i=1 To count-1";
if (true) break;

case 56:
//for
this.state = 75;
step115 = 1;
limit115 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 87;
if (true) break;

case 87:
//C
this.state = 75;
if ((step115 > 0 && parent._i <= limit115) || (step115 < 0 && parent._i >= limit115)) this.state = 58;
if (true) break;

case 88:
//C
this.state = 87;
parent._i = ((int)(0 + parent._i + step115)) ;
if (true) break;

case 58:
//C
this.state = 59;
 //BA.debugLineNum = 250;BA.debugLine="If i >= count Then";
if (true) break;

case 59:
//if
this.state = 74;
if (parent._i>=parent._count) { 
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
 //BA.debugLineNum = 252;BA.debugLine="OrdemProd = ListOrdemProdSAP.Get(i)";
_ordemprod = BA.ObjectToString(parent.mostCurrent._listordemprodsap.Get(parent._i));
 //BA.debugLineNum = 253;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryS";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemProg, DataHora, CodigoCUC, DescricaoCUC, Batch, Quant, OrdemProd, StatusPesagemProg, Rota, IdOrdemProdSap, Prioridade FROM unilever_pi.pesagemprog WHERE OrdemProd="+_ordemprod+" LIMIT 1;";
 //BA.debugLineNum = 254;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 255;BA.debugLine="Job1.GetRequest.SetContentType(\"application/X";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 256;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 89;
return;
case 89:
//C
this.state = 64;
;
 //BA.debugLineNum = 257;BA.debugLine="If Job1.Success = True Then";
if (true) break;

case 64:
//if
this.state = 73;
if (parent._job1._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 66;
}if (true) break;

case 66:
//C
this.state = 67;
 //BA.debugLineNum = 258;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 259;BA.debugLine="If XMLwork=\"<DocumentElement />\" Or XMLwork=";
if (true) break;

case 67:
//if
this.state = 72;
if ((parent.mostCurrent._xmlwork).equals("<DocumentElement />") || (parent.mostCurrent._xmlwork).equals("0")) { 
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
 //BA.debugLineNum = 261;BA.debugLine="ListViewCUCMain.AddSingleLine2(XMLwork.SubS";
parent.mostCurrent._listviewcucmain.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<CodigoCUC>")+11),parent.mostCurrent._xmlwork.indexOf("</CodigoCUC>"))+" | "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<OrdemProd>")+11),parent.mostCurrent._xmlwork.indexOf("</OrdemProd>"))+" | "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<DescricaoCUC>")+14),parent.mostCurrent._xmlwork.indexOf("</DescricaoCUC>"))+" | "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Batch>")+7),parent.mostCurrent._xmlwork.indexOf("</Batch>"))+" | "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Quant>")+7),parent.mostCurrent._xmlwork.indexOf("</Quant>"))),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idPesagemProg>")+15),parent.mostCurrent._xmlwork.indexOf("</idPesagemProg>"))));
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
 if (true) break;

case 77:
//C
this.state = 78;
this.catchState = 0;
 //BA.debugLineNum = 267;BA.debugLine="MsgboxAsync(\"Erro ao carregar os CUCs\",\"AvisoS\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao carregar os CUCs"),BA.ObjectToCharSequence("AvisoS"),processBA);
 if (true) break;
if (true) break;

case 78:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 269;BA.debugLine="ListProdutosPesagem.Initialize";
parent.mostCurrent._listprodutospesagem.Initialize();
 //BA.debugLineNum = 270;BA.debugLine="ButtonCadastraBalnca.Enabled = False";
parent.mostCurrent._buttoncadastrabalnca.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 271;BA.debugLine="ButtonUsuarios.Enabled =  False";
parent.mostCurrent._buttonusuarios.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 272;BA.debugLine="ButtonCadastroProduto.Enabled =  False";
parent.mostCurrent._buttoncadastroproduto.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 273;BA.debugLine="ButtonWebservice.Enabled =  False";
parent.mostCurrent._buttonwebservice.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
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
public static void  _jobdone() throws Exception{
}
public static void  _activity_pause(boolean _userclosed) throws Exception{
ResumableSub_Activity_Pause rsub = new ResumableSub_Activity_Pause(null,_userclosed);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Pause extends BA.ResumableSub {
public ResumableSub_Activity_Pause(wrong.addition.main parent,boolean _userclosed) {
this.parent = parent;
this._userclosed = _userclosed;
}
wrong.addition.main parent;
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
 //BA.debugLineNum = 281;BA.debugLine="Do While UserClosed = True";
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
 //BA.debugLineNum = 282;BA.debugLine="Sleep(1000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (1000));
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
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public static void  _buttonalterarusuario_click() throws Exception{
ResumableSub_ButtonAlterarUsuario_Click rsub = new ResumableSub_ButtonAlterarUsuario_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonAlterarUsuario_Click extends BA.ResumableSub {
public ResumableSub_ButtonAlterarUsuario_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
String _ret = "";
String _retu = "";
String _usercurrent = "";
String _usermain = "";
int step19;
int limit19;
int step28;
int limit28;

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
 //BA.debugLineNum = 643;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDAT";
_url = parent.mostCurrent._urlglobal+"/ExecQueryUPDATE unilever_pi.usuarios SET usuario='"+parent.mostCurrent._edittextnomeusuario.getText()+"', nivel="+BA.NumberToString(parent._positionnivel)+", pesagem=1, processo=1, relatorio=1 WHERE idusuario="+BA.NumberToString(parent._idusuario);
 //BA.debugLineNum = 644;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 645;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 646;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 27;
return;
case 27:
//C
this.state = 1;
;
 //BA.debugLineNum = 647;BA.debugLine="Dim ret As String  = Job1.GetString";
_ret = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 648;BA.debugLine="If ret = \"0\"  Or ret=\"2\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((_ret).equals("0") || (_ret).equals("2")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 649;BA.debugLine="MsgboxAsync(\"Falha ao Alterar\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Falha ao Alterar"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 651;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
parent._job1._download /*String*/ (parent.mostCurrent._urlglobal+"/ListaUsuarios");
 //BA.debugLineNum = 652;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 5;
;
 //BA.debugLineNum = 653;BA.debugLine="Dim retu As String = Job1.GetString";
_retu = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 654;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
_ret = _retu.substring((int) (_retu.indexOf("<return>")+8),_retu.lastIndexOf("</return>"));
 //BA.debugLineNum = 655;BA.debugLine="Dim usercurrent As String = \"\"";
_usercurrent = "";
 //BA.debugLineNum = 656;BA.debugLine="Dim count As Int = ListViewUsuarios.Size";
parent._count = parent.mostCurrent._listviewusuarios.getSize();
 //BA.debugLineNum = 657;BA.debugLine="ListViewUsuarios.Clear";
parent.mostCurrent._listviewusuarios.Clear();
 //BA.debugLineNum = 658;BA.debugLine="If ret = \"1\"  Then";
if (true) break;

case 5:
//if
this.state = 26;
if ((_ret).equals("1")) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 659;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
_usermain = _retu.substring(_retu.indexOf("<usuario>"),_retu.lastIndexOf("</usuario>"));
 //BA.debugLineNum = 660;BA.debugLine="Try";
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
 //BA.debugLineNum = 661;BA.debugLine="For i=0 To count-1";
if (true) break;

case 11:
//for
this.state = 22;
step19 = 1;
limit19 = (int) (parent._count-1);
parent._i = (int) (0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 22;
if ((step19 > 0 && parent._i <= limit19) || (step19 < 0 && parent._i >= limit19)) this.state = 13;
if (true) break;

case 30:
//C
this.state = 29;
parent._i = ((int)(0 + parent._i + step19)) ;
if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 662;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
_usercurrent = _usermain.substring(_usermain.indexOf("<usuario>"));
 //BA.debugLineNum = 663;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
_usercurrent = _usercurrent.substring((int) (0),(int) (_usermain.indexOf("</usuario>")+10));
 //BA.debugLineNum = 664;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
parent.mostCurrent._listviewusuarios.AddSingleLine2(BA.ObjectToCharSequence(_usercurrent.substring((int) (_usercurrent.indexOf("<nomeusuario>")+13),_usercurrent.indexOf("</nomeusuario>"))),(Object)(_usercurrent.substring((int) (_usercurrent.indexOf("<idusuario>")+11),_usercurrent.indexOf("</idusuario>"))));
 //BA.debugLineNum = 665;BA.debugLine="If i = PositionUser Then";
if (true) break;

case 14:
//if
this.state = 21;
if (parent._i==parent._positionuser) { 
this.state = 16;
}if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 666;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
parent.mostCurrent._edittextnomeusuario.setText(BA.ObjectToCharSequence(_usercurrent.substring((int) (_usercurrent.indexOf("<nomeusuario>")+13),_usercurrent.indexOf("</nomeusuario>"))));
 //BA.debugLineNum = 667;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
parent._positionnivel = (int)(Double.parseDouble(_usercurrent.substring((int) (_usercurrent.indexOf("<nivel>")+7),_usercurrent.indexOf("</nivel>"))));
 //BA.debugLineNum = 668;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
parent._idusuario = (int)(Double.parseDouble(_usercurrent.substring((int) (_usercurrent.indexOf("<idusuario>")+11),_usercurrent.indexOf("</idusuario>"))));
 //BA.debugLineNum = 669;BA.debugLine="ListViewAcesso.Clear";
parent.mostCurrent._listviewacesso.Clear();
 //BA.debugLineNum = 670;BA.debugLine="For i=0 To 4";
if (true) break;

case 17:
//for
this.state = 20;
step28 = 1;
limit28 = (int) (4);
parent._i = (int) (0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 20;
if ((step28 > 0 && parent._i <= limit28) || (step28 < 0 && parent._i >= limit28)) this.state = 19;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = ((int)(0 + parent._i + step28)) ;
if (true) break;

case 19:
//C
this.state = 32;
 //BA.debugLineNum = 671;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
parent.mostCurrent._listviewacesso.AddSingleLine2(BA.ObjectToCharSequence(parent._i),(Object)(parent._i));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 //BA.debugLineNum = 673;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
parent.mostCurrent._listviewacesso.SetSelection(parent._positionnivel);
 if (true) break;

case 21:
//C
this.state = 30;
;
 //BA.debugLineNum = 675;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
_usermain = _usermain.substring((int) (_usermain.indexOf("</usuario>")+10));
 if (true) break;
if (true) break;

case 22:
//C
this.state = 25;
;
 if (true) break;

case 24:
//C
this.state = 25;
this.catchState = 0;
 //BA.debugLineNum = 678;BA.debugLine="MsgboxAsync(\"Erro ao Alterar\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao Alterar"),BA.ObjectToCharSequence("Erro"),processBA);
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
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
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
public static void  _buttonapagarusuario_click() throws Exception{
ResumableSub_ButtonApagarUsuario_Click rsub = new ResumableSub_ButtonApagarUsuario_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonApagarUsuario_Click extends BA.ResumableSub {
public ResumableSub_ButtonApagarUsuario_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
String _ret = "";
String _retu = "";
String _usercurrent = "";
int _cnt = 0;
String _usermain = "";
int step20;
int limit20;
int step29;
int limit29;

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
 //BA.debugLineNum = 684;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryDELET";
_url = parent.mostCurrent._urlglobal+"/ExecQueryDELETE * FROM unilever_pi.usuarios WHERE idusuario="+BA.NumberToString(parent._idusuario)+";";
 //BA.debugLineNum = 685;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 686;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 687;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 27;
return;
case 27:
//C
this.state = 1;
;
 //BA.debugLineNum = 688;BA.debugLine="Dim ret As String  = Job1.GetString";
_ret = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 689;BA.debugLine="If ret = \"0\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((_ret).equals("0")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 690;BA.debugLine="MsgboxAsync(\"Falha ao gravar\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Falha ao gravar"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 692;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
parent._job1._download /*String*/ (parent.mostCurrent._urlglobal+"/ListaUsuarios");
 //BA.debugLineNum = 693;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 5;
;
 //BA.debugLineNum = 694;BA.debugLine="Dim retu As String = Job1.GetString";
_retu = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 695;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
_ret = _retu.substring((int) (_retu.indexOf("<return>")+8),_retu.lastIndexOf("</return>"));
 //BA.debugLineNum = 696;BA.debugLine="Dim usercurrent As String = \"\"";
_usercurrent = "";
 //BA.debugLineNum = 697;BA.debugLine="Dim count As Int = ListViewUsuarios.Size";
parent._count = parent.mostCurrent._listviewusuarios.getSize();
 //BA.debugLineNum = 698;BA.debugLine="ListViewUsuarios.Clear";
parent.mostCurrent._listviewusuarios.Clear();
 //BA.debugLineNum = 699;BA.debugLine="If ret = \"1\"  Then";
if (true) break;

case 5:
//if
this.state = 26;
if ((_ret).equals("1")) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 700;BA.debugLine="Dim cnt As Int = retu.SubString2(retu.IndexOf(\"<";
_cnt = (int)(Double.parseDouble(_retu.substring((int) (_retu.indexOf("<count>")+7),_retu.lastIndexOf("</count>"))));
 //BA.debugLineNum = 701;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
_usermain = _retu.substring(_retu.indexOf("<usuario>"),_retu.lastIndexOf("</usuario>"));
 //BA.debugLineNum = 702;BA.debugLine="Try";
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
 //BA.debugLineNum = 703;BA.debugLine="For i=0 To cnt-1";
if (true) break;

case 11:
//for
this.state = 22;
step20 = 1;
limit20 = (int) (_cnt-1);
parent._i = (int) (0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 22;
if ((step20 > 0 && parent._i <= limit20) || (step20 < 0 && parent._i >= limit20)) this.state = 13;
if (true) break;

case 30:
//C
this.state = 29;
parent._i = ((int)(0 + parent._i + step20)) ;
if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 704;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
_usercurrent = _usermain.substring(_usermain.indexOf("<usuario>"));
 //BA.debugLineNum = 705;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
_usercurrent = _usercurrent.substring((int) (0),(int) (_usermain.indexOf("</usuario>")+10));
 //BA.debugLineNum = 706;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
parent.mostCurrent._listviewusuarios.AddSingleLine2(BA.ObjectToCharSequence(_usercurrent.substring((int) (_usercurrent.indexOf("<nomeusuario>")+13),_usercurrent.indexOf("</nomeusuario>"))),(Object)(_usercurrent.substring((int) (_usercurrent.indexOf("<idusuario>")+11),_usercurrent.indexOf("</idusuario>"))));
 //BA.debugLineNum = 707;BA.debugLine="If i = PositionUser Then";
if (true) break;

case 14:
//if
this.state = 21;
if (parent._i==parent._positionuser) { 
this.state = 16;
}if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 708;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
parent.mostCurrent._edittextnomeusuario.setText(BA.ObjectToCharSequence(_usercurrent.substring((int) (_usercurrent.indexOf("<nomeusuario>")+13),_usercurrent.indexOf("</nomeusuario>"))));
 //BA.debugLineNum = 709;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
parent._positionnivel = (int)(Double.parseDouble(_usercurrent.substring((int) (_usercurrent.indexOf("<nivel>")+7),_usercurrent.indexOf("</nivel>"))));
 //BA.debugLineNum = 710;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
parent._idusuario = (int)(Double.parseDouble(_usercurrent.substring((int) (_usercurrent.indexOf("<idusuario>")+11),_usercurrent.indexOf("</idusuario>"))));
 //BA.debugLineNum = 711;BA.debugLine="ListViewAcesso.Clear";
parent.mostCurrent._listviewacesso.Clear();
 //BA.debugLineNum = 712;BA.debugLine="For i=0 To 4";
if (true) break;

case 17:
//for
this.state = 20;
step29 = 1;
limit29 = (int) (4);
parent._i = (int) (0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 20;
if ((step29 > 0 && parent._i <= limit29) || (step29 < 0 && parent._i >= limit29)) this.state = 19;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = ((int)(0 + parent._i + step29)) ;
if (true) break;

case 19:
//C
this.state = 32;
 //BA.debugLineNum = 713;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
parent.mostCurrent._listviewacesso.AddSingleLine2(BA.ObjectToCharSequence(parent._i),(Object)(parent._i));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 //BA.debugLineNum = 715;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
parent.mostCurrent._listviewacesso.SetSelection(parent._positionnivel);
 if (true) break;

case 21:
//C
this.state = 30;
;
 //BA.debugLineNum = 717;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
_usermain = _usermain.substring((int) (_usermain.indexOf("</usuario>")+10));
 if (true) break;
if (true) break;

case 22:
//C
this.state = 25;
;
 if (true) break;

case 24:
//C
this.state = 25;
this.catchState = 0;
 //BA.debugLineNum = 720;BA.debugLine="MsgboxAsync(\"Erro ao Alterar\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao Alterar"),BA.ObjectToCharSequence("Erro"),processBA);
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
 //BA.debugLineNum = 723;BA.debugLine="End Sub";
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
public static void  _buttonapgarprodutocuc_click() throws Exception{
ResumableSub_ButtonApgarProdutoCUC_Click rsub = new ResumableSub_ButtonApgarProdutoCUC_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonApgarProdutoCUC_Click extends BA.ResumableSub {
public ResumableSub_ButtonApgarProdutoCUC_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1030;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryDELET";
_url = parent.mostCurrent._urlglobal+"/ExecQueryDELETE FROM unilever_pi.produto_cuc WHERE codigomaterial="+parent.mostCurrent._edittextcodigoproduto.getText()+"AND codigoCUC="+parent.mostCurrent._edittextcodigocuctela.getText()+";";
 //BA.debugLineNum = 1031;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1032;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1033;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 //BA.debugLineNum = 1034;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1035;BA.debugLine="If XMLwork = \"1\" Then";
if (true) break;

case 1:
//if
this.state = 6;
if ((parent.mostCurrent._xmlwork).equals("1")) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 1036;BA.debugLine="MsgboxAsync(\"Apagado com sucesso.\",\"Sucesso\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Apagado com sucesso."),BA.ObjectToCharSequence("Sucesso"),processBA);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 1038;BA.debugLine="MsgboxAsync(\"Erro ao apagar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao apagar."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 1040;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _buttonbalanaalterar_click() throws Exception{
ResumableSub_ButtonBalanaAlterar_Click rsub = new ResumableSub_ButtonBalanaAlterar_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonBalanaAlterar_Click extends BA.ResumableSub {
public ResumableSub_ButtonBalanaAlterar_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int _idbalanca = 0;
int step27;
int limit27;

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
 //BA.debugLineNum = 1238;BA.debugLine="Try";
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
 //BA.debugLineNum = 1239;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="+BA.NumberToString(parent._positiondb2)+";";
 //BA.debugLineNum = 1240;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1241;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1242;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 4;
;
 //BA.debugLineNum = 1243;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1244;BA.debugLine="Dim idBalanca As Int = XMLwork.SubString2(XMLwor";
_idbalanca = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1245;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
_url = parent.mostCurrent._urlglobal+"/ExecQueryUPDATE unilever_pi.balancas SET balanca='"+parent.mostCurrent._edittextnomebalanca.getText()+"', ipbalanca='"+parent.mostCurrent._edittextip.getText()+"', portabalanca="+parent.mostCurrent._edittextporta.getText()+", divisor="+parent.mostCurrent._edittextdivisor.getText()+", decimais="+parent.mostCurrent._edittextdecimais.getText()+" WHERE idbalancas="+BA.NumberToString(_idbalanca)+";";
 //BA.debugLineNum = 1246;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1247;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1248;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 18;
return;
case 18:
//C
this.state = 4;
;
 //BA.debugLineNum = 1249;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1250;BA.debugLine="ListViewTelaBalanca.Clear";
parent.mostCurrent._listviewtelabalanca.Clear();
 //BA.debugLineNum = 1251;BA.debugLine="ListViewBalanca.Clear";
parent.mostCurrent._listviewbalanca.Clear();
 //BA.debugLineNum = 1252;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;";
 //BA.debugLineNum = 1253;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1254;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1255;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 19;
return;
case 19:
//C
this.state = 4;
;
 //BA.debugLineNum = 1256;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1257;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1258;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1259;BA.debugLine="XMLCurrent = XMLwork.SubString2(XMLwork.IndexOf(";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 1260;BA.debugLine="If count=1 Then";
if (true) break;

case 4:
//if
this.state = 13;
if (parent._count==1) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 //BA.debugLineNum = 1261;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLwo";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 //BA.debugLineNum = 1262;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&X";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1264;BA.debugLine="For i=1 To count";
if (true) break;

case 9:
//for
this.state = 12;
step27 = 1;
limit27 = parent._count;
parent._i = (int) (1) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 12;
if ((step27 > 0 && parent._i <= limit27) || (step27 < 0 && parent._i >= limit27)) this.state = 11;
if (true) break;

case 21:
//C
this.state = 20;
parent._i = ((int)(0 + parent._i + step27)) ;
if (true) break;

case 11:
//C
this.state = 21;
 //BA.debugLineNum = 1265;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubStri";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1266;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.Sub";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1267;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1268;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 1272;BA.debugLine="count  =  count";
parent._count = parent._count;
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1274;BA.debugLine="End Sub";
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
public static void  _buttonbalancadown_click() throws Exception{
ResumableSub_ButtonBalancaDown_Click rsub = new ResumableSub_ButtonBalancaDown_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonBalancaDown_Click extends BA.ResumableSub {
public ResumableSub_ButtonBalancaDown_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";

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
 //BA.debugLineNum = 784;BA.debugLine="Try";
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
 //BA.debugLineNum = 785;BA.debugLine="If PosBalanca=0 Then";
if (true) break;

case 4:
//if
this.state = 9;
if (parent._posbalanca==0) { 
this.state = 6;
}else if(parent._posbalanca<=parent.mostCurrent._listviewtelabalanca.getSize()-1) { 
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 786;BA.debugLine="PosBalanca = 1";
parent._posbalanca = (int) (1);
 //BA.debugLineNum = 787;BA.debugLine="positionDB2 =  2";
parent._positiondb2 = (int) (2);
 //BA.debugLineNum = 788;BA.debugLine="ListViewTelaBalanca.SetSelection(1)";
parent.mostCurrent._listviewtelabalanca.SetSelection((int) (1));
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 790;BA.debugLine="PosBalanca =  PosBalanca+1";
parent._posbalanca = (int) (parent._posbalanca+1);
 //BA.debugLineNum = 791;BA.debugLine="positionDB2=  PosBalanca+1";
parent._positiondb2 = (int) (parent._posbalanca+1);
 //BA.debugLineNum = 792;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
parent.mostCurrent._listviewtelabalanca.SetSelection(parent._posbalanca);
 if (true) break;
;
 //BA.debugLineNum = 794;BA.debugLine="If PosBalanca > ListViewTelaBalanca.Size Then";

case 9:
//if
this.state = 12;
if (parent._posbalanca>parent.mostCurrent._listviewtelabalanca.getSize()) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 795;BA.debugLine="positionDB2 = ListViewTelaBalanca.Size";
parent._positiondb2 = parent.mostCurrent._listviewtelabalanca.getSize();
 //BA.debugLineNum = 796;BA.debugLine="PosBalanca = ListViewTelaBalanca.Size-1";
parent._posbalanca = (int) (parent.mostCurrent._listviewtelabalanca.getSize()-1);
 if (true) break;

case 12:
//C
this.state = 13;
;
 //BA.debugLineNum = 798;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="+BA.NumberToString(parent._positiondb2)+";";
 //BA.debugLineNum = 799;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 800;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 801;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 13;
;
 //BA.debugLineNum = 802;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 803;BA.debugLine="If XMLwork=\"<DocumentElement />\" Or XMLwork=\"0\"";
if (true) break;

case 13:
//if
this.state = 24;
if ((parent.mostCurrent._xmlwork).equals("<DocumentElement />") || (parent.mostCurrent._xmlwork).equals("0")) { 
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
 //BA.debugLineNum = 805;BA.debugLine="EditTextNomeBalanca.Text = XMLwork.SubString2(X";
parent.mostCurrent._edittextnomebalanca.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))));
 //BA.debugLineNum = 806;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.In";
parent.mostCurrent._edittextip.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<ipbalanca>")+11),parent.mostCurrent._xmlwork.indexOf("</ipbalanca>"))));
 //BA.debugLineNum = 807;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork";
parent.mostCurrent._edittextporta.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<portabalanca>")+14),parent.mostCurrent._xmlwork.indexOf("</portabalanca>"))));
 //BA.debugLineNum = 808;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwo";
parent.mostCurrent._edittextdivisor.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 809;BA.debugLine="EditTextDecimais.Text = XMLwork.SubString2(XMLw";
parent.mostCurrent._edittextdecimais.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<decimais>")+10),parent.mostCurrent._xmlwork.indexOf("</decimais>"))));
 //BA.debugLineNum = 810;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipope";
if (true) break;

case 18:
//if
this.state = 23;
if ((parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))).equals("g")) { 
this.state = 20;
}else {
this.state = 22;
}if (true) break;

case 20:
//C
this.state = 23;
 //BA.debugLineNum = 811;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 812;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 813;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 814;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
 if (true) break;

case 22:
//C
this.state = 23;
 //BA.debugLineNum = 816;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 817;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 818;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 819;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
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
 if (true) break;

case 26:
//C
this.state = 27;
this.catchState = 0;
 //BA.debugLineNum = 823;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao mudar a posição."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 27:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 825;BA.debugLine="End Sub";
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
public static void  _buttonbalancaup_click() throws Exception{
ResumableSub_ButtonBalancaUp_Click rsub = new ResumableSub_ButtonBalancaUp_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonBalancaUp_Click extends BA.ResumableSub {
public ResumableSub_ButtonBalancaUp_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";

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
 //BA.debugLineNum = 743;BA.debugLine="Try";
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
 //BA.debugLineNum = 744;BA.debugLine="Try";
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
 //BA.debugLineNum = 745;BA.debugLine="If PosBalanca=0 Then";
if (true) break;

case 7:
//if
this.state = 12;
if (parent._posbalanca==0) { 
this.state = 9;
}else if(parent._posbalanca>=parent.mostCurrent._listviewtelabalanca.getSize()-1 || parent._posbalanca<=parent.mostCurrent._listviewtelabalanca.getSize()-1) { 
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 746;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
parent.mostCurrent._listviewtelabalanca.SetSelection(parent._posbalanca);
 //BA.debugLineNum = 747;BA.debugLine="positionDB2 = 1";
parent._positiondb2 = (int) (1);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 749;BA.debugLine="positionDB2=  PosBalanca";
parent._positiondb2 = parent._posbalanca;
 //BA.debugLineNum = 750;BA.debugLine="PosBalanca =  PosBalanca-1";
parent._posbalanca = (int) (parent._posbalanca-1);
 //BA.debugLineNum = 751;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
parent.mostCurrent._listviewtelabalanca.SetSelection(parent._posbalanca);
 if (true) break;

case 12:
//C
this.state = 15;
;
 if (true) break;

case 14:
//C
this.state = 15;
this.catchState = 23;
 //BA.debugLineNum = 754;BA.debugLine="ListViewTelaBalanca.SetSelection(PosBalanca)";
parent.mostCurrent._listviewtelabalanca.SetSelection(parent._posbalanca);
 //BA.debugLineNum = 755;BA.debugLine="positionDB2 = 1";
parent._positiondb2 = (int) (1);
 if (true) break;
if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 23;
;
 //BA.debugLineNum = 757;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="+BA.NumberToString(parent._positiondb2)+";";
 //BA.debugLineNum = 758;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 759;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 760;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 25;
return;
case 25:
//C
this.state = 16;
;
 //BA.debugLineNum = 761;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 762;BA.debugLine="EditTextNomeBalanca.Text = XMLwork.SubString2(XM";
parent.mostCurrent._edittextnomebalanca.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))));
 //BA.debugLineNum = 763;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
parent.mostCurrent._edittextip.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<ipbalanca>")+11),parent.mostCurrent._xmlwork.indexOf("</ipbalanca>"))));
 //BA.debugLineNum = 764;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
parent.mostCurrent._edittextporta.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<portabalanca>")+14),parent.mostCurrent._xmlwork.indexOf("</portabalanca>"))));
 //BA.debugLineNum = 765;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwor";
parent.mostCurrent._edittextdivisor.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 766;BA.debugLine="EditTextDecimais.Text = XMLwork.SubString2(XMLwo";
parent.mostCurrent._edittextdecimais.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<decimais>")+10),parent.mostCurrent._xmlwork.indexOf("</decimais>"))));
 //BA.debugLineNum = 767;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipopes";
if (true) break;

case 16:
//if
this.state = 21;
if ((parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))).equals("g")) { 
this.state = 18;
}else {
this.state = 20;
}if (true) break;

case 18:
//C
this.state = 21;
 //BA.debugLineNum = 768;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 769;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 770;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 771;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
 if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 773;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 774;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 775;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 776;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
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
 //BA.debugLineNum = 779;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao mudar a posição."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 24:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 781;BA.debugLine="End Sub";
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
public static void  _buttoncadastrabalnca_click() throws Exception{
ResumableSub_ButtonCadastraBalnca_Click rsub = new ResumableSub_ButtonCadastraBalnca_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonCadastraBalnca_Click extends BA.ResumableSub {
public ResumableSub_ButtonCadastraBalnca_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";

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
 //BA.debugLineNum = 1095;BA.debugLine="Try";
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
 //BA.debugLineNum = 1096;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num=1;";
 //BA.debugLineNum = 1097;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1098;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1099;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 13;
return;
case 13:
//C
this.state = 4;
;
 //BA.debugLineNum = 1100;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1101;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1102;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1103;BA.debugLine="EditTextNomeBalanca.Text = XMLwork.SubString2(XM";
parent.mostCurrent._edittextnomebalanca.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))));
 //BA.debugLineNum = 1104;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
parent.mostCurrent._edittextip.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<ipbalanca>")+11),parent.mostCurrent._xmlwork.indexOf("</ipbalanca>"))));
 //BA.debugLineNum = 1105;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
parent.mostCurrent._edittextporta.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<portabalanca>")+14),parent.mostCurrent._xmlwork.indexOf("</portabalanca>"))));
 //BA.debugLineNum = 1106;BA.debugLine="decimal = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
parent._decimal = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<decimais>")+10),parent.mostCurrent._xmlwork.indexOf("</decimais>"))));
 //BA.debugLineNum = 1107;BA.debugLine="divisor = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
parent._divisor = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 1108;BA.debugLine="EditTextDivisor.Text = divisor";
parent.mostCurrent._edittextdivisor.setText(BA.ObjectToCharSequence(parent._divisor));
 //BA.debugLineNum = 1109;BA.debugLine="EditTextDecimais.Text = decimal";
parent.mostCurrent._edittextdecimais.setText(BA.ObjectToCharSequence(parent._decimal));
 //BA.debugLineNum = 1110;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipopes";
if (true) break;

case 4:
//if
this.state = 9;
if ((parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))).equals("g")) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 1111;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 1112;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 1113;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 1114;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1116;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 1117;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 1118;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 1119;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
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
 //BA.debugLineNum = 1122;BA.debugLine="count = count";
parent._count = parent._count;
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1124;BA.debugLine="panelMenu.Visible =  False";
parent.mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1125;BA.debugLine="panelConexao.Visible = True";
parent.mostCurrent._panelconexao.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1126;BA.debugLine="End Sub";
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
public static void  _buttoncadastroproduto_click() throws Exception{
ResumableSub_ButtonCadastroProduto_Click rsub = new ResumableSub_ButtonCadastroProduto_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonCadastroProduto_Click extends BA.ResumableSub {
public ResumableSub_ButtonCadastroProduto_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int step10;
int limit10;

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
 //BA.debugLineNum = 835;BA.debugLine="Try";
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
 //BA.debugLineNum = 836;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idproduto_cuc, codigoCUC, descricaoCUC, row_number() OVER (order by idproduto_cuc) as row_num FROM (SELECT idproduto_cuc, codigoCUC, descricaoCUC FROM unilever_pi.produto_cuc) t group by (CodigoCUC);";
 //BA.debugLineNum = 837;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 838;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 839;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 //BA.debugLineNum = 840;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 841;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 842;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 843;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 844;BA.debugLine="For i=1 To count-1";
if (true) break;

case 4:
//for
this.state = 7;
step10 = 1;
limit10 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if ((step10 > 0 && parent._i <= limit10) || (step10 < 0 && parent._i >= limit10)) this.state = 6;
if (true) break;

case 13:
//C
this.state = 12;
parent._i = ((int)(0 + parent._i + step10)) ;
if (true) break;

case 6:
//C
this.state = 13;
 //BA.debugLineNum = 845;BA.debugLine="ListViewCUC.AddSingleLine2(XMLCurrent.SubString";
parent.mostCurrent._listviewcuc.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaoCUC>")+14),parent.mostCurrent._xmlcurrent.indexOf("</descricaoCUC>"))),(Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))));
 //BA.debugLineNum = 846;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 847;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.IndexO";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
;
 //BA.debugLineNum = 849;BA.debugLine="SelecionaCUC.Visible =  True";
parent.mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 850;BA.debugLine="panelMenu.Visible =  False";
parent.mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 //BA.debugLineNum = 852;BA.debugLine="SelecionaCUC.Visible =  True";
parent.mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 853;BA.debugLine="panelMenu.Visible =  False";
parent.mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 855;BA.debugLine="End Sub";
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
public static void  _buttoncarregarcuc_click() throws Exception{
ResumableSub_ButtonCarregarCUC_Click rsub = new ResumableSub_ButtonCarregarCUC_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonCarregarCUC_Click extends BA.ResumableSub {
public ResumableSub_ButtonCarregarCUC_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int step11;
int limit11;

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
 //BA.debugLineNum = 946;BA.debugLine="Try";
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
 //BA.debugLineNum = 947;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico, row_number() OVER (order by idproduto_cuc) as row_num FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico from unilever_pi.produto_cuc) t WHERE codigocuc="+parent.mostCurrent._edittextcodigocuc.getText()+";";
 //BA.debugLineNum = 948;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 949;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 950;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 //BA.debugLineNum = 951;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 952;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 953;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 954;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 955;BA.debugLine="ListViewProdutosCUC.Clear";
parent.mostCurrent._listviewprodutoscuc.Clear();
 //BA.debugLineNum = 956;BA.debugLine="For i=1 To count-1";
if (true) break;

case 4:
//for
this.state = 7;
step11 = 1;
limit11 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if ((step11 > 0 && parent._i <= limit11) || (step11 < 0 && parent._i >= limit11)) this.state = 6;
if (true) break;

case 13:
//C
this.state = 12;
parent._i = ((int)(0 + parent._i + step11)) ;
if (true) break;

case 6:
//C
this.state = 13;
 //BA.debugLineNum = 957;BA.debugLine="ListViewProdutosCUC.AddSingleLine2(XMLCurrent.S";
parent.mostCurrent._listviewprodutoscuc.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaomaterial>")+19),parent.mostCurrent._xmlcurrent.indexOf("</descricaomaterial>"))),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<codigomaterial>")+16),parent.mostCurrent._xmlwork.indexOf("</codigomaterial>"))));
 //BA.debugLineNum = 958;BA.debugLine="EditTextPordutoCUC.Text = XMLCurrent.SubString2";
parent.mostCurrent._edittextpordutocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaoCUC>")+14),parent.mostCurrent._xmlcurrent.indexOf("</descricaoCUC>"))));
 //BA.debugLineNum = 959;BA.debugLine="EditTextCodigoCuc.Text = XMLCurrent.SubString2(";
parent.mostCurrent._edittextcodigocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))));
 //BA.debugLineNum = 960;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 961;BA.debugLine="XMLCurrent =  XMLwork.SubString2(5,XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),(int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
;
 //BA.debugLineNum = 963;BA.debugLine="panelProdutos.Visible =  True";
parent.mostCurrent._panelprodutos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 964;BA.debugLine="SelecionaCUC.Visible =  False";
parent.mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
 //BA.debugLineNum = 966;BA.debugLine="panelProdutos.Visible =  True";
parent.mostCurrent._panelprodutos.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 967;BA.debugLine="SelecionaCUC.Visible =  False";
parent.mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 969;BA.debugLine="End Sub";
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
public static void  _buttonconcluirpesagem_click() throws Exception{
ResumableSub_ButtonConcluirPesagem_Click rsub = new ResumableSub_ButtonConcluirPesagem_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonConcluirPesagem_Click extends BA.ResumableSub {
public ResumableSub_ButtonConcluirPesagem_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
double _pesobalanca = 0;
String _url = "";
String _xmlwork3 = "";
int _count2 = 0;
String _xmlcurrent2 = "";
int _x = 0;
int step22;
int limit22;
int step34;
int limit34;

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
 //BA.debugLineNum = 1341;BA.debugLine="Try";
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
 //BA.debugLineNum = 1342;BA.debugLine="Dim PesoBalanca As Double =  EditTextPeso.Text";
_pesobalanca = (double)(Double.parseDouble(parent.mostCurrent._edittextpeso.getText()));
 //BA.debugLineNum = 1343;BA.debugLine="If PesoAlvo =  0.0 Then";
if (true) break;

case 4:
//if
this.state = 29;
if (parent._pesoalvo==0.0) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 29;
 //BA.debugLineNum = 1344;BA.debugLine="MsgboxAsync(\"Peso já está correto\",\"Peso\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Peso já está correto"),BA.ObjectToCharSequence("Peso"),processBA);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1346;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
_url = parent.mostCurrent._urlglobal+"/ExecQueryUPDATE unilever_pi.pesagemreceita SET PesoRota1="+BA.NumberToString(_pesobalanca)+" WHERE IdCampanha="+parent.mostCurrent._campanha+" AND CodigoMaterial="+parent.mostCurrent._cod+";";
 //BA.debugLineNum = 1347;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1348;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1349;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 33;
return;
case 33:
//C
this.state = 9;
;
 //BA.debugLineNum = 1350;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1351;BA.debugLine="If XMLwork=\"1\" Then";
if (true) break;

case 9:
//if
this.state = 28;
if ((parent.mostCurrent._xmlwork).equals("1")) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 1352;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idCampanha, idPesagemProg, DataHora, Usuario, IdProcesso, Impresso, row_number() OVER (order by idCampanha) as row_num FROM unilever_pi.campanha WHERE idPesagemProg="+parent.mostCurrent._idpesagemprog+";";
 //BA.debugLineNum = 1353;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XM";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1354;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1355;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 34;
return;
case 34:
//C
this.state = 12;
;
 //BA.debugLineNum = 1356;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1357;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 12:
//if
this.state = 27;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 1358;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1359;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1360;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Ind";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 1361;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 1362;BA.debugLine="For i=1 To count-1";
if (true) break;

case 15:
//for
this.state = 26;
step22 = 1;
limit22 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 35;
if (true) break;

case 35:
//C
this.state = 26;
if ((step22 > 0 && parent._i <= limit22) || (step22 < 0 && parent._i >= limit22)) this.state = 17;
if (true) break;

case 36:
//C
this.state = 35;
parent._i = ((int)(0 + parent._i + step22)) ;
if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 1363;BA.debugLine="If i=1 Then";
if (true) break;

case 18:
//if
this.state = 25;
if (parent._i==1) { 
this.state = 20;
}if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 1364;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuer";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))+";";
 //BA.debugLineNum = 1365;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1366;BA.debugLine="Job1.GetRequest.SetContentType(\"application";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1367;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 37;
return;
case 37:
//C
this.state = 21;
;
 //BA.debugLineNum = 1368;BA.debugLine="Dim XMLwork3 As String = Job1.GetString";
_xmlwork3 = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1369;BA.debugLine="Dim count2 As Int = XMLwork3.SubString2(XML";
_count2 = (int)(Double.parseDouble(_xmlwork3.substring((int) (_xmlwork3.lastIndexOf("<row_num>")+9),_xmlwork3.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1370;BA.debugLine="Dim XMLCurrent2 As String = XMLwork3.SubStr";
_xmlcurrent2 = _xmlwork3.substring((int) (_xmlwork3.indexOf("<SQL>")+5),_xmlwork3.indexOf("</SQL>"));
 //BA.debugLineNum = 1371;BA.debugLine="Campanha =  XMLCurrent.SubString2(XMLCurren";
parent.mostCurrent._campanha = parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"));
 //BA.debugLineNum = 1372;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 1373;BA.debugLine="ListProdutosPesagem.Clear";
parent.mostCurrent._listprodutospesagem.Clear();
 //BA.debugLineNum = 1374;BA.debugLine="For x=1 To count2-1";
if (true) break;

case 21:
//for
this.state = 24;
step34 = 1;
limit34 = (int) (_count2-1);
_x = (int) (1) ;
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
if (true) break;

case 23:
//C
this.state = 39;
 //BA.debugLineNum = 1375;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent2.SubStr";
parent.mostCurrent._listprodutospesagem.Add((Object)(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1376;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurre";
parent.mostCurrent._listviewcucpesagem.AddSingleLine2(BA.ObjectToCharSequence(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<DescricaoMaterial>")+19),_xmlcurrent2.indexOf("</DescricaoMaterial>")).trim()+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Peso>")+6),_xmlcurrent2.indexOf("</Peso>"))+" "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Unidade>")+9),_xmlcurrent2.indexOf("</Unidade>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<EmbFechada>")+12),_xmlcurrent2.indexOf("</EmbFechada>"))+" "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Unidade>")+9),_xmlcurrent2.indexOf("</Unidade>"))+" ("+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<UnidadeEmb>")+12),_xmlcurrent2.indexOf("</UnidadeEmb>"))+") | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<PesoRota1>")+11),_xmlcurrent2.indexOf("</PesoRota1>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<PesoRota2>")+11),_xmlcurrent2.indexOf("</PesoRota2>"))),(Object)(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1377;BA.debugLine="XMLwork3 = XMLwork3.SubString(XMLwork3.Ind";
_xmlwork3 = _xmlwork3.substring((int) (_xmlwork3.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1378;BA.debugLine="XMLCurrent2 =  XMLwork3.SubString2(XMLwork";
_xmlcurrent2 = _xmlwork3.substring((int) (_xmlwork3.indexOf("<SQL>")+5),_xmlwork3.indexOf("</SQL>"));
 if (true) break;
if (true) break;

case 24:
//C
this.state = 25;
;
 if (true) break;

case 25:
//C
this.state = 36;
;
 //BA.debugLineNum = 1381;BA.debugLine="ListViewCampanha.AddSingleLine2(XMLCurrent.S";
parent.mostCurrent._listviewcampanha.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))),(Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))));
 //BA.debugLineNum = 1382;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1383;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Ind";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 31:
//C
this.state = 32;
this.catchState = 0;
 //BA.debugLineNum = 1389;BA.debugLine="MsgboxAsync(\"Erro ao adicionar o peso.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao adicionar o peso."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 32:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1391;BA.debugLine="End Sub";
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
public static void  _buttondeletarbalanca_click() throws Exception{
ResumableSub_ButtonDeletarBalanca_Click rsub = new ResumableSub_ButtonDeletarBalanca_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonDeletarBalanca_Click extends BA.ResumableSub {
public ResumableSub_ButtonDeletarBalanca_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int _idbalanca = 0;
int step27;
int limit27;

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
 //BA.debugLineNum = 1277;BA.debugLine="Try";
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
 //BA.debugLineNum = 1278;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="+BA.NumberToString(parent._positiondb2)+";";
 //BA.debugLineNum = 1279;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1280;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1281;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 4;
;
 //BA.debugLineNum = 1282;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1283;BA.debugLine="Dim idBalanca As Int = XMLwork.SubString2(XMLwor";
_idbalanca = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1284;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryDELE";
_url = parent.mostCurrent._urlglobal+"/ExecQueryDELETE FROM unilever_pi.balancas WHERE idbalancas="+BA.NumberToString(_idbalanca)+";";
 //BA.debugLineNum = 1285;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1286;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1287;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 18;
return;
case 18:
//C
this.state = 4;
;
 //BA.debugLineNum = 1288;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1289;BA.debugLine="ListViewTelaBalanca.Clear";
parent.mostCurrent._listviewtelabalanca.Clear();
 //BA.debugLineNum = 1290;BA.debugLine="ListViewBalanca.Clear";
parent.mostCurrent._listviewbalanca.Clear();
 //BA.debugLineNum = 1291;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;";
 //BA.debugLineNum = 1292;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1293;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1294;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 19;
return;
case 19:
//C
this.state = 4;
;
 //BA.debugLineNum = 1295;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1296;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1297;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1298;BA.debugLine="XMLCurrent= XMLwork.SubString2(XMLwork.IndexOf(\"";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 1299;BA.debugLine="If count=1 Then";
if (true) break;

case 4:
//if
this.state = 13;
if (parent._count==1) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 //BA.debugLineNum = 1300;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLwo";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 //BA.debugLineNum = 1301;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&X";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1303;BA.debugLine="For i=1 To count";
if (true) break;

case 9:
//for
this.state = 12;
step27 = 1;
limit27 = parent._count;
parent._i = (int) (1) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 12;
if ((step27 > 0 && parent._i <= limit27) || (step27 < 0 && parent._i >= limit27)) this.state = 11;
if (true) break;

case 21:
//C
this.state = 20;
parent._i = ((int)(0 + parent._i + step27)) ;
if (true) break;

case 11:
//C
this.state = 21;
 //BA.debugLineNum = 1304;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubStri";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1305;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.Sub";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1306;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1307;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 1311;BA.debugLine="MsgboxAsync(\"Eoo ao alterar o registro.\",\"Aviso\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Eoo ao alterar o registro."),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1313;BA.debugLine="End Sub";
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
public static void  _buttonembalagem_click() throws Exception{
ResumableSub_ButtonEmbalagem_Click rsub = new ResumableSub_ButtonEmbalagem_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonEmbalagem_Click extends BA.ResumableSub {
public ResumableSub_ButtonEmbalagem_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
double _pesoatual = 0;
String _url = "";
String _xmlwork3 = "";
int _count2 = 0;
String _xmlcurrent2 = "";
int _x = 0;
int step27;
int limit27;
int step39;
int limit39;

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
 //BA.debugLineNum = 1425;BA.debugLine="Try'";
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
 //BA.debugLineNum = 1426;BA.debugLine="Dim PesoAtual As Double";
_pesoatual = 0;
 //BA.debugLineNum = 1427;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="+parent.mostCurrent._campanha+" AND CodigoMaterial="+parent.mostCurrent._cod+";";
 //BA.debugLineNum = 1428;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1429;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1430;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 31;
return;
case 31:
//C
this.state = 4;
;
 //BA.debugLineNum = 1431;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1432;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1433;BA.debugLine="PesoAtual  = XMLwork.SubString2(XMLwork.IndexOf";
_pesoatual = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<PesoRota2>")+11),parent.mostCurrent._xmlwork.indexOf("</PesoRota2>"))));
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 1435;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
_url = parent.mostCurrent._urlglobal+"/ExecQueryUPDATE unilever_pi.pesagemreceita SET PesoRota2="+BA.NumberToString((parent._embfechada+_pesoatual))+" WHERE IdCampanha="+parent.mostCurrent._campanha+" AND CodigoMaterial="+parent.mostCurrent._cod+";";
 //BA.debugLineNum = 1436;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1437;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1438;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 32;
return;
case 32:
//C
this.state = 8;
;
 //BA.debugLineNum = 1439;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1440;BA.debugLine="If XMLwork=\"1\" Then";
if (true) break;

case 8:
//if
this.state = 27;
if ((parent.mostCurrent._xmlwork).equals("1")) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 1441;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idCampanha, idPesagemProg, DataHora, Usuario, IdProcesso, Impresso, row_number() OVER (order by idCampanha) as row_num FROM unilever_pi.campanha WHERE idPesagemProg="+parent.mostCurrent._idpesagemprog+";";
 //BA.debugLineNum = 1442;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1443;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1444;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 33;
return;
case 33:
//C
this.state = 11;
;
 //BA.debugLineNum = 1445;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1446;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 11:
//if
this.state = 26;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 1447;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1448;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1449;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 1450;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 1451;BA.debugLine="For i=1 To count-1";
if (true) break;

case 14:
//for
this.state = 25;
step27 = 1;
limit27 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 34;
if (true) break;

case 34:
//C
this.state = 25;
if ((step27 > 0 && parent._i <= limit27) || (step27 < 0 && parent._i >= limit27)) this.state = 16;
if (true) break;

case 35:
//C
this.state = 34;
parent._i = ((int)(0 + parent._i + step27)) ;
if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 1452;BA.debugLine="If i=1 Then";
if (true) break;

case 17:
//if
this.state = 24;
if (parent._i==1) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 1453;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuery";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))+";";
 //BA.debugLineNum = 1454;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1455;BA.debugLine="Job1.GetRequest.SetContentType(\"application/";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1456;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 36;
return;
case 36:
//C
this.state = 20;
;
 //BA.debugLineNum = 1457;BA.debugLine="Dim XMLwork3 As String = Job1.GetString";
_xmlwork3 = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1458;BA.debugLine="Dim count2 As Int = XMLwork3.SubString2(XMLw";
_count2 = (int)(Double.parseDouble(_xmlwork3.substring((int) (_xmlwork3.lastIndexOf("<row_num>")+9),_xmlwork3.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1459;BA.debugLine="Dim XMLCurrent2 As String = XMLwork3.SubStri";
_xmlcurrent2 = _xmlwork3.substring((int) (_xmlwork3.indexOf("<SQL>")+5),_xmlwork3.indexOf("</SQL>"));
 //BA.debugLineNum = 1460;BA.debugLine="Campanha =  XMLCurrent.SubString2(XMLCurrent";
parent.mostCurrent._campanha = parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"));
 //BA.debugLineNum = 1461;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 1462;BA.debugLine="ListProdutosPesagem.Clear";
parent.mostCurrent._listprodutospesagem.Clear();
 //BA.debugLineNum = 1463;BA.debugLine="For x=1 To count2-1";
if (true) break;

case 20:
//for
this.state = 23;
step39 = 1;
limit39 = (int) (_count2-1);
_x = (int) (1) ;
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
if (true) break;

case 22:
//C
this.state = 38;
 //BA.debugLineNum = 1464;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent2.SubStri";
parent.mostCurrent._listprodutospesagem.Add((Object)(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1465;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurren";
parent.mostCurrent._listviewcucpesagem.AddSingleLine2(BA.ObjectToCharSequence(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<DescricaoMaterial>")+19),_xmlcurrent2.indexOf("</DescricaoMaterial>")).trim()+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Peso>")+6),_xmlcurrent2.indexOf("</Peso>"))+" "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Unidade>")+9),_xmlcurrent2.indexOf("</Unidade>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<EmbFechada>")+12),_xmlcurrent2.indexOf("</EmbFechada>"))+" "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Unidade>")+9),_xmlcurrent2.indexOf("</Unidade>"))+" ("+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<UnidadeEmb>")+12),_xmlcurrent2.indexOf("</UnidadeEmb>"))+") | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<PesoRota1>")+11),_xmlcurrent2.indexOf("</PesoRota1>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<PesoRota2>")+11),_xmlcurrent2.indexOf("</PesoRota2>"))),(Object)(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1466;BA.debugLine="XMLwork3 = XMLwork3.SubString(XMLwork3.Inde";
_xmlwork3 = _xmlwork3.substring((int) (_xmlwork3.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1467;BA.debugLine="XMLCurrent2 =  XMLwork3.SubString2(XMLwork3";
_xmlcurrent2 = _xmlwork3.substring((int) (_xmlwork3.indexOf("<SQL>")+5),_xmlwork3.indexOf("</SQL>"));
 if (true) break;
if (true) break;

case 23:
//C
this.state = 24;
;
 if (true) break;

case 24:
//C
this.state = 35;
;
 //BA.debugLineNum = 1470;BA.debugLine="ListViewCampanha.AddSingleLine2(XMLCurrent.Su";
parent.mostCurrent._listviewcampanha.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))),(Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))));
 //BA.debugLineNum = 1471;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1472;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 29:
//C
this.state = 30;
this.catchState = 0;
 //BA.debugLineNum = 1477;BA.debugLine="MsgboxAsync(\"Erro ao adicionar Embalagem Fechada";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao adicionar Embalagem Fechada"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 30:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1479;BA.debugLine="End Sub";
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
public static void  _buttongravardb_click() throws Exception{
ResumableSub_ButtonGravarDB_Click rsub = new ResumableSub_ButtonGravarDB_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonGravarDB_Click extends BA.ResumableSub {
public ResumableSub_ButtonGravarDB_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int step26;
int limit26;

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
 //BA.debugLineNum = 1129;BA.debugLine="Try";
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
 //BA.debugLineNum = 1130;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t WHERE row_num="+BA.NumberToString(parent._positiondb2)+";";
 //BA.debugLineNum = 1131;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1132;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1133;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 4;
;
 //BA.debugLineNum = 1134;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1135;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryINSE";
_url = parent.mostCurrent._urlglobal+"/ExecQueryINSERT INTO unilever_pi.balancas (balanca, tipopeso, tipocom, ipbalanca, portabalanca, divisor, decimais) VALUES ('"+parent.mostCurrent._edittextnomebalanca.getText()+"','"+parent.mostCurrent._listposition+"','rede','"+parent.mostCurrent._edittextip.getText()+"',"+parent.mostCurrent._edittextporta.getText()+","+parent.mostCurrent._edittextdivisor.getText()+", "+parent.mostCurrent._edittextdecimais.getText()+")";
 //BA.debugLineNum = 1136;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1137;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1138;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 18;
return;
case 18:
//C
this.state = 4;
;
 //BA.debugLineNum = 1139;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1140;BA.debugLine="ListViewTelaBalanca.Clear";
parent.mostCurrent._listviewtelabalanca.Clear();
 //BA.debugLineNum = 1141;BA.debugLine="ListViewBalanca.Clear";
parent.mostCurrent._listviewbalanca.Clear();
 //BA.debugLineNum = 1142;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, balanca, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE tipocom='rede') t;";
 //BA.debugLineNum = 1143;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1144;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1145;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 19;
return;
case 19:
//C
this.state = 4;
;
 //BA.debugLineNum = 1146;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1147;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1148;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1149;BA.debugLine="XMLCurrent = XMLwork.SubString2(XMLwork.IndexOf(";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 1150;BA.debugLine="If count=1 Then";
if (true) break;

case 4:
//if
this.state = 13;
if (parent._count==1) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 13;
 //BA.debugLineNum = 1151;BA.debugLine="ListViewBalanca.AddSingleLine2(\"Balança \"&XMLwo";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 //BA.debugLineNum = 1152;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(\"Balança \"&X";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))+" "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.lastIndexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.lastIndexOf("</idbalancas>"))));
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1154;BA.debugLine="For i=1 To count";
if (true) break;

case 9:
//for
this.state = 12;
step26 = 1;
limit26 = parent._count;
parent._i = (int) (1) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 12;
if ((step26 > 0 && parent._i <= limit26) || (step26 < 0 && parent._i >= limit26)) this.state = 11;
if (true) break;

case 21:
//C
this.state = 20;
parent._i = ((int)(0 + parent._i + step26)) ;
if (true) break;

case 11:
//C
this.state = 21;
 //BA.debugLineNum = 1155;BA.debugLine="ListViewBalanca.AddSingleLine2(XMLwork.SubString";
parent.mostCurrent._listviewbalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1156;BA.debugLine="ListViewTelaBalanca.AddSingleLine2(XMLwork.SubS";
parent.mostCurrent._listviewtelabalanca.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<balanca>")+9),parent.mostCurrent._xmlwork.indexOf("</balanca>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+12),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))));
 //BA.debugLineNum = 1157;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1158;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.IndexO";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 1162;BA.debugLine="count =  count";
parent._count = parent._count;
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1164;BA.debugLine="End Sub";
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
public static void  _buttongravarproduto_click() throws Exception{
ResumableSub_ButtonGravarProduto_Click rsub = new ResumableSub_ButtonGravarProduto_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonGravarProduto_Click extends BA.ResumableSub {
public ResumableSub_ButtonGravarProduto_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int step19;
int limit19;

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
 //BA.debugLineNum = 858;BA.debugLine="Try";
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
 //BA.debugLineNum = 859;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryINSE";
_url = parent.mostCurrent._urlglobal+"/ExecQueryINSERT INTO unilever_pi.produtosCUC (codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico) VALUES("+parent.mostCurrent._edittextcodigocuc.getText()+",'"+parent.mostCurrent._edittextnomeproduto.getText()+"',"+parent.mostCurrent._edittextcodigoproduto.getText()+",'"+parent.mostCurrent._edittextnomeproduto.getText()+"',10,'KG',0,20,'Sacaria','334.31',4,0,0);";
 //BA.debugLineNum = 860;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 861;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 862;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 //BA.debugLineNum = 863;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 864;BA.debugLine="If XMLwork = \"0\" Or XMLwork = \"2\" Then";
if (true) break;

case 4:
//if
this.state = 7;
if ((parent.mostCurrent._xmlwork).equals("0") || (parent.mostCurrent._xmlwork).equals("2")) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 865;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ai gravar."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 867;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico, row_number=83113;";
 //BA.debugLineNum = 868;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 869;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 870;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 16;
return;
case 16:
//C
this.state = 8;
;
 //BA.debugLineNum = 871;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 872;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 873;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 874;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 875;BA.debugLine="ListViewProdutosCUC.Clear";
parent.mostCurrent._listviewprodutoscuc.Clear();
 //BA.debugLineNum = 876;BA.debugLine="For i=0 To count-1";
if (true) break;

case 8:
//for
this.state = 11;
step19 = 1;
limit19 = (int) (parent._count-1);
parent._i = (int) (0) ;
this.state = 17;
if (true) break;

case 17:
//C
this.state = 11;
if ((step19 > 0 && parent._i <= limit19) || (step19 < 0 && parent._i >= limit19)) this.state = 10;
if (true) break;

case 18:
//C
this.state = 17;
parent._i = ((int)(0 + parent._i + step19)) ;
if (true) break;

case 10:
//C
this.state = 18;
 //BA.debugLineNum = 877;BA.debugLine="ListViewProdutosCUC.AddSingleLine2(XMLCurrent.S";
parent.mostCurrent._listviewprodutoscuc.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaomaterial>")+19),parent.mostCurrent._xmlcurrent.indexOf("</descricaomaterial>"))),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<codigomaterial>")+16),parent.mostCurrent._xmlwork.indexOf("</codigomaterial>"))));
 //BA.debugLineNum = 878;BA.debugLine="EditTextPordutoCUC.Text = XMLCurrent.SubString2";
parent.mostCurrent._edittextpordutocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaoCUC>")+14),parent.mostCurrent._xmlcurrent.indexOf("</descricaoCUC>"))));
 //BA.debugLineNum = 879;BA.debugLine="EditTextCodigoCuc.Text = XMLCurrent.SubString2(";
parent.mostCurrent._edittextcodigocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))));
 //BA.debugLineNum = 880;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 881;BA.debugLine="XMLCurrent =  XMLwork.SubString2(5,XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),(int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 if (true) break;
if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 //BA.debugLineNum = 884;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ai gravar."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 886;BA.debugLine="End Sub";
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
public static void  _buttongravaruusario_click() throws Exception{
ResumableSub_ButtonGravarUusario_Click rsub = new ResumableSub_ButtonGravarUusario_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonGravarUusario_Click extends BA.ResumableSub {
public ResumableSub_ButtonGravarUusario_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
String _ret = "";
String _retu = "";
String _usercurrent = "";
int _cnt = 0;
String _usermain = "";
int step20;
int limit20;
int step29;
int limit29;

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
 //BA.debugLineNum = 601;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryINSER";
_url = parent.mostCurrent._urlglobal+"/ExecQueryINSERT INTO unilever_pi.usuarios (usuario, nivel, pesagem, processo, relatorio) VALUES ('"+parent.mostCurrent._edittextnomeusuario.getText()+"',"+BA.NumberToString(parent._positionnivel)+",1,1,1);";
 //BA.debugLineNum = 602;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 603;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 604;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 27;
return;
case 27:
//C
this.state = 1;
;
 //BA.debugLineNum = 605;BA.debugLine="Dim ret As String  = Job1.GetString";
_ret = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 606;BA.debugLine="If ret = \"0\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((_ret).equals("0")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 607;BA.debugLine="MsgboxAsync(\"Falha ao gravar\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Falha ao gravar"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 609;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
parent._job1._download /*String*/ (parent.mostCurrent._urlglobal+"/ListaUsuarios");
 //BA.debugLineNum = 610;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 28;
return;
case 28:
//C
this.state = 5;
;
 //BA.debugLineNum = 611;BA.debugLine="Dim retu As String = Job1.GetString";
_retu = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 612;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf(";
_ret = _retu.substring((int) (_retu.indexOf("<return>")+8),_retu.lastIndexOf("</return>"));
 //BA.debugLineNum = 613;BA.debugLine="Dim usercurrent As String = \"\"";
_usercurrent = "";
 //BA.debugLineNum = 614;BA.debugLine="Dim count As Int = ListViewUsuarios.Size";
parent._count = parent.mostCurrent._listviewusuarios.getSize();
 //BA.debugLineNum = 615;BA.debugLine="ListViewUsuarios.Clear";
parent.mostCurrent._listviewusuarios.Clear();
 //BA.debugLineNum = 616;BA.debugLine="If ret = \"1\"  Then";
if (true) break;

case 5:
//if
this.state = 26;
if ((_ret).equals("1")) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 617;BA.debugLine="Dim cnt As Int = retu.SubString2(retu.IndexOf(\"<";
_cnt = (int)(Double.parseDouble(_retu.substring((int) (_retu.indexOf("<count>")+7),_retu.lastIndexOf("</count>"))));
 //BA.debugLineNum = 618;BA.debugLine="Dim usermain As String = retu.SubString2(retu.In";
_usermain = _retu.substring(_retu.indexOf("<usuario>"),_retu.lastIndexOf("</usuario>"));
 //BA.debugLineNum = 619;BA.debugLine="Try";
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
 //BA.debugLineNum = 620;BA.debugLine="For i=0 To cnt-1";
if (true) break;

case 11:
//for
this.state = 22;
step20 = 1;
limit20 = (int) (_cnt-1);
parent._i = (int) (0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 22;
if ((step20 > 0 && parent._i <= limit20) || (step20 < 0 && parent._i >= limit20)) this.state = 13;
if (true) break;

case 30:
//C
this.state = 29;
parent._i = ((int)(0 + parent._i + step20)) ;
if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 621;BA.debugLine="usercurrent = usermain.SubString(usermain.Inde";
_usercurrent = _usermain.substring(_usermain.indexOf("<usuario>"));
 //BA.debugLineNum = 622;BA.debugLine="usercurrent =  usercurrent.SubString2(0,userma";
_usercurrent = _usercurrent.substring((int) (0),(int) (_usermain.indexOf("</usuario>")+10));
 //BA.debugLineNum = 623;BA.debugLine="ListViewUsuarios.AddSingleLine2(usercurrent.Su";
parent.mostCurrent._listviewusuarios.AddSingleLine2(BA.ObjectToCharSequence(_usercurrent.substring((int) (_usercurrent.indexOf("<nomeusuario>")+13),_usercurrent.indexOf("</nomeusuario>"))),(Object)(_usercurrent.substring((int) (_usercurrent.indexOf("<idusuario>")+11),_usercurrent.indexOf("</idusuario>"))));
 //BA.debugLineNum = 624;BA.debugLine="If i = PositionUser Then";
if (true) break;

case 14:
//if
this.state = 21;
if (parent._i==parent._positionuser) { 
this.state = 16;
}if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 625;BA.debugLine="EditTextNomeUsuario.Text = usercurrent.SubStr";
parent.mostCurrent._edittextnomeusuario.setText(BA.ObjectToCharSequence(_usercurrent.substring((int) (_usercurrent.indexOf("<nomeusuario>")+13),_usercurrent.indexOf("</nomeusuario>"))));
 //BA.debugLineNum = 626;BA.debugLine="PositionNivel = usercurrent.SubString2(usercu";
parent._positionnivel = (int)(Double.parseDouble(_usercurrent.substring((int) (_usercurrent.indexOf("<nivel>")+7),_usercurrent.indexOf("</nivel>"))));
 //BA.debugLineNum = 627;BA.debugLine="idusuario =  usercurrent.SubString2(usercurre";
parent._idusuario = (int)(Double.parseDouble(_usercurrent.substring((int) (_usercurrent.indexOf("<idusuario>")+11),_usercurrent.indexOf("</idusuario>"))));
 //BA.debugLineNum = 628;BA.debugLine="ListViewAcesso.Clear";
parent.mostCurrent._listviewacesso.Clear();
 //BA.debugLineNum = 629;BA.debugLine="For i=0 To 4";
if (true) break;

case 17:
//for
this.state = 20;
step29 = 1;
limit29 = (int) (4);
parent._i = (int) (0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 20;
if ((step29 > 0 && parent._i <= limit29) || (step29 < 0 && parent._i >= limit29)) this.state = 19;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = ((int)(0 + parent._i + step29)) ;
if (true) break;

case 19:
//C
this.state = 32;
 //BA.debugLineNum = 630;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
parent.mostCurrent._listviewacesso.AddSingleLine2(BA.ObjectToCharSequence(parent._i),(Object)(parent._i));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 //BA.debugLineNum = 632;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
parent.mostCurrent._listviewacesso.SetSelection(parent._positionnivel);
 if (true) break;

case 21:
//C
this.state = 30;
;
 //BA.debugLineNum = 634;BA.debugLine="usermain =  usermain.SubString(usermain.IndexO";
_usermain = _usermain.substring((int) (_usermain.indexOf("</usuario>")+10));
 if (true) break;
if (true) break;

case 22:
//C
this.state = 25;
;
 if (true) break;

case 24:
//C
this.state = 25;
this.catchState = 0;
 //BA.debugLineNum = 637;BA.debugLine="MsgboxAsync(\"Erro ao Alterar\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao Alterar"),BA.ObjectToCharSequence("Erro"),processBA);
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
 //BA.debugLineNum = 640;BA.debugLine="End Sub";
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
public static String  _buttonleiturabarcode_click() throws Exception{
 //BA.debugLineNum = 1044;BA.debugLine="Sub ButtonLeituraBarcode_Click";
 //BA.debugLineNum = 1045;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
mostCurrent._myabbarcode.ABGetBarcode(mostCurrent.activityBA,"myabbarcode","");
 //BA.debugLineNum = 1046;BA.debugLine="End Sub";
return "";
}
public static String  _buttonllimpar_click() throws Exception{
 //BA.debugLineNum = 434;BA.debugLine="Sub ButtonlLimpar_Click";
 //BA.debugLineNum = 435;BA.debugLine="EditTextUser.Text =  \"\"";
mostCurrent._edittextuser.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 436;BA.debugLine="EditTextPassword.Text = \"\"";
mostCurrent._edittextpassword.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 437;BA.debugLine="End Sub";
return "";
}
public static String  _buttonlogin_click() throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Sub ButtonLogin_Click";
 //BA.debugLineNum = 391;BA.debugLine="panelLogin.Visible = True";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 392;BA.debugLine="panelMain.Visible =  False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return "";
}
public static String  _buttonmenu_click() throws Exception{
 //BA.debugLineNum = 444;BA.debugLine="Sub ButtonMenu_Click";
 //BA.debugLineNum = 445;BA.debugLine="panelMenu.Visible =  True";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 446;BA.debugLine="panelMain.Visible =  False";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return "";
}
public static String  _buttonmenucuc_click() throws Exception{
 //BA.debugLineNum = 935;BA.debugLine="Sub ButtonMenuCUC_Click";
 //BA.debugLineNum = 936;BA.debugLine="panelMenu.Visible = True";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 937;BA.debugLine="SelecionaCUC.Visible = False";
mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 938;BA.debugLine="End Sub";
return "";
}
public static String  _buttonniveldown_click() throws Exception{
 //BA.debugLineNum = 587;BA.debugLine="Sub ButtonNivelDown_Click";
 //BA.debugLineNum = 588;BA.debugLine="Try";
try { //BA.debugLineNum = 589;BA.debugLine="If PositionNivel <= ListViewAcesso.Size-1 Then";
if (_positionnivel<=mostCurrent._listviewacesso.getSize()-1) { 
 //BA.debugLineNum = 590;BA.debugLine="PositionNivel =  PositionNivel+1";
_positionnivel = (int) (_positionnivel+1);
 //BA.debugLineNum = 591;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
mostCurrent._listviewacesso.SetSelection(_positionnivel);
 }else if(_positionnivel==1) { 
 //BA.debugLineNum = 593;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
mostCurrent._listviewacesso.SetSelection(_positionnivel);
 };
 } 
       catch (Exception e9) {
			processBA.setLastException(e9); //BA.debugLineNum = 596;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao mudar a posição."),BA.ObjectToCharSequence("Erro"),processBA);
 };
 //BA.debugLineNum = 598;BA.debugLine="End Sub";
return "";
}
public static String  _buttonnivelup_click() throws Exception{
 //BA.debugLineNum = 570;BA.debugLine="Sub ButtonNivelUp_Click";
 //BA.debugLineNum = 571;BA.debugLine="Try";
try { //BA.debugLineNum = 572;BA.debugLine="If PositionNivel >= ListViewAcesso.Size-1 Or Pos";
if (_positionnivel>=mostCurrent._listviewacesso.getSize()-1 || _positionnivel<=mostCurrent._listviewacesso.getSize()-1) { 
 //BA.debugLineNum = 573;BA.debugLine="PositionNivel =  PositionNivel-1";
_positionnivel = (int) (_positionnivel-1);
 //BA.debugLineNum = 574;BA.debugLine="If PositionNivel=0 Then";
if (_positionnivel==0) { 
 //BA.debugLineNum = 575;BA.debugLine="PositionNivel = 1";
_positionnivel = (int) (1);
 //BA.debugLineNum = 576;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
mostCurrent._listviewacesso.SetSelection(_positionnivel);
 };
 //BA.debugLineNum = 578;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
mostCurrent._listviewacesso.SetSelection(_positionnivel);
 }else if(_positionnivel==1) { 
 //BA.debugLineNum = 580;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
mostCurrent._listviewacesso.SetSelection(_positionnivel);
 };
 } 
       catch (Exception e13) {
			processBA.setLastException(e13); //BA.debugLineNum = 583;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao mudar a posição."),BA.ObjectToCharSequence("Erro"),processBA);
 };
 //BA.debugLineNum = 585;BA.debugLine="End Sub";
return "";
}
public static void  _buttonprodutoalterar_click() throws Exception{
ResumableSub_ButtonProdutoAlterar_Click rsub = new ResumableSub_ButtonProdutoAlterar_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonProdutoAlterar_Click extends BA.ResumableSub {
public ResumableSub_ButtonProdutoAlterar_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
int step19;
int limit19;

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
 //BA.debugLineNum = 889;BA.debugLine="Try";
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
 //BA.debugLineNum = 890;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQueryUPDA";
_url = parent.mostCurrent._urlglobal+"/ExecQueryUPDATE unilever_pi.produtosCUC SET (codigoCUC=83113, descricaoCUC='"+parent.mostCurrent._edittextnomeproduto.getText()+"', codigomaterial="+parent.mostCurrent._edittextcodigoproduto.getText()+", descricaomaterial='"+parent.mostCurrent._edittextnomeproduto.getText()+"', quant=10, unidade='KG', obrigatorio=0, embfechada=20, faseprod=1, unidadeemb='Sacaria', batch='334.31', rota=4, numeromix=0, alergenico=0);";
 //BA.debugLineNum = 891;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 892;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 893;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 //BA.debugLineNum = 894;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 895;BA.debugLine="If XMLwork = \"0\" Or XMLwork = \"2\" Then";
if (true) break;

case 4:
//if
this.state = 7;
if ((parent.mostCurrent._xmlwork).equals("0") || (parent.mostCurrent._xmlwork).equals("2")) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 896;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ai gravar."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 898;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, quant, unidade, obrigatorio, embfechada, faseprod, unidadeemb, batch, rota, numeromix, alergenico, row_number=83113;";
 //BA.debugLineNum = 899;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 900;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 901;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 16;
return;
case 16:
//C
this.state = 8;
;
 //BA.debugLineNum = 902;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 903;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.La";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 904;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 905;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.IndexO";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 906;BA.debugLine="ListViewProdutosCUC.Clear";
parent.mostCurrent._listviewprodutoscuc.Clear();
 //BA.debugLineNum = 907;BA.debugLine="For i=0 To count-1";
if (true) break;

case 8:
//for
this.state = 11;
step19 = 1;
limit19 = (int) (parent._count-1);
parent._i = (int) (0) ;
this.state = 17;
if (true) break;

case 17:
//C
this.state = 11;
if ((step19 > 0 && parent._i <= limit19) || (step19 < 0 && parent._i >= limit19)) this.state = 10;
if (true) break;

case 18:
//C
this.state = 17;
parent._i = ((int)(0 + parent._i + step19)) ;
if (true) break;

case 10:
//C
this.state = 18;
 //BA.debugLineNum = 908;BA.debugLine="ListViewProdutosCUC.AddSingleLine2(XMLCurrent.S";
parent.mostCurrent._listviewprodutoscuc.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaomaterial>")+19),parent.mostCurrent._xmlcurrent.indexOf("</descricaomaterial>"))),(Object)(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<codigomaterial>")+16),parent.mostCurrent._xmlwork.indexOf("</codigomaterial>"))));
 //BA.debugLineNum = 909;BA.debugLine="EditTextPordutoCUC.Text = XMLCurrent.SubString2";
parent.mostCurrent._edittextpordutocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<descricaoCUC>")+14),parent.mostCurrent._xmlcurrent.indexOf("</descricaoCUC>"))));
 //BA.debugLineNum = 910;BA.debugLine="EditTextCodigoCuc.Text = XMLCurrent.SubString2(";
parent.mostCurrent._edittextcodigocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlcurrent.indexOf("</codigoCUC>"))));
 //BA.debugLineNum = 911;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"</";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 912;BA.debugLine="XMLCurrent =  XMLwork.SubString2(5,XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),(int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 if (true) break;
if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 //BA.debugLineNum = 915;BA.debugLine="MsgboxAsync(\"Erro ai gravar.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ai gravar."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 917;BA.debugLine="End Sub";
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
public static String  _buttonprodutosvolta_click() throws Exception{
 //BA.debugLineNum = 940;BA.debugLine="Sub ButtonProdutosVolta_Click";
 //BA.debugLineNum = 941;BA.debugLine="panelProdutos.Visible =  False";
mostCurrent._panelprodutos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 942;BA.debugLine="SelecionaCUC.Visible =  True";
mostCurrent._selecionacuc.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 943;BA.debugLine="End Sub";
return "";
}
public static String  _buttonreset_click() throws Exception{
 //BA.debugLineNum = 464;BA.debugLine="Sub ButtonReset_Click";
 //BA.debugLineNum = 465;BA.debugLine="MsgboxAsync(\"Reset\",\"\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Reset"),BA.ObjectToCharSequence(""),processBA);
 //BA.debugLineNum = 466;BA.debugLine="End Sub";
return "";
}
public static String  _buttonsair_click() throws Exception{
int _answ = 0;
String _msgyes = "";
String _msgno = "";
 //BA.debugLineNum = 371;BA.debugLine="Sub ButtonSair_Click";
 //BA.debugLineNum = 372;BA.debugLine="Dim Answ As Int";
_answ = 0;
 //BA.debugLineNum = 373;BA.debugLine="Dim msgYes As String = \"Sim\"";
_msgyes = "Sim";
 //BA.debugLineNum = 374;BA.debugLine="Dim msgNo As String = \"Não\"";
_msgno = "Não";
 //BA.debugLineNum = 375;BA.debugLine="Answ= Msgbox2(\"\",\"Tem certeza que deseja sair?\",m";
_answ = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence(""),BA.ObjectToCharSequence("Tem certeza que deseja sair?"),_msgyes,"",_msgno,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 376;BA.debugLine="If Answ=DialogResponse.POSITIVE Then";
if (_answ==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 377;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public static String  _buttonsairpeso_click() throws Exception{
 //BA.debugLineNum = 459;BA.debugLine="Sub ButtonSairPeso_Click";
 //BA.debugLineNum = 460;BA.debugLine="panelPesagem.Visible =  False";
mostCurrent._panelpesagem.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 461;BA.debugLine="panelMain.Visible =  True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 462;BA.debugLine="End Sub";
return "";
}
public static String  _buttontelaleitura_click() throws Exception{
 //BA.debugLineNum = 454;BA.debugLine="Sub ButtonTelaLeitura_Click";
 //BA.debugLineNum = 455;BA.debugLine="DisableStrictMode";
_disablestrictmode();
 //BA.debugLineNum = 456;BA.debugLine="CallSubDelayed(Me,\"Connect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,main.getObject(),"Connect");
 //BA.debugLineNum = 457;BA.debugLine="End Sub";
return "";
}
public static void  _buttontelalogin_click() throws Exception{
ResumableSub_ButtonTelaLogin_Click rsub = new ResumableSub_ButtonTelaLogin_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonTelaLogin_Click extends BA.ResumableSub {
public ResumableSub_ButtonTelaLogin_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
String _ret = "";

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
 //BA.debugLineNum = 398;BA.debugLine="Try";
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
 //BA.debugLineNum = 399;BA.debugLine="If EditTextUser.Text = \"myDB\" Then";
if (true) break;

case 4:
//if
this.state = 19;
if ((parent.mostCurrent._edittextuser.getText()).equals("myDB")) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 19;
 //BA.debugLineNum = 400;BA.debugLine="ButtonWebservice.Enabled =  True";
parent.mostCurrent._buttonwebservice.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 401;BA.debugLine="panelMain.Visible =  True";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 402;BA.debugLine="panelLogin.Visible = False";
parent.mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 404;BA.debugLine="Dim url As String =  URLglobal & \"/Login\"&EditT";
_url = parent.mostCurrent._urlglobal+"/Login"+parent.mostCurrent._edittextuser.getText()+"-"+parent.mostCurrent._edittextpassword.getText();
 //BA.debugLineNum = 405;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 406;BA.debugLine="Job1.GetRequest.SetContentType(\"application/jso";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 407;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 23;
return;
case 23:
//C
this.state = 9;
;
 //BA.debugLineNum = 408;BA.debugLine="Dim ret As String  = Job1.GetString";
_ret = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 409;BA.debugLine="Job1.Release";
parent._job1._release /*String*/ ();
 //BA.debugLineNum = 410;BA.debugLine="If ret.SubString2(ret.IndexOf(\"<Resultado>\")+11";
if (true) break;

case 9:
//if
this.state = 18;
if ((_ret.substring((int) (_ret.indexOf("<Resultado>")+11),_ret.indexOf("</Resultado>"))).equals("1")) { 
this.state = 11;
}else {
this.state = 17;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 411;BA.debugLine="panelMain.Visible =  True";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 412;BA.debugLine="panelLogin.Visible = False";
parent.mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 413;BA.debugLine="Usertext.Text =  EditTextUser.Text";
parent.mostCurrent._usertext.setText(BA.ObjectToCharSequence(parent.mostCurrent._edittextuser.getText()));
 //BA.debugLineNum = 414;BA.debugLine="NivelUsuario  = ret.SubString2(ret.IndexOf(\"<ni";
parent.mostCurrent._nivelusuario = _ret.substring((int) (_ret.indexOf("<nivel>")+7),_ret.indexOf("</nivel>"));
 //BA.debugLineNum = 415;BA.debugLine="EditTextUser.Text = \"\"";
parent.mostCurrent._edittextuser.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 416;BA.debugLine="EditTextPassword.Text =  \"\"";
parent.mostCurrent._edittextpassword.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 417;BA.debugLine="If NivelUsuario =  4 Then";
if (true) break;

case 12:
//if
this.state = 15;
if ((parent.mostCurrent._nivelusuario).equals(BA.NumberToString(4))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 418;BA.debugLine="ButtonCadastraBalnca.Enabled =  True";
parent.mostCurrent._buttoncadastrabalnca.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 419;BA.debugLine="ButtonUsuarios.Enabled =  True";
parent.mostCurrent._buttonusuarios.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 420;BA.debugLine="ButtonMenu.Enabled = True";
parent.mostCurrent._buttonmenu.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 421;BA.debugLine="ButtonCadastroProduto.Enabled = True";
parent.mostCurrent._buttoncadastroproduto.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 422;BA.debugLine="ButtonWebservice.Enabled =  True";
parent.mostCurrent._buttonwebservice.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 425;BA.debugLine="MsgboxAsync(\"Usuário ou senha invalido.\",\"Avis";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Usuário ou senha invalido."),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;

case 18:
//C
this.state = 19;
;
 //BA.debugLineNum = 427;BA.debugLine="Job1.Release";
parent._job1._release /*String*/ ();
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
 //BA.debugLineNum = 430;BA.debugLine="MsgboxAsync(\"Erro ao conectar, verifique sua con";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao conectar, verifique sua conexão."),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;
if (true) break;

case 22:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 432;BA.debugLine="End Sub";
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
public static String  _buttontelaloginvolta_click() throws Exception{
 //BA.debugLineNum = 385;BA.debugLine="Sub ButtonTelaLoginVolta_Click";
 //BA.debugLineNum = 386;BA.debugLine="panelLogin.Visible =  False";
mostCurrent._panellogin.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 387;BA.debugLine="panelMain.Visible = True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public static String  _buttontelamain_click() throws Exception{
 //BA.debugLineNum = 449;BA.debugLine="Sub ButtonTelaMain_Click";
 //BA.debugLineNum = 450;BA.debugLine="panelMenu.Visible =  True";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 451;BA.debugLine="panelConexao.Visible =  False";
mostCurrent._panelconexao.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 452;BA.debugLine="End Sub";
return "";
}
public static String  _buttontelamenu_click() throws Exception{
 //BA.debugLineNum = 439;BA.debugLine="Sub ButtonTelaMenu_Click";
 //BA.debugLineNum = 440;BA.debugLine="panelMain.Visible =  True";
mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 441;BA.debugLine="panelMenu.Visible =  False";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
return "";
}
public static String  _buttontelawebservicemenu_click() throws Exception{
 //BA.debugLineNum = 827;BA.debugLine="Sub ButtonTelawebserviceMenu_Click";
 //BA.debugLineNum = 828;BA.debugLine="panelWebservice.Visible =  False";
mostCurrent._panelwebservice.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 829;BA.debugLine="panelMenu.Visible =  True";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 830;BA.debugLine="End Sub";
return "";
}
public static void  _buttonuserdown_click() throws Exception{
ResumableSub_ButtonUserDown_Click rsub = new ResumableSub_ButtonUserDown_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonUserDown_Click extends BA.ResumableSub {
public ResumableSub_ButtonUserDown_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
String _xml = "";
int step19;
int limit19;

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
 //BA.debugLineNum = 542;BA.debugLine="Try";
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
 //BA.debugLineNum = 543;BA.debugLine="If PositionUser <= ListViewUsuarios.Size-1 Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent._positionuser<=parent.mostCurrent._listviewusuarios.getSize()-1) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 544;BA.debugLine="PositionUser =  PositionUser+1";
parent._positionuser = (int) (parent._positionuser+1);
 //BA.debugLineNum = 545;BA.debugLine="PositionDB =  PositionUser+1";
parent._positiondb = (int) (parent._positionuser+1);
 //BA.debugLineNum = 546;BA.debugLine="ListViewUsuarios.SetSelection(PositionUser)";
parent.mostCurrent._listviewusuarios.SetSelection(parent._positionuser);
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 548;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idusuario, usuario, nivel, pesagem, processo, relatorio, row_number() OVER (order by idusuario) as row_num from unilever_pi.usuarios) t WHERE row_num="+BA.NumberToString(parent._positiondb);
 //BA.debugLineNum = 549;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 550;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 551;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 21;
return;
case 21:
//C
this.state = 8;
;
 //BA.debugLineNum = 552;BA.debugLine="XMLwork  = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 553;BA.debugLine="If XMLwork=\"<DocumentElement />\" Or XMLwork=\"0\"";
if (true) break;

case 8:
//if
this.state = 17;
if ((parent.mostCurrent._xmlwork).equals("<DocumentElement />") || (parent.mostCurrent._xmlwork).equals("0")) { 
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
 //BA.debugLineNum = 555;BA.debugLine="Dim XML As String = XMLwork.SubString2(XMLwork.";
_xml = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 556;BA.debugLine="EditTextNomeUsuario.Text = XML.SubString2(XML.I";
parent.mostCurrent._edittextnomeusuario.setText(BA.ObjectToCharSequence(_xml.substring((int) (_xml.indexOf("<usuario>")+9),_xml.indexOf("</usuario>"))));
 //BA.debugLineNum = 557;BA.debugLine="PositionNivel = XML.SubString2(XML.IndexOf(\"<ni";
parent._positionnivel = (int)(Double.parseDouble(_xml.substring((int) (_xml.indexOf("<nivel>")+7),_xml.indexOf("</nivel>"))));
 //BA.debugLineNum = 558;BA.debugLine="idusuario =  XML.SubString2(XML.IndexOf(\"<idusu";
parent._idusuario = (int)(Double.parseDouble(_xml.substring((int) (_xml.indexOf("<idusuario>")+11),_xml.indexOf("</idusuario>"))));
 //BA.debugLineNum = 559;BA.debugLine="ListViewAcesso.Clear";
parent.mostCurrent._listviewacesso.Clear();
 //BA.debugLineNum = 560;BA.debugLine="For i=0 To 4";
if (true) break;

case 13:
//for
this.state = 16;
step19 = 1;
limit19 = (int) (4);
parent._i = (int) (0) ;
this.state = 22;
if (true) break;

case 22:
//C
this.state = 16;
if ((step19 > 0 && parent._i <= limit19) || (step19 < 0 && parent._i >= limit19)) this.state = 15;
if (true) break;

case 23:
//C
this.state = 22;
parent._i = ((int)(0 + parent._i + step19)) ;
if (true) break;

case 15:
//C
this.state = 23;
 //BA.debugLineNum = 561;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
parent.mostCurrent._listviewacesso.AddSingleLine2(BA.ObjectToCharSequence(parent._i),(Object)(parent._i));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
 //BA.debugLineNum = 563;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
parent.mostCurrent._listviewacesso.SetSelection(parent._positionnivel);
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
 //BA.debugLineNum = 566;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao mudar a posição."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 568;BA.debugLine="End Sub";
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
public static void  _buttonuserup_click() throws Exception{
ResumableSub_ButtonUserUp_Click rsub = new ResumableSub_ButtonUserUp_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonUserUp_Click extends BA.ResumableSub {
public ResumableSub_ButtonUserUp_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _url = "";
String _ret = "";
String _xml = "";
int step20;
int limit20;

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
 //BA.debugLineNum = 513;BA.debugLine="Try";
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
 //BA.debugLineNum = 514;BA.debugLine="If PositionUser=0 Then";
if (true) break;

case 4:
//if
this.state = 9;
if (parent._positionuser==0) { 
this.state = 6;
}else if(parent._positionuser>=parent.mostCurrent._listviewusuarios.getSize()-1 || parent._positionuser<=parent.mostCurrent._listviewusuarios.getSize()-1) { 
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 515;BA.debugLine="ListViewUsuarios.SetSelection(PositionUser)";
parent.mostCurrent._listviewusuarios.SetSelection(parent._positionuser);
 //BA.debugLineNum = 516;BA.debugLine="PositionDB = 1";
parent._positiondb = (int) (1);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 518;BA.debugLine="PositionDB =  PositionUser";
parent._positiondb = parent._positionuser;
 //BA.debugLineNum = 519;BA.debugLine="PositionUser =  PositionUser-1";
parent._positionuser = (int) (parent._positionuser-1);
 //BA.debugLineNum = 520;BA.debugLine="ListViewUsuarios.SetSelection(PositionUser)";
parent.mostCurrent._listviewusuarios.SetSelection(parent._positionuser);
 if (true) break;

case 9:
//C
this.state = 10;
;
 //BA.debugLineNum = 522;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idusuario, usuario, nivel, pesagem, processo, relatorio, row_number() OVER (order by idusuario) as row_num from unilever_pi.usuarios) t WHERE row_num="+BA.NumberToString(parent._positiondb);
 //BA.debugLineNum = 523;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 524;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 525;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 17;
return;
case 17:
//C
this.state = 10;
;
 //BA.debugLineNum = 526;BA.debugLine="Dim ret As String  = Job1.GetString";
_ret = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 527;BA.debugLine="Dim XML As String = ret.SubString2(ret.IndexOf(\"";
_xml = _ret.substring((int) (_ret.indexOf("<SQL>")+5),_ret.indexOf("</SQL>"));
 //BA.debugLineNum = 528;BA.debugLine="EditTextNomeUsuario.Text = XML.SubString2(XML.In";
parent.mostCurrent._edittextnomeusuario.setText(BA.ObjectToCharSequence(_xml.substring((int) (_xml.indexOf("<usuario>")+9),_xml.indexOf("</usuario>"))));
 //BA.debugLineNum = 529;BA.debugLine="PositionNivel = XML.SubString2(XML.IndexOf(\"<niv";
parent._positionnivel = (int)(Double.parseDouble(_xml.substring((int) (_xml.indexOf("<nivel>")+7),_xml.indexOf("</nivel>"))));
 //BA.debugLineNum = 530;BA.debugLine="idusuario =  XML.SubString2(XML.IndexOf(\"<idusua";
parent._idusuario = (int)(Double.parseDouble(_xml.substring((int) (_xml.indexOf("<idusuario>")+11),_xml.indexOf("</idusuario>"))));
 //BA.debugLineNum = 531;BA.debugLine="ListViewAcesso.Clear";
parent.mostCurrent._listviewacesso.Clear();
 //BA.debugLineNum = 532;BA.debugLine="For i=0 To 4";
if (true) break;

case 10:
//for
this.state = 13;
step20 = 1;
limit20 = (int) (4);
parent._i = (int) (0) ;
this.state = 18;
if (true) break;

case 18:
//C
this.state = 13;
if ((step20 > 0 && parent._i <= limit20) || (step20 < 0 && parent._i >= limit20)) this.state = 12;
if (true) break;

case 19:
//C
this.state = 18;
parent._i = ((int)(0 + parent._i + step20)) ;
if (true) break;

case 12:
//C
this.state = 19;
 //BA.debugLineNum = 533;BA.debugLine="ListViewAcesso.AddSingleLine2(i,i)";
parent.mostCurrent._listviewacesso.AddSingleLine2(BA.ObjectToCharSequence(parent._i),(Object)(parent._i));
 if (true) break;
if (true) break;

case 13:
//C
this.state = 16;
;
 //BA.debugLineNum = 535;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
parent.mostCurrent._listviewacesso.SetSelection(parent._positionnivel);
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 537;BA.debugLine="MsgboxAsync(\"Erro ao mudar a posição.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao mudar a posição."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 539;BA.debugLine="End Sub";
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
public static void  _buttonusuarios_click() throws Exception{
ResumableSub_ButtonUsuarios_Click rsub = new ResumableSub_ButtonUsuarios_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ButtonUsuarios_Click extends BA.ResumableSub {
public ResumableSub_ButtonUsuarios_Click(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;
String _retu = "";
String _ret = "";
int _cnt = 0;
String _usermain = "";
int _c = 0;
int step9;
int limit9;
int step15;
int limit15;

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
 //BA.debugLineNum = 476;BA.debugLine="Try";
if (true) break;

case 1:
//try
this.state = 29;
this.catchState = 28;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 28;
 //BA.debugLineNum = 477;BA.debugLine="Job1.Download(URLglobal & \"/ListaUsuarios\")";
parent._job1._download /*String*/ (parent.mostCurrent._urlglobal+"/ListaUsuarios");
 //BA.debugLineNum = 478;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 30;
return;
case 30:
//C
this.state = 4;
;
 //BA.debugLineNum = 479;BA.debugLine="Dim retu As String = Job1.GetString";
_retu = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 480;BA.debugLine="Dim ret As String = retu.SubString2(retu.IndexOf";
_ret = _retu.substring((int) (_retu.indexOf("<return>")+8),_retu.lastIndexOf("</return>"));
 //BA.debugLineNum = 481;BA.debugLine="If ret = \"1\" Then";
if (true) break;

case 4:
//if
this.state = 26;
if ((_ret).equals("1")) { 
this.state = 6;
}else {
this.state = 25;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 482;BA.debugLine="Dim cnt As Int = retu.SubString2(retu.LastIndex";
_cnt = (int)(Double.parseDouble(_retu.substring((int) (_retu.lastIndexOf("<count>")+7),_retu.lastIndexOf("</count>"))));
 //BA.debugLineNum = 483;BA.debugLine="Dim usermain As String = retu.SubString2(retu.I";
_usermain = _retu.substring(_retu.indexOf("<usuario>"),_retu.lastIndexOf("</usuario>"));
 //BA.debugLineNum = 484;BA.debugLine="For i=1 To cnt";
if (true) break;

case 7:
//for
this.state = 23;
step9 = 1;
limit9 = _cnt;
parent._i = (int) (1) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 23;
if ((step9 > 0 && parent._i <= limit9) || (step9 < 0 && parent._i >= limit9)) this.state = 9;
if (true) break;

case 32:
//C
this.state = 31;
parent._i = ((int)(0 + parent._i + step9)) ;
if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 485;BA.debugLine="If i=1 Then";
if (true) break;

case 10:
//if
this.state = 17;
if (parent._i==1) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 486;BA.debugLine="EditTextNomeUsuario.Text = usermain.SubString";
parent.mostCurrent._edittextnomeusuario.setText(BA.ObjectToCharSequence(_usermain.substring((int) (_usermain.indexOf("<nomeusuario>")+13),_usermain.indexOf("</nomeusuario>"))));
 //BA.debugLineNum = 487;BA.debugLine="PositionNivel = usermain.SubString2(usermain.";
parent._positionnivel = (int)(Double.parseDouble(_usermain.substring((int) (_usermain.indexOf("<nivel>")+7),_usermain.indexOf("</nivel>"))));
 //BA.debugLineNum = 488;BA.debugLine="idusuario =  usermain.SubString2(usermain.Ind";
parent._idusuario = (int)(Double.parseDouble(_usermain.substring((int) (_usermain.indexOf("<idusuario>")+11),_usermain.indexOf("</idusuario>"))));
 //BA.debugLineNum = 489;BA.debugLine="ListViewAcesso.Clear";
parent.mostCurrent._listviewacesso.Clear();
 //BA.debugLineNum = 490;BA.debugLine="For c=0 To 4";
if (true) break;

case 13:
//for
this.state = 16;
step15 = 1;
limit15 = (int) (4);
_c = (int) (0) ;
this.state = 33;
if (true) break;

case 33:
//C
this.state = 16;
if ((step15 > 0 && _c <= limit15) || (step15 < 0 && _c >= limit15)) this.state = 15;
if (true) break;

case 34:
//C
this.state = 33;
_c = ((int)(0 + _c + step15)) ;
if (true) break;

case 15:
//C
this.state = 34;
 //BA.debugLineNum = 491;BA.debugLine="ListViewAcesso.AddSingleLine2(c,c)";
parent.mostCurrent._listviewacesso.AddSingleLine2(BA.ObjectToCharSequence(_c),(Object)(_c));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
 //BA.debugLineNum = 493;BA.debugLine="ListViewAcesso.SetSelection(PositionNivel)";
parent.mostCurrent._listviewacesso.SetSelection(parent._positionnivel);
 if (true) break;
;
 //BA.debugLineNum = 495;BA.debugLine="If i < cnt Then";

case 17:
//if
this.state = 22;
if (parent._i<_cnt) { 
this.state = 19;
}else if(parent._i==_cnt) { 
this.state = 21;
}if (true) break;

case 19:
//C
this.state = 22;
 //BA.debugLineNum = 496;BA.debugLine="ListViewUsuarios.AddSingleLine2(usermain.SubS";
parent.mostCurrent._listviewusuarios.AddSingleLine2(BA.ObjectToCharSequence(_usermain.substring((int) (_usermain.indexOf("<nomeusuario>")+13),_usermain.indexOf("</nomeusuario>"))),(Object)(_usermain.substring((int) (_usermain.indexOf("<idusuario>")+11),_usermain.indexOf("</idusuario>"))));
 //BA.debugLineNum = 497;BA.debugLine="usermain =  usermain.SubString(usermain.Index";
_usermain = _usermain.substring((int) (_usermain.indexOf("</usuario>")+10));
 if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 499;BA.debugLine="ListViewUsuarios.AddSingleLine2(usermain.SubS";
parent.mostCurrent._listviewusuarios.AddSingleLine2(BA.ObjectToCharSequence(_usermain.substring((int) (_usermain.indexOf("<nomeusuario>")+13),_usermain.indexOf("</nomeusuario>"))),(Object)(_usermain.substring((int) (_usermain.indexOf("<idusuario>")+11),_usermain.indexOf("</idusuario>"))));
 if (true) break;

case 22:
//C
this.state = 32;
;
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
;
 //BA.debugLineNum = 502;BA.debugLine="panelUsuarios.Visible =  True";
parent.mostCurrent._panelusuarios.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 503;BA.debugLine="panelMenu.Visible =  False";
parent.mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
 //BA.debugLineNum = 505;BA.debugLine="MsgboxAsync(\"Erro ao carregar os usuários\",\"Err";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao carregar os usuários"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;

case 26:
//C
this.state = 29;
;
 if (true) break;

case 28:
//C
this.state = 29;
this.catchState = 0;
 //BA.debugLineNum = 508;BA.debugLine="MsgboxAsync(\"Erro ao conectar com o bando de dad";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao conectar com o bando de dados."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 29:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 510;BA.debugLine="End Sub";
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
public static String  _buttonvoltarmenuusuarios_click() throws Exception{
 //BA.debugLineNum = 468;BA.debugLine="Sub ButtonVoltarMenuUsuarios_Click";
 //BA.debugLineNum = 469;BA.debugLine="panelUsuarios.Visible =  False";
mostCurrent._panelusuarios.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 470;BA.debugLine="panelMenu.Visible =  True";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 471;BA.debugLine="End Sub";
return "";
}
public static String  _buttonwebservice_click() throws Exception{
 //BA.debugLineNum = 727;BA.debugLine="Sub ButtonWebservice_Click";
 //BA.debugLineNum = 728;BA.debugLine="Try";
try { //BA.debugLineNum = 729;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT * FROM Webservic";
_cursor.setObject((android.database.Cursor)(_sql1.ExecQuery("SELECT * FROM Webservice")));
 //BA.debugLineNum = 730;BA.debugLine="cursor.Position=0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 731;BA.debugLine="EditTextWebserviceIP.Text = cursor.GetString2(1)";
mostCurrent._edittextwebserviceip.setText(BA.ObjectToCharSequence(_cursor.GetString2((int) (1))));
 //BA.debugLineNum = 732;BA.debugLine="EditTextWebservicePorta.Text = cursor.GetString2";
mostCurrent._edittextwebserviceporta.setText(BA.ObjectToCharSequence(_cursor.GetString2((int) (2))));
 //BA.debugLineNum = 733;BA.debugLine="panelWebservice.Visible =  True";
mostCurrent._panelwebservice.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 734;BA.debugLine="panelMenu.Visible =  False";
mostCurrent._panelmenu.setVisible(anywheresoftware.b4a.keywords.Common.False);
 } 
       catch (Exception e9) {
			processBA.setLastException(e9); //BA.debugLineNum = 736;BA.debugLine="MsgboxAsync(\"Eoo ao alterar ao carregar o webser";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Eoo ao alterar ao carregar o webservice."),BA.ObjectToCharSequence("Aviso"),processBA);
 };
 //BA.debugLineNum = 738;BA.debugLine="End Sub";
return "";
}
public static String  _buttonwebservicealterar_click() throws Exception{
 //BA.debugLineNum = 1166;BA.debugLine="Sub ButtonWebserviceAlterar_Click";
 //BA.debugLineNum = 1167;BA.debugLine="Try";
try { //BA.debugLineNum = 1168;BA.debugLine="sql1.ExecNonQuery(\"UPDATE 'Webservice' SET port=";
_sql1.ExecNonQuery("UPDATE 'Webservice' SET port='"+mostCurrent._edittextwebserviceip.getText()+"', ip='"+mostCurrent._edittextwebserviceporta.getText()+"'WHERE id=1");
 //BA.debugLineNum = 1169;BA.debugLine="cursor = sql1.ExecQuery(\"SELECT * FROM Webservic";
_cursor.setObject((android.database.Cursor)(_sql1.ExecQuery("SELECT * FROM Webservice")));
 //BA.debugLineNum = 1170;BA.debugLine="cursor.Position=0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 1171;BA.debugLine="EditTextWebserviceIP.Text = cursor.GetString2(1)";
mostCurrent._edittextwebserviceip.setText(BA.ObjectToCharSequence(_cursor.GetString2((int) (1))));
 //BA.debugLineNum = 1172;BA.debugLine="EditTextWebservicePorta.Text = cursor.GetString2";
mostCurrent._edittextwebserviceporta.setText(BA.ObjectToCharSequence(_cursor.GetString2((int) (2))));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8); //BA.debugLineNum = 1174;BA.debugLine="MsgboxAsync(\"Eoo ao alterar o registro.\",\"Aviso\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Eoo ao alterar o registro."),BA.ObjectToCharSequence("Aviso"),processBA);
 };
 //BA.debugLineNum = 1176;BA.debugLine="End Sub";
return "";
}
public static void  _clock(boolean _value) throws Exception{
ResumableSub_Clock rsub = new ResumableSub_Clock(null,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_Clock extends BA.ResumableSub {
public ResumableSub_Clock(wrong.addition.main parent,boolean _value) {
this.parent = parent;
this._value = _value;
}
wrong.addition.main parent;
boolean _value;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 289;BA.debugLine="Do While value =  True";
if (true) break;

case 1:
//do while
this.state = 4;
while (_value==anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 290;BA.debugLine="Sleep(500)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (500));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 291;BA.debugLine="LabelClock.Text = DateTime.Time(DateTime.Now)";
parent.mostCurrent._labelclock.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _connect() throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Sub Connect";
 //BA.debugLineNum = 310;BA.debugLine="socket1.Initialize(\"CoonectTelnet\")";
_socket1.Initialize("CoonectTelnet");
 //BA.debugLineNum = 311;BA.debugLine="CallSubDelayed(Me,\"CoonectTelnet\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,main.getObject(),"CoonectTelnet");
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public static void  _coonecttelnet() throws Exception{
ResumableSub_CoonectTelnet rsub = new ResumableSub_CoonectTelnet(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_CoonectTelnet extends BA.ResumableSub {
public ResumableSub_CoonectTelnet(wrong.addition.main parent) {
this.parent = parent;
}
wrong.addition.main parent;

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
 //BA.debugLineNum = 315;BA.debugLine="Try";
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
 //BA.debugLineNum = 316;BA.debugLine="Sleep(1)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (1));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 //BA.debugLineNum = 317;BA.debugLine="If socket1.IsInitialized = True And j=0 Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent._socket1.IsInitialized()==anywheresoftware.b4a.keywords.Common.True && parent._j==0) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 318;BA.debugLine="socket1.Connect(EditTextIP.Text,EditTextPorta.T";
parent._socket1.Connect(processBA,parent.mostCurrent._edittextip.getText(),(int)(Double.parseDouble(parent.mostCurrent._edittextporta.getText())),(int) (2500));
 //BA.debugLineNum = 319;BA.debugLine="CallSubDelayed2(Me,\"CoonectTelnet_Connected\",Tr";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,main.getObject(),"CoonectTelnet_Connected",(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 320;BA.debugLine="j=1";
parent._j = (int) (1);
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
 //BA.debugLineNum = 323;BA.debugLine="MsgboxAsync(\"No connection\",\"Network\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("No connection"),BA.ObjectToCharSequence("Network"),processBA);
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
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
public static void  _coonecttelnet_connected(boolean _state) throws Exception{
ResumableSub_CoonectTelnet_Connected rsub = new ResumableSub_CoonectTelnet_Connected(null,_state);
rsub.resume(processBA, null);
}
public static class ResumableSub_CoonectTelnet_Connected extends BA.ResumableSub {
public ResumableSub_CoonectTelnet_Connected(wrong.addition.main parent,boolean _state) {
this.parent = parent;
this._state = _state;
}
wrong.addition.main parent;
boolean _state;

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
 //BA.debugLineNum = 328;BA.debugLine="Do While socket1.Connected= True";
if (true) break;

case 1:
//do while
this.state = 44;
while (parent._socket1.getConnected()==anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 329;BA.debugLine="str = socket1.InputStream";
parent.mostCurrent._str.setObject((java.io.InputStream)(parent._socket1.getInputStream()));
 //BA.debugLineNum = 330;BA.debugLine="reader.Initialize(socket1.InputStream)";
parent.mostCurrent._reader.Initialize(parent._socket1.getInputStream());
 //BA.debugLineNum = 331;BA.debugLine="UnidadePeso = \"KG\"";
parent.mostCurrent._unidadepeso = "KG";
 //BA.debugLineNum = 332;BA.debugLine="If str.BytesAvailable-str3 >= 9 Then";
if (true) break;

case 4:
//if
this.state = 43;
if (parent.mostCurrent._str.BytesAvailable()-parent._str3>=9) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 333;BA.debugLine="Try";
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
 //BA.debugLineNum = 334;BA.debugLine="str2 =  reader.ReadLine";
parent._str2 = (double)(Double.parseDouble(parent.mostCurrent._reader.ReadLine()));
 //BA.debugLineNum = 335;BA.debugLine="str2 = str2 / divisor";
parent._str2 = parent._str2/(double)parent._divisor;
 //BA.debugLineNum = 336;BA.debugLine="If UnidadePeso =  \"KG\" Then";
if (true) break;

case 10:
//if
this.state = 39;
if ((parent.mostCurrent._unidadepeso).equals("KG")) { 
this.state = 12;
}else if((parent.mostCurrent._unidadepeso).equals("G")) { 
this.state = 26;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 337;BA.debugLine="If str2 <= ToleranciaMinimo Or str2 >= Tolera";
if (true) break;

case 13:
//if
this.state = 24;
if (parent._str2<=parent._toleranciaminimo || parent._str2>=parent._toleranciamaximo) { 
this.state = 15;
}else {
this.state = 23;
}if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 338;BA.debugLine="If  str2 >= (ToleranciaMinimo * 0.975) And s";
if (true) break;

case 16:
//if
this.state = 21;
if (parent._str2>=(parent._toleranciaminimo*0.975) && parent._str2<=(parent._toleranciamaximo*1.025)) { 
this.state = 18;
}else {
this.state = 20;
}if (true) break;

case 18:
//C
this.state = 21;
 //BA.debugLineNum = 339;BA.debugLine="EditTextPeso.TextColor = Colors.Yellow";
parent.mostCurrent._edittextpeso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Yellow);
 if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 341;BA.debugLine="EditTextPeso.TextColor = Colors.Red";
parent.mostCurrent._edittextpeso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 344;BA.debugLine="EditTextPeso.TextColor = Colors.Green";
parent.mostCurrent._edittextpeso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 if (true) break;

case 24:
//C
this.state = 39;
;
 //BA.debugLineNum = 346;BA.debugLine="EditTextPeso.Text = NumberFormat(str2,decimal";
parent.mostCurrent._edittextpeso.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(parent._str2,parent._decimal,(int) (1)).replace(".","")));
 //BA.debugLineNum = 347;BA.debugLine="str3 = str.BytesAvailable";
parent._str3 = parent.mostCurrent._str.BytesAvailable();
 if (true) break;

case 26:
//C
this.state = 27;
 //BA.debugLineNum = 349;BA.debugLine="If  str2 < ToleranciaMinimo Or str2 > Toleran";
if (true) break;

case 27:
//if
this.state = 38;
if (parent._str2<parent._toleranciaminimo || parent._str2>parent._toleranciamaximo) { 
this.state = 29;
}else {
this.state = 37;
}if (true) break;

case 29:
//C
this.state = 30;
 //BA.debugLineNum = 350;BA.debugLine="If  str2 >= (ToleranciaMinimo * 0.975) And s";
if (true) break;

case 30:
//if
this.state = 35;
if (parent._str2>=(parent._toleranciaminimo*0.975) && parent._str2<=(parent._toleranciamaximo*1.025)) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 35;
 //BA.debugLineNum = 351;BA.debugLine="EditTextPeso.TextColor = Colors.Red";
parent.mostCurrent._edittextpeso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 if (true) break;

case 34:
//C
this.state = 35;
 //BA.debugLineNum = 353;BA.debugLine="EditTextPeso.TextColor = Colors.Yellow";
parent.mostCurrent._edittextpeso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Yellow);
 if (true) break;

case 35:
//C
this.state = 38;
;
 if (true) break;

case 37:
//C
this.state = 38;
 //BA.debugLineNum = 356;BA.debugLine="EditTextPeso.TextColor = Colors.Green";
parent.mostCurrent._edittextpeso.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 if (true) break;

case 38:
//C
this.state = 39;
;
 //BA.debugLineNum = 358;BA.debugLine="EditTextPeso.Text = NumberFormat(str2,decimal";
parent.mostCurrent._edittextpeso.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(parent._str2,parent._decimal,(int) (1)).replace(".","")));
 //BA.debugLineNum = 359;BA.debugLine="str3 = str.BytesAvailable";
parent._str3 = parent.mostCurrent._str.BytesAvailable();
 if (true) break;

case 39:
//C
this.state = 42;
;
 if (true) break;

case 41:
//C
this.state = 42;
this.catchState = 0;
 //BA.debugLineNum = 362;BA.debugLine="EditTextPeso.Text =  \"Erro ao ler, verifique a";
parent.mostCurrent._edittextpeso.setText(BA.ObjectToCharSequence("Erro ao ler, verifique a balança."));
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
 //BA.debugLineNum = 365;BA.debugLine="Sleep(500)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (500));
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
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
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
public static String  _disablestrictmode() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _policy = null;
anywheresoftware.b4j.object.JavaObject _sm = null;
 //BA.debugLineNum = 297;BA.debugLine="Sub DisableStrictMode";
 //BA.debugLineNum = 298;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 299;BA.debugLine="jo.InitializeStatic(\"android.os.Build.VERSION\")";
_jo.InitializeStatic("android.os.Build.VERSION");
 //BA.debugLineNum = 300;BA.debugLine="If jo.GetField(\"SDK_INT\") > 9 Then";
if ((double)(BA.ObjectToNumber(_jo.GetField("SDK_INT")))>9) { 
 //BA.debugLineNum = 301;BA.debugLine="Dim policy As JavaObject";
_policy = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 302;BA.debugLine="policy = policy.InitializeNewInstance(\"android.o";
_policy = _policy.InitializeNewInstance("android.os.StrictMode.ThreadPolicy.Builder",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 303;BA.debugLine="policy = policy.RunMethodJO(\"permitAll\", Null).R";
_policy = _policy.RunMethodJO("permitAll",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethodJO("build",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 304;BA.debugLine="Dim sm As JavaObject";
_sm = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 305;BA.debugLine="sm.InitializeStatic(\"android.os.StrictMode\").Run";
_sm.InitializeStatic("android.os.StrictMode").RunMethod("setThreadPolicy",new Object[]{(Object)(_policy.getObject())});
 };
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private ButtonSair As Button";
mostCurrent._buttonsair = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ButtonLogin As Button";
mostCurrent._buttonlogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private LabelClock As Label";
mostCurrent._labelclock = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private ImageAplipack As ImageView";
mostCurrent._imageaplipack = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private ButtonMenu As Button";
mostCurrent._buttonmenu = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim panelMain As Panel";
mostCurrent._panelmain = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim panelLogin As Panel";
mostCurrent._panellogin = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim panelMenu As Panel";
mostCurrent._panelmenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim panelConexao As Panel";
mostCurrent._panelconexao = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim panelPesagem As Panel";
mostCurrent._panelpesagem = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim panelUsuarios As Panel";
mostCurrent._panelusuarios = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Dim panelWebservice As Panel";
mostCurrent._panelwebservice = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim panelProdutos As Panel";
mostCurrent._panelprodutos = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Dim SelecionaCUC As Panel";
mostCurrent._selecionacuc = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private ButtonTelaLogin As Button";
mostCurrent._buttontelalogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private ButtonlLimpar As Button";
mostCurrent._buttonllimpar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private EditTextUser As EditText";
mostCurrent._edittextuser = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private EditTextPassword As EditText";
mostCurrent._edittextpassword = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private ButtonTelaMenu As Button";
mostCurrent._buttontelamenu = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Dim str As InputStream";
mostCurrent._str = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Dim str2 As Double";
_str2 = 0;
 //BA.debugLineNum = 44;BA.debugLine="Dim str3 As Int";
_str3 = 0;
 //BA.debugLineNum = 45;BA.debugLine="Dim reader As TextReader";
mostCurrent._reader = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private ButtonTelaMain As Button";
mostCurrent._buttontelamain = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private ButtonTelaLeitura As Button";
mostCurrent._buttontelaleitura = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private EditTextIP As EditText";
mostCurrent._edittextip = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private EditTextPorta As EditText";
mostCurrent._edittextporta = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private ButtonManualSoftware As Button";
mostCurrent._buttonmanualsoftware = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private ButtonConcluirPesagem As Button";
mostCurrent._buttonconcluirpesagem = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private EditTextPeso As EditText";
mostCurrent._edittextpeso = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private ButtonSairPeso As Button";
mostCurrent._buttonsairpeso = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private ButtonCadastraBalnca As Button";
mostCurrent._buttoncadastrabalnca = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Dim myABBarcode As ABZxing";
mostCurrent._myabbarcode = new com.AB.ABZxing.ABZxing();
 //BA.debugLineNum = 56;BA.debugLine="Private ButtonLeituraBarcode As Button";
mostCurrent._buttonleiturabarcode = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private EditTextProduto As EditText";
mostCurrent._edittextproduto = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private EditTextFabricacao As EditText";
mostCurrent._edittextfabricacao = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private EditTextValidadePdoruo As EditText";
mostCurrent._edittextvalidadepdoruo = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private EditTextLote As EditText";
mostCurrent._edittextlote = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 62;BA.debugLine="Dim j As Int";
_j = 0;
 //BA.debugLineNum = 63;BA.debugLine="Dim count As Int";
_count = 0;
 //BA.debugLineNum = 64;BA.debugLine="Dim filename As String";
mostCurrent._filename = "";
 //BA.debugLineNum = 65;BA.debugLine="Dim listPosition As String";
mostCurrent._listposition = "";
 //BA.debugLineNum = 66;BA.debugLine="Private EditTextNomeBalanca As EditText";
mostCurrent._edittextnomebalanca = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private ButtonGravarDB As Button";
mostCurrent._buttongravardb = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private ListViewBalanca As ListView";
mostCurrent._listviewbalanca = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private ListViewTelaBalanca As ListView";
mostCurrent._listviewtelabalanca = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private ButtonVoltarMenuUsuarios As Button";
mostCurrent._buttonvoltarmenuusuarios = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private ButtonUsuarios As Button";
mostCurrent._buttonusuarios = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private ButtonWebservice As Button";
mostCurrent._buttonwebservice = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Private ButtonTelawebserviceMenu As Button";
mostCurrent._buttontelawebservicemenu = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private ButtonProdutosVolta As Button";
mostCurrent._buttonprodutosvolta = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private ButtonCadastroProduto As Button";
mostCurrent._buttoncadastroproduto = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private ListViewTipoPesagem As ListView";
mostCurrent._listviewtipopesagem = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private EditTextWebserviceIP As EditText";
mostCurrent._edittextwebserviceip = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private EditTextWebservicePorta As EditText";
mostCurrent._edittextwebserviceporta = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private ButtonWebserviceAlterar As Button";
mostCurrent._buttonwebservicealterar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private EditTextXML As EditText";
mostCurrent._edittextxml = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private ButtonBalancaUp As Button";
mostCurrent._buttonbalancaup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 82;BA.debugLine="Private ButtonBalancaDown As Button";
mostCurrent._buttonbalancadown = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private ButtonBalanaAlterar As Button";
mostCurrent._buttonbalanaalterar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 84;BA.debugLine="Private ButtonDeletarBalanca As Button";
mostCurrent._buttondeletarbalanca = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private Usertext As EditText";
mostCurrent._usertext = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Private ListViewUsuarios As ListView";
mostCurrent._listviewusuarios = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 87;BA.debugLine="Private ListViewAcesso As ListView";
mostCurrent._listviewacesso = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Private EditTextNomeUsuario As EditText";
mostCurrent._edittextnomeusuario = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 89;BA.debugLine="Private ButtonGravarUusario As Button";
mostCurrent._buttongravaruusario = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private ButtonAlterarUsuario As Button";
mostCurrent._buttonalterarusuario = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 91;BA.debugLine="Private ButtonUserUp As Button";
mostCurrent._buttonuserup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 92;BA.debugLine="Private ButtonUserDown As Button";
mostCurrent._buttonuserdown = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 93;BA.debugLine="Dim PositionUser As Int = 0";
_positionuser = (int) (0);
 //BA.debugLineNum = 94;BA.debugLine="Dim PositionDB As Int = 1";
_positiondb = (int) (1);
 //BA.debugLineNum = 95;BA.debugLine="Dim positionDB2 As Int = 1";
_positiondb2 = (int) (1);
 //BA.debugLineNum = 96;BA.debugLine="Private ButtonNivelUp As Button";
mostCurrent._buttonnivelup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 97;BA.debugLine="Private ButtonNivelDown As Button";
mostCurrent._buttonniveldown = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 98;BA.debugLine="Dim PositionNivel As Int = 0";
_positionnivel = (int) (0);
 //BA.debugLineNum = 99;BA.debugLine="Dim idusuario As Int = 0";
_idusuario = (int) (0);
 //BA.debugLineNum = 100;BA.debugLine="Private ButtonApagarUsuario As Button";
mostCurrent._buttonapagarusuario = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 101;BA.debugLine="Private EditTextNomeProduto As EditText";
mostCurrent._edittextnomeproduto = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 102;BA.debugLine="Private EditTextCodigoProduto As EditText";
mostCurrent._edittextcodigoproduto = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 103;BA.debugLine="Private EditTextCodigoCuc As EditText";
mostCurrent._edittextcodigocuc = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 104;BA.debugLine="Private ButtonGravarProduto As Button";
mostCurrent._buttongravarproduto = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 105;BA.debugLine="Private ButtonProdutoAlterar As Button";
mostCurrent._buttonprodutoalterar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 106;BA.debugLine="Private ListViewProdutosCUC As ListView";
mostCurrent._listviewprodutoscuc = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 107;BA.debugLine="Private EditTextPordutoCUC As EditText";
mostCurrent._edittextpordutocuc = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 108;BA.debugLine="Private ButtonMenuCUC As Button";
mostCurrent._buttonmenucuc = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 109;BA.debugLine="Private ButtonCarregarCUC As Button";
mostCurrent._buttoncarregarcuc = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 110;BA.debugLine="Private EditTextDescricaoCUC As EditText";
mostCurrent._edittextdescricaocuc = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Private ListViewCUC As ListView";
mostCurrent._listviewcuc = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 112;BA.debugLine="Private EditTextCodigoCUCTela As EditText";
mostCurrent._edittextcodigocuctela = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 113;BA.debugLine="Private ButtonApgarProdutoCUC As Button";
mostCurrent._buttonapgarprodutocuc = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 114;BA.debugLine="Private NivelUsuario As String=0";
mostCurrent._nivelusuario = BA.NumberToString(0);
 //BA.debugLineNum = 115;BA.debugLine="Private ListViewCUCMain As ListView";
mostCurrent._listviewcucmain = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 116;BA.debugLine="Private ListViewCUCPesagem As ListView";
mostCurrent._listviewcucpesagem = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 117;BA.debugLine="Private Peso As Double";
_peso = 0;
 //BA.debugLineNum = 118;BA.debugLine="Private UnidadePeso As String";
mostCurrent._unidadepeso = "";
 //BA.debugLineNum = 119;BA.debugLine="Dim ToleranciaMinimo As Double";
_toleranciaminimo = 0;
 //BA.debugLineNum = 120;BA.debugLine="Dim ToleranciaMaximo As Double";
_toleranciamaximo = 0;
 //BA.debugLineNum = 121;BA.debugLine="Dim URLglobal As String";
mostCurrent._urlglobal = "";
 //BA.debugLineNum = 122;BA.debugLine="Dim PosBalanca As Int = 0";
_posbalanca = (int) (0);
 //BA.debugLineNum = 123;BA.debugLine="Private ButtonTelaLoginVolta As Button";
mostCurrent._buttontelaloginvolta = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 124;BA.debugLine="Dim ListOrdemProdSAP As List";
mostCurrent._listordemprodsap = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 125;BA.debugLine="Dim ListProdutosPesagem As List";
mostCurrent._listprodutospesagem = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 126;BA.debugLine="Private ListViewCampanha As ListView";
mostCurrent._listviewcampanha = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 127;BA.debugLine="Dim Campanha As String";
mostCurrent._campanha = "";
 //BA.debugLineNum = 128;BA.debugLine="Dim Cod As String";
mostCurrent._cod = "";
 //BA.debugLineNum = 129;BA.debugLine="Dim PesoRota1 As Double";
_pesorota1 = 0;
 //BA.debugLineNum = 130;BA.debugLine="Dim PesoAlvo As Double";
_pesoalvo = 0;
 //BA.debugLineNum = 131;BA.debugLine="Dim UnidadeAlvo As String";
mostCurrent._unidadealvo = "";
 //BA.debugLineNum = 132;BA.debugLine="Dim IdPesagemProg As String";
mostCurrent._idpesagemprog = "";
 //BA.debugLineNum = 133;BA.debugLine="Private ButtonEmbalagem As Button";
mostCurrent._buttonembalagem = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 134;BA.debugLine="Dim EmbFechada As Double";
_embfechada = 0;
 //BA.debugLineNum = 135;BA.debugLine="Dim XMLCurrent As String";
mostCurrent._xmlcurrent = "";
 //BA.debugLineNum = 136;BA.debugLine="Dim XMLwork As String";
mostCurrent._xmlwork = "";
 //BA.debugLineNum = 137;BA.debugLine="Dim divisor As Int = 0";
_divisor = (int) (0);
 //BA.debugLineNum = 138;BA.debugLine="Dim decimal As Int = 0";
_decimal = (int) (0);
 //BA.debugLineNum = 139;BA.debugLine="Private EditTextDivisor As EditText";
mostCurrent._edittextdivisor = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 140;BA.debugLine="Private EditTextDecimais As EditText";
mostCurrent._edittextdecimais = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static void  _listviewbalanca_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewBalanca_ItemClick rsub = new ResumableSub_ListViewBalanca_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewBalanca_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewBalanca_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";

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
 //BA.debugLineNum = 1181;BA.debugLine="Sleep(2)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (2));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 //BA.debugLineNum = 1182;BA.debugLine="Try";
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
 //BA.debugLineNum = 1183;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE idBalancas="+BA.ObjectToString(_value)+";";
 //BA.debugLineNum = 1184;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1185;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1186;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 //BA.debugLineNum = 1187;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1188;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1189;BA.debugLine="EditTextNomeBalanca.Text = \"Balança \"&XMLwork.Su";
parent.mostCurrent._edittextnomebalanca.setText(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+10),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"));
 //BA.debugLineNum = 1190;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
parent.mostCurrent._edittextip.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<ipbalanca>")+11),parent.mostCurrent._xmlwork.indexOf("</ipbalanca>"))));
 //BA.debugLineNum = 1191;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
parent.mostCurrent._edittextporta.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<portabalanca>")+14),parent.mostCurrent._xmlwork.indexOf("</portabalanca>"))));
 //BA.debugLineNum = 1192;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwor";
parent.mostCurrent._edittextdivisor.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 1193;BA.debugLine="decimal = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
parent._decimal = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<decimais>")+10),parent.mostCurrent._xmlwork.indexOf("</decimais>"))));
 //BA.debugLineNum = 1194;BA.debugLine="divisor = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
parent._divisor = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 1195;BA.debugLine="DisableStrictMode";
_disablestrictmode();
 //BA.debugLineNum = 1196;BA.debugLine="CallSubDelayed(Me,\"Connect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,main.getObject(),"Connect");
 if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 //BA.debugLineNum = 1198;BA.debugLine="MsgboxAsync(\"Não foi possivel se conectar com a";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Não foi possivel se conectar com a balança"),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1200;BA.debugLine="End Sub";
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
public static void  _listviewcampanha_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewCampanha_ItemClick rsub = new ResumableSub_ListViewCampanha_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewCampanha_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCampanha_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";
int step13;
int limit13;

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
 //BA.debugLineNum = 1316;BA.debugLine="Try";
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
 //BA.debugLineNum = 1317;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="+BA.ObjectToString(_value)+";";
 //BA.debugLineNum = 1318;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1319;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1320;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 //BA.debugLineNum = 1321;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1322;BA.debugLine="Campanha =  Value";
parent.mostCurrent._campanha = BA.ObjectToString(_value);
 //BA.debugLineNum = 1323;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 4:
//if
this.state = 11;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1324;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.L";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1325;BA.debugLine="XMLCurrent = XMLwork.SubString2(XMLwork.IndexOf";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 1326;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 1327;BA.debugLine="ListProdutosPesagem.Clear";
parent.mostCurrent._listprodutospesagem.Clear();
 //BA.debugLineNum = 1328;BA.debugLine="For i=1 To count-1";
if (true) break;

case 7:
//for
this.state = 10;
step13 = 1;
limit13 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 16;
if (true) break;

case 16:
//C
this.state = 10;
if ((step13 > 0 && parent._i <= limit13) || (step13 < 0 && parent._i >= limit13)) this.state = 9;
if (true) break;

case 17:
//C
this.state = 16;
parent._i = ((int)(0 + parent._i + step13)) ;
if (true) break;

case 9:
//C
this.state = 17;
 //BA.debugLineNum = 1329;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent.SubString2(";
parent.mostCurrent._listprodutospesagem.Add((Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<CodigoMaterial>")+16),parent.mostCurrent._xmlcurrent.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1330;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurrent.S";
parent.mostCurrent._listviewcucpesagem.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<CodigoMaterial>")+16),parent.mostCurrent._xmlcurrent.indexOf("</CodigoMaterial>"))+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<DescricaoMaterial>")+19),parent.mostCurrent._xmlcurrent.indexOf("</DescricaoMaterial>")).trim()+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<Peso>")+6),parent.mostCurrent._xmlcurrent.indexOf("</Peso>"))+" "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<Unidade>")+9),parent.mostCurrent._xmlcurrent.indexOf("</Unidade>"))+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<EmbFechada>")+12),parent.mostCurrent._xmlcurrent.indexOf("</EmbFechada>"))+" "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<Unidade>")+9),parent.mostCurrent._xmlcurrent.indexOf("</Unidade>"))+" ("+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<UnidadeEmb>")+12),parent.mostCurrent._xmlcurrent.indexOf("</UnidadeEmb>"))+") | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<PesoRota1>")+11),parent.mostCurrent._xmlcurrent.indexOf("</PesoRota1>"))+" | "+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<PesoRota2>")+11),parent.mostCurrent._xmlcurrent.indexOf("</PesoRota2>"))),(Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<CodigoMaterial>")+16),parent.mostCurrent._xmlcurrent.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1331;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1332;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 //BA.debugLineNum = 1336;BA.debugLine="MsgboxAsync(\"Erro ao carregar as campanhas\", \"Er";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao carregar as campanhas"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1338;BA.debugLine="End Sub";
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
public static void  _listviewcuc_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewCUC_ItemClick rsub = new ResumableSub_ListViewCUC_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewCUC_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCUC_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 972;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELEC";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT codigoCUC, descricaoCUC, row_number() OVER (order by idproduto_cuc) as row_num from unilever_pi.produto_cuc group by (codigoCUC)) t WHERE codigoCUC="+BA.ObjectToString(_value)+";";
 //BA.debugLineNum = 973;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 974;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\")";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 975;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 976;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 977;BA.debugLine="EditTextDescricaoCUC.Text  = XMLwork.SubString2(X";
parent.mostCurrent._edittextdescricaocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<descricaoCUC>")+14),parent.mostCurrent._xmlwork.indexOf("</descricaoCUC>"))));
 //BA.debugLineNum = 978;BA.debugLine="EditTextCodigoCuc.Text =  XMLwork.SubString2(XMLw";
parent.mostCurrent._edittextcodigocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<codigoCUC>")+11),parent.mostCurrent._xmlwork.indexOf("</codigoCUC>"))));
 //BA.debugLineNum = 979;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _listviewcucmain_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewCUCMain_ItemClick rsub = new ResumableSub_ListViewCUCMain_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewCUCMain_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCUCMain_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";
String _xmlwork3 = "";
int _count2 = 0;
String _xmlcurrent2 = "";
int _x = 0;
int step16;
int limit16;
int step28;
int limit28;

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
 //BA.debugLineNum = 982;BA.debugLine="If NivelUsuario=0 Then";
if (true) break;

case 1:
//if
this.state = 28;
if ((parent.mostCurrent._nivelusuario).equals(BA.NumberToString(0))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 28;
 //BA.debugLineNum = 983;BA.debugLine="MsgboxAsync(\"É necessario logar prmeiro\",\"Aviso\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("É necessario logar prmeiro"),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 985;BA.debugLine="Try";
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
 //BA.debugLineNum = 986;BA.debugLine="IdPesagemProg =  Value";
parent.mostCurrent._idpesagemprog = BA.ObjectToString(_value);
 //BA.debugLineNum = 987;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idCampanha, idPesagemProg, DataHora, Usuario, IdProcesso, Impresso, row_number() OVER (order by idCampanha) as row_num FROM unilever_pi.campanha WHERE idPesagemProg="+parent.mostCurrent._idpesagemprog+";";
 //BA.debugLineNum = 988;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 989;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 990;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 29;
return;
case 29:
//C
this.state = 9;
;
 //BA.debugLineNum = 991;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 992;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 9:
//if
this.state = 24;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 993;BA.debugLine="Dim count As Int = XMLwork.SubString2(XMLwork.";
parent._count = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.lastIndexOf("<row_num>")+9),parent.mostCurrent._xmlwork.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 994;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 995;BA.debugLine="XMLCurrent = XMLwork.SubString2(5,XMLwork.Inde";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
 //BA.debugLineNum = 996;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 997;BA.debugLine="For i=1 To count-1";
if (true) break;

case 12:
//for
this.state = 23;
step16 = 1;
limit16 = (int) (parent._count-1);
parent._i = (int) (1) ;
this.state = 30;
if (true) break;

case 30:
//C
this.state = 23;
if ((step16 > 0 && parent._i <= limit16) || (step16 < 0 && parent._i >= limit16)) this.state = 14;
if (true) break;

case 31:
//C
this.state = 30;
parent._i = ((int)(0 + parent._i + step16)) ;
if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 998;BA.debugLine="If i=1 Then";
if (true) break;

case 15:
//if
this.state = 22;
if (parent._i==1) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 999;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuery";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="+parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))+";";
 //BA.debugLineNum = 1000;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1001;BA.debugLine="Job1.GetRequest.SetContentType(\"application/";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1002;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 32;
return;
case 32:
//C
this.state = 18;
;
 //BA.debugLineNum = 1003;BA.debugLine="Dim XMLwork3 As String = Job1.GetString";
_xmlwork3 = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1004;BA.debugLine="Dim count2 As Int = XMLwork3.SubString2(XMLw";
_count2 = (int)(Double.parseDouble(_xmlwork3.substring((int) (_xmlwork3.lastIndexOf("<row_num>")+9),_xmlwork3.lastIndexOf("</row_num>"))));
 //BA.debugLineNum = 1005;BA.debugLine="Dim XMLCurrent2 As String = XMLwork3.SubStri";
_xmlcurrent2 = _xmlwork3.substring((int) (_xmlwork3.indexOf("<SQL>")+5),_xmlwork3.indexOf("</SQL>"));
 //BA.debugLineNum = 1006;BA.debugLine="Campanha =  XMLCurrent.SubString2(XMLCurrent";
parent.mostCurrent._campanha = parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"));
 //BA.debugLineNum = 1007;BA.debugLine="ListViewCUCPesagem.Clear";
parent.mostCurrent._listviewcucpesagem.Clear();
 //BA.debugLineNum = 1008;BA.debugLine="ListProdutosPesagem.Clear";
parent.mostCurrent._listprodutospesagem.Clear();
 //BA.debugLineNum = 1009;BA.debugLine="For x=1 To count2-1";
if (true) break;

case 18:
//for
this.state = 21;
step28 = 1;
limit28 = (int) (_count2-1);
_x = (int) (1) ;
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
if (true) break;

case 20:
//C
this.state = 34;
 //BA.debugLineNum = 1010;BA.debugLine="ListProdutosPesagem.Add(XMLCurrent2.SubStri";
parent.mostCurrent._listprodutospesagem.Add((Object)(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1011;BA.debugLine="ListViewCUCPesagem.AddSingleLine2(XMLCurren";
parent.mostCurrent._listviewcucpesagem.AddSingleLine2(BA.ObjectToCharSequence(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<DescricaoMaterial>")+19),_xmlcurrent2.indexOf("</DescricaoMaterial>")).trim()+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Peso>")+6),_xmlcurrent2.indexOf("</Peso>"))+" "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Unidade>")+9),_xmlcurrent2.indexOf("</Unidade>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<EmbFechada>")+12),_xmlcurrent2.indexOf("</EmbFechada>"))+" "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<Unidade>")+9),_xmlcurrent2.indexOf("</Unidade>"))+" ("+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<UnidadeEmb>")+12),_xmlcurrent2.indexOf("</UnidadeEmb>"))+") | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<PesoRota1>")+11),_xmlcurrent2.indexOf("</PesoRota1>"))+" | "+_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<PesoRota2>")+11),_xmlcurrent2.indexOf("</PesoRota2>"))),(Object)(_xmlcurrent2.substring((int) (_xmlcurrent2.indexOf("<CodigoMaterial>")+16),_xmlcurrent2.indexOf("</CodigoMaterial>"))));
 //BA.debugLineNum = 1012;BA.debugLine="XMLwork3 = XMLwork3.SubString(XMLwork3.Inde";
_xmlwork3 = _xmlwork3.substring((int) (_xmlwork3.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1013;BA.debugLine="XMLCurrent2 =  XMLwork3.SubString2(XMLwork3";
_xmlcurrent2 = _xmlwork3.substring((int) (_xmlwork3.indexOf("<SQL>")+5),_xmlwork3.indexOf("</SQL>"));
 if (true) break;
if (true) break;

case 21:
//C
this.state = 22;
;
 if (true) break;

case 22:
//C
this.state = 31;
;
 //BA.debugLineNum = 1016;BA.debugLine="ListViewCampanha.AddSingleLine2(XMLCurrent.Sub";
parent.mostCurrent._listviewcampanha.AddSingleLine2(BA.ObjectToCharSequence(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))),(Object)(parent.mostCurrent._xmlcurrent.substring((int) (parent.mostCurrent._xmlcurrent.indexOf("<idCampanha>")+12),parent.mostCurrent._xmlcurrent.indexOf("</idCampanha>"))));
 //BA.debugLineNum = 1017;BA.debugLine="XMLwork = XMLwork.SubString(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("</SQL>")+6));
 //BA.debugLineNum = 1018;BA.debugLine="XMLCurrent =  XMLwork.SubString2(XMLwork.Index";
parent.mostCurrent._xmlcurrent = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<SQL>")+5),parent.mostCurrent._xmlwork.indexOf("</SQL>"));
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
 //BA.debugLineNum = 1021;BA.debugLine="panelPesagem.Visible =  True";
parent.mostCurrent._panelpesagem.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1022;BA.debugLine="panelMain.Visible =  False";
parent.mostCurrent._panelmain.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 26:
//C
this.state = 27;
this.catchState = 0;
 //BA.debugLineNum = 1024;BA.debugLine="MsgboxAsync(\"Erro ao carregar os produtos.\",\"Er";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao carregar os produtos."),BA.ObjectToCharSequence("Erro"),processBA);
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
 //BA.debugLineNum = 1027;BA.debugLine="End Sub";
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
public static void  _listviewcucpesagem_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewCUCPesagem_ItemClick rsub = new ResumableSub_ListViewCUCPesagem_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewCUCPesagem_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewCUCPesagem_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";

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
 //BA.debugLineNum = 1394;BA.debugLine="Try";
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
 //BA.debugLineNum = 1395;BA.debugLine="Cod = Value";
parent.mostCurrent._cod = BA.ObjectToString(_value);
 //BA.debugLineNum = 1396;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idPesagemReceita, IdCampanha, Peso, Unidade, PesoMin, PesoMax, CodigoMaterial, Obrigatorio, DescricaoMaterial, EmbFechada, UnidadeEmb, PesoRota1, PesoRota2, PesoRota3, FaseProd, QuantPesagem, NumeroMix, Alergenico, PesoRota4, row_number() OVER (order by idPesagemReceita) as row_num FROM unilever_pi.pesagemreceita WHERE IdCampanha="+parent.mostCurrent._campanha+" AND CodigoMaterial="+BA.ObjectToString(_value)+";";
 //BA.debugLineNum = 1397;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1398;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1399;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 15;
return;
case 15:
//C
this.state = 4;
;
 //BA.debugLineNum = 1400;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1401;BA.debugLine="If XMLwork.Contains(\"<SQL>\")= True Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 1402;BA.debugLine="PesoRota1 = XMLwork.SubString2(XMLwork.IndexOf(";
parent._pesorota1 = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<PesoRota1>")+11),parent.mostCurrent._xmlwork.indexOf("</PesoRota1>"))));
 //BA.debugLineNum = 1403;BA.debugLine="EmbFechada = XMLwork.SubString2(XMLwork.IndexOf";
parent._embfechada = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<EmbFechada>")+12),parent.mostCurrent._xmlwork.indexOf("</EmbFechada>"))));
 //BA.debugLineNum = 1404;BA.debugLine="PesoAlvo = XMLwork.SubString2(XMLwork.IndexOf(\"";
parent._pesoalvo = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Peso>")+6),parent.mostCurrent._xmlwork.indexOf("</Peso>")).replace(".","")));
 //BA.debugLineNum = 1405;BA.debugLine="UnidadeAlvo = XMLwork.SubString2(XMLwork.IndexO";
parent.mostCurrent._unidadealvo = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Unidade>")+9),parent.mostCurrent._xmlwork.indexOf("</Unidade>"));
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 1407;BA.debugLine="PesoAlvo = PesoAlvo-PesoRota1";
parent._pesoalvo = parent._pesoalvo-parent._pesorota1;
 //BA.debugLineNum = 1408;BA.debugLine="UnidadeAlvo =  \"G\"";
parent.mostCurrent._unidadealvo = "G";
 //BA.debugLineNum = 1409;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT (pesoMinimo-Tolerancia) As PesoMinimo, (pesoMaximo+Tolerancia) As PesoMaximo FROM unilever_pi.tolerancia WHERE "+BA.NumberToString(parent._pesoalvo)+" >= PesoMinimo AND "+BA.NumberToString(parent._pesoalvo)+" <= PesoMaximo AND UM='"+parent.mostCurrent._unidadealvo+"' LIMIT 1;";
 //BA.debugLineNum = 1410;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1411;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1412;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 16;
return;
case 16:
//C
this.state = 8;
;
 //BA.debugLineNum = 1413;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1414;BA.debugLine="Job1.Release";
parent._job1._release /*String*/ ();
 //BA.debugLineNum = 1415;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 8:
//if
this.state = 11;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 1416;BA.debugLine="ToleranciaMinimo = XMLwork.SubString2(XMLwork.I";
parent._toleranciaminimo = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<PesoMinimo>")+12),parent.mostCurrent._xmlwork.indexOf("</PesoMinimo>"))));
 //BA.debugLineNum = 1417;BA.debugLine="ToleranciaMaximo = XMLwork.SubString2(XMLwork.I";
parent._toleranciamaximo = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<PesoMaximo>")+12),parent.mostCurrent._xmlwork.indexOf("</PesoMaximo>"))));
 if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
this.catchState = 0;
 //BA.debugLineNum = 1420;BA.debugLine="MsgboxAsync(\"Erro ao carregar as campanhas\", \"Er";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao carregar as campanhas"),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1422;BA.debugLine="End Sub";
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
public static void  _listviewprodutoscuc_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewProdutosCUC_ItemClick rsub = new ResumableSub_ListViewProdutosCUC_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewProdutosCUC_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewProdutosCUC_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";

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
 //BA.debugLineNum = 920;BA.debugLine="Try";
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
 //BA.debugLineNum = 921;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM (SELECT idproduto_CUC, codigoCUC, descricaoCUC, codigomaterial, descricaomaterial, row_number() OVER (order by idproduto_cuc) as row_num from unilever_pi.produto_cuc) t WHERE codigomaterial="+BA.ObjectToString(_value)+" AND codigoCUC="+parent.mostCurrent._edittextcodigocuc.getText()+";";
 //BA.debugLineNum = 922;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 923;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 924;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 //BA.debugLineNum = 925;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 926;BA.debugLine="EditTextPordutoCUC.Text =  EditTextDescricaoCUC.";
parent.mostCurrent._edittextpordutocuc.setText(BA.ObjectToCharSequence(parent.mostCurrent._edittextdescricaocuc.getText()));
 //BA.debugLineNum = 927;BA.debugLine="EditTextNomeProduto.Text  = XMLwork.SubString2(X";
parent.mostCurrent._edittextnomeproduto.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<descricaomaterial>")+19),parent.mostCurrent._xmlwork.indexOf("</descricaomaterial>"))));
 //BA.debugLineNum = 928;BA.debugLine="EditTextCodigoProduto.Text = Value";
parent.mostCurrent._edittextcodigoproduto.setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 929;BA.debugLine="EditTextCodigoCUCTela.Text =  EditTextCodigoCuc.";
parent.mostCurrent._edittextcodigocuctela.setText(BA.ObjectToCharSequence(parent.mostCurrent._edittextcodigocuc.getText()));
 if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 //BA.debugLineNum = 931;BA.debugLine="MsgboxAsync(\"Erro ao ler.\",\"Erro\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Erro ao ler."),BA.ObjectToCharSequence("Erro"),processBA);
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 933;BA.debugLine="End Sub";
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
public static void  _listviewtelabalanca_itemclick(int _position,Object _value) throws Exception{
ResumableSub_ListViewTelaBalanca_ItemClick rsub = new ResumableSub_ListViewTelaBalanca_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_ListViewTelaBalanca_ItemClick extends BA.ResumableSub {
public ResumableSub_ListViewTelaBalanca_ItemClick(wrong.addition.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
wrong.addition.main parent;
int _position;
Object _value;
String _url = "";

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
 //BA.debugLineNum = 1203;BA.debugLine="Try";
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
 //BA.debugLineNum = 1204;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySELE";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais, row_number() OVER (order by idBalancas) as row_num FROM (SELECT idbalancas, tipopeso, tipocom, portaserial, bauderate, parity, databits, encoding, ipbalanca, portabalanca, divisor, decimais from unilever_pi.balancas) t WHERE idBalancas="+BA.ObjectToString(_value)+";";
 //BA.debugLineNum = 1205;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1206;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML\"";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1207;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 13;
return;
case 13:
//C
this.state = 4;
;
 //BA.debugLineNum = 1208;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1209;BA.debugLine="XMLwork =  XMLwork.SubString2(XMLwork.IndexOf(\"<";
parent.mostCurrent._xmlwork = parent.mostCurrent._xmlwork.substring(parent.mostCurrent._xmlwork.indexOf("<SQL>"),(int) (parent.mostCurrent._xmlwork.lastIndexOf("</SQL>")+6));
 //BA.debugLineNum = 1210;BA.debugLine="EditTextNomeBalanca.Text = \"Balança \"&XMLwork.Su";
parent.mostCurrent._edittextnomebalanca.setText(BA.ObjectToCharSequence("Balança "+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<idbalancas>")+10),parent.mostCurrent._xmlwork.indexOf("</idbalancas>"))+" ("+parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))+")"));
 //BA.debugLineNum = 1211;BA.debugLine="EditTextIP.Text = XMLwork.SubString2(XMLwork.Ind";
parent.mostCurrent._edittextip.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<ipbalanca>")+11),parent.mostCurrent._xmlwork.indexOf("</ipbalanca>"))));
 //BA.debugLineNum = 1212;BA.debugLine="EditTextPorta.Text = XMLwork.SubString2(XMLwork.";
parent.mostCurrent._edittextporta.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<portabalanca>")+14),parent.mostCurrent._xmlwork.indexOf("</portabalanca>"))));
 //BA.debugLineNum = 1213;BA.debugLine="EditTextDivisor.Text = XMLwork.SubString2(XMLwor";
parent.mostCurrent._edittextdivisor.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 1214;BA.debugLine="EditTextDecimais.Text = XMLwork.SubString2(XMLwo";
parent.mostCurrent._edittextdecimais.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<decimais>")+10),parent.mostCurrent._xmlwork.indexOf("</decimais>"))));
 //BA.debugLineNum = 1215;BA.debugLine="decimal = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
parent._decimal = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<decimais>")+10),parent.mostCurrent._xmlwork.indexOf("</decimais>"))));
 //BA.debugLineNum = 1216;BA.debugLine="divisor = XMLwork.SubString2(XMLwork.IndexOf(\"<d";
parent._divisor = (int)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<divisor>")+9),parent.mostCurrent._xmlwork.indexOf("</divisor>"))));
 //BA.debugLineNum = 1217;BA.debugLine="If  XMLwork.SubString2(XMLwork.IndexOf(\"<tipopes";
if (true) break;

case 4:
//if
this.state = 9;
if ((parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<tipopeso>")+10),parent.mostCurrent._xmlwork.indexOf("</tipopeso>"))).equals("g")) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 1218;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 1219;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 1220;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 1221;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1223;BA.debugLine="ListViewTipoPesagem.Clear";
parent.mostCurrent._listviewtipopesagem.Clear();
 //BA.debugLineNum = 1224;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"kg\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("kg"));
 //BA.debugLineNum = 1225;BA.debugLine="ListViewTipoPesagem.AddSingleLine(\"g\")";
parent.mostCurrent._listviewtipopesagem.AddSingleLine(BA.ObjectToCharSequence("g"));
 //BA.debugLineNum = 1226;BA.debugLine="ListViewTipoPesagem.SetSelection(0)";
parent.mostCurrent._listviewtipopesagem.SetSelection((int) (0));
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
 //BA.debugLineNum = 1229;BA.debugLine="MsgboxAsync(\"Eoo ao carregar a balança.\",\"Aviso\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Eoo ao carregar a balança."),BA.ObjectToCharSequence("Aviso"),processBA);
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 1231;BA.debugLine="End Sub";
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
public static String  _listviewtipopesagem_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 1233;BA.debugLine="Sub ListViewTipoPesagem_ItemClick (Position As Int";
 //BA.debugLineNum = 1234;BA.debugLine="listPosition =  Value";
mostCurrent._listposition = BA.ObjectToString(_value);
 //BA.debugLineNum = 1235;BA.debugLine="End Sub";
return "";
}
public static void  _myabbarcode_barcodefound(String _barcode,String _formatname) throws Exception{
ResumableSub_myABBarcode_BarcodeFound rsub = new ResumableSub_myABBarcode_BarcodeFound(null,_barcode,_formatname);
rsub.resume(processBA, null);
}
public static class ResumableSub_myABBarcode_BarcodeFound extends BA.ResumableSub {
public ResumableSub_myABBarcode_BarcodeFound(wrong.addition.main parent,String _barcode,String _formatname) {
this.parent = parent;
this._barcode = _barcode;
this._formatname = _formatname;
}
wrong.addition.main parent;
String _barcode;
String _formatname;
String _lote = "";
double _cod2 = 0;
String _url = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1049;BA.debugLine="If barCode.Length=32 Then";
if (true) break;

case 1:
//if
this.state = 22;
if (_barcode.length()==32) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 22;
 //BA.debugLineNum = 1050;BA.debugLine="barCode =  barCode.SubString2(16,32)";
_barcode = _barcode.substring((int) (16),(int) (32));
 //BA.debugLineNum = 1051;BA.debugLine="EditTextValidadePdoruo.Text = barCode.SubString2";
parent.mostCurrent._edittextvalidadepdoruo.setText(BA.ObjectToCharSequence(_barcode.substring((int) (2),(int) (8))));
 //BA.debugLineNum = 1052;BA.debugLine="EditTextValidadePdoruo.Text = EditTextValidadePd";
parent.mostCurrent._edittextvalidadepdoruo.setText(BA.ObjectToCharSequence(parent.mostCurrent._edittextvalidadepdoruo.getText().substring((int) (4),(int) (6))+"/"+parent.mostCurrent._edittextvalidadepdoruo.getText().substring((int) (2),(int) (4))+"/"+parent.mostCurrent._edittextvalidadepdoruo.getText().substring((int) (0),(int) (2))));
 //BA.debugLineNum = 1053;BA.debugLine="EditTextFabricacao.Text = barCode.SubString(10)";
parent.mostCurrent._edittextfabricacao.setText(BA.ObjectToCharSequence(_barcode.substring((int) (10))));
 //BA.debugLineNum = 1054;BA.debugLine="EditTextFabricacao.Text = EditTextFabricacao.Tex";
parent.mostCurrent._edittextfabricacao.setText(BA.ObjectToCharSequence(parent.mostCurrent._edittextfabricacao.getText().substring((int) (4),(int) (6))+"/"+parent.mostCurrent._edittextfabricacao.getText().substring((int) (2),(int) (4))+"/"+parent.mostCurrent._edittextfabricacao.getText().substring((int) (0),(int) (2))));
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 1056;BA.debugLine="If barCode.StartsWith(\"90\") = True Then";
if (true) break;

case 6:
//if
this.state = 21;
if (_barcode.startsWith("90")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 8;
}else {
this.state = 20;
}if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 1057;BA.debugLine="Cod = barCode.SubString2(2,10)";
parent.mostCurrent._cod = _barcode.substring((int) (2),(int) (10));
 //BA.debugLineNum = 1058;BA.debugLine="Dim lote As String =  barCode.SubString(20)";
_lote = _barcode.substring((int) (20));
 //BA.debugLineNum = 1059;BA.debugLine="EditTextLote.Text =  lote";
parent.mostCurrent._edittextlote.setText(BA.ObjectToCharSequence(_lote));
 //BA.debugLineNum = 1060;BA.debugLine="EditTextProduto.Text = Cod";
parent.mostCurrent._edittextproduto.setText(BA.ObjectToCharSequence(parent.mostCurrent._cod));
 //BA.debugLineNum = 1061;BA.debugLine="Dim cod2 As Double = Cod";
_cod2 = (double)(Double.parseDouble(parent.mostCurrent._cod));
 //BA.debugLineNum = 1062;BA.debugLine="Cod = cod2";
parent.mostCurrent._cod = BA.NumberToString(_cod2);
 //BA.debugLineNum = 1063;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT * FROM unilever_pi.produto_cuc WHERE CodigoCUC="+parent.mostCurrent._campanha+" AND CodigoMaterial="+"1874"+";";
 //BA.debugLineNum = 1064;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1065;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1066;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 23;
return;
case 23:
//C
this.state = 9;
;
 //BA.debugLineNum = 1067;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1068;BA.debugLine="Job1.Release";
parent._job1._release /*String*/ ();
 //BA.debugLineNum = 1069;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 9:
//if
this.state = 14;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 11;
}else {
this.state = 13;
}if (true) break;

case 11:
//C
this.state = 14;
 //BA.debugLineNum = 1070;BA.debugLine="EditTextProduto.Text = XMLwork.SubString2(XMLw";
parent.mostCurrent._edittextproduto.setText(BA.ObjectToCharSequence(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<DescricaoMaterial>")+19),parent.mostCurrent._xmlwork.indexOf("</DescricaoMaterial>"))));
 //BA.debugLineNum = 1071;BA.debugLine="Peso = XMLwork.SubString2(XMLwork.IndexOf(\"<Qu";
parent._peso = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Quant>")+7),parent.mostCurrent._xmlwork.indexOf("</Quant>"))));
 //BA.debugLineNum = 1072;BA.debugLine="UnidadePeso = XMLwork.SubString2(XMLwork.Index";
parent.mostCurrent._unidadepeso = parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<Unidade>")+9),parent.mostCurrent._xmlwork.indexOf("</Unidade>"));
 if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 1074;BA.debugLine="EditTextProduto.Text = Cod";
parent.mostCurrent._edittextproduto.setText(BA.ObjectToCharSequence(parent.mostCurrent._cod));
 if (true) break;

case 14:
//C
this.state = 15;
;
 //BA.debugLineNum = 1076;BA.debugLine="Dim url As String =  URLglobal & \"/ExecQuerySEL";
_url = parent.mostCurrent._urlglobal+"/ExecQuerySELECT (pesoMinimo-Tolerancia) As PesoMinimo, (pesoMaximo+Tolerancia) As PesoMaximo FROM unilever_pi.tolerancia WHERE "+BA.NumberToString(parent._peso)+" >= PesoMinimo AND "+BA.NumberToString(parent._peso)+" <= PesoMinimo AND UM='"+parent.mostCurrent._unidadepeso+"';";
 //BA.debugLineNum = 1077;BA.debugLine="Job1.PostString(url,\"\")";
parent._job1._poststring /*String*/ (_url,"");
 //BA.debugLineNum = 1078;BA.debugLine="Job1.GetRequest.SetContentType(\"application/XML";
parent._job1._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/XML");
 //BA.debugLineNum = 1079;BA.debugLine="Wait For (Job1) JobDone";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(parent._job1));
this.state = 24;
return;
case 24:
//C
this.state = 15;
;
 //BA.debugLineNum = 1080;BA.debugLine="XMLwork = Job1.GetString";
parent.mostCurrent._xmlwork = parent._job1._getstring /*String*/ ();
 //BA.debugLineNum = 1081;BA.debugLine="Job1.Release";
parent._job1._release /*String*/ ();
 //BA.debugLineNum = 1082;BA.debugLine="If XMLwork.Contains(\"<SQL>\") = True Then";
if (true) break;

case 15:
//if
this.state = 18;
if (parent.mostCurrent._xmlwork.contains("<SQL>")==anywheresoftware.b4a.keywords.Common.True) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 1083;BA.debugLine="ToleranciaMinimo =  XMLwork.SubString2(XMLwork";
parent._toleranciaminimo = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<PesoMinimo>")+12),parent.mostCurrent._xmlwork.indexOf("</PesoMinimo>")).replace(".","")));
 //BA.debugLineNum = 1084;BA.debugLine="ToleranciaMaximo = XMLwork.SubString2(XMLwork.";
parent._toleranciamaximo = (double)(Double.parseDouble(parent.mostCurrent._xmlwork.substring((int) (parent.mostCurrent._xmlwork.indexOf("<PesoMaximo>")+12),parent.mostCurrent._xmlwork.indexOf("</PesoMaximo>")).replace(".","")));
 if (true) break;

case 18:
//C
this.state = 21;
;
 if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 1087;BA.debugLine="MsgboxAsync(barCode,\"Enviado ao Webservice\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence(_barcode),BA.ObjectToCharSequence("Enviado ao Webservice"),processBA);
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
 //BA.debugLineNum = 1090;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim socket1 As Socket";
_socket1 = new anywheresoftware.b4a.objects.SocketWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new wrong.addition.httpjob();
 //BA.debugLineNum = 18;BA.debugLine="Dim sql1 As SQL";
_sql1 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 19;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
}
