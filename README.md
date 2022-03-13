# AssetManagement
# AssetManagement

Manages the asset's used in an organisation


## Index

1.Category                                                      
2.Asset                                                    



## API Reference

1.1addCategory                                            
                                                      

    Method=POST
    API url=/category
    Operation=Add Category
    Payload:

          {
      "name": "Electronic",
        "description": "all electronic items of org"
        }

1.2.getCategory                                            
                                                      

    Method=GET
    API url=/category
    Operation=get all the items of category

1.3.updateCategory                                            
                                                      

    Method=PUT
    API url=/category/{id}
    Operation=update a category
    Payload:

          {
      "name": "Electronic",
        "description": "all electronic items of org avail"
        }

2.1.addAsset                                           
                                                      

    Method=POST
    API url=/asset
    Operation=add an asset under a category
    Payload:

          {
            "category": {
              "id": 1
                  },
           "conditionNote": "new full upgrade",
           "name": "laptop",
           "purchaseDate": "2022-03-12"
          }
2.2.getAsset                                           
                                                      

    Method=GET
    API url=/asset
    Operation=get a list of asset

2.3.assignAssetToEmp                                           
                                                      

    Method=PUT
    API url=/assign
    Operation=assign an asset to an employee
    Query Param:
              Key: assetId
              Key: empId
             
2.4.searchAsset                                         
                                                      

    Method=GET
    API url=/asset-search
    Operation=search for an asset
    Query Param:
              Key: name

2.5.deleteAsset                                         
                                                      

    Method=DELETE
    API url=/asset/{id}
    Operation=delete an asset
    
2.6.updateAsset                                          
                                                      

    Method=PUT
    API url=/asset/{id}
    Operation=update an asset and status 
    Payload:
        {
       "category": {
        "description": "all electronic items of org",
       "id": 1,
       "name": "electronic"
        },
       "conditionNote": "new full upgrade",
        "employee": {
       "designation": "associate",
        "id": 1,
         "name": "srishti"
        },
       "id": 3,
       "name": "laptop",
       "purchaseDate": "2022-03-13T06:56:30.083Z",
       "status": "AVAILABLE"
}
             


             

             
             




