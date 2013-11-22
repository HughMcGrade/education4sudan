class Staff < ActiveRecord::Base

  belongs_to :school
  has_many :messages
  has_and_belongs_to_many :curriculums
  has_and_belongs_to_many :grades
  has_many :students

end