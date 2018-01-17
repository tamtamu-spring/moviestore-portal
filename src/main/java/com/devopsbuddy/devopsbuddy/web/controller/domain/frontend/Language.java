package com.devopsbuddy.devopsbuddy.web.controller.domain.frontend;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int language_id;

    @Column(name="name")
    private String languageName;

    @Column(name = "last_update")
    private String lastUpdate;

    public Language()
    {

    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return languageName;
    }
}
