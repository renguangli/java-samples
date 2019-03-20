local key = KEYS[1]
local limits = tonumber(ARGV[1])
local expire_time = ARGV[2]

local times = redis.call('incr', key)
if times == 1 then
    redis.call('pexpire', key, expire_time)
end
if times > limits then
    return 0
end
return 1
