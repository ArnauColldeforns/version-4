
public class DoctorC implements DoctorIF{
	private int id; /* Identificador unívoco */
	private AcademiaC academia; /* Academia a la que pertenece */
	private CollectionIF<DoctorIF> students; /* A quienes ha dirigido la tesis */
	
	
	public void setStudents(QueueIF<DoctorIF> colaEstudiantes){
		this.students=colaEstudiantes;
		
	}
	public DoctorC(int iDDoctor, AcademiaIF academiaDoctorFundador, List<DoctorIF> supervisors) {
		//creamos una nueva sub academia
		this.academia=new AcademiaC(supervisors,academiaDoctorFundador);
		
		this.id=iDDoctor; //definimos el valor de id en el constructor
		
		//tenemos que anadir en todos los doctores supervisores este doctor como estudiante
		IteratorIF<DoctorIF> doctorSupervisor=supervisors.iterator();
		while(doctorSupervisor.hasNext()){
			DoctorIF next=doctorSupervisor.getNext();
			QueueIF<DoctorIF> estudiantes=(QueueIF<DoctorIF>) next.getStudents();
			if(!estudiantes.contains(this))estudiantes.enqueue(this);
			((DoctorC) next).setStudents(estudiantes);
		}
	}

	public DoctorC(int iD) {
		this.id=iD;
	}

	@Override
	public CollectionIF<DoctorIF> getAncestors(int generations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getStudents() {
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public CollectionIF<DoctorIF> getDescendants(int generations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIF<DoctorIF> getSiblings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public CollectionIF<DoctorIF> getSupervisors() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAcademia(AcademiaC a) {
		this.academia=a;
		
	}
	
	public AcademiaC getAcademy(){
		
		return academia;
	}

}
