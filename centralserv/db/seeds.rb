# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)



School.create(name: "test", location: "7.917793,27.596054")
School.create(name: "test2", location: "8.515836,30.935898")
School.create(name: "test2", location: "8.515836,27.486191")
School.create(name: "test2", location: "5.397273,32.408066")
School.create(name: "test2", location: "6.125836,29.343398")
School.create(name: "test2", location: "9.795678,32.792587")


Staff.create(name: "Subin", role: "Headmaster",school_id:"1")
Staff.create(name: "Nafy", role: "Teacher",school_id:"1")
Staff.create(name: "Samir", role: "Teacher",school_id:"1")
Staff.create(name: "Mohammed", role: "Teacher",school_id:"1")

