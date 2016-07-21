
public class MainMainC {
	public static void main(String[] args) {
	DoctorC founder = new DoctorC(1);
	AcademiaC a = new AcademiaC();
	a.setFounder(founder);
	founder.setAcademia(a);
	List<DoctorIF> supervisors = new List<DoctorIF>();
	supervisors.insert(a.getDoctor(1), supervisors.size()+1);
	DoctorC d2=new DoctorC(2,a,supervisors);
	CollectionIF<DoctorIF> listaSupervisors2=d2.getSupervisors();
	IteratorIF<DoctorIF> it=listaSupervisors2.iterator();
	a.addDoctor(d2, it.getNext());
	while(it.hasNext()) a.addSupervision(d2, it.getNext());
	supervisors.clear();
	supervisors.insert(a.getDoctor(1), supervisors.size()+1);
	supervisors.insert(a.getDoctor(2), supervisors.size()+1);
	DoctorC d3=new DoctorC(3,a,supervisors);
	CollectionIF<DoctorIF> listaSupervisors3=d3.getSupervisors();
	IteratorIF<DoctorIF> it1=listaSupervisors3.iterator();
	a.addDoctor(d3, it1.getNext());
	while(it.hasNext()) a.addSupervision(d3, it1.getNext());
	supervisors.clear();
	supervisors.insert(a.getDoctor(2), supervisors.size()+1);
	DoctorC d4=new DoctorC(4,a,supervisors);
	CollectionIF<DoctorIF> listaSupervisors4=d4.getSupervisors();
	IteratorIF<DoctorIF> it2=listaSupervisors4.iterator();
	a.addDoctor(d2, it2.getNext());
	while(it.hasNext()) a.addSupervision(d2, it2.getNext());
	supervisors.clear();
	supervisors.insert(a.getDoctor(1), supervisors.size()+1);
	supervisors.insert(a.getDoctor(3), supervisors.size()+1);
	DoctorC d5=new DoctorC(5,a,supervisors);
	CollectionIF<DoctorIF> listaSupervisors5=d5.getSupervisors();
	IteratorIF<DoctorIF> it3=listaSupervisors5.iterator();
	a.addDoctor(d5, it3.getNext());
	while(it.hasNext()) a.addSupervision(d5, it3.getNext());
	supervisors.clear();
	supervisors.insert(a.getDoctor(4), supervisors.size()+1);
	supervisors.insert(a.getDoctor(5), supervisors.size()+1);
	DoctorC d6=new DoctorC(6,a,supervisors);
	CollectionIF<DoctorIF> listaSupervisors6=d6.getSupervisors();
	IteratorIF<DoctorIF> it4=listaSupervisors6.iterator();
	a.addDoctor(d6, it4.getNext());
	while(it4.hasNext()) a.addSupervision(d6, it4.getNext());
	supervisors.clear();
	supervisors.insert(a.getDoctor(3), supervisors.size()+1);
	DoctorC d7=new DoctorC(7,a,supervisors);
	CollectionIF<DoctorIF> listaSupervisors7=d7.getSupervisors();
	IteratorIF<DoctorIF> it5=listaSupervisors7.iterator();
	a.addDoctor(d7, it5.getNext());
	while(it.hasNext()) a.addSupervision(d7, it5.getNext());
	}
}
