/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.tentaPrep.kryssTal.f1;

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DirectoryEntry t = (DirectoryEntry) obj;
        return (t.name == ((DirectoryEntry) obj).name && t.number == ((DirectoryEntry) obj).number );
    }

    
}
