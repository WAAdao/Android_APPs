
package VinculaBomba.Unielver;

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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "VinculaBomba.Unielver.main");
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
public static RemoteObject _btconnection = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial");
public static RemoteObject _myabbarcode = RemoteObject.declareNull("com.AB.ABZxing.ABZxing");
public static RemoteObject _codigobomba = RemoteObject.createImmutable("");
public static RemoteObject _idsscc = RemoteObject.createImmutable("");
public static RemoteObject _mode = RemoteObject.createImmutable(0);
public static RemoteObject _addresswebservice = RemoteObject.createImmutable("");
public static RemoteObject _panellogin2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelleitura = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelconfig = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _buttonconcluir = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttondesvincularbomba = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonregistrasscc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonscan = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonvincularbomba = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextbalanca = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonimprimir = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _printer = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.TextWriterWrapper");
public static RemoteObject _printbuffer = RemoteObject.createImmutable("");
public static RemoteObject _nameprinter = RemoteObject.createImmutable("");
public static RemoteObject _barcode1 = RemoteObject.createImmutable("");
public static RemoteObject _barcode2 = RemoteObject.createImmutable("");
public static RemoteObject _barcodesscc = RemoteObject.createImmutable("");
public static RemoteObject _quantidade = RemoteObject.createImmutable("");
public static RemoteObject _validade = RemoteObject.createImmutable("");
public static RemoteObject _material = RemoteObject.createImmutable("");
public static RemoteObject _lote = RemoteObject.createImmutable("");
public static RemoteObject _codzpl = RemoteObject.createImmutable("");
public static RemoteObject _nometerminal = RemoteObject.createImmutable("");
public static RemoteObject _dataproducao = RemoteObject.createImmutable("");
public static RemoteObject _filename = RemoteObject.createImmutable("");
public static RemoteObject _statuslogin = RemoteObject.createImmutable(0);
public static RemoteObject _buttonlimparlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonlogintela = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonvoltarlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextsenha = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextusuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonupdatedados = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonvoltarconfig = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextenderecowebservice = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextnomeimpressora = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextnometerminal = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _imageviewunilever = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static VinculaBomba.Unielver.starter _starter = null;
public static VinculaBomba.Unielver.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"AddressWebservice",main.mostCurrent._addresswebservice,"Barcode1",main.mostCurrent._barcode1,"Barcode2",main.mostCurrent._barcode2,"BarcodeSSCC",main.mostCurrent._barcodesscc,"BTConnection",main._btconnection,"ButtonConcluir",main.mostCurrent._buttonconcluir,"ButtonDesvincularBomba",main.mostCurrent._buttondesvincularbomba,"ButtonImprimir",main.mostCurrent._buttonimprimir,"ButtonLimparLogin",main.mostCurrent._buttonlimparlogin,"ButtonLogin",main.mostCurrent._buttonlogin,"ButtonLoginTela",main.mostCurrent._buttonlogintela,"ButtonRegistraSSCC",main.mostCurrent._buttonregistrasscc,"ButtonScan",main.mostCurrent._buttonscan,"ButtonUpdateDados",main.mostCurrent._buttonupdatedados,"ButtonVincularBomba",main.mostCurrent._buttonvincularbomba,"ButtonVoltarConfig",main.mostCurrent._buttonvoltarconfig,"ButtonVoltarLogin",main.mostCurrent._buttonvoltarlogin,"CodigoBomba",main.mostCurrent._codigobomba,"CodZPL",main.mostCurrent._codzpl,"cursor",main._cursor,"DataProducao",main.mostCurrent._dataproducao,"EditTextBalanca",main.mostCurrent._edittextbalanca,"EditTextEnderecoWebservice",main.mostCurrent._edittextenderecowebservice,"EditTextNomeImpressora",main.mostCurrent._edittextnomeimpressora,"EditTextNomeTerminal",main.mostCurrent._edittextnometerminal,"EditTextSenha",main.mostCurrent._edittextsenha,"EditTextUsuario",main.mostCurrent._edittextusuario,"filename",main.mostCurrent._filename,"HttpUtils2Service",Debug.moduleToString(VinculaBomba.Unielver.httputils2service.class),"idSSCC",main.mostCurrent._idsscc,"ImageViewUnilever",main.mostCurrent._imageviewunilever,"Lote",main.mostCurrent._lote,"Material",main.mostCurrent._material,"Mode",main._mode,"myABBarcode",main.mostCurrent._myabbarcode,"NamePrinter",main.mostCurrent._nameprinter,"Nometerminal",main.mostCurrent._nometerminal,"PanelConfig",main.mostCurrent._panelconfig,"PanelLeitura",main.mostCurrent._panelleitura,"PanelLogin2",main.mostCurrent._panellogin2,"PrintBuffer",main.mostCurrent._printbuffer,"Printer",main.mostCurrent._printer,"Quantidade",main.mostCurrent._quantidade,"sql1",main._sql1,"Starter",Debug.moduleToString(VinculaBomba.Unielver.starter.class),"StatusLogin",main._statuslogin,"Validade",main.mostCurrent._validade,"xui",main._xui};
}
}