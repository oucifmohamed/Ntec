/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletangular.beans;

/**
 *
 * @author HP
 */
public class Mail {
   private int mailid;
   private String expediteur;
   private String destinataire;
   private String objet;
   private String sujet;

    public Mail(int mailid, String expediteur, String destinataire, String objet, String sujet) {
        this.mailid = mailid;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.objet = objet;
        this.sujet = sujet;
    }

    public int getMailid() {
        return mailid;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String getObjet() {
        return objet;
    }

    public String getSujet() {
        return sujet;
    }

    public void setMailid(int mailid) {
        this.mailid = mailid;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
   
   
}
