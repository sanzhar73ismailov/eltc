package eltc.model;

import domain.Organization;

public class FindOrganizationQuery implements FindQuery {

    private Organization objectToFind;

    public FindOrganizationQuery(Object objectToFind) {
        this.objectToFind = (Organization) objectToFind;
    }

    public String createFindQuery() {
        String rnnLike = "";
        String nameLike = "";
        
        if(objectToFind.getRnn() != null && !objectToFind.getRnn().isEmpty()){
            rnnLike =  "and o.rnn like '%" + objectToFind.getRnn() + "%'";
        }
        
        if(objectToFind.getName() != null && !objectToFind.getName().isEmpty()){
            nameLike = " and o.name like '%" + objectToFind.getName() + "%'";
        }
        return  String.format("from Organization o where 1=1 %s %s order by o.id", 
                rnnLike, nameLike);
    }

    public String createGetSizeQuery() {
        return "select count(*) " + createFindQuery();
    }
}
