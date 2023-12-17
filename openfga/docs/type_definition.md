# What Is A Type Definition?

- 타입 정의는 해당 타입에 대해 유저 또는 다른 오브젝트가 가질 수 있는 모든 관계에 대한 정의다.

## Examples of types

document와 연결된 모든 관계 정의
  
```
type document
  relations
    define viewer: [user]
    define commenter: [user]
    define editor: [user]
    define owner: [user]
```