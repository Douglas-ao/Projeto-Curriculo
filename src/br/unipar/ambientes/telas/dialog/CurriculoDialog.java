package br.unipar.ambientes.telas.dialog;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

import br.unipar.ambientes.aplicacao.enums.EstadoCivilEnum;
import br.unipar.ambientes.aplicacao.enums.SexoEnum;
import br.unipar.ambientes.aplicacao.enums.UfEnum;
import br.unipar.ambientes.aplicacao.helper.MessageHelper;
import swing2swt.layout.BorderLayout;

public class CurriculoDialog extends TitleAreaDialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text txtObjetivo;
	private Text textExp;
	private Text textComplemento;
	private Text textFormacao;
	private Table tableFormacao;
	private TableViewer tvFormacao;
	private List<String> listFormacao = new ArrayList<String>();
	private List<String> listExp = new ArrayList<String>();
	private Table tableExp;
	private TableViewer tvExp;
	private TableViewerColumn tvColumnExp;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public CurriculoDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Curriculo");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new BorderLayout(0, 0));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setLayoutData(BorderLayout.CENTER);

		TabItem tbtmDadosPessoais = new TabItem(tabFolder, SWT.NONE);
		tbtmDadosPessoais.setText("Dados Pessoais");

		Composite compositeDadosP = new Composite(tabFolder, SWT.NONE);
		tbtmDadosPessoais.setControl(compositeDadosP);
		compositeDadosP.setLayout(new GridLayout(6, false));
		new Label(compositeDadosP, SWT.NONE);
		new Label(compositeDadosP, SWT.NONE);
		new Label(compositeDadosP, SWT.NONE);
		new Label(compositeDadosP, SWT.NONE);
		new Label(compositeDadosP, SWT.NONE);
		new Label(compositeDadosP, SWT.NONE);

		Label lblNome = new Label(compositeDadosP, SWT.NONE);
		lblNome.setAlignment(SWT.CENTER);
		GridData gd_lblNome = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNome.widthHint = 114;
		lblNome.setLayoutData(gd_lblNome);
		lblNome.setText("Nome Completo:");

		text = new Text(compositeDadosP, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));

		Label lblEmail = new Label(compositeDadosP, SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEmail.setText("E-Mail:");

		text_1 = new Text(compositeDadosP, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));

		Label lblRg = new Label(compositeDadosP, SWT.NONE);
		lblRg.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRg.setText("RG:");

		text_5 = new Text(compositeDadosP, SWT.BORDER);
		GridData gd_text_5 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text_5.widthHint = 232;
		text_5.setLayoutData(gd_text_5);

		Label lblCpf = new Label(compositeDadosP, SWT.NONE);
		lblCpf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCpf.setText("CPF:");

		text_6 = new Text(compositeDadosP, SWT.BORDER);
		GridData gd_text_6 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text_6.widthHint = 237;
		text_6.setLayoutData(gd_text_6);

		Label lblIdade = new Label(compositeDadosP, SWT.NONE);
		lblIdade.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblIdade.setText("Idade");

		Label lblSexo = new Label(compositeDadosP, SWT.NONE);
		lblSexo.setAlignment(SWT.CENTER);
		GridData gd_lblSexo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblSexo.widthHint = 114;
		lblSexo.setLayoutData(gd_lblSexo);
		lblSexo.setText("Sexo");

		Label lblEstadoCivil = new Label(compositeDadosP, SWT.NONE);
		lblEstadoCivil.setAlignment(SWT.CENTER);
		GridData gd_lblEstadoCivil = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblEstadoCivil.widthHint = 114;
		lblEstadoCivil.setLayoutData(gd_lblEstadoCivil);
		lblEstadoCivil.setText("Estado Civil");

		Label lblNaturalidade = new Label(compositeDadosP, SWT.NONE);
		lblNaturalidade.setAlignment(SWT.CENTER);
		GridData gd_lblNaturalidade = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNaturalidade.widthHint = 114;
		lblNaturalidade.setLayoutData(gd_lblNaturalidade);
		lblNaturalidade.setText("Naturalidade");

		Label lblTelefone = new Label(compositeDadosP, SWT.NONE);
		lblTelefone.setAlignment(SWT.CENTER);
		GridData gd_lblTelefone = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTelefone.widthHint = 114;
		lblTelefone.setLayoutData(gd_lblTelefone);
		lblTelefone.setText("Telefone");

		Label lblCelular = new Label(compositeDadosP, SWT.NONE);
		lblCelular.setAlignment(SWT.CENTER);
		GridData gd_lblCelular = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblCelular.widthHint = 114;
		lblCelular.setLayoutData(gd_lblCelular);
		lblCelular.setText("Telefone Celular");

		Spinner spinnerIdade = new Spinner(compositeDadosP, SWT.BORDER);
		spinnerIdade.setMaximum(70);
		spinnerIdade.setMinimum(15);
		GridData gd_spinnerIdade = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_spinnerIdade.widthHint = 60;
		spinnerIdade.setLayoutData(gd_spinnerIdade);

		ComboViewer cvSexo = new ComboViewer(compositeDadosP, SWT.NONE);
		Combo comboSexo = cvSexo.getCombo();
		comboSexo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// Define o tipo de conteúdo que será utilizado (padrão é usar
		// Array)
		cvSexo.setContentProvider(ArrayContentProvider.getInstance());
		// Insere nas combinações a lista que deverá ser exibida
		cvSexo.setInput(SexoEnum.values());
		// Definimos a forma que será exibido esses dados
		cvSexo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				SexoEnum sexoEnum = (SexoEnum) element;
				return sexoEnum.getDescricao();
			}
		});

		ComboViewer cvEstadoCivil = new ComboViewer(compositeDadosP, SWT.NONE);
		Combo combo_EstadoCivil = cvEstadoCivil.getCombo();
		combo_EstadoCivil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// Define o tipo de conteúdo que será utilizado (padrão é usar
		// Array)
		cvEstadoCivil.setContentProvider(ArrayContentProvider.getInstance());
		// Insere nas combinações a lista que deverá ser exibida
		cvEstadoCivil.setInput(EstadoCivilEnum.values());
		// Definimos a forma que será exibido esses dados
		cvEstadoCivil.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				EstadoCivilEnum estadoCivilEnum = (EstadoCivilEnum) element;
				return estadoCivilEnum.getDescricao();
			}
		});

		text_2 = new Text(compositeDadosP, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		text_3 = new Text(compositeDadosP, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		text_4 = new Text(compositeDadosP, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Group grpInformeOSeu = new Group(compositeDadosP, SWT.NONE);
		grpInformeOSeu.setLayout(new GridLayout(19, false));
		GridData gd_grpInformeOSeu = new GridData(SWT.LEFT, SWT.CENTER, false, false, 6, 1);
		gd_grpInformeOSeu.heightHint = 72;
		gd_grpInformeOSeu.widthHint = 708;
		grpInformeOSeu.setLayoutData(gd_grpInformeOSeu);
		grpInformeOSeu.setText("Informe o seu endere\u00E7o");

		Label lblNomeDaRua = new Label(grpInformeOSeu, SWT.NONE);
		lblNomeDaRua.setAlignment(SWT.RIGHT);
		GridData gd_lblNomeDaRua = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblNomeDaRua.widthHint = 107;
		lblNomeDaRua.setLayoutData(gd_lblNomeDaRua);
		lblNomeDaRua.setText("Nome da rua:");

		text_8 = new Text(grpInformeOSeu, SWT.BORDER);
		text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 14, 1));
		new Label(grpInformeOSeu, SWT.NONE);
		new Label(grpInformeOSeu, SWT.NONE);

		Label lblNmero = new Label(grpInformeOSeu, SWT.NONE);
		lblNmero.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNmero.setText("N\u00FAmero:");

		text_7 = new Text(grpInformeOSeu, SWT.BORDER);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_7 = new Label(grpInformeOSeu, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_7.setText("Bairro:");

		text_9 = new Text(grpInformeOSeu, SWT.BORDER);
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		new Label(grpInformeOSeu, SWT.NONE);

		Label lblCidade = new Label(grpInformeOSeu, SWT.NONE);
		lblCidade.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCidade.setText("Cidade:");

		text_10 = new Text(grpInformeOSeu, SWT.BORDER);
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		new Label(grpInformeOSeu, SWT.NONE);
		new Label(grpInformeOSeu, SWT.NONE);

		Label lblUf = new Label(grpInformeOSeu, SWT.NONE);
		lblUf.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUf.setText("UF:");

		ComboViewer cvUf = new ComboViewer(grpInformeOSeu, SWT.NONE);
		Combo combo_UF = cvUf.getCombo();
		combo_UF.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// Define o tipo de conteúdo que será utilizado (padrão é usar
		// Array)
		cvUf.setContentProvider(ArrayContentProvider.getInstance());
		// Insere nas combinações a lista que deverá ser exibida
		cvUf.setInput(UfEnum.values());
		// Definimos a forma que será exibido esses dados
		cvUf.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				UfEnum ufEnum = (UfEnum) element;
				return ufEnum.getDescricao();
			}
		});

		TabItem tbtmObjetivo = new TabItem(tabFolder, SWT.NONE);
		tbtmObjetivo.setText("Objetivo");

		Composite compositeObjetivo = new Composite(tabFolder, SWT.NONE);
		tbtmObjetivo.setControl(compositeObjetivo);

		Group grpInformeSeuObjetivo = new Group(compositeObjetivo, SWT.NONE);
		grpInformeSeuObjetivo.setText("Informe seu objetivo");
		grpInformeSeuObjetivo.setBounds(10, 10, 702, 260);

		txtObjetivo = new Text(grpInformeSeuObjetivo, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtObjetivo.setBounds(10, 43, 682, 189);

		TabItem tbtmFormacao = new TabItem(tabFolder, SWT.NONE);
		tbtmFormacao.setText("Forma\u00E7\u00E3o");

		Composite compositeFomacao = new Composite(tabFolder, SWT.NONE);
		compositeFomacao.setTouchEnabled(true);
		tbtmFormacao.setControl(compositeFomacao);
		compositeFomacao.setLayout(new GridLayout(5, false));

		Label lblNewLabel = new Label(compositeFomacao, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 30;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		
				Label lblFormao = new Label(compositeFomacao, SWT.NONE);
				lblFormao.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				lblFormao.setText("Forma\u00E7\u00E3o:");
		
				textFormacao = new Text(compositeFomacao, SWT.BORDER);
				textFormacao.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
				Button btnAdd = new Button(compositeFomacao, SWT.NONE);
				GridData gd_btnAdd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_btnAdd.widthHint = 100;
				btnAdd.setLayoutData(gd_btnAdd);
				btnAdd.setText("Adicionar");
				btnAdd.setImage(ResourceManager.getPluginImage("br.unipar.ambientes", "assets/funcoes/plus16.png"));
				btnAdd.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						// Obtemos o valor digitado pelo usuário
						String formacao = textFormacao.getText();
						// Validamos se foi digitado alguma coisa
						if (formacao.equals("")) {
							MessageHelper.openError("N�o foi informada a forma��o");
							return;
						}
						if (listFormacao.contains(formacao)) {
							textFormacao.setText("");
							return;
						}
						// Insere o texto obtido na lista de formacao
						listFormacao.add(formacao);
						// Atualiza a tabela, para a informação nova apareça
						tvFormacao.refresh();
						// Limpa o campo de texto para inserir uma nova tag
						textFormacao.setText("");
					}
				});
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);

		// Cria uma nova TableViewer
		tvFormacao = new TableViewer(compositeFomacao, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tvFormacao.setUseHashlookup(true);
		tableFormacao = tvFormacao.getTable();
		tableFormacao.setLinesVisible(true);
		tableFormacao.setHeaderVisible(true);
		GridData gd_tableFormacao = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2);
		gd_tableFormacao.widthHint = 665;
		tableFormacao.setLayoutData(gd_tableFormacao);
		// Define como será o conteúdo da tabela (padrão utilizamos array)
		tvFormacao.setContentProvider(ArrayContentProvider.getInstance());
		// Insere na tabela a lista que deverá ser exibida
		tvFormacao.setInput(listFormacao);

		TableViewerColumn tvColumnFormacao = new TableViewerColumn(tvFormacao, SWT.NONE);
		// Definimos a forma que será exibido esses dados
		tvColumnFormacao.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return element == null ? "" : element.toString();
			}
		});
		TableColumn tblclmnFormao = tvColumnFormacao.getColumn();
		tblclmnFormao.setMoveable(true);
		tblclmnFormao.setWidth(670);
		tblclmnFormao.setText("Forma\u00E7\u00E3o");

		Menu menu = new Menu(tableFormacao);
		tableFormacao.setMenu(menu);

		// Cria um item dentro desse menu de contexto para remover o item
		MenuItem mntmRemover = new MenuItem(menu, SWT.NONE);
		mntmRemover.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Comando padrão para obter o item selecionado na lista
				IStructuredSelection selecao = (IStructuredSelection) tvFormacao.getSelection();
				// Pega o primeiro item selecionado
				String formacao = (String) selecao.getFirstElement();
				if (formacao == null)
					return;

				// Remove o item selecionado da lista
				listFormacao.remove(formacao);
				// Atualiza a tabela para visualizar as modificações
				tvFormacao.refresh();
			}
		});

		mntmRemover.setText("Remover");
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);
		new Label(compositeFomacao, SWT.NONE);

		TabItem tbtmExperiencia = new TabItem(tabFolder, SWT.NONE);
		tbtmExperiencia.setText("Experi\u00EAncias Profissionais");

		Composite compositeExperiencia = new Composite(tabFolder, SWT.NONE);
		tbtmExperiencia.setControl(compositeExperiencia);
		compositeExperiencia.setLayout(new GridLayout(5, false));

		Label lblNewLabel_11 = new Label(compositeExperiencia, SWT.NONE);
		GridData gd_lblNewLabel_11 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_11.widthHint = 27;
		lblNewLabel_11.setLayoutData(gd_lblNewLabel_11);
		new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);

		Label lblNewLabel_1 = new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);
		
		Label lblExperincias = new Label(compositeExperiencia, SWT.NONE);
		lblExperincias.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblExperincias.setText("Experi\u00EAncias:");

		textExp = new Text(compositeExperiencia, SWT.BORDER);
		GridData gd_textExp = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_textExp.widthHint = 463;
		textExp.setLayoutData(gd_textExp);

		Button btnAddExp = new Button(compositeExperiencia, SWT.NONE);
		btnAddExp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String exp = textExp.getText().trim();

				if (exp.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe todos os campos!");
					return;
				}

				if (listExp.contains(exp)) {
					textExp.setText("");
					return;
				}

				listExp.add(exp);

				tvExp.refresh();

				textExp.setText("");
			}
		});
		btnAddExp.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		btnAddExp.setText("Adicionar");
		new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);

		Label lblExp = new Label(compositeExperiencia, SWT.NONE);
		lblExp.setEnabled(false);
		lblExp.setText("Exemplo: Empresa  -  Cargo  -   Periodo.");
		new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);
		new Label(compositeExperiencia, SWT.NONE);
		
				tvExp = new TableViewer(compositeExperiencia, SWT.BORDER | SWT.FULL_SELECTION);
				tableExp = tvExp.getTable();
				tableExp.setLinesVisible(true);
				tableExp.setHeaderVisible(true);
				GridData gd_tableExp = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
				gd_tableExp.heightHint = 155;
				tableExp.setLayoutData(gd_tableExp);
				// Define como será o conteúdo da tabela (padrão utilizamos array)
				tvExp.setContentProvider(ArrayContentProvider.getInstance());
				// Insere na tabela a lista que deverá ser exibida
				tvExp.setInput(listExp);
				
						tvColumnExp = new TableViewerColumn(tvExp, SWT.NONE);
						tvColumnExp.setLabelProvider(new ColumnLabelProvider() {
							public String getText(Object element) {
								return element == null ? "" : element.toString();
							}
						});
						TableColumn tblclmnExp = tvColumnExp.getColumn();
						tblclmnExp.setWidth(681);
						tblclmnExp.setText("Experi\u00EAncias");
						
								Menu menu_1 = new Menu(tableExp);
								tableExp.setMenu(menu_1);
								
										MenuItem mntmRemover_1 = new MenuItem(menu_1, SWT.NONE);
										mntmRemover_1.addSelectionListener(new SelectionAdapter() {
											@Override
											public void widgetSelected(SelectionEvent e) {
												// Comando padrão para obter o item selecionado na lista
												IStructuredSelection selecao = (IStructuredSelection) tvExp.getSelection();
												// Pega o primeiro item selecionado
												String exp = (String) selecao.getFirstElement();

												if (exp == null) {
													return;
												}

												// Remove o item selecionado da lista
												listExp.remove(exp);
												// Atualiza a tabela para visualizar as modificações
												tvExp.refresh();
											}
										});
										mntmRemover_1.setText("Remover");
										tvExp.refresh();
		new Label(compositeExperiencia, SWT.NONE);

		TabItem tbtmIdiomas = new TabItem(tabFolder, SWT.NONE);
		tbtmIdiomas.setText("Idiomas");

		Composite compositeIdioma = new Composite(tabFolder, SWT.NONE);
		tbtmIdiomas.setControl(compositeIdioma);
		compositeIdioma.setLayout(new GridLayout(10, false));
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);
		new Label(compositeIdioma, SWT.NONE);

		Group grpSelecioneOIdioma = new Group(compositeIdioma, SWT.NONE);
		grpSelecioneOIdioma.setText("Selecione seus Idioma");
		GridData gd_grpSelecioneOIdioma = new GridData(SWT.LEFT, SWT.CENTER, false, false, 9, 1);
		gd_grpSelecioneOIdioma.heightHint = 97;
		gd_grpSelecioneOIdioma.widthHint = 693;
		grpSelecioneOIdioma.setLayoutData(gd_grpSelecioneOIdioma);

		Button btnPortugus = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnPortugus.setBounds(29, 23, 135, 20);
		btnPortugus.setText("Portugu\u00EAs");

		Button btnJapones = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnJapones.setText("Japon\u00EAs");
		btnJapones.setBounds(535, 75, 146, 20);

		Button btnAlemao = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnAlemao.setBounds(29, 75, 76, 20);
		btnAlemao.setText("Alem\u00E3o");

		Button btnEspanhol = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnEspanhol.setBounds(283, 23, 120, 20);
		btnEspanhol.setText("Espanhol");

		Button btnItaliano = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnItaliano.setBounds(283, 49, 74, 20);
		btnItaliano.setText("Italiano");

		Button btnFrances = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnFrances.setBounds(283, 75, 73, 20);
		btnFrances.setText("Franc\u00EAs");

		Button btnChines = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnChines.setBounds(535, 23, 113, 20);
		btnChines.setText("Chin\u00EAs");

		Button btnRusso = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnRusso.setBounds(535, 49, 62, 20);
		btnRusso.setText("Russo");

		Button btnIngles = new Button(grpSelecioneOIdioma, SWT.CHECK);
		btnIngles.setBounds(29, 49, 63, 20);
		btnIngles.setText("Ingl\u00EAs");

		TabItem tbtmInformaesComplementares = new TabItem(tabFolder, SWT.NONE);
		tbtmInformaesComplementares.setText("Informa\u00E7\u00F5es Complementares");

		Composite compositeComplemento = new Composite(tabFolder, SWT.NONE);
		tbtmInformaesComplementares.setControl(compositeComplemento);
		compositeComplemento.setLayout(new GridLayout(1, false));

		Group grpInformeSeuObjetivo_1 = new Group(compositeComplemento, SWT.NONE);
		GridData gd_grpInformeSeuObjetivo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_grpInformeSeuObjetivo_1.widthHint = 702;
		gd_grpInformeSeuObjetivo_1.heightHint = 242;
		grpInformeSeuObjetivo_1.setLayoutData(gd_grpInformeSeuObjetivo_1);
		grpInformeSeuObjetivo_1.setText("Informa\u00E7\u00F5es Complementares");

		textComplemento = new Text(grpInformeSeuObjetivo_1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textComplemento.setBounds(10, 43, 682, 189);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(776, 499);
	}
}
