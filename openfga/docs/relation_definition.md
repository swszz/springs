# What Is A Relation Definition?

- 관계 정의는 이 관계가 가능한 조건 또는 요구 사항을 나열하는 것.

## example

document라는 타입은 viewer, commenter, editor, owner라는 관계를 가지고 있고, 이는 user라는 타입으로 표현한다.

```
type document
  relations
    define viewer: [user]
    define commenter: [user]
    define editor: [user]
    define owner: [user]

type user
```