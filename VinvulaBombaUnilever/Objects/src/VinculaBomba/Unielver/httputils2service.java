package VinculaBomba.Unielver;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class httputils2service extends  android.app.Service{
	public static class httputils2service_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (httputils2service) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, httputils2service.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static httputils2service mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return httputils2service.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "VinculaBomba.Unielver", "VinculaBomba.Unielver.httputils2service");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "VinculaBomba.Unielver.httputils2service", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (httputils2service) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (httputils2service) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (httputils2service) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (httputils2service) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (httputils2service) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4h.okhttp.OkHttpClientWrapper _hc = null;
public static anywheresoftware.b4a.objects.collections.Map _taskidtojob = null;
public static String _tempfolder = "";
public static int _taskcounter = 0;
public VinculaBomba.Unielver.main _main = null;
public VinculaBomba.Unielver.starter _starter = null;
public static String  _completejob(int _taskid,boolean _success,String _errormessage) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "completejob", false))
	 {return ((String) Debug.delegate(processBA, "completejob", new Object[] {_taskid,_success,_errormessage}));}
VinculaBomba.Unielver.httpjob _job = null;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (VinculaBomba.Unielver.httpjob)(_taskidtojob.Get((Object)(_taskid)));
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="If job = Null Then";
if (_job== null) { 
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="Log(\"HttpUtils2Service: job completed multiple t";
anywheresoftware.b4a.keywords.Common.LogImpl("82490374","HttpUtils2Service: job completed multiple times - "+BA.NumberToString(_taskid),0);
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="TaskIdToJob.Remove(TaskId)";
_taskidtojob.Remove((Object)(_taskid));
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="job.success = success";
_job._success /*boolean*/  = _success;
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="job.errorMessage = errorMessage";
_job._errormessage /*String*/  = _errormessage;
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="job.Complete(TaskId)";
_job._complete /*String*/ (null,_taskid);
RDebugUtils.currentLine=2490385;
 //BA.debugLineNum = 2490385;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,String _reason,int _statuscode,int _taskid) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "hc_responseerror", false))
	 {return ((String) Debug.delegate(processBA, "hc_responseerror", new Object[] {_response,_reason,_statuscode,_taskid}));}
VinculaBomba.Unielver.httpjob _job = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Log($\"ResponseError. Reason: ${Reason}, Response:";
anywheresoftware.b4a.keywords.Common.LogImpl("82424833",("ResponseError. Reason: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_reason))+", Response: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_response.getErrorResponse()))+""),0);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Response.Release";
_response.Release();
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (VinculaBomba.Unielver.httpjob)(_taskidtojob.Get((Object)(_taskid)));
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="If job = Null Then";
if (_job== null) { 
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="Log(\"HttpUtils2Service (hc_ResponseError): job c";
anywheresoftware.b4a.keywords.Common.LogImpl("82424837","HttpUtils2Service (hc_ResponseError): job completed multiple times - "+BA.NumberToString(_taskid),0);
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="job.Response = Response";
_job._response /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/  = _response;
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="If Response.ErrorResponse <> \"\" Then";
if ((_response.getErrorResponse()).equals("") == false) { 
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="CompleteJob(TaskId, False, Response.ErrorRespons";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.False,_response.getErrorResponse());
 }else {
RDebugUtils.currentLine=2424844;
 //BA.debugLineNum = 2424844;BA.debugLine="CompleteJob(TaskId, False, Reason)";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.False,_reason);
 };
RDebugUtils.currentLine=2424846;
 //BA.debugLineNum = 2424846;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,int _taskid) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "hc_responsesuccess", false))
	 {return ((String) Debug.delegate(processBA, "hc_responsesuccess", new Object[] {_response,_taskid}));}
VinculaBomba.Unielver.httpjob _job = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (VinculaBomba.Unielver.httpjob)(_taskidtojob.Get((Object)(_taskid)));
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="If job = Null Then";
if (_job== null) { 
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Log(\"HttpUtils2Service (hc_ResponseSuccess): job";
anywheresoftware.b4a.keywords.Common.LogImpl("82293763","HttpUtils2Service (hc_ResponseSuccess): job completed multiple times - "+BA.NumberToString(_taskid),0);
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="job.Response = Response";
_job._response /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse*/  = _response;
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="Dim out As OutputStream = File.OpenOutput(TempFol";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(_tempfolder,BA.NumberToString(_taskid),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="Response.GetAsynchronously(\"response\", out , _";
_response.GetAsynchronously(processBA,"response",(java.io.OutputStream)(_out.getObject()),anywheresoftware.b4a.keywords.Common.True,_taskid);
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="End Sub";
return "";
}
public static String  _response_streamfinish(boolean _success,int _taskid) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "response_streamfinish", false))
	 {return ((String) Debug.delegate(processBA, "response_streamfinish", new Object[] {_success,_taskid}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub Response_StreamFinish (Success As Bool";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
_completejob(_taskid,_success,"");
 }else {
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
_completejob(_taskid,_success,anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="TempFolder = File.DirInternalCache";
_tempfolder = anywheresoftware.b4a.keywords.Common.File.getDirInternalCache();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Try";
try {RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="File.WriteString(TempFolder, \"~test.test\", \"test";
anywheresoftware.b4a.keywords.Common.File.WriteString(_tempfolder,"~test.test","test");
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="File.Delete(TempFolder, \"~test.test\")";
anywheresoftware.b4a.keywords.Common.File.Delete(_tempfolder,"~test.test");
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("82031623",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="Log(\"Switching to File.DirInternal\")";
anywheresoftware.b4a.keywords.Common.LogImpl("82031624","Switching to File.DirInternal",0);
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="TempFolder = File.DirInternal";
_tempfolder = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 };
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="If hc.IsInitialized = False Then";
if (_hc.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="hc.Initialize(\"hc\")";
_hc.Initialize("hc");
 };
RDebugUtils.currentLine=2031643;
 //BA.debugLineNum = 2031643;BA.debugLine="TaskIdToJob.Initialize";
_taskidtojob.Initialize();
RDebugUtils.currentLine=2031645;
 //BA.debugLineNum = 2031645;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public static String  _submitjob(VinculaBomba.Unielver.httpjob _job) throws Exception{
RDebugUtils.currentModule="httputils2service";
if (Debug.shouldDelegate(processBA, "submitjob", false))
	 {return ((String) Debug.delegate(processBA, "submitjob", new Object[] {_job}));}
int _taskid = 0;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Public Sub SubmitJob(job As HttpJob)";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="If TaskIdToJob.IsInitialized = False Then Service";
if (_taskidtojob.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_service_create();};
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="taskCounter = taskCounter + 1";
_taskcounter = (int) (_taskcounter+1);
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="Dim TaskId As Int = taskCounter";
_taskid = _taskcounter;
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="TaskIdToJob.Put(TaskId, job)";
_taskidtojob.Put((Object)(_taskid),(Object)(_job));
RDebugUtils.currentLine=2228233;
 //BA.debugLineNum = 2228233;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
if ((_job._username /*String*/ ).equals("") == false && (_job._password /*String*/ ).equals("") == false) { 
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, TaskId, jo";
_hc.ExecuteCredentials(processBA,_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null),_taskid,_job._username /*String*/ ,_job._password /*String*/ );
 }else {
RDebugUtils.currentLine=2228236;
 //BA.debugLineNum = 2228236;BA.debugLine="hc.Execute(job.GetRequest, TaskId)";
_hc.Execute(processBA,_job._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null),_taskid);
 };
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="End Sub";
return "";
}
}