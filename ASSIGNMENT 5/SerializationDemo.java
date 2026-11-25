import java.io.*;import java.util.*;
class Resident implements Serializable{private static final long serialVersionUID=1L;String name,regNo,password;transient String phone;transient Object liveConnection;Resident(String n,String r,String p,String ph){name=n;regNo=r;password=p;phone=ph;}}
class Room implements Serializable{private static final long serialVersionUID=1L;int roomNo;List<Resident> residents=new ArrayList<>();Room(int n){roomNo=n;}}
class Hostel implements Serializable{private static final long serialVersionUID=1L;List<Room> rooms=new ArrayList<>();}
public class SerializationDemo{public static void main(String[] a)throws Exception{
 Hostel h=new Hostel();Room room=new Room(101);room.residents.add(new Resident("Arun","192311001","demo-only","9000000000"));h.rooms.add(room);
 try(ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("hostel.dat"))){o.writeObject(h);}
 try(ObjectInputStream i=new ObjectInputStream(new FileInputStream("hostel.dat"))){Hostel copy=(Hostel)i.readObject();Resident r=copy.rooms.get(0).residents.get(0);System.out.println(r.name+" "+r.regNo);System.out.println("Transient phone after load: "+r.phone);}
}}
