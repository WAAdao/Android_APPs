
package wrong.addition;

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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "wrong.addition.main");
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
public static RemoteObject _socket1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper");
public static RemoteObject _job1 = RemoteObject.declareNull("wrong.addition.httpjob");
public static RemoteObject _sql1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _buttonsair = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonlogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _labelclock = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _imageaplipack = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _buttonmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panelmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panellogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelconexao = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelpesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelusuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelwebservice = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelprodutos = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _selecionacuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _buttontelalogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonllimpar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextuser = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextpassword = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttontelamenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _str = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
public static RemoteObject _str2 = RemoteObject.createImmutable(0);
public static RemoteObject _str3 = RemoteObject.createImmutable(0);
public static RemoteObject _reader = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.TextReaderWrapper");
public static RemoteObject _buttontelamain = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttontelaleitura = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextip = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextporta = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonmanualsoftware = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonconcluirpesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextpeso = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonsairpeso = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttoncadastrabalnca = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _myabbarcode = RemoteObject.declareNull("com.AB.ABZxing.ABZxing");
public static RemoteObject _buttonleiturabarcode = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextproduto = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextfabricacao = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextvalidadepdoruo = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextlote = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _i = RemoteObject.createImmutable(0);
public static RemoteObject _j = RemoteObject.createImmutable(0);
public static RemoteObject _count = RemoteObject.createImmutable(0);
public static RemoteObject _filename = RemoteObject.createImmutable("");
public static RemoteObject _listposition = RemoteObject.createImmutable("");
public static RemoteObject _edittextnomebalanca = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttongravardb = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _listviewbalanca = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _listviewtelabalanca = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _buttonvoltarmenuusuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonusuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonwebservice = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttontelawebservicemenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonprodutosvolta = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttoncadastroproduto = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _listviewtipopesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _edittextwebserviceip = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextwebserviceporta = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonwebservicealterar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextxml = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonbalancaup = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonbalancadown = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonbalanaalterar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttondeletarbalanca = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _usertext = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _listviewusuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _listviewacesso = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _edittextnomeusuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttongravaruusario = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonalterarusuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonuserup = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonuserdown = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _positionuser = RemoteObject.createImmutable(0);
public static RemoteObject _positiondb = RemoteObject.createImmutable(0);
public static RemoteObject _positiondb2 = RemoteObject.createImmutable(0);
public static RemoteObject _buttonnivelup = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonniveldown = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _positionnivel = RemoteObject.createImmutable(0);
public static RemoteObject _idusuario = RemoteObject.createImmutable(0);
public static RemoteObject _buttonapagarusuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextnomeproduto = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextcodigoproduto = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextcodigocuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttongravarproduto = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttonprodutoalterar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _listviewprodutoscuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _edittextpordutocuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonmenucuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _buttoncarregarcuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _edittextdescricaocuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _listviewcuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _edittextcodigocuctela = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _buttonapgarprodutocuc = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _nivelusuario = RemoteObject.createImmutable("");
public static RemoteObject _listviewcucmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _listviewcucpesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _peso = RemoteObject.createImmutable(0);
public static RemoteObject _unidadepeso = RemoteObject.createImmutable("");
public static RemoteObject _toleranciaminimo = RemoteObject.createImmutable(0);
public static RemoteObject _toleranciamaximo = RemoteObject.createImmutable(0);
public static RemoteObject _urlglobal = RemoteObject.createImmutable("");
public static RemoteObject _posbalanca = RemoteObject.createImmutable(0);
public static RemoteObject _buttontelaloginvolta = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _listordemprodsap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _listprodutospesagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _listviewcampanha = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _campanha = RemoteObject.createImmutable("");
public static RemoteObject _cod = RemoteObject.createImmutable("");
public static RemoteObject _pesorota1 = RemoteObject.createImmutable(0);
public static RemoteObject _pesoalvo = RemoteObject.createImmutable(0);
public static RemoteObject _unidadealvo = RemoteObject.createImmutable("");
public static RemoteObject _idpesagemprog = RemoteObject.createImmutable("");
public static RemoteObject _buttonembalagem = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _embfechada = RemoteObject.createImmutable(0);
public static RemoteObject _xmlcurrent = RemoteObject.createImmutable("");
public static RemoteObject _xmlwork = RemoteObject.createImmutable("");
public static RemoteObject _divisor = RemoteObject.createImmutable(0);
public static RemoteObject _decimal = RemoteObject.createImmutable(0);
public static RemoteObject _edittextdivisor = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edittextdecimais = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static wrong.addition.starter _starter = null;
public static wrong.addition.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"ButtonAlterarUsuario",main.mostCurrent._buttonalterarusuario,"ButtonApagarUsuario",main.mostCurrent._buttonapagarusuario,"ButtonApgarProdutoCUC",main.mostCurrent._buttonapgarprodutocuc,"ButtonBalanaAlterar",main.mostCurrent._buttonbalanaalterar,"ButtonBalancaDown",main.mostCurrent._buttonbalancadown,"ButtonBalancaUp",main.mostCurrent._buttonbalancaup,"ButtonCadastraBalnca",main.mostCurrent._buttoncadastrabalnca,"ButtonCadastroProduto",main.mostCurrent._buttoncadastroproduto,"ButtonCarregarCUC",main.mostCurrent._buttoncarregarcuc,"ButtonConcluirPesagem",main.mostCurrent._buttonconcluirpesagem,"ButtonDeletarBalanca",main.mostCurrent._buttondeletarbalanca,"ButtonEmbalagem",main.mostCurrent._buttonembalagem,"ButtonGravarDB",main.mostCurrent._buttongravardb,"ButtonGravarProduto",main.mostCurrent._buttongravarproduto,"ButtonGravarUusario",main.mostCurrent._buttongravaruusario,"ButtonLeituraBarcode",main.mostCurrent._buttonleiturabarcode,"ButtonlLimpar",main.mostCurrent._buttonllimpar,"ButtonLogin",main.mostCurrent._buttonlogin,"ButtonManualSoftware",main.mostCurrent._buttonmanualsoftware,"ButtonMenu",main.mostCurrent._buttonmenu,"ButtonMenuCUC",main.mostCurrent._buttonmenucuc,"ButtonNivelDown",main.mostCurrent._buttonniveldown,"ButtonNivelUp",main.mostCurrent._buttonnivelup,"ButtonProdutoAlterar",main.mostCurrent._buttonprodutoalterar,"ButtonProdutosVolta",main.mostCurrent._buttonprodutosvolta,"ButtonSair",main.mostCurrent._buttonsair,"ButtonSairPeso",main.mostCurrent._buttonsairpeso,"ButtonTelaLeitura",main.mostCurrent._buttontelaleitura,"ButtonTelaLogin",main.mostCurrent._buttontelalogin,"ButtonTelaLoginVolta",main.mostCurrent._buttontelaloginvolta,"ButtonTelaMain",main.mostCurrent._buttontelamain,"ButtonTelaMenu",main.mostCurrent._buttontelamenu,"ButtonTelawebserviceMenu",main.mostCurrent._buttontelawebservicemenu,"ButtonUserDown",main.mostCurrent._buttonuserdown,"ButtonUserUp",main.mostCurrent._buttonuserup,"ButtonUsuarios",main.mostCurrent._buttonusuarios,"ButtonVoltarMenuUsuarios",main.mostCurrent._buttonvoltarmenuusuarios,"ButtonWebservice",main.mostCurrent._buttonwebservice,"ButtonWebserviceAlterar",main.mostCurrent._buttonwebservicealterar,"Campanha",main.mostCurrent._campanha,"Cod",main.mostCurrent._cod,"count",main._count,"cursor",main._cursor,"decimal",main._decimal,"divisor",main._divisor,"EditTextCodigoCuc",main.mostCurrent._edittextcodigocuc,"EditTextCodigoCUCTela",main.mostCurrent._edittextcodigocuctela,"EditTextCodigoProduto",main.mostCurrent._edittextcodigoproduto,"EditTextDecimais",main.mostCurrent._edittextdecimais,"EditTextDescricaoCUC",main.mostCurrent._edittextdescricaocuc,"EditTextDivisor",main.mostCurrent._edittextdivisor,"EditTextFabricacao",main.mostCurrent._edittextfabricacao,"EditTextIP",main.mostCurrent._edittextip,"EditTextLote",main.mostCurrent._edittextlote,"EditTextNomeBalanca",main.mostCurrent._edittextnomebalanca,"EditTextNomeProduto",main.mostCurrent._edittextnomeproduto,"EditTextNomeUsuario",main.mostCurrent._edittextnomeusuario,"EditTextPassword",main.mostCurrent._edittextpassword,"EditTextPeso",main.mostCurrent._edittextpeso,"EditTextPordutoCUC",main.mostCurrent._edittextpordutocuc,"EditTextPorta",main.mostCurrent._edittextporta,"EditTextProduto",main.mostCurrent._edittextproduto,"EditTextUser",main.mostCurrent._edittextuser,"EditTextValidadePdoruo",main.mostCurrent._edittextvalidadepdoruo,"EditTextWebserviceIP",main.mostCurrent._edittextwebserviceip,"EditTextWebservicePorta",main.mostCurrent._edittextwebserviceporta,"EditTextXML",main.mostCurrent._edittextxml,"EmbFechada",main._embfechada,"filename",main.mostCurrent._filename,"HttpUtils2Service",Debug.moduleToString(wrong.addition.httputils2service.class),"i",main._i,"IdPesagemProg",main.mostCurrent._idpesagemprog,"idusuario",main._idusuario,"ImageAplipack",main.mostCurrent._imageaplipack,"j",main._j,"Job1",main._job1,"LabelClock",main.mostCurrent._labelclock,"ListOrdemProdSAP",main.mostCurrent._listordemprodsap,"listPosition",main.mostCurrent._listposition,"ListProdutosPesagem",main.mostCurrent._listprodutospesagem,"ListViewAcesso",main.mostCurrent._listviewacesso,"ListViewBalanca",main.mostCurrent._listviewbalanca,"ListViewCampanha",main.mostCurrent._listviewcampanha,"ListViewCUC",main.mostCurrent._listviewcuc,"ListViewCUCMain",main.mostCurrent._listviewcucmain,"ListViewCUCPesagem",main.mostCurrent._listviewcucpesagem,"ListViewProdutosCUC",main.mostCurrent._listviewprodutoscuc,"ListViewTelaBalanca",main.mostCurrent._listviewtelabalanca,"ListViewTipoPesagem",main.mostCurrent._listviewtipopesagem,"ListViewUsuarios",main.mostCurrent._listviewusuarios,"myABBarcode",main.mostCurrent._myabbarcode,"NivelUsuario",main.mostCurrent._nivelusuario,"panelConexao",main.mostCurrent._panelconexao,"panelLogin",main.mostCurrent._panellogin,"panelMain",main.mostCurrent._panelmain,"panelMenu",main.mostCurrent._panelmenu,"panelPesagem",main.mostCurrent._panelpesagem,"panelProdutos",main.mostCurrent._panelprodutos,"panelUsuarios",main.mostCurrent._panelusuarios,"panelWebservice",main.mostCurrent._panelwebservice,"Peso",main._peso,"PesoAlvo",main._pesoalvo,"PesoRota1",main._pesorota1,"PosBalanca",main._posbalanca,"PositionDB",main._positiondb,"positionDB2",main._positiondb2,"PositionNivel",main._positionnivel,"PositionUser",main._positionuser,"reader",main.mostCurrent._reader,"SelecionaCUC",main.mostCurrent._selecionacuc,"socket1",main._socket1,"sql1",main._sql1,"Starter",Debug.moduleToString(wrong.addition.starter.class),"str",main.mostCurrent._str,"str2",main._str2,"str3",main._str3,"ToleranciaMaximo",main._toleranciamaximo,"ToleranciaMinimo",main._toleranciaminimo,"UnidadeAlvo",main.mostCurrent._unidadealvo,"UnidadePeso",main.mostCurrent._unidadepeso,"URLglobal",main.mostCurrent._urlglobal,"Usertext",main.mostCurrent._usertext,"XMLCurrent",main.mostCurrent._xmlcurrent,"XMLwork",main.mostCurrent._xmlwork};
}
}