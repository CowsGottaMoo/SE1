package org.hbrs.se1.ws25.exercises.uebung2;

import java.util.List;

public class Container {
    private List<Member> members = new java.util.ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        if(member.getID()<1 || member == null){
            throw new ContainerException("Das Member-Objekt ist ungültig!");
        }
        for (Member m : members) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        members.add(member);
    }

    public void deleteMember(Integer id){
        int size = members.size();
        for (Member m : members) {
            if(m.getID().equals(id)){
                members.remove(m);
                break;
            }
        }
        if(size == members.size()){
            System.out.println("Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!");
        }
    }

    public void dump(){
        for (Member m : members) {
            System.out.println(m);
        }
    }

    public int size(){
        return members.size();
    }
}
