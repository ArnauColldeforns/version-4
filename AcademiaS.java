
public class AcademiaS implements AcademiaIF {

	
	//es la lista de academias hijas
	private ListIF<AcademiaS> AcademiasHijas;
	
	//es la raiz de mi arbol de academias
	private AcademiaIF raiz;
	
	//es la lista de estudiantes de la subacademia 
	private ListIF<DoctorIF> estudiantesAcademia; 
	
	//es el doctores superior
	private DoctorIF doctorAcademiaSuperior;
	
	//getters and setters
	
	public ListIF<AcademiaS> getAcademiasHijas() {
		return AcademiasHijas;
	}



	public void setAcademiasHijas(ListIF<AcademiaS> academiasHijas) {
		AcademiasHijas = academiasHijas;
	}



	public AcademiaIF getRaiz() {
		return raiz;
	}



	public void setRaiz(AcademiaIF raiz) {
		this.raiz = raiz;
	}



	public ListIF<DoctorIF> getEstudinatesAcademia() {
		return estudiantesAcademia;
	}



	public void setEstudiantesAcademia(ListIF<DoctorIF> estudiantes) {
		this.estudiantesAcademia = estudiantes;
	}



	public DoctorIF getDoctorAcademiaSuperior() {
		return doctorAcademiaSuperior;
	}



	public void setDoctorAcademiaSuperior(DoctorIF DoctoresSuperior) {
		this.doctorAcademiaSuperior=DoctoresSuperior;
	}



	//constructor de academiaS
	public AcademiaS() {}
				

	
	@Override
	public boolean isEmpty() {
		// si no tiene doctor fundador devolvemos falso, eso quiere decir que la lista de academias hijas de raiz esta vacia
		if(((AcademiaS) this.getRaiz()).getAcademiasHijas().isEmpty()) return true;
		//si no tenemos ningun estudiante tambien podemos decir que esta vacia
		else if(((AcademiaS) this.getRaiz()).getAcademiasHijas().get(1).getAcademiasHijas().isEmpty()) return true;
		else return false;
		
	}
 
	@Override
	/**
	 * Este método me devuelve true si existe el doctor en mi academia
	 */
	public boolean contains(DoctorIF e) {
		
		//creamos un iterador desde raiz
		
		
		IteratorIF<DoctorIF> itdoctor=this.iterator();
		while(itdoctor.hasNext()){
			if(itdoctor.getNext().getId()==e.getId()) return true;
		}
		
		//llegado a este punto es que no tenemos el doctor
		return false;
		
	}

	

	@Override
	public void clear() {
		// Borramos la lista de hijos de raiz
		((AcademiaS) this.getRaiz()).getAcademiasHijas().clear();
	}

	@Override
	public IteratorIF<DoctorIF> iterator() {
		
		ListIF<DoctorIF> ListaDoctores=iteratorR(((AcademiaS) this.getRaiz()).getAcademiasHijas(),new List<DoctorIF>());
		ListaDoctores.insert(this.getFounder(), 1);
		return ListaDoctores.iterator();
		
	}

	private ListIF<DoctorIF> iteratorR(ListIF<AcademiaS> academiasHijas2, ListIF<DoctorIF> listaDoctores) {
		// metodo trivial, si la lista de academias esta vacia entonces devolvemos el resultado final
		if(academiasHijas2.isEmpty()) return listaDoctores;
		
		else{
			ListIF<AcademiaS> nuevaListahijos=new List<AcademiaS>();
			
			//iteramos la lista de hijos
			
			IteratorIF<AcademiaS> ithijos=academiasHijas2.iterator();
			
			while(ithijos.hasNext()){
				AcademiaS next=ithijos.getNext();
				//guardamos los doctores estudiantes de next si la lista no esta vacia
				if(!next.getEstudinatesAcademia().isEmpty()){
				IteratorIF<DoctorIF> itestudiantes=next.getEstudinatesAcademia().iterator();
				while(itestudiantes.hasNext()){
				int positionlistaDoctores=listaDoctores.size()+1;
				listaDoctores.insert(itestudiantes.getNext(), positionlistaDoctores);
						}
				
					}
				//buscamos las academis hijas de next
				
				ListIF<AcademiaS> hijasNext=next.getAcademiasHijas();
				//iteramos las hijas de next
				IteratorIF<AcademiaS> itnexthijas=hijasNext.iterator();
				while(itnexthijas.hasNext()){
					int tamanohijasnext=nuevaListahijos.size()+1;
					nuevaListahijos.insert(itnexthijas.getNext(), tamanohijasnext);
				}
			}
			
			return iteratorR(nuevaListahijos,listaDoctores);
		}
	}



	@Override
	public DoctorIF getFounder() {
		
		return ((AcademiaS) this.getRaiz()).getEstudinatesAcademia().get(1);
	}

	@Override
	public DoctorIF getDoctor(int id) {
		//creamos un iterador desde raiz
		IteratorIF<DoctorIF> itdoctor=this.iterator();
				while(itdoctor.hasNext()){
					DoctorIF doctornext=itdoctor.getNext();
					if(doctornext.getId()==id) return doctornext;
				}
				
				//llegado a este punto es que no tenemos el doctor
				return null;
	
		
	}



	@Override
	public int size() {
		int contador = 0;
		//creamos un iterador desde raiz
				IteratorIF<DoctorIF> itdoctor=this.iterator();
						while(itdoctor.hasNext()){
							itdoctor.getNext();
							contador++;
						}
						
						//llegado a este punto es que no tenemos el doctor
						return contador;
				}

	@Override
	public void addDoctor(DoctorIF newDoctor, DoctorIF supervisor) {
		
		if(this.contains(supervisor)&&!this.contains(newDoctor)){
			//Primero encontramos las academias de supervisor y de nuevo doctor
			AcademiaS academiaDoctorSuperior=((DoctorS) supervisor).getAcademy();
			AcademiaS academiaNuevoDoctor=((DoctorS) newDoctor).getAcademy();
			
			// tenemos que insertar la academia del nuevo doctor en la lista de academias hijas del supervisor
			
			int sizeListaHijosSupervisor=academiaDoctorSuperior.getAcademiasHijas().size()+1;
			
			academiaDoctorSuperior.getAcademiasHijas().insert(academiaNuevoDoctor, sizeListaHijosSupervisor);
			
			//tenemos que anadir el nuevo doctor como estudiante de la academia del supervisor
			
			academiaDoctorSuperior.getEstudinatesAcademia().insert(newDoctor, 1);
			
		}
		
	}
	
	@Override
	public void addSupervision(DoctorIF student, DoctorIF supervisor) {
		
		
	}
	/**
	 * Este método solamente se aplica una vez al crear la academia.
	 * Lo que hace es anadir un nuevo nodo academia justo despues de
	 * la raiz
	 * @param founder
	 */
	public void setFounder(DoctorS founder) {
		//creamos una academia raiz
		AcademiaS nuevaraiz=new AcademiaS();
		//hacemos los set
		nuevaraiz.setAcademiasHijas(new List<AcademiaS>());
		ListIF<DoctorIF> ListaPrimeraAcademia=new List<DoctorIF>();
		ListaPrimeraAcademia.insert(founder, 1);
		nuevaraiz.setEstudiantesAcademia(ListaPrimeraAcademia);
		this.setRaiz(nuevaraiz);
		//inicializamos los setters de lo que va ser la academia del fundador
		this.setDoctorAcademiaSuperior(null); //el doctor superior
		this.setEstudiantesAcademia(new List<DoctorIF>());//inicialmente no tengo estudiantes del fundador
		this.setAcademiasHijas(new List<AcademiaS>()); //tampoco tengo academias hijas
		nuevaraiz.getAcademiasHijas().insert(this, 1);	//insertamos en raiz la primera subacademia
		
		
		
	}
	
	
		
}

