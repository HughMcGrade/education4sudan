class School < ActiveRecord::Base

  has_many :staffs
  has_many :resources
  has_many :requests
  has_many :notifications

end