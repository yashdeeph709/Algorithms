package com.algo.design.man.chap3;


public class HashMapTest{
	public static void main(String args[]){
		testInsert();
		testDelete();
		testInsertFive();
	}
	public static void testInsert(){
		HashMap<RollCall,Student> map=new HashMap<RollCall,Student>();
		RollCall r=new RollCall(12,1,43);
		Student expected=new Student("rahul","singh","maths");
		map.put(r,expected);
		Student actual=map.get(r);
		if(actual.equals(expected)){
			System.out.println("Test Passed!");	
		}else{
			System.out.println("Test Failed!");
		}
	}
	public static void testDelete(){
		HashMap<RollCall,Student> map=new HashMap<RollCall,Student>();
		RollCall r1=new RollCall(12,2,40);
		Student rahul=new Student("rahul","sundi","maths");
		RollCall r2=new RollCall(12,1,43);
		Student rahul2=new Student("kahul","jhandi","science");
		RollCall r3=new RollCall(12,3,32);
		Student rahul3=new Student("mehul","gandhi","soc");
		RollCall r4=new RollCall(11,4,2);
		Student rahul4=new Student("sejal","khurana","soc");
		map.put(r1,rahul);
		map.put(r2,rahul2);
		map.put(r3,rahul3);
		map.put(r4,rahul4);
		//map.delete(r1);
		//map.delete(r2);
		RollCall[] calls={r1,r2,r3,r4};
		Student[] students={rahul,rahul2,rahul3,rahul4};
		boolean result=true;
		for(int i=0;i<4;i++){
			Student s= map.get(calls[i]);
			if(s==null){
				result=false;
				continue;
			}
			if(!s.equals(students[i])){
				result=false;
			}
		}
		if(!result){
			System.out.println("Test Failed!");
		}else{
			System.out.println("Test Passed");
		}	
	}
	public static void testInsertFive(){
		HashMap<RollCall,Student> map=new HashMap<RollCall,Student>();
		RollCall r1=new RollCall(12,2,40);
		Student rahul=new Student("rahul","sundi","maths");
		RollCall r2=new RollCall(12,1,43);
		Student rahul2=new Student("kahul","jhandi","science");
		RollCall r3=new RollCall(12,3,32);
		Student rahul3=new Student("mehul","gandhi","soc");
		RollCall r4=new RollCall(2,3,22);
		Student rahul4=new Student("babita","fogat","soc");
		map.put(r1,rahul);
		map.put(r2,rahul2);
		map.put(r3,rahul3);
		if(map.get(r1).equals(rahul)){
			System.out.println("Test Passed!");	
		}else{
			System.out.println("Test Failed!");
		}

	}
	@SuppressWarnings("unchecked")
	public static class HashMap<K,V>{
		private Entry[] entries;
		private static final int mod=53;

		public HashMap(){
			entries=new Entry[mod];
		}
		
		public void put(K key,V value){
			int code=key.hashCode();
			int index=code%entries.length;
			Entry<K,V> entry=entries[index];
			if(entry==null){
				Entry<K,V> data=new Entry<K,V>();
				data.setKey(key);
				data.setValue(value);
				data.next=null;
				data.previous=null;
				entries[index]=data;
			}else{
				Entry<K,V> data=new Entry<K,V>();
				data.setKey(key);
				while(entry.getNext()!=null){
					entry=entry.getNext();
				}		
				entry.next=data;
				data.previous=entry;
			}	
		}
		public V get(K key){
			int code=key.hashCode();
			int index=code%entries.length;
			Entry<K,V> entry=entries[index];
			if(entry==null){
				return null;
			}
			while(!entry.getKey().equals(key)){
				entry=entry.getNext();	
			}
			return entry.getValue();
		}
		public boolean delete(K key){
			int code=key.hashCode();
			int index=code%entries.length;
			Entry<K,V> entry=entries[index];
			System.out.println("Delete called for "+key);
			if(entry==null){
				return true;
			}
			System.out.println("Searching for"+key);
			while(!entry.getKey().equals(key)){
				System.out.println(entry.getValue());
				System.out.println(entry.getKey());
				entry=entry.getNext();
				if(entry!=null){
					break;
				}
			}
			System.out.println("Key is "+entry);
			if(entry==null){
				return true;
			}else{
				Entry e=entry.getPrevious();
				if(e==null){
					entries[index]=null;
				}else{
					e.setNext(null);
				}	
				return true;
			}
		}

		public static class Entry<K,V>{
			private Entry<K,V> next;
			private Entry<K,V> previous;
			private K key;
			private V value;
			public Entry(){
			}
			public void setNext(Entry<K,V> next){
				this.next=next;
			}
			public Entry<K,V> getNext(){
				return next;	
			}
			public void setPrevious(Entry<K,V> previous){
				this.previous=previous;
			}
			public Entry<K,V> getPrevious(){
				return previous;	
			}
			public void setKey(K key){
				this.key=key;
			}
			public K getKey(){
				return key;
			}
			public void setValue(V value){
				this.value=value;
			}
			public V getValue(){
				return value;
			}
		}
	}	
	public static class Student{
		private String firstname;
		private String lastname;
		private String subject;

		//Consider twelve classes,1-50 rollnumbers and 1-5 sections
		public Student(String fname,String lname,String subj){
			this.firstname=fname;
			this.lastname=lname;
			this.subject=subj;
		}
		public boolean equals(Student s){
			if(s==null){
				return false;
			}
			return this.firstname.equals(s.firstname) && this.lastname.equals(s.lastname) && this.subject.equals(s.subject);
		}
		public String toString(){
			return firstname+"\t"+lastname+"\t"+subject;
		}
	}
	public static class RollCall {
		private int classn;
		private int rollno;
		private int section;

		public RollCall(int classn,int section,int rollno){
			this.classn=classn;
			this.rollno=rollno;
			this.section=section;
		}
		public int hashCode(){
			return classn+rollno+section;
		}
		public boolean equals(Object x){
			if(x==null){
				return false;
			}
			RollCall o=(RollCall)x;
			return classn==o.classn && rollno==o.rollno && section==o.section;
		}
		public String toString(){
			return classn+"\t"+rollno+"\t"+section;
		}
	}
}
