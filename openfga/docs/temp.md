```
model
  schema 1.1

type user

type group
  relations
    define member: [user]

type folder
  relations
    define can_create_file: owner
    define owner: [user]
    define parent: [folder]
    define viewer: [user, user:*, group#member] or owner or viewer from parent

type doc
  relations
    define can_change_owner: owner
    define owner: [user]
    define parent: [folder]
    define can_read: viewer or owner or viewer from parent
    define can_share: owner or owner from parent
    define viewer: [user, user:*, group#member]
    define can_write: owner or owner from parent



```

```

class AuthorizationModel {
    id: 01HHV4044YMPRJXX6AB2P5YYH5
    schemaVersion: 1.1
    typeDefinitions: [class TypeDefinition {
        type: user
        relations: {}
        metadata: null
    }, class TypeDefinition {
        type: group
        relations: {member=class Userset {
            _this: {}
            computedUserset: null
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }}
        metadata: class Metadata {
            relations: {member=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: user
                    relation: null
                    wildcard: null
                    condition: 
                }]
            }}
        }
    }, class TypeDefinition {
        type: folder
        relations: {can_create_file=class Userset {
            _this: null
            computedUserset: class ObjectRelation {
                _object: 
                relation: owner
            }
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }, owner=class Userset {
            _this: {}
            computedUserset: null
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }, parent=class Userset {
            _this: {}
            computedUserset: null
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }, viewer=class Userset {
            _this: null
            computedUserset: null
            tupleToUserset: null
            union: class Usersets {
                child: [class Userset {
                    _this: {}
                    computedUserset: null
                    tupleToUserset: null
                    union: null
                    intersection: null
                    difference: null
                }, class Userset {
                    _this: null
                    computedUserset: class ObjectRelation {
                        _object: 
                        relation: owner
                    }
                    tupleToUserset: null
                    union: null
                    intersection: null
                    difference: null
                }, class Userset {
                    _this: null
                    computedUserset: null
                    tupleToUserset: class TupleToUserset {
                        tupleset: class ObjectRelation {
                            _object: 
                            relation: parent
                        }
                        computedUserset: class ObjectRelation {
                            _object: 
                            relation: viewer
                        }
                    }
                    union: null
                    intersection: null
                    difference: null
                }]
            }
            intersection: null
            difference: null
        }}
        metadata: class Metadata {
            relations: {can_create_file=class RelationMetadata {
                directlyRelatedUserTypes: []
            }, owner=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: user
                    relation: null
                    wildcard: null
                    condition: 
                }]
            }, parent=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: folder
                    relation: null
                    wildcard: null
                    condition: 
                }]
            }, viewer=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: user
                    relation: null
                    wildcard: null
                    condition: 
                }, class RelationReference {
                    type: user
                    relation: null
                    wildcard: {}
                    condition: 
                }, class RelationReference {
                    type: group
                    relation: member
                    wildcard: null
                    condition: 
                }]
            }}
        }
    }, class TypeDefinition {
        type: doc
        relations: {can_change_owner=class Userset {
            _this: null
            computedUserset: class ObjectRelation {
                _object: 
                relation: owner
            }
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }, can_read=class Userset {
            _this: null
            computedUserset: null
            tupleToUserset: null
            union: class Usersets {
                child: [class Userset {
                    _this: null
                    computedUserset: class ObjectRelation {
                        _object: 
                        relation: viewer
                    }
                    tupleToUserset: null
                    union: null
                    intersection: null
                    difference: null
                }, class Userset {
                    _this: null
                    computedUserset: class ObjectRelation {
                        _object: 
                        relation: owner
                    }
                    tupleToUserset: null
                    union: null
                    intersection: null
                    difference: null
                }, class Userset {
                    _this: null
                    computedUserset: null
                    tupleToUserset: class TupleToUserset {
                        tupleset: class ObjectRelation {
                            _object: 
                            relation: parent
                        }
                        computedUserset: class ObjectRelation {
                            _object: 
                            relation: viewer
                        }
                    }
                    union: null
                    intersection: null
                    difference: null
                }]
            }
            intersection: null
            difference: null
        }, can_share=class Userset {
            _this: null
            computedUserset: null
            tupleToUserset: null
            union: class Usersets {
                child: [class Userset {
                    _this: null
                    computedUserset: class ObjectRelation {
                        _object: 
                        relation: owner
                    }
                    tupleToUserset: null
                    union: null
                    intersection: null
                    difference: null
                }, class Userset {
                    _this: null
                    computedUserset: null
                    tupleToUserset: class TupleToUserset {
                        tupleset: class ObjectRelation {
                            _object: 
                            relation: parent
                        }
                        computedUserset: class ObjectRelation {
                            _object: 
                            relation: owner
                        }
                    }
                    union: null
                    intersection: null
                    difference: null
                }]
            }
            intersection: null
            difference: null
        }, can_write=class Userset {
            _this: null
            computedUserset: null
            tupleToUserset: null
            union: class Usersets {
                child: [class Userset {
                    _this: null
                    computedUserset: class ObjectRelation {
                        _object: 
                        relation: owner
                    }
                    tupleToUserset: null
                    union: null
                    intersection: null
                    difference: null
                }, class Userset {
                    _this: null
                    computedUserset: null
                    tupleToUserset: class TupleToUserset {
                        tupleset: class ObjectRelation {
                            _object: 
                            relation: parent
                        }
                        computedUserset: class ObjectRelation {
                            _object: 
                            relation: owner
                        }
                    }
                    union: null
                    intersection: null
                    difference: null
                }]
            }
            intersection: null
            difference: null
        }, owner=class Userset {
            _this: {}
            computedUserset: null
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }, parent=class Userset {
            _this: {}
            computedUserset: null
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }, viewer=class Userset {
            _this: {}
            computedUserset: null
            tupleToUserset: null
            union: null
            intersection: null
            difference: null
        }}
        metadata: class Metadata {
            relations: {can_change_owner=class RelationMetadata {
                directlyRelatedUserTypes: []
            }, can_read=class RelationMetadata {
                directlyRelatedUserTypes: []
            }, can_share=class RelationMetadata {
                directlyRelatedUserTypes: []
            }, can_write=class RelationMetadata {
                directlyRelatedUserTypes: []
            }, owner=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: user
                    relation: null
                    wildcard: null
                    condition: 
                }]
            }, parent=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: folder
                    relation: null
                    wildcard: null
                    condition: 
                }]
            }, viewer=class RelationMetadata {
                directlyRelatedUserTypes: [class RelationReference {
                    type: user
                    relation: null
                    wildcard: null
                    condition: 
                }, class RelationReference {
                    type: user
                    relation: null
                    wildcard: {}
                    condition: 
                }, class RelationReference {
                    type: group
                    relation: member
                    wildcard: null
                    condition: 
                }]
            }}
        }
    }]
    conditions: {}
}


```