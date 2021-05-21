package io.moonbucks.api.exception

abstract class Unauthorized(message: String) : CommonException(message = message)

class NoAuthorizationToken : Unauthorized(message = "로그인이 필요합니다.")
class NoAccessKey : Unauthorized(message = "액세스 키가 없습니다.")
class InvalidAccessKey: Unauthorized(message = "잘못된 액세스 키입니다.")
class JwtVerification: Unauthorized(message = "Jwt 토큰 검증에 실패했습니다.")
class ExpiredAccessKey: Unauthorized(message = "키가 만료되었습니다.")
