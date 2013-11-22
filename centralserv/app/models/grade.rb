class Grade < ActiveRecord::Base

  has_and_belongs_to_many :staffs
  has_many :curriculums

end