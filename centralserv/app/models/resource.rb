class Resource < ActiveRecord::Base

  has_and_belongs_to_many :schools
  has_and_belongs_to_many :requests

end