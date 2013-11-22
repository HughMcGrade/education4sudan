class School < ActiveRecord::Base

  has_many :staffs
  has_and_belongs_to_many :resources
  has_many :requests
  has_many :notifications

end