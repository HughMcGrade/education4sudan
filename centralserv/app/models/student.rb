class Student < ActiveRecord::Base

  belongs_to :staff
  belongs_to :grade

end