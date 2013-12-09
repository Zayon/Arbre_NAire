/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minesales.infres5.a2.p2.arbre_NAire;

import java.util.ArrayList;

/**
 *
 * @author zayon
 */
public class ArbreNAire<T> {

    public Noeud<T> racine;
    public Noeud<T> vue;

    /**
     * Constructeur de la classe : création d'un arbre vide
     */
    public ArbreNAire() {
        this(null);
    }

    /**
     * Constructeur de la classe : création d'un arbre dont la racine est initialisée
     */
    public ArbreNAire(T racine) {
        this.initRacine(racine);
    }

    /**
     * Initialisation de la racine de l'arbre
     */
    public void initRacine(T item) {
        this.racine = new Noeud(item);
        this.vue = this.racine;
    }

    /**
     * Ajoute un fils au noeud courant
     */
    public void addFils(T item) {
        vue.addFils(item);
    }

    /**
     * Accès au contenu du noeud courant
     */
    public T getItem() {
        return this.vue.getItem();
    }

    /**
     * Teste si le noeud courant est la racine
     */
    public boolean isRacine() {
        return this.vue.isRacine();
    }

    /**
     * Teste si le noeud courant est un noeud feuille
     */
    public boolean isNoeudFeuille() {
        return this.vue.isNoeudFeuille();

    }

    /**
     * Retourne le nombre de fils du noeud courant
     */
    public int getNbFils() {
        return this.vue.getNbFils();

    }

    /**
     * Positionne le noeud courant sur la racine
     */
    public void goToRacine() {
        while (!this.vue.isRacine()) {
            this.goToPere();
        }
    }

    /**
     * ¨Positionne le noeud courant sur le ieme fils du noeud courant les indices commencent à zéro
     */
    public void goToFils(int i) {
        this.vue = this.vue.goToFils(i);
    }

    /**
     * Positionne le noeud courant sur le père du noeud courant
     */
    public void goToPere() {
        this.vue = this.vue.getPere();
    }

    /**
     * Supprime le noeud courant et sa descendance le père du noeud supprimé devient le noeud
     * courant
     */
    public void suppressNoeud() {

    }

    public class Noeud<T2> {

        private T2 item;
        private Noeud pere;
        private ArrayList<Noeud> fils;

        public T2 getItem() {
            return item;
        }

        public void setItem(T2 item) {
            this.item = item;
        }

        public Noeud getPere() {
            return pere;
        }

        public Noeud(T2 item) {
            this(item, null);
        }

        private Noeud(T2 item, Noeud pere) {
            this.item = item;
            this.pere = pere;
            this.fils = new ArrayList();
        }

        public void addFils(T2 item) {
            fils.add(new Noeud(item, this));
        }

        /**
         * Teste si le noeud courant est la racine
         */
        public boolean isRacine() {
            return this.pere == null;
        }

        /**
         * Teste si le noeud courant est un noeud feuille
         */
        public boolean isNoeudFeuille() {
            return this.fils.isEmpty();
        }

        /**
         * Retourne le nombre de fils du noeud courant
         */
        public int getNbFils() {
            return this.fils.size();
        }

        /**
         * Positionne le noeud courant sur le ieme fils du noeud courant les indices commencent à
         * zéro
         */
        public Noeud goToFils(int i) {
            return this.fils.get(i);
        }

    }

}
