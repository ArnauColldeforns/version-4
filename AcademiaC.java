
public class AcademiaC implements AcademiaIF { 
	//todos esos atributos me definen mi AcademiaC
	public AcademiaC next; // es la academia que apunta a la siguiente academia de mi lista
	private TreeIF<DoctorIF> DoctoresSuperiores;
	private TreeIF<DoctorIF> DoctoresEstudiantes;
	private AcademiaC raiz; //Es la primera academia de mi lista de academias
	
	//los gets de mis atributos, los sets se hacen desde constructor
	

	public AcademiaC getAcademiaFirst(){
		return raiz;
	}

	public TreeIF<DoctorIF> getDoctoresSuperiores() {
		return DoctoresSuperiores;
	}
	
	/**
	 * Constructor inicial de la academiaC. Solamente me inicia la lista de academiasIF
	 */
	public AcademiaC(){
		// inicializamos la primera academia
				
				DoctoresSuperiores=new Tree<DoctorIF>(); //inicializamos el arbol de doctores superiores
				DoctoresEstudiantes=new Tree<DoctorIF>();//inicializamos el arbol de doctores estudiantes
				raiz=this; //guardamos esa primera academia en el primer nodo de mi lista de academias
				
		
	}
	
	
	public AcademiaC(List<DoctorIF> supervisors, AcademiaIF academiaDoctorFundador) {
		// cuando tenemos que insertar una nueva academia a mi arbol de academias
		//creamos una nueva academia
		DoctoresSuperiores=new Tree<DoctorIF>(); //inicializamos el arbol de doctores superiores
		
	
	}

	


	/**
	 * Es importante considerar que mi academia cuando solamente tiene el supervisor yo la considero que esta vacia, ya que no tenemos 
	 * ningun estudiante
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(DoctorIF e) {
		return false;
	}

	@Override
	public void clear() {
		
		
	}

	@Override
	public IteratorIF<DoctorIF> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorIF getFounder() {
		// devolvemos el estudinate del primer nodo
		return raiz.getDoctoresSuperiores().getRoot();
	}

	@Override
	public DoctorIF getDoctor(int id) {
	
				return null; //llegado a este punto es que no tenemos el doctor en la academia
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		// TODO Auto-generated method stub
		
	}

	public void setFounder(DoctorC founder) {
		this.raiz.DoctoresEstudiantes.setRoot(founder); //ponemos el doctor fundador como estudiante de la primera academia de mi lista
		//anadimos la primera academia despues de raiz
		List<DoctorIF> superiores=new List<DoctorIF>();
		superiores.insert(founder, 1);
		new AcademiaC(superiores,raiz);
		
		
	}

}
