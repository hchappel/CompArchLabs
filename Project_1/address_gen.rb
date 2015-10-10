require 'distribution'

lambda = 256**-1
rng = Distribution::Exponential.rng(lambda)
address_array = Array.new
b = Array.new
new_address = true

while address_array.length < 100000
	
	if new_address
		address = rand(2 ** 30 - 1)
		b.push(address)
		if b.length > 12
			b.shift
		end
	else
		address = b[rand(b.length)]
	end
	spatial = 0
	spatial = rng.call.to_i
	(0..spatial).step(1) do |i|
		p "here  2"
		if address_array.length < 100000
			address_array.push(address + i)
		end
	end

	p address_array.length


	markov = rand(10)
	if new_address 
		if markov <= 2
			new_address = true
		else
			new_address = false
		end
	else
		if markov >= 9 
			new_address = false
		else
			new_address = true
		end
	end
end


filename = "address.txt"
target = open(filename, 'w')
target.truncate(0)

address_array.each do |x|
	address = (x << 2).to_s(16)
	
	(address.length..7).step(1) do |i|
		address = '0' + address
	end
	
	target.write("0x" + address)
	target.write("\n")

end

target.close
