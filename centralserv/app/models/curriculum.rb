class Curriculum < ActiveRecord::Base

  belongs_to :grade
  has_and_belongs_to_many :staffs

end