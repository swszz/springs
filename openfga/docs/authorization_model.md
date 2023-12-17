# What Is An Authorization Model?

- 인가 모델은 하나 이상의 타입 정의(Type Definition)의 조합이다.
- 시스템의 권한 모델을 정의하는 데 사용됩니다.

## snippet

- domain 중 member라는 권한과 user라는 권한이 있어야 document에 특정 권한을 얻을 수 있음

```
model
  schema 1.1

type document
  relations
    define viewer: [domain#member, user]
    define commenter: [domain#member, user]
    define editor: [domain#member, user]
    define owner: [domain#member, user]

type domain
  relations
    define member: [user]

type user
```