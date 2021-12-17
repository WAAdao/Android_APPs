
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _sql1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _listviewop = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _labelclockmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panelmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelsettings = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panellogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelpesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _buttonconfig = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panelqrcode2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _buttonvalidate = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextbarcode = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonvoltarpesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonlimparbarcode = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _barcode1 = RemoteObject.createImmutable("");
public static RemoteObject _barcode2 = RemoteObject.createImmutable("");
public static RemoteObject _barcodesscc = RemoteObject.createImmutable("");
public static RemoteObject _myabbarcode = RemoteObject.declareNull("com.AB.ABZxing.ABZxing");
public static RemoteObject _myabbarcode2 = RemoteObject.declareNull("com.AB.ABZxing.ABZxing");
public static RemoteObject _quantidade = RemoteObject.createImmutable(0);
public static RemoteObject _buttonscan = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextbarcode1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextbarcode2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextbarcodesscc = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextlote = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextproduto = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextquantidade = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextvalidade = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _validade = RemoteObject.createImmutable("");
public static RemoteObject _lote = RemoteObject.createImmutable(0);
public static RemoteObject _material = RemoteObject.createImmutable("");
public static RemoteObject _dataproducao = RemoteObject.createImmutable("");
public static RemoteObject _edittextfabricacao = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextlinha = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextwebservice = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _filename = RemoteObject.createImmutable("");
public static RemoteObject _nometerminal = RemoteObject.createImmutable("");
public static RemoteObject _addresswebservice = RemoteObject.createImmutable("");
public static RemoteObject _buttonlimparlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonvoltarlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextsenhalogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextusuariologin = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _labelclocklogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _buttonvoltar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btscan2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonvoltarop = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _bomba = RemoteObject.createImmutable("");
public static RemoteObject _sscc = RemoteObject.createImmutable("");
public static RemoteObject _codmaterial = RemoteObject.createImmutable("");
public static RemoteObject _opsap = RemoteObject.createImmutable("");
public static RemoteObject _ordemprodsap = null;
public static RemoteObject _labelscan = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _idpesagem = RemoteObject.createImmutable("");
public static RemoteObject _peso = RemoteObject.createImmutable("");
public static RemoteObject _buttonloginop2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _logado = RemoteObject.createImmutable(false);
public static RemoteObject _buttonop1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonop2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonop3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonop4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonop5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonop6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _opselecionadabutton = RemoteObject.createImmutable(0);
public static b4a.example.starter _starter = null;
public static b4a.example.autostart _autostart = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"AddressWebservice",main.mostCurrent._addresswebservice,"Autostart",Debug.moduleToString(b4a.example.autostart.class),"Barcode1",main.mostCurrent._barcode1,"Barcode2",main.mostCurrent._barcode2,"BarcodeSSCC",main.mostCurrent._barcodesscc,"Bomba",main.mostCurrent._bomba,"BtScan2",main.mostCurrent._btscan2,"ButtonConfig",main.mostCurrent._buttonconfig,"ButtonLimparBarcode",main.mostCurrent._buttonlimparbarcode,"ButtonLimparLogin",main.mostCurrent._buttonlimparlogin,"ButtonLogin",main.mostCurrent._buttonlogin,"ButtonLoginOP2",main.mostCurrent._buttonloginop2,"ButtonOP1",main.mostCurrent._buttonop1,"ButtonOP2",main.mostCurrent._buttonop2,"ButtonOP3",main.mostCurrent._buttonop3,"ButtonOP4",main.mostCurrent._buttonop4,"ButtonOP5",main.mostCurrent._buttonop5,"ButtonOP6",main.mostCurrent._buttonop6,"ButtonScan",main.mostCurrent._buttonscan,"ButtonValidate",main.mostCurrent._buttonvalidate,"ButtonVoltar",main.mostCurrent._buttonvoltar,"ButtonVoltarLogin",main.mostCurrent._buttonvoltarlogin,"ButtonVoltarOP",main.mostCurrent._buttonvoltarop,"ButtonVoltarPesagem",main.mostCurrent._buttonvoltarpesagem,"CodMaterial",main.mostCurrent._codmaterial,"cursor",main._cursor,"DataProducao",main.mostCurrent._dataproducao,"EditTextBarcode",main.mostCurrent._edittextbarcode,"EditTextBarcode1",main.mostCurrent._edittextbarcode1,"EditTextBarcode2",main.mostCurrent._edittextbarcode2,"EditTextBarcodeSSCC",main.mostCurrent._edittextbarcodesscc,"EditTextFabricacao",main.mostCurrent._edittextfabricacao,"EditTextLinha",main.mostCurrent._edittextlinha,"EditTextLote",main.mostCurrent._edittextlote,"EditTextProduto",main.mostCurrent._edittextproduto,"EditTextQuantidade",main.mostCurrent._edittextquantidade,"EditTextSenhaLogin",main.mostCurrent._edittextsenhalogin,"EditTextUsuarioLogin",main.mostCurrent._edittextusuariologin,"EditTextValidade",main.mostCurrent._edittextvalidade,"EditTextWebservice",main.mostCurrent._edittextwebservice,"filename",main.mostCurrent._filename,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"IdPesagem",main.mostCurrent._idpesagem,"LabelClockLogin",main.mostCurrent._labelclocklogin,"LabelClockMain",main.mostCurrent._labelclockmain,"LabelScan",main.mostCurrent._labelscan,"ListViewOP",main.mostCurrent._listviewop,"Logado",main._logado,"Lote",main._lote,"Material",main.mostCurrent._material,"myABBarcode",main.mostCurrent._myabbarcode,"myABBarcode2",main.mostCurrent._myabbarcode2,"NomeTerminal",main.mostCurrent._nometerminal,"OPSap",main.mostCurrent._opsap,"OPSelecionadaButton",main._opselecionadabutton,"OrdemProdSAP",main.mostCurrent._ordemprodsap,"PanelLogin",main.mostCurrent._panellogin,"PanelMain",main.mostCurrent._panelmain,"PanelPesagem",main.mostCurrent._panelpesagem,"PanelQRCode2",main.mostCurrent._panelqrcode2,"PanelSettings",main.mostCurrent._panelsettings,"Peso",main.mostCurrent._peso,"Quantidade",main._quantidade,"sql1",main._sql1,"SSCC",main.mostCurrent._sscc,"Starter",Debug.moduleToString(b4a.example.starter.class),"Validade",main.mostCurrent._validade,"xui",main._xui};
}
}